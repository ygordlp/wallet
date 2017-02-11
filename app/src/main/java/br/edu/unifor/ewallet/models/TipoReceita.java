package br.edu.unifor.ewallet.models;

/**
 * Created by alunor17 on 04/02/17.
 */

public enum TipoReceita {

    SALARIO, INVESTIMENTO, PRESENTE, OUTROS;

    public String getString(){
        switch (this){
            case SALARIO:
                return "Salário";
            case INVESTIMENTO:
                return "Investimento";
            case PRESENTE:
                return "Presente";
            case OUTROS:
                return "Outros";
            default:
                return null;
        }
    }

    public static TipoReceita getValue(String string) {
        switch (string) {
            case "Salário":
                return SALARIO;
            case "Investimento":
                return INVESTIMENTO;
            case "Presente":
                return PRESENTE;
            case "Outros":
                return OUTROS;
            default:
                return null;
        }
    }

}
