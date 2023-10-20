package com.academia.academia.service;

import com.academia.academia.exceptions.ResourceNotFoundException;
import com.academia.academia.models.ClientModel;
import com.academia.academia.models.DTOS.ClieneAlterarPlano;
import com.academia.academia.models.DTOS.ClientDTO;
import com.academia.academia.models.DTOS.PlanDTO;
import com.academia.academia.models.PlanModel;
import com.academia.academia.models.SituacaoCliente;
import com.academia.academia.repositories.ClientRepository;
import com.academia.academia.repositories.PlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;

    @Autowired
    private PlanRepository planRepository;

    public List<ClientModel> listarClientes(){
        List<ClientModel> clientes = repository.findAll();
        System.out.println(clientes);
        return clientes;
    }

    public ClientModel cadastrarCliente(ClientDTO clientDTO) throws ParseException {
        PlanModel plano = planRepository.findById(clientDTO.idPlano()).orElseThrow(() -> new ResourceNotFoundException("Não foi encontrado nenhum plano com este ID!"));
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date dataNascimento = dateFormat.parse(clientDTO.dataDeNascimento());

        ClientModel cliente = new ClientModel(clientDTO, plano, dataNascimento);
        System.out.println(cliente);
        repository.save(cliente);
        return cliente;
    }

    public ClientModel buscarClientePorID(Integer id){
        ClientModel clientModel = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Não foi encontrado nenhum cliente com este ID!"));
        return clientModel;
    }

    public ClientModel atualizarCliente(Integer clientId, ClientDTO clientDTO) throws ParseException {

        var entity = repository.findById(clientId).orElseThrow(() -> new ResourceNotFoundException("Não foi encontrado nenhum cliente com este ID!"));

        entity.setNome(clientDTO.nome());
        entity.setEmail(clientDTO.email());
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        try{
            Date dataNascimento = dateFormat.parse(clientDTO.dataDeNascimento());
            entity.setDataNascimento(dataNascimento);
        }catch (ParseException e) {
            e.printStackTrace();
        }
        entity.setNumeroTelefone(clientDTO.numeroTelefone());
        repository.save(entity);

        return entity;
    }

    public void deletarCliente(Integer clientID){
        var entity = repository.findById(clientID).orElseThrow(() -> new ResourceNotFoundException("Não foi encontrado nenhum cliente com este ID!"));
        repository.delete(entity);
    }

    public void alterarPlano(ClieneAlterarPlano clieneAlterarPlano){
        var entity = repository.findById(clieneAlterarPlano.idCliente()).orElseThrow(() -> new ResourceNotFoundException("Não foi encontrado nenhum cliente com este ID!"));
        PlanModel plano = planRepository.findById(clieneAlterarPlano.idPlano()).orElseThrow(() -> new ResourceNotFoundException("Não foi encontrado nenhum plano com este ID!"));
        entity.setPlanModel(plano);
        repository.save(entity);
    }


}
