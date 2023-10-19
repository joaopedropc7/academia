package com.academia.academia.service;

import com.academia.academia.exceptions.ResourceNotFoundException;
import com.academia.academia.models.DTOS.RealizarMatriculaDTO;
import com.academia.academia.models.MatriculaModel;
import com.academia.academia.models.SituacaoCliente;
import com.academia.academia.repositories.ClientRepository;
import com.academia.academia.repositories.MatriculaRepository;
import com.academia.academia.repositories.PlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MatriculaService {

    @Autowired
    private MatriculaRepository matriculaRepository;

    @Autowired
    private PlanRepository planRepository;

    @Autowired
    private ClientRepository clientRepository;

    public MatriculaModel matricularCliente(RealizarMatriculaDTO dto){
        var cliente = clientRepository.findById(dto.idCliente()).orElseThrow(() -> new ResourceNotFoundException("Não foi encontrado nenhum cliente com este ID!"));
        var plano = planRepository.findById(dto.idPlano()).orElseThrow(() -> new ResourceNotFoundException("Não foi encontrado nenhum plano com este ID!"));
        cliente.setSituacaoCliente(SituacaoCliente.Regular);
        cliente.setPlanModel(plano);
        MatriculaModel matricula = new MatriculaModel(cliente, plano);
        clientRepository.save(cliente);
        matriculaRepository.save(matricula);
        return matricula;
    }

    public void desmtricularCliente(Integer idCliente, Integer idPlano){
        var cliente = clientRepository.findById(idCliente).orElseThrow(() -> new ResourceNotFoundException("Não foi encontrado nenhum cliente com este ID!"));
    }
}
