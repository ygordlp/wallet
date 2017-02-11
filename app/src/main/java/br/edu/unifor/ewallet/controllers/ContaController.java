package br.edu.unifor.ewallet.controllers;

import com.orm.query.Condition;
import com.orm.query.Select;

import java.util.List;

import br.edu.unifor.ewallet.models.Conta;
import br.edu.unifor.ewallet.models.TipoConta;
import br.edu.unifor.ewallet.models.Usuarios;

import static android.R.attr.author;

/**
 * Created by Naldo on 2/4/2017.
 */

public class ContaController {

    public static List<Conta> getAll() {
        return Conta.listAll(Conta.class);
    }

    public static Conta getById(Long id) {
        return Conta.findById(Conta.class, id);
    }

    public static Conta getByNome(String tipoConta) {
        Conta conta = Select.from(Conta.class).where(Condition.prop("tipo_conta").eq(TipoConta.getValue(tipoConta))).first();
        if (conta != null) {
            return conta;
        }
        return null;
    }

    public static Long insert(Conta conta) {
        return conta.save();
    }

    public static Long update(Conta conta, Long id) {
        Conta contaAtual = getById(id);
        contaAtual.setUsuario(conta.getUsuario());
        contaAtual.setTitulo(conta.getTitulo());
        contaAtual.setBanco(conta.getBanco());
        contaAtual.setCor(conta.getCor());
        contaAtual.setNumeroConta(conta.getNumeroConta());
        contaAtual.setSaldo(conta.getSaldo());
        contaAtual.setTipoConta(conta.getTipoConta());
        return contaAtual.save();
    }

    public static boolean delete(Long id) {
        Conta contaAtual = getById(id);
        return contaAtual.delete();
    }
}
