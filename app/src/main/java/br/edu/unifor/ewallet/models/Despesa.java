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
    private String dataSaida;
    private String descricao;
    private boolean isPago;
    private boolean isFixa;



    public Despesa() {

    }

    public Despesa(Conta conta, TipoDespesa tipoDespesa, Double valor, String dataSaida, String descricao, boolean isPago, boolean isFixa) {
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

    public String getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(String dataSaida) {
        this.dataSaida = dataSaida;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
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
