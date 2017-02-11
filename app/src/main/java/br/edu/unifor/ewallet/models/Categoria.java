package br.edu.unifor.ewallet.models;

import com.orm.SugarRecord;

/**
 * Created by Naldo on 2/11/2017.
 */

public class Categoria extends SugarRecord {
    private String descricao;
    private String icone;

    public Categoria(String descricao, String icone) {
        this.descricao = descricao;
        this.icone = icone;
    }

    public Categoria() {
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getIcone() {
        return icone;
    }

    public void setIcone(String icone) {
        this.icone = icone;
    }

    @Override
    public String toString() {
        return descricao;
    }
}
