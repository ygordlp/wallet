package br.edu.unifor.ewallet.models;

/**
 * Created by alunor17 on 04/02/17.
 */

public enum TipoDespesa {

    ALIMENTACAO, EDUCACAO, LAZER, MORADIA, PAGAMENTOS, ROUPA, SAUDE, TRANSPORTE, OUTROS;

    public String getString(){
        switch (this){
            case ALIMENTACAO:
                return "Alimentação";
            case EDUCACAO:
                return "Educação";
            case LAZER:
                return "Lazer";
            case MORADIA:
                return "Moradia";
            case PAGAMENTOS:
                return "Pagamentos";
            case ROUPA:
                return "Roupa";
            case SAUDE:
                return "Saúde";
            case TRANSPORTE:
                return "Transporte";
            case OUTROS:
                return "Outros";
            default:
                return null;
        }
    }

    public static TipoDespesa getValue(String string) {
        switch (string){
            case "Alimentação":
                return ALIMENTACAO;
            case "Educação":
                return EDUCACAO;
            case "Lazer":
                return LAZER;
            case "Moradia":
                return MORADIA;
            case "Pagamentos":
                return PAGAMENTOS;
            case "Roupa":
                return ROUPA;
            case "Saúde":
                return SAUDE;
            case "Transporte":
                return TRANSPORTE;
            case "Outros":
                return OUTROS;
            default:
                return null;
        }
    }

}
