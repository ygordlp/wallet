package br.edu.unifor.ewallet.activities;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import br.edu.unifor.ewallet.R;
import br.edu.unifor.ewallet.controllers.UsuarioController;
import br.edu.unifor.ewallet.models.Usuarios;

/**
 * Created by maycon on 2/10/17.
 */
public class CadastroUsuarioActivity extends AppCompatActivity {

    private EditText mEdtNome;
    private EditText mEdtEmail;
    private EditText mEdtSenha;
    private Button mBtnCadastra;
    private CoordinatorLayout coordinatorLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_usuario);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        this.coordinatorLayout = (CoordinatorLayout) findViewById(R.id.cadastro_usuario);

        this.mEdtNome = (EditText) findViewById(R.id.edt_nome);
        this.mEdtEmail = (EditText) findViewById(R.id.edt_email);
        this.mEdtSenha = (EditText) findViewById(R.id.edt_senha);
        this.mBtnCadastra = (Button) findViewById(R.id.btn_cadastra);

        this.mBtnCadastra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Usuarios usuarios = new Usuarios(mEdtNome.getText().toString(), mEdtEmail.getText().toString(), mEdtSenha.getText().toString());

                Snackbar snackbar = null;
                if (UsuarioController.insert(usuarios) != null) {
                    snackbar = Snackbar
                            .make(coordinatorLayout, "Usuario cadastrado com sucesso!", Snackbar.LENGTH_LONG);
                    clearFields();

                } else {
                    snackbar = Snackbar
                            .make(coordinatorLayout, "Ocorreu um erro!", Snackbar.LENGTH_LONG);
                }
                snackbar.show();
            }
        });
    }

    private void clearFields() {
        this.mEdtNome.setText("");
        this.mEdtEmail.setText("");
        this.mEdtSenha.setText("");
    }
}
