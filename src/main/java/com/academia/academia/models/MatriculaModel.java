package com.academia.academia.models;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "matriculas")
public class MatriculaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "data_matricula")
    private LocalDate dataMatricula;
    @ManyToOne
    @JoinColumn(name = "idcliente")
    private ClientModel cliente;
    @ManyToOne
    @JoinColumn(name = "idplano")
    private PlanModel plano;
    @Column(name = "valorpago")
    private Double valorPago;
    @Column(name = "matriculaativa")
    private Boolean matriculaAtiva;

    public MatriculaModel(ClientModel cliente, PlanModel plano) {
        this.dataMatricula = LocalDate.now();
        this.cliente = cliente;
        this.plano = plano;
        this.valorPago = plano.getValue();
        this.matriculaAtiva = true;
    }

    public MatriculaModel() {

    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDataMatricula() {
        return dataMatricula;
    }

    public void setDataMatricula(LocalDate dataMatricula) {
        this.dataMatricula = dataMatricula;
    }

    public ClientModel getCliente() {
        return cliente;
    }

    public void setCliente(ClientModel cliente) {
        this.cliente = cliente;
    }

    public PlanModel getPlano() {
        return plano;
    }

    public void setPlano(PlanModel plano) {
        this.plano = plano;
    }

    public Double getValorPago() {
        return valorPago;
    }

    public void setValorPago(Double valorPago) {
        this.valorPago = valorPago;
    }

    public Boolean getMatriculaAtiva() {
        return matriculaAtiva;
    }

    public void setMatriculaAtiva(Boolean matriculaAtiva) {
        this.matriculaAtiva = matriculaAtiva;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MatriculaModel that = (MatriculaModel) o;
        return Objects.equals(id, that.id) && Objects.equals(dataMatricula, that.dataMatricula) && Objects.equals(cliente, that.cliente) && Objects.equals(plano, that.plano) && Objects.equals(valorPago, that.valorPago);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dataMatricula, cliente, plano, valorPago);
    }
}
