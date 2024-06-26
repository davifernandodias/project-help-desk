package com.systemupdate.beta.models;

import jakarta.persistence.*;

@Entity
@Table(name = "informacao_adicionais")
public class InformacaoAdicionaisColaborador extends AbstractEntity {
    @Column(name = "telefone")
    private String telefone;

    @Column(name = "cpf")
    private Integer cpf;

    @Column(name = "rg")
    private String rg;

    @Column(name = "sobrenome")
    private String sobrenome;

    @OneToOne
    @JoinColumn(name = "id_colaborador", nullable = false)
    private Colaborador colaborador;

    @OneToOne(mappedBy = "informacaoAdicionaisColaborador", cascade = CascadeType.ALL)
    private Endereco endereco;

    // Getters and Setters
    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Integer getCpf() {
        return cpf;
    }

    public void setCpf(Integer cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public Colaborador getColaborador() {
        return colaborador;
    }

    public void setColaborador(Colaborador colaborador) {
        this.colaborador = colaborador;
    }
}
