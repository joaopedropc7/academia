package com.academia.academia.models;

import com.academia.academia.models.DTOS.ClientDTO;
import jakarta.persistence.*;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "clientes")
public class ClientModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;
    @Column(name = "cpf")
    private String cpf;
    @Column(name = "dataNascimento")
    private Date dataNascimento;
    @ManyToOne
    @JoinColumn(name = "plano_id")
    private PlanModel planModel;
    @Column(name = "numero_telefone")
    private String numeroTelefone;
    @Column(name = "situacao_cliente_id")
    private SituacaoCliente situacaoCliente;
    @ManyToOne
    @JoinColumn(name = "matricula_id")
    private MatriculaModel matriculaModel;


    public ClientModel() {
    }

    public ClientModel(ClientDTO clientDTO, PlanModel planModel, Date dataNascimento){
        this.name = clientDTO.nome();
        this.email = clientDTO.email();
        this.cpf = clientDTO.cpf();
        this.dataNascimento = dataNascimento;
        this.planModel = planModel;
        this.numeroTelefone = clientDTO.numeroTelefone();
        this.situacaoCliente = SituacaoCliente.Desmatriculado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return name
                ;
    }

    public void setNome(String nome) {
        this.name = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public PlanModel getPlanModel() {
        return planModel;
    }

    public void setPlanModel(PlanModel planModel) {
        this.planModel = planModel;
    }

    public String getNumeroTelefone() {
        return numeroTelefone;
    }

    public void setNumeroTelefone(String numeroTelefone) {
        this.numeroTelefone = numeroTelefone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SituacaoCliente getSituacaoCliente() {
        return situacaoCliente;
    }

    public void setSituacaoCliente(SituacaoCliente situacaoCliente) {
        this.situacaoCliente = situacaoCliente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientModel that = (ClientModel) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(email, that.email) && Objects.equals(dataNascimento, that.dataNascimento) && Objects.equals(planModel, that.planModel) && Objects.equals(numeroTelefone, that.numeroTelefone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, dataNascimento, planModel, numeroTelefone);
    }
}
