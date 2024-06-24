package com.systemupdate.beta.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "informacao_adicionais")
public class InformacaoAdicionaisColaborador extends AbstractEntity {
    @Column(name = "telefone")
    private String telefone;
    
    
    @Column(name = "cpf")
    private Integer cpf;
    
    @Column(name = "rg")
    private String rg;

    @OneToOne
    @JoinColumn(name = "id_colaborador", nullable = false)
    private Colaborador colaborador;
    
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
}