package com.academia.academia.service;

import com.academia.academia.exceptions.ResourceNotFoundException;
import com.academia.academia.models.ClientModel;
import com.academia.academia.models.DTOS.PagamentoDTO;
import com.academia.academia.models.DTOS.RealizarMatriculaDTO;
import com.academia.academia.models.MatriculaModel;
import com.academia.academia.models.SituacaoCliente;
import com.academia.academia.repositories.ClientRepository;
import com.academia.academia.repositories.MatriculaRepository;
import com.academia.academia.repositories.PlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatriculaService {

    @Autowired
    private MatriculaRepository matriculaRepository;

    @Autowired
    private PlanRepository planRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private PagamentosService pagamentosService;

    public MatriculaModel matricularCliente(RealizarMatriculaDTO dto){
        var cliente = clientRepository.findById(dto.idCliente()).orElseThrow(() -> new ResourceNotFoundException("Não foi encontrado nenhum cliente com este ID!"));
        var plano = planRepository.findById(dto.idPlano()).orElseThrow(() -> new ResourceNotFoundException("Não foi encontrado nenhum plano com este ID!"));
        if(cliente.getSituacaoCliente() == SituacaoCliente.Regular){
            throw new ResourceNotFoundException("Este cliente já está matriculado!");
        }
        if(cliente.getSituacaoCliente() == SituacaoCliente.Atrasado){
            throw new ResourceNotFoundException("Este cliente esta com pendencias!");
        }
        cliente.setSituacaoCliente(SituacaoCliente.Regular);
        cliente.setPlanModel(plano);
        MatriculaModel matricula = new MatriculaModel(cliente, plano);
        cliente.setMatriculaModel(matricula);
        PagamentoDTO pagamentoDTO = new PagamentoDTO(cliente.getId(), dto.formaDePagamento());
        pagamentosService.realizarPagamento(pagamentoDTO);
        clientRepository.save(cliente);
        matriculaRepository.save(matricula);
        return matricula;
    }

    public void desmtricularCliente(Integer idCliente){
        ClientModel cliente = clientRepository.findById(idCliente).orElseThrow(() -> new ResourceNotFoundException("Não foi encontrado nenhum cliente com este ID!"));
       if (cliente.getSituacaoCliente() == SituacaoCliente.Desmatriculado){
           throw new ResourceNotFoundException("Este cliente já está desmatriculado!");}
        cliente.setPlanModel(null);
        cliente.setMatriculaModel(null);
        cliente.setSituacaoCliente(SituacaoCliente.Desmatriculado);
        clientRepository.save(cliente);
        MatriculaModel matricula = clientRepository.findMatriculaModelById(idCliente);
        matricula.setMatriculaAtiva(false);
        matriculaRepository.save(matricula);
    }

    public List<MatriculaModel> listarMatriculas(){
        List<MatriculaModel> matriculas = matriculaRepository.findAll();
        return matriculas;
    }

    public MatriculaModel buscarMatriculaPorId(Integer id){
        MatriculaModel matricula = matriculaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Não foi encontrado nenhuma matricula com este ID!"));
        return matricula;
    }
}
