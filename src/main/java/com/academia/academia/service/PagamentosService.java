package com.academia.academia.service;

import com.academia.academia.exceptions.ResourceNotFoundException;
import com.academia.academia.models.ClientModel;
import com.academia.academia.models.DTOS.PagamentoDTO;
import com.academia.academia.models.PagamentosModel;
import com.academia.academia.repositories.ClientRepository;
import com.academia.academia.repositories.PagamentosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;

@Service
public class PagamentosService {

    @Autowired
    private PagamentosRepository pagamentosRepository;

    @Autowired
    private ClientRepository clientRepository;

    //Este método calcula o valor a pagar na mensalidade, caso tenha juros, caso não tenha e caso seja o primeiro pagamento
    public PagamentosModel realizarPagamento(PagamentoDTO pagamentoDTO){
        ClientModel cliente = clientRepository.findById(pagamentoDTO.idCliente()    ).orElseThrow(() -> new ResourceNotFoundException("Não existe cliente com o ID informado!"));
        PagamentosModel ultimoPagamento = pagamentosRepository.findLastPaymentByClient(cliente);
        LocalDate dataAtual = LocalDate.now();
        double juros = 0;

        if (ultimoPagamento != null) {
            LocalDate dataUltimoPagamento = ultimoPagamento.getDataPagamento();
            long periodoPagamento = ChronoUnit.DAYS.between(dataUltimoPagamento, dataAtual);

            juros = (periodoPagamento > 31) ? (periodoPagamento - 31) * 2 : 0;
        }

        double valorPagar = juros + cliente.getPlanModel().getValue();
        PagamentosModel pagamento = new PagamentosModel(cliente, cliente.getPlanModel(), valorPagar, juros, pagamentoDTO.formaDePagamento());
        pagamentosRepository.save(pagamento);
        return pagamento;
    }

    public List<PagamentosModel> listarPagamentos(){
         List<PagamentosModel> pagamentos = pagamentosRepository.findAll();
         return pagamentos;
    }

    public void estornarPagamento(Integer idPagamento){
        PagamentosModel pagamentos = pagamentosRepository.findById(idPagamento).orElseThrow(() -> new ResourceNotFoundException("Não existe pagamento com este ID!"));
        LocalDate dataAtual = LocalDate.now();
        LocalDate dataPagamento = pagamentos.getDataPagamento();
        long periodioPagamento = ChronoUnit.DAYS.between(dataPagamento, dataAtual);
        if (periodioPagamento > 3){
            throw new ResourceNotFoundException("O prazo máximo é de 3 dias para estorno!");
        }
        pagamentos.setEstornado(true);
        pagamentosRepository.save(pagamentos);
    }





}
