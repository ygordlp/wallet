package br.edu.unifor.ewallet.models;

import com.orm.SugarRecord;

/**
 * Created by alunor17 on 04/02/17.
 */

public class Receita extends SugarRecord {

    private Conta conta;
    private TipoReceita tipoReceita;
    private Double valor;
    private String data;
    private String descricao;
    private boolean isRecebida;
    private boolean isFixa;

    public Receita() {

    }

    public Receita(Conta conta, TipoReceita tipoReceita, Double valor, String data, String descricao, boolean isRecebida, boolean isFixa) {
        this.conta = conta;
        this.tipoReceita = tipoReceita;
        this.valor = valor;
        this.data = data;
        this.descricao = descricao;
        this.isRecebida = isRecebida;
        this.isFixa = isFixa;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    public TipoReceita getTipoReceita() {
        return tipoReceita;
    }

    public void setTipoReceita(TipoReceita tipoReceita) {
        this.tipoReceita = tipoReceita;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isRecebida() {
        return isRecebida;
    }

    public void setRecebida(boolean recebida) {
        isRecebida = recebida;
    }

    public boolean isFixa() {
        return isFixa;
    }

    public void setFixa(boolean fixa) {
        isFixa = fixa;
    }
}
