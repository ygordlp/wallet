package br.edu.unifor.ewallet.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.List;

import br.edu.unifor.ewallet.R;
import br.edu.unifor.ewallet.controllers.ContaController;
import br.edu.unifor.ewallet.controllers.DespesaController;
import br.edu.unifor.ewallet.models.Conta;
import br.edu.unifor.ewallet.models.Despesa;
import br.edu.unifor.ewallet.models.TipoDespesa;

/**
 * Created by maycon on 2/10/17.
 */

public class InserirDespesaActivity extends AppCompatActivity {

    private EditText mEdtValor;
    private EditText mEdtDataSaida;
    private EditText mEdtDescricao;
    private Spinner mSelectTipoDespesa;
    private Spinner mSelectContas;
    private CheckBox mIsPago;
    private CheckBox mIsFixa;
    private Button mBtnCadastra;
    private CoordinatorLayout coordinatorLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_despesa);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        this.coordinatorLayout = (CoordinatorLayout) findViewById(R.id.cadastro_despesa);

        this.mEdtValor = (EditText) findViewById(R.id.edt_valor_despesas);
        this.mEdtDataSaida = (EditText) findViewById(R.id.edt_data_saida);
        this.mEdtDescricao = (EditText) findViewById(R.id.edt_descricao);
        this.mSelectTipoDespesa = (Spinner) findViewById(R.id.select_tipo_despesa);
        this.mSelectContas = (Spinner) findViewById(R.id.select_contas);
        this.mIsPago = (CheckBox) findViewById(R.id.is_pago);
        this.mIsFixa = (CheckBox) findViewById(R.id.is_fixa);
        this.mBtnCadastra = (Button) findViewById(R.id.btn_cadastra);

        this.mBtnCadastra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Despesa despesa = new Despesa(ContaController.getByNome(mSelectTipoDespesa.getSelectedItem().toString()),
                        TipoDespesa.getValue(mSelectTipoDespesa.getSelectedItem().toString()),
                        Double.valueOf(mEdtValor.getText().toString()), mEdtDataSaida.getText().toString(),
                        mEdtDescricao.getText().toString(), mIsPago.isChecked(), mIsFixa.isChecked());

                Snackbar snackbar = null;
                if (DespesaController.insert(despesa) != null) {
                    snackbar = Snackbar
                            .make(coordinatorLayout, "Usuario cadastrado com sucesso!", Snackbar.LENGTH_LONG);
//                    clearFields();

                } else {
                    snackbar = Snackbar
                            .make(coordinatorLayout, "Ocorreu um erro!", Snackbar.LENGTH_LONG);
                }
                snackbar.show();
            }
        });


    }
}
