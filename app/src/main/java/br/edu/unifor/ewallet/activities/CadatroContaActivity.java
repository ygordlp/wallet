package br.edu.unifor.ewallet.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.orhanobut.hawk.Hawk;

import br.edu.unifor.ewallet.R;
import br.edu.unifor.ewallet.controllers.ContaController;
import br.edu.unifor.ewallet.models.Conta;
import br.edu.unifor.ewallet.models.TipoConta;
import br.edu.unifor.ewallet.models.Usuarios;

public class CadatroContaActivity extends AppCompatActivity  implements View.OnClickListener{

    private Spinner spinTipoConta;
    private EditText txtBanco;
    private EditText txtNumeroConta;
    private EditText txtTitulo;
    private Spinner spinCorConta;
    private EditText txtSaldo;
    private Button btnSalvar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadatro_conta);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        this.spinTipoConta = (Spinner) findViewById(R.id.spinTipoConta);
        this.txtBanco = (EditText) findViewById(R.id.txtBanco);
        this.txtNumeroConta = (EditText) findViewById(R.id.txtNumeroConta);
        this.txtTitulo = (EditText) findViewById(R.id.txtTitulo);
        this.spinCorConta = (Spinner) findViewById(R.id.spinCorConta);
        this.txtSaldo = (EditText) findViewById(R.id.txtSaldo);
        this.btnSalvar = (Button) findViewById(R.id.btnSalvar);

        btnSalvar.setOnClickListener(this);
    }

    private void criarConta() {
        Conta conta = new Conta();

        conta.setTipoConta(TipoConta.getValue(spinTipoConta.getSelectedItem().toString()));
        conta.setTitulo(txtTitulo.getText().toString());
        conta.setSaldo(Double.parseDouble(txtSaldo.getText().toString()));
        conta.setNumeroConta(txtNumeroConta.getText().toString());
        conta.setBanco(txtBanco.getText().toString());
        conta.setCor(spinCorConta.getSelectedItem().toString());

        ContaController.insert(conta);
    }

    @Override
    public void onClick(View view) {
        criarConta();
        finish();
    }
}
