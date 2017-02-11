package br.edu.unifor.ewallet.models;

import com.google.common.base.Strings;
import com.orm.SugarRecord;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by alunor17 on 04/02/17.
 */

public class Despesa extends SugarRecord {

    private Conta conta;
    private TipoDespesa tipoDespesa;
    private Double valor;
    private Date data;
    private String descricao;
    private boolean isPago;
    private boolean isFixa;

    public Despesa() {

    }

    public Despesa(Conta conta, TipoDespesa tipoDespesa, Double valor, Date data, String descricao, boolean isPago, boolean isFixa) {
        this.conta = conta;
        this.tipoDespesa = tipoDespesa;
        this.valor = valor;
        this.data = data;
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

    public Date getData() {
        return this.data;
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

    public String getDateBr(){
        String stringData;

        Format formatter;

        formatter = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        stringData = formatter.format(data);

        return stringData;
    }
}
