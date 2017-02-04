package br.edu.unifor.ewallet.models;

import com.orm.SugarRecord;

/**
 * Created by alunor17 on 04/02/17.
 */

public class Receita extends SugarRecord {

    private Movimentacao movimentacao;
    private TipoReceita tipoReceita;

    public Receita() {

    }

    public Receita(Movimentacao movimentacao, TipoReceita tipoReceita) {
        this.movimentacao = movimentacao;
        this.tipoReceita = tipoReceita;
    }

    public Movimentacao getMovimentacao() {
        return movimentacao;
    }

    public void setMovimentacao(Movimentacao movimentacao) {
        this.movimentacao = movimentacao;
    }

    public TipoReceita getTipoReceita() {
        return tipoReceita;
    }

    public void setTipoReceita(TipoReceita tipoReceita) {
        this.tipoReceita = tipoReceita;
    }
}
