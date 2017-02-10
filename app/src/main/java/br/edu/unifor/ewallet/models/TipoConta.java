package br.edu.unifor.ewallet.models;

/**
 * Created by alunor17 on 04/02/17.
 */

public enum TipoConta {

    CORRENTE, POUPANCA, CARTEIRA;

    public String getString(){
        switch (this){
            case CORRENTE:
                return "Corrente";
            case POUPANCA:
                return "Poupança";
            case CARTEIRA:
                return "Carteira";
            default:
                return null;
        }
    }

    public static TipoConta getValue(String string) {
        switch (string) {
            case "Corrente":
                return CORRENTE;
            case "Poupança":
                return POUPANCA;
            case "Carteira":
                return CARTEIRA;
            default:
                return null;
        }
    }

}
