package br.edu.unifor.ewallet.models;

import com.orm.SugarRecord;

/**
 * Created by alunor17 on 04/02/17.
 */

public class CartaoCredito extends SugarRecord {

    private Bandeira bandeira;
    private String numeroCartao;
    private String codigoSeguranca;
    private Double limite;
    private Integer diaVencimento;
    private Integer diaFechamento;
    private Double valorFaturaAtual;

    public CartaoCredito() {

    }

    public CartaoCredito(Bandeira bandeira, String numeroCartao, String codigoSeguranca,
                         Double limite, Integer diaVencimento, Integer diaFechamento,
                         Double valorFaturaAtual) {
        this.bandeira = bandeira;
        this.numeroCartao = numeroCartao;
        this.codigoSeguranca = codigoSeguranca;
        this.limite = limite;
        this.diaVencimento = diaVencimento;
        this.diaFechamento = diaFechamento;
        this.valorFaturaAtual = valorFaturaAtual;
    }

    public Bandeira getBandeira() {
        return bandeira;
    }

    public void setBandeira(Bandeira bandeira) {
        this.bandeira = bandeira;
    }

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public String getCodigoSeguranca() {
        return codigoSeguranca;
    }

    public void setCodigoSeguranca(String codigoSeguranca) {
        this.codigoSeguranca = codigoSeguranca;
    }

    public Double getLimite() {
        return limite;
    }

    public void setLimite(Double limite) {
        this.limite = limite;
    }

    public Integer getDiaVencimento() {
        return diaVencimento;
    }

    public void setDiaVencimento(Integer diaVencimento) {
        this.diaVencimento = diaVencimento;
    }

    public Integer getDiaFechamento() {
        return diaFechamento;
    }

    public void setDiaFechamento(Integer diaFechamento) {
        this.diaFechamento = diaFechamento;
    }

    public Double getValorFaturaAtual() {
        return valorFaturaAtual;
    }

    public void setValorFaturaAtual(Double valorFaturaAtual) {
        this.valorFaturaAtual = valorFaturaAtual;
    }
}