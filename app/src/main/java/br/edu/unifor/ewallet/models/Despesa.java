package br.edu.unifor.ewallet.models;

import com.google.common.base.Strings;
import com.orm.SugarRecord;

/**
 * Created by alunor17 on 04/02/17.
 */

public class Despesa extends SugarRecord {

    private Conta conta;
    private TipoDespesa tipoDespesa;
    private Double valor;
    private Strings dataSaida;
    private Strings descricao;
    private boolean isPago;
    private boolean isFixa;



    public Despesa() {

    }

    public Despesa(Conta conta, TipoDespesa tipoDespesa, Double valor, Strings dataSaida, Strings descricao, boolean isPago, boolean isFixa) {
        this.conta = conta;
        this.tipoDespesa = tipoDespesa;
        this.valor = valor;
        this.dataSaida = dataSaida;
        this.descricao = descricao;
        this.isPago = isPago;
        this.isFixa = isFixa;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    public TipoDespesa getTipoDespesa() {
        return tipoDespesa;
    }

    public void setTipoDespesa(TipoDespesa tipoDespesa) {
        this.tipoDespesa = tipoDespesa;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Strings getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(Strings dataSaida) {
        this.dataSaida = dataSaida;
    }

    public Strings getDescricao() {
        return descricao;
    }

    public void setDescricao(Strings descricao) {
        this.descricao = descricao;
    }

    public boolean isPago() {
        return isPago;
    }

    public void setPago(boolean pago) {
        isPago = pago;
    }

    public boolean isFixa() {
        return isFixa;
    }

    public void setFixa(boolean fixa) {
        isFixa = fixa;
    }
}
