package com.arturlogan.animal_service.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column
    private String nomeProvisorio;

    @Column
    private String raca;

    @Column
    private Integer idadeEstimada;

    @Column
    private String especie;

    @Column
    private Date dataEntrada;

    @Column
    private Date adocao;

    @Column
    private Date obito;

    @Column
    private String nomeRecebedor;

    @Column
    private String porte;

    @ManyToOne
    @JsonBackReference
    private Funcionario funcionario;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeProvisorio() {
        return nomeProvisorio;
    }

    public void setNomeProvisorio(String nomeProvisorio) {
        this.nomeProvisorio = nomeProvisorio;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public Integer getIdadeEstimada() {
        return idadeEstimada;
    }

    public void setIdadeEstimada(Integer idadeEstimada) {
        this.idadeEstimada = idadeEstimada;
    }

    public Date getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(Date dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public Date getAdocao() {
        return adocao;
    }

    public void setAdocao(Date adocao) {
        this.adocao = adocao;
    }

    public Date getObito() {
        return obito;
    }

    public void setObito(Date obito) {
        this.obito = obito;
    }

    public String getNomeRecebedor() {
        return nomeRecebedor;
    }

    public void setNomeRecebedor(String nomeRecebedor) {
        this.nomeRecebedor = nomeRecebedor;
    }

    public String getPorte() {
        return porte;
    }

    public void setPorte(String porte) {
        this.porte = porte;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
}
