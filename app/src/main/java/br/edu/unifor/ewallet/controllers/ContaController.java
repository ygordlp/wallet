package br.edu.unifor.ewallet.controllers;

import java.util.List;

import br.edu.unifor.ewallet.models.Conta;

import static android.R.attr.author;

/**
 * Created by Naldo on 2/4/2017.
 */

public class ContaController {

    public void inserirConta(Conta conta){
        conta.save();
    }

    public boolean verificarContaExistente(Conta conta){
        List<Conta> contas = Conta.find(Conta.class, "banco = ? or numero_conta = ? ",  conta.getBanco().toString(),  conta.getNumeroConta().toString() );
//        List<Conta> contas = Conta.find(Conta.class, "banco = ? ",  conta.getBanco() );

        if (contas.size() > 0 && contas != null){
            return true;
        }else{
            return false;
        }

    }
}
