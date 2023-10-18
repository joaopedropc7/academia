package com.academia.academia.service;

import com.academia.academia.exceptions.ResourceNotFoundException;
import com.academia.academia.models.DTOS.PlanDTO;
import com.academia.academia.models.PlanModel;
import com.academia.academia.repositories.PlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanService {

    @Autowired
    private PlanRepository repository;


    public PlanModel cadastrarPlano(PlanDTO planoDTO){
        PlanModel plano = new PlanModel(planoDTO);
        repository.save(plano);
        return plano;
    }

    public List<PlanModel> buscarPlanos(){
        List<PlanModel> planos = repository.findAll();
        return  planos;
    }

    public PlanModel buscarPorId(Integer id){
        PlanModel plano = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Não foi encontrado nenhum plano com este ID!"));
        return plano;
    }

    public PlanModel atualizarPlano(PlanDTO planDTO, Integer planoID){

        var entity = repository.findById(planoID).orElseThrow(() -> new ResourceNotFoundException("Não foi encontrado nenhum plano com este ID!"));

        entity.setName(planDTO.nome());
        entity.setDescricao(planDTO.descricao());
        entity.setValue(planDTO.valor());
        repository.save(entity);

        return  entity;
    }

    public void deletarPlano(Integer planoID){
        var entity = repository.findById(planoID).orElseThrow(() -> new ResourceNotFoundException("Não foi encontrado nenhum plano com este ID!"));
        repository.delete(entity);
    }
}
