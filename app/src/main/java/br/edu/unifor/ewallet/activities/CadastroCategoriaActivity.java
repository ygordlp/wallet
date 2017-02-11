package br.edu.unifor.ewallet.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import br.edu.unifor.ewallet.R;
import br.edu.unifor.ewallet.controllers.CategoriaController;
import br.edu.unifor.ewallet.models.Categoria;

public class CadastroCategoriaActivity extends AppCompatActivity implements View.OnClickListener {
    EditText txtDescricaoCategoria;
    EditText txtIconeCategoria;
    Button   btnCadastraCategoria;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_categoria);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        txtDescricaoCategoria = (EditText) findViewById(R.id.txtDescricaoCategoria);
        txtIconeCategoria = (EditText) findViewById(R.id.txtIconeCategoria);
        btnCadastraCategoria = (Button) findViewById(R.id.btnCadastraCategoria);
        btnCadastraCategoria.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        CategoriaController.insert(criarCategoria());
        finish();
    }

    private Categoria criarCategoria(){
        Categoria categoria = new Categoria();
        categoria.setDescricao(txtDescricaoCategoria.getText().toString());
        categoria.setIcone(txtIconeCategoria.getText().toString());
        return categoria;
    }

}
