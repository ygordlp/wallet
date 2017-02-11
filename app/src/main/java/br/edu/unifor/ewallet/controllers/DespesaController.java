package br.edu.unifor.ewallet.controllers;

import java.util.Date;
import java.util.List;

import br.edu.unifor.ewallet.models.Conta;
import br.edu.unifor.ewallet.models.Despesa;
import br.edu.unifor.ewallet.util.Util;


/**
 * Created by maycon on 2/10/17.
 */

public class DespesaController {

    public static List<Despesa> getAll() {
        return Despesa.listAll(Despesa.class);
    }

    public static Despesa getById(Long id) {
        return Despesa.findById(Despesa.class, id);
    }


    public static List<Despesa> getDespesasDoMes() {
        Date startOfMonth = Util.getStartOfMonth(new Date());
        return Despesa.find(Despesa.class, "data IS NOT NULL AND data >= " + startOfMonth.getTime());
    }

    public static List<Despesa> getDespesasDoMes(Date date) {
        if (date == null) {
            date = new Date();
        }
        Date startOfMonth = Util.getStartOfMonth(date);
        return Despesa.find(Despesa.class, "data IS NOT NULL AND data >= " + startOfMonth.getTime());
    }


    public static Long insert(Despesa despesa) {
        if (despesa.getData() == null) {
            despesa.setData(new Date());
        }
        Conta conta = despesa.getConta();
        conta.setSaldo(conta.getSaldo() - despesa.getValor());
        ContaController.update(conta, conta.getId());
        return despesa.save();
    }

    public static Long update(Despesa despesa, Long id) {
        Despesa despesaAtual = getById(id);
        despesaAtual.setConta(despesa.getConta());
        despesaAtual.setTipoDespesa(despesa.getTipoDespesa());
        despesaAtual.setValor(despesa.getValor());
        despesaAtual.setData(new Date());
        despesaAtual.setDescricao(despesa.getDescricao());
        despesaAtual.setPago(despesa.isPago());
        despesaAtual.setFixa(despesa.isFixa());
        return despesaAtual.save();
    }

    public static boolean delete(Long id) {
        Despesa despesaAtual = getById(id);
        return despesaAtual.delete();
    }
}
