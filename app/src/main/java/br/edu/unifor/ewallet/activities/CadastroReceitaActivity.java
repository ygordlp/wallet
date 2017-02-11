package br.edu.unifor.ewallet.activities;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;

import java.util.Calendar;
import java.util.Date;

import br.edu.unifor.ewallet.R;
import br.edu.unifor.ewallet.controllers.ContaController;
import br.edu.unifor.ewallet.controllers.DespesaController;
import br.edu.unifor.ewallet.controllers.ReceitaController;
import br.edu.unifor.ewallet.models.Receita;
import br.edu.unifor.ewallet.models.TipoReceita;

public class CadastroReceitaActivity extends AppCompatActivity implements View.OnClickListener, DatePickerDialog.OnDateSetListener{

    private EditText mEdtValor;
    private TextView mEdtData;
    private EditText mEdtDescricao;
    private Spinner mSelectTipoReceita;
    private Spinner mSelectContas;
    private CheckBox mIsRecebida;
    private CheckBox mIsFixa;
    private Button mBtnCadastra;
    private CoordinatorLayout coordinatorLayout;
    Calendar now = Calendar.getInstance();
    private Date dateSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_receita);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        this.mEdtValor = (EditText) findViewById(R.id.edt_valor_receita);
        this.mEdtData = (TextView) findViewById(R.id.edt_data_entrada);
        this.mEdtDescricao = (EditText) findViewById(R.id.edt_descricao);
        this.mSelectTipoReceita = (Spinner) findViewById(R.id.select_tipo_receita);
        this.mSelectContas = (Spinner) findViewById(R.id.select_contas);
        this.mIsRecebida = (CheckBox) findViewById(R.id.checkbox_recebido);
        this.mIsFixa = (CheckBox) findViewById(R.id.checkbox_fixa);
        this.mBtnCadastra = (Button) findViewById(R.id.btn_cadastra);
        this.coordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinatorReceita);

        this.mBtnCadastra.setOnClickListener(this);
        this.mEdtData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog dpd = DatePickerDialog.newInstance(
                        CadastroReceitaActivity.this,
                        now.get(Calendar.YEAR),
                        now.get(Calendar.MONTH),
                        now.get(Calendar.DAY_OF_MONTH)
                );
                dpd.show(getFragmentManager(), "Datepickerdialog");
            }
        });
    }

    public void salvaReceita(){
        Receita receita = new Receita();
        receita.setConta(ContaController.getByNome(mSelectContas.getSelectedItem().toString()));
        receita.setData(dateSelected);
        receita.setDescricao(mEdtDescricao.getText().toString());
        receita.setFixa(mIsFixa.isChecked());
        receita.setTipoReceita(TipoReceita.getValue(mSelectTipoReceita.getSelectedItem().toString()));
        receita.setRecebida(mIsRecebida.isChecked());
        receita.setValor(Double.parseDouble(mEdtValor.getText().toString()));

        Snackbar snackbar = null;
        if (ReceitaController.insert(receita) != null) {
            snackbar = Snackbar
                    .make(coordinatorLayout, "Receita cadastrada com sucesso!", Snackbar.LENGTH_LONG);
//                    clearFields();

        } else {
            snackbar = Snackbar
                    .make(coordinatorLayout, "Ocorreu um erro!", Snackbar.LENGTH_LONG);
        }
        snackbar.show();
    }

    @Override
    public void onClick(View v) {
        salvaReceita();
    }

    @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
        String dateScreen = ""+dayOfMonth+"/"+(monthOfYear+1)+"/"+year;
        String date = ""+(monthOfYear+1)+"/"+dayOfMonth+"/"+year;
        dateSelected = new Date(Date.parse(date));
        mEdtData.setText(dateScreen);
    }
}
