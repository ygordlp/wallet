package br.edu.unifor.ewallet.models;

import com.orm.SugarRecord;

import java.util.Date;

/**
 * Created by alunor17 on 04/02/17.
 */

public class Movimentacao extends SugarRecord {

    private Double valor;
    private Date data;
    private String descricao;
    private Conta conta;
    private Boolean flagRepetir;
    private Periodo periodo;

    public Movimentacao() {

    }

    public Movimentacao(Double valor, Date data, String descricao, Conta conta, Boolean flagRepetir, Periodo periodo) {
        this.valor = valor;
        this.data = data;
        this.descricao = descricao;
        this.conta = conta;
        this.flagRepetir = flagRepetir;
        this.periodo = periodo;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    public Boolean getFlagRepetir() {
        return flagRepetir;
    }

    public void setFlagRepetir(Boolean flagRepetir) {
        this.flagRepetir = flagRepetir;
    }

    public Periodo getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Periodo periodo) {
        this.periodo = periodo;
    }
}
