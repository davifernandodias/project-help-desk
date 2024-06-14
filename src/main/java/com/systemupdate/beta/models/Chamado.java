package com.systemupdate.beta.models;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@SuppressWarnings("serial")
@Entity
@Table(name = "chamados",
       indexes = {@Index(name = "idx_tipo_chamado", columnList = "tipo_chamado")})
public class Chamado extends AbstractEntity {

    @Column(name = "titulo", nullable = false)
    private String titulo;

    @Column(name = "tipo_chamado", nullable = false, columnDefinition = "INT CHECK (tipo_chamado IN (1, 2, 3))")
    private int tipoDeChamado;

    @Column(name = "descricao", nullable = false)
    private String descricao;

    @Column(name = "supervisor", nullable = false)
    private String supervisor;

    @Column(name = "status", nullable = false)
    private String status = "aberto";

    @Column(name = "data_criacao", nullable = false)
    @DateTimeFormat(iso = ISO.DATE_TIME)
    private LocalDateTime dataCriacao;

    @Column(name = "data_atualizacao")
    @DateTimeFormat(iso = ISO.DATE_TIME)
    private LocalDateTime dataAtualizacao;

    @ManyToOne
    @JoinColumn(name = "id_colaborador", nullable = false)
    private Colaborador colaborador;

    // Getters and Setters
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getTipoDeChamado() {
        return tipoDeChamado;
    }

    public void setTipoDeChamado(int tipoDeChamado) {
        this.tipoDeChamado = tipoDeChamado;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public LocalDateTime getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    public Colaborador getColaborador() {
        return colaborador;
    }

    public void setColaborador(Colaborador colaborador) {
        this.colaborador = colaborador;
    }
}
