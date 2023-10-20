package com.academia.academia.models;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "titulos")
public class PagamentosModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "idcliente")
    private ClientModel client;
    @ManyToOne
    @JoinColumn(name = "idplano")
    private PlanModel plan;
    @Column(name = "valorpago")
    private Double valorPago;
    @Column(name = "juros")
    private Double juros;
    @Column(name = "datapagamento")
    private LocalDate dataPagamento;
    @Column(name = "formadepagamento")
    private String formaDePagamento;
    @Column(name = "estornado")
    private boolean estornado;


    public PagamentosModel() {
    }

    public PagamentosModel(ClientModel client, PlanModel plan, Double valorPago, Double juros, String formaDePagamento) {
        this.client = client;
        this.plan = plan;
        this.valorPago = valorPago;
        this.juros = juros;
        this.dataPagamento = LocalDate.now();
        this.formaDePagamento = formaDePagamento;
        this.estornado = false;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ClientModel getClient() {
        return client;
    }

    public void setClient(ClientModel client) {
        this.client = client;
    }

    public PlanModel getPlan() {
        return plan;
    }

    public void setPlan(PlanModel plan) {
        this.plan = plan;
    }

    public Double getValorPago() {
        return valorPago;
    }

    public void setValorPago(Double valorPago) {
        this.valorPago = valorPago;
    }

    public Double getJuros() {
        return juros;
    }

    public void setJuros(Double juros) {
        this.juros = juros;
    }

    public LocalDate getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(LocalDate dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public String getFormaDePagamento() {
        return formaDePagamento;
    }

    public void setFormaDePagamento(String formaDePagamento) {
        formaDePagamento = formaDePagamento;
    }

    public boolean isEstornado() {
        return estornado;
    }

    public void setEstornado(boolean estornado) {
        this.estornado = estornado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PagamentosModel that = (PagamentosModel) o;
        return Objects.equals(id, that.id) && Objects.equals(client, that.client) && Objects.equals(plan, that.plan) && Objects.equals(valorPago, that.valorPago) && Objects.equals(juros, that.juros) && Objects.equals(dataPagamento, that.dataPagamento) && Objects.equals(formaDePagamento, that.formaDePagamento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, client, plan, valorPago, juros, dataPagamento, formaDePagamento);
    }
}
