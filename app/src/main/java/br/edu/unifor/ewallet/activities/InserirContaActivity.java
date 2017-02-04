package br.edu.unifor.ewallet.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import br.edu.unifor.ewallet.R;
import br.edu.unifor.ewallet.controllers.ContaController;
import br.edu.unifor.ewallet.models.Conta;
import br.edu.unifor.ewallet.models.TipoConta;

/**
 * Created by Naldo on 2/4/2017.
 */

public class InserirContaActivity extends AppCompatActivity {

    private Spinner mSpinTipoConta;
    private EditText mTxtBanco;
    private EditText mTxtNumConta;
    private EditText mTxtTitulo;
    private EditText mTxtSaldo;
    private Spinner mSpinCor;
    private Button mBtnSalvar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inserir_conta);

        mSpinTipoConta = (Spinner) findViewById(R.id.spinTipoConta);
        mTxtBanco = (EditText) findViewById(R.id.txtBanco);
        mTxtNumConta = (EditText) findViewById(R.id.txtNumeroConta);
        mTxtTitulo = (EditText) findViewById(R.id.txtTitulo);
        mTxtSaldo = (EditText) findViewById(R.id.txtSaldo);
        mSpinCor = (Spinner) findViewById(R.id.spinCorConta);
        mBtnSalvar = (Button) findViewById(R.id.btnSalvar);


        mSpinTipoConta.setAdapter(new ArrayAdapter<TipoConta>(this, android.R.layout.simple_list_item_1, TipoConta.values()));

        mBtnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Log.i("teste", "onClick: " + mTxtBanco.getText().toString());
                //TipoConta tipoConta, String banco, String numeroConta, String titulo, String cor, Double saldo
                Conta conta = new Conta((TipoConta) mSpinTipoConta.getSelectedItem(),
                        mTxtBanco.getText().toString(), mTxtNumConta.getText().toString(), mTxtTitulo.getText().toString(),
                        mSpinCor.getSelectedItem().toString(), Double.parseDouble( mTxtSaldo.getText().toString()) );

                ContaController contaController = new ContaController();
                boolean result = contaController.verificarContaExistente(conta);
                if (result == true){
                    Toast.makeText(getApplicationContext(), "JA EXISTE", Toast.LENGTH_SHORT).show();
                }else{
                    contaController.inserirConta(conta);
                    Toast.makeText(getApplicationContext(), "SALVO", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }

}
