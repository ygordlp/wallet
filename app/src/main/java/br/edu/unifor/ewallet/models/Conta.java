package br.edu.unifor.ewallet.models;

import com.orm.SugarRecord;

import java.util.List;

/**
 * Created by alunor17 on 04/02/17.
 */

public class Conta extends SugarRecord {

    private Usuarios usuario;
    private TipoConta tipoConta;
    private String titulo;
    private String banco;
    private String numeroConta;
    private Double saldo;
    private String cor;

    public Conta(){

    }

    public Conta(TipoConta tipoConta, String banco, String numeroConta, String titulo, String cor, Double saldo, Usuarios usuario) {
        this.tipoConta = tipoConta;
        this.banco = banco;
        this.numeroConta = numeroConta;
        this.titulo = titulo;
        this.cor = cor;
        this.saldo = saldo;
        this.usuario = usuario;
    }

    List<Receita> getReceitas() {
        return Receita.find(Receita.class, "conta = ?", String.valueOf(getId()));
    }

    List<Despesa> getDespesas() {
        return Despesa.find(Despesa.class, "conta = ?", String.valueOf(getId()));
    }

    public TipoConta getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(TipoConta tipoConta) {
        this.tipoConta = tipoConta;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }
}
