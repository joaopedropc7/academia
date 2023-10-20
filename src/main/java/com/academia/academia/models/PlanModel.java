package com.academia.academia.models;

import com.academia.academia.models.DTOS.PlanDTO;
import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "planos")
public class PlanModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Double value;
    private String descricao;

    public PlanModel() {
    }

    public PlanModel(PlanDTO plano) {
       this.name = plano.nome();
       this.value = plano.valor();
       this.descricao = plano.descricao();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlanModel planModel = (PlanModel) o;
        return Objects.equals(id, planModel.id) && Objects.equals(name, planModel.name) && Objects.equals(value, planModel.value) && Objects.equals(descricao, planModel.descricao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, value, descricao);
    }
}
