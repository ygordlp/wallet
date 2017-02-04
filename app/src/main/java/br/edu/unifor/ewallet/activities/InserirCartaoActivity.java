package br.edu.unifor.ewallet.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.Spinner;

import br.edu.unifor.ewallet.R;

/**
 * Created by Naldo on 2/4/2017.
 */

public class InserirCartaoActivity extends AppCompatActivity {
    Spinner mSpinBandeira;
    EditText mTxtNumeroCartao;
    EditText mTxtCodigo;
    EditText mTxtLimiteCartao;
    EditText mTxtDiaVencimentoFatura;
    EditText mTxtDiaFechamentoFatura;


    private void iniciarComponentes(){
        mSpinBandeira = (Spinner) findViewById(R.id.spinBandeira);
        mTxtNumeroCartao = (EditText) findViewById(R.id.txtNumeroCartao);
        mTxtCodigo = (EditText) findViewById(R.id.txtCodigoSeguranca);
        mTxtLimiteCartao = (EditText) findViewById(R.id.txtLimiteCartao);
        mTxtDiaVencimentoFatura = (EditText) findViewById(R.id.txtDiaVencimentoFatura);
        mTxtDiaFechamentoFatura = (EditText) findViewById(R.id.txtDiaFechamentoFatura);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        iniciarComponentes();
    }


}
