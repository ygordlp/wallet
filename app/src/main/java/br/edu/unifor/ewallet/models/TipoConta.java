package br.edu.unifor.ewallet.models;

/**
 * Created by alunor17 on 04/02/17.
 */

public enum TipoConta {

    CORRENTE, CARTEIRA;

    public String getString(){
        switch (this){
            case CORRENTE:
                return "Corrente";
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
            case "Carteira":
                return CARTEIRA;
            default:
                return null;
        }
    }

}
