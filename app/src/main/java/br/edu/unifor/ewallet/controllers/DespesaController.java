package br.edu.unifor.ewallet.controllers;

import java.util.Date;
import java.util.List;

import br.edu.unifor.ewallet.models.Conta;
import br.edu.unifor.ewallet.models.Despesa;


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

//    public static List<String> getDespesasByTempo(){
////        Conta conta = Select.from(Conta.class).where(Condition.prop("tipo_conta").eq(TipoConta.getValue(tipoConta))).first();
//        if (null != null) {
////            return conta;
//        }
//        return null;
//    }

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
