package br.edu.unifor.ewallet.controllers;

import java.util.List;

import br.edu.unifor.ewallet.models.Conta;
import br.edu.unifor.ewallet.models.Despesa;
import br.edu.unifor.ewallet.models.Receita;

/**
 * Created by maycon on 2/10/17.
 */

public class ReceitaController {

    public static List<Receita> getAll() {
        return Receita.listAll(Receita.class);
    }

    public static Receita getById(Long id) {
        return Receita.findById(Receita.class, id);
    }

    public static Long insert(Receita receita) {
        Conta conta = receita.getConta();
        conta.setSaldo(conta.getSaldo() + receita.getValor());
        ContaController.update(conta, conta.getId());
        return receita.save();
    }

    public static Long update(Receita receita, Long id) {
        Receita receitaAtual = getById(id);
        receitaAtual.setConta(receita.getConta());
        receitaAtual.setTipoReceita(receita.getTipoReceita());
        receitaAtual.setValor(receita.getValor());
        receitaAtual.setData(receita.getData());
        receitaAtual.setDescricao(receita.getDescricao());
        receitaAtual.setRecebida(receita.isRecebida());
        receitaAtual.setFixa(receita.isFixa());
        return receitaAtual.save();
    }

    public static boolean delete(Long id) {
        Receita receitaAtual = getById(id);
        return receitaAtual.delete();
    }
}
