package com.academia.academia.models;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "titulos")
public class TitulosModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "idcliente")
    private Integer idCliente;
    @Column(name = "idplano")
    private Integer idPlano;
    @Column(name = "valorpago")
    private Double valorPago;
    @Column(name = "juros")
    private Double juros;
    @Column(name = "datapagamento")
    private Date dataPagamento;
    @Column(name = "formadepagamento")
    private String FormaDePagamento;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Integer getIdPlano() {
        return idPlano;
    }

    public void setIdPlano(Integer idPlano) {
        this.idPlano = idPlano;
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

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public String getFormaDePagamento() {
        return FormaDePagamento;
    }

    public void setFormaDePagamento(String formaDePagamento) {
        FormaDePagamento = formaDePagamento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TitulosModel that = (TitulosModel) o;
        return Objects.equals(id, that.id) && Objects.equals(idCliente, that.idCliente) && Objects.equals(idPlano, that.idPlano) && Objects.equals(valorPago, that.valorPago) && Objects.equals(juros, that.juros) && Objects.equals(dataPagamento, that.dataPagamento) && Objects.equals(FormaDePagamento, that.FormaDePagamento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idCliente, idPlano, valorPago, juros, dataPagamento, FormaDePagamento);
    }
}
