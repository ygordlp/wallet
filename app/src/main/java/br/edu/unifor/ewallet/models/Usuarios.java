package br.edu.unifor.ewallet.models;

import com.orm.SugarRecord;

import java.util.List;

/**
 * Created by alunor17 on 04/02/17.
 */

public class Usuarios extends SugarRecord {
    private String nome;
    private String email;
    private String senha;

    List<Conta> getContas() {
        return Conta.find(Conta.class, "usuario = ?", String.valueOf(getId()));
    }

    List<CartaoCredito> getCartoes() {
        return CartaoCredito.find(CartaoCredito.class, "usuario = ?", String.valueOf(getId()));
    }

    public Usuarios() {
    }

    public Usuarios(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
