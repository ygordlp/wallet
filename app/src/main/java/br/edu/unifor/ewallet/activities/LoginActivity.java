package br.edu.unifor.ewallet.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.orhanobut.hawk.Hawk;

import br.edu.unifor.ewallet.R;
import br.edu.unifor.ewallet.controllers.UsuarioController;
import br.edu.unifor.ewallet.models.Usuarios;

public class LoginActivity extends AppCompatActivity {

    private EditText mEdtEmail;
    private EditText mEdtSenha;
    private TextView mBtnRegister;
    private Button mBtnLogin;
    private CoordinatorLayout coordinatorLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        this.coordinatorLayout = (CoordinatorLayout) findViewById(R.id.login);

        this.mEdtEmail = (EditText) findViewById(R.id.edt_email);
        this.mEdtSenha = (EditText) findViewById(R.id.edt_senha);
        this.mBtnRegister = (TextView) findViewById(R.id.btn_registra);
        this.mBtnLogin = (Button) findViewById(R.id.btn_login);

        this.mBtnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, CadastroUsuarioActivity.class));
            }
        });

        this.mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Usuarios usuario = UsuarioController.getByEmailSenha(mEdtEmail.getText().toString(), mEdtSenha.getText().toString());

                if (usuario != null) {
                    Hawk.put("user", usuario);
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                } else {
                    Snackbar snackbar = Snackbar
                            .make(coordinatorLayout, "Não foi possivel efetua o login!", Snackbar.LENGTH_LONG);
                    snackbar.show();
                }
            }
        });
    }

}
