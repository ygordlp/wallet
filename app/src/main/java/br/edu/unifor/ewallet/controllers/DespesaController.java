package br.edu.unifor.ewallet.controllers;

import com.orm.query.Condition;
import com.orm.query.Select;

import java.util.List;

import br.edu.unifor.ewallet.models.Conta;
import br.edu.unifor.ewallet.models.Despesa;
import br.edu.unifor.ewallet.models.Usuarios;

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

    public static Long insert(Despesa despesa) {
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
        despesaAtual.setDataSaida(despesa.getDataSaida());
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
