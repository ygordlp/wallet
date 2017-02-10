package br.edu.unifor.ewallet.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.Spinner;

import br.edu.unifor.ewallet.R;

/**
 * Created by Naldo on 2/4/2017.
 */

public class InserirCartaoActivity extends AppCompatActivity {
    private Spinner mSpinBandeira;
    private EditText mTxtNumeroCartao;
    private EditText mTxtCodigo;
    private EditText mTxtLimiteCartao;
    private EditText mTxtDiaVencimentoFatura;
    private EditText mTxtDiaFechamentoFatura;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inserir_cartao);
        iniciarComponentes();
    }

    private void iniciarComponentes(){
        mSpinBandeira = (Spinner) findViewById(R.id.spinBandeira);
        mTxtNumeroCartao = (EditText) findViewById(R.id.txtNumeroCartao);
        mTxtCodigo = (EditText) findViewById(R.id.txtCodigoSeguranca);
        mTxtLimiteCartao = (EditText) findViewById(R.id.txtLimiteCartao);
        mTxtDiaVencimentoFatura = (EditText) findViewById(R.id.txtDiaVencimentoFatura);
        mTxtDiaFechamentoFatura = (EditText) findViewById(R.id.txtDiaFechamentoFatura);
    }
}
