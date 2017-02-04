package br.edu.unifor.ewallet.models;

import com.orm.SugarRecord;

/**
 * Created by alunor17 on 04/02/17.
 */

public class Despesa extends SugarRecord {

    private Movimentacao movimentacao;
    private TipoDespesa tipoDespesa;

    public Despesa() {

    }

    public Despesa(Movimentacao movimentacao, TipoDespesa tipoDespesa) {
        this.movimentacao = movimentacao;
        this.tipoDespesa = tipoDespesa;
    }

    public Movimentacao getMovimentacao() {
        return movimentacao;
    }

    public void setMovimentacao(Movimentacao movimentacao) {
        this.movimentacao = movimentacao;
    }

    public TipoDespesa getTipoDespesa() {
        return tipoDespesa;
    }

    public void setTipoDespesa(TipoDespesa tipoDespesa) {
        this.tipoDespesa = tipoDespesa;
    }
}
