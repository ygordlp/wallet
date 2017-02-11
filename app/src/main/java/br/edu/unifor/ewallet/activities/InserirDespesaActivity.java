package br.edu.unifor.ewallet.activities;

import android.content.Intent;
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
import br.edu.unifor.ewallet.models.TipoConta;
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
    private Despesa despesa;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_despesa);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        despesa = (Despesa) getIntent().getSerializableExtra("despesa");

        this.coordinatorLayout = (CoordinatorLayout) findViewById(R.id.cadastro_despesa);
        this.mEdtValor = (EditText) findViewById(R.id.edt_valor_despesas);
        this.mEdtDataSaida = (EditText) findViewById(R.id.edt_data_saida);
        this.mEdtDescricao = (EditText) findViewById(R.id.edt_descricao);
        this.mSelectTipoDespesa = (Spinner) findViewById(R.id.select_tipo_despesa);
        this.mSelectContas = (Spinner) findViewById(R.id.select_contas);
        this.mIsPago = (CheckBox) findViewById(R.id.is_pago);
        this.mIsFixa = (CheckBox) findViewById(R.id.is_fixa);
        this.mBtnCadastra = (Button) findViewById(R.id.btn_cadastra);

        if (despesa != null){
            PovoarCampos(despesa);
        }

        this.mBtnCadastra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Despesa d;
                if (despesa != null){
                    long id = getIntent().getLongExtra("id", 0);
                    d = Despesa.findById(Despesa.class,id);
                } else {
                    despesa = new Despesa();
                }
                double valorSaldo = despesa.getConta().getSaldo();
                double despesaAnterior = despesa.getValor();


                despesa.setTipoDespesa(TipoDespesa.getValue(mSelectTipoDespesa.getSelectedItem().toString()));
                despesa.setValor(Double.valueOf(mEdtValor.getText().toString()));
                despesa.setDataSaida(mEdtDataSaida.getText().toString());
                despesa.setDescricao(mEdtDescricao.getText().toString());
                despesa.setFixa(mIsFixa.isChecked());
                despesa.setPago(mIsPago.isChecked());

                despesa.getConta().setSaldo((valorSaldo+despesaAnterior)-despesa.getValor());


                Snackbar snackbar = null;
                if (DespesaController.insert(despesa) != null) {
                    snackbar = Snackbar
                            .make(coordinatorLayout, "Despesa cadastrado com sucesso!", Snackbar.LENGTH_LONG);
//                    clearFields();

                } else {
                    snackbar = Snackbar
                            .make(coordinatorLayout, "Ocorreu um erro!", Snackbar.LENGTH_LONG);
                }
                snackbar.show();
            }
        });


    }

    private void PovoarCampos(Despesa d) {

        this.mEdtValor.setText(d.getValor()+"");

        this.mEdtDataSaida.setText(d.getDataSaida().toString());
        this.mEdtDescricao.setText(d.getDescricao());

        String[] tiposDespesas = getResources().getStringArray(R.array.tiposDespesa);

        for (int i = 0; i < tiposDespesas.length; i++) {
            if (d.getTipoDespesa().getString().equals(tiposDespesas[i])) {
                mSelectTipoDespesa.setSelection(i);
            }
        }

if(d.getConta().getTipoConta().equals(TipoConta.CARTEIRA))
    mSelectContas.setSelection(0);
        else
mSelectContas.setSelection(1);

         this.mIsPago = (CheckBox) findViewById(R.id.is_pago);
        if(d.isPago())
            mIsPago.setChecked(true);
        else
            mIsPago.setChecked(false);
        if(d.isFixa())
            mIsFixa.setChecked(true);
        else
            mIsFixa.setChecked(false);

        this.mBtnCadastra.setText("Atualizar");

//        this.mBtnCadastra.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                Despesa despesaUpdate = Despesa.findById(Despesa.class,d.getId());
//                despesaUpdate.setConta(ContaController.getByNome(mSelectContas.getSelectedItem().toString()));
//                despesaUpdate.setTipoDespesa();
//                despesaUpdate.setValor(Double.valueOf(mEdtValor.getText().toString()));
//                despesaUpdate.setDataSaida(mEdtDataSaida.getText().toString());
//                despesaUpdate.setDescricao(mEdtDescricao.getText().toString());
//                despesaUpdate.setFixa(mIsFixa.isChecked());
//                despesaUpdate.setPago(mIsPago.isChecked());
//
//                Despesa despesa = new Despesa(ContaController.getByNome(mSelectContas.getSelectedItem().toString()),
//                TipoDespesa.getValue(mSelectTipoDespesa.getSelectedItem().toString()),
//                Double.valueOf(mEdtValor.getText().toString()),
//                mEdtDataSaida.getText().toString(),
//                mEdtDescricao.getText().toString(),
//                mIsPago.isChecked(),
//                mIsFixa.isChecked());
//
//                Snackbar snackbar = null;
//                if (DespesaController.insert(despesa) != null) {
//                    snackbar = Snackbar
//                            .make(coordinatorLayout, "Despesa cadastrado com sucesso!", Snackbar.LENGTH_LONG);
////                    clearFields();
//
//                } else {
//                    snackbar = Snackbar
//                            .make(coordinatorLayout, "Ocorreu um erro!", Snackbar.LENGTH_LONG);
//                }
//                snackbar.show();
//            }
//        });
    }
}
