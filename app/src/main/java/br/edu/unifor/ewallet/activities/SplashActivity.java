package br.edu.unifor.ewallet.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.orhanobut.hawk.Hawk;

import br.edu.unifor.ewallet.R;
import br.edu.unifor.ewallet.models.Usuarios;


public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Toolbar toolbar = (Toolbar) findViewById(R .id.toolbar);
        setSupportActionBar(toolbar);

        new CountDownTimer(1000, 5000){

            @Override
            public void onTick(long l) {

            }

            @Override
            public void onFinish() {
                Usuarios user = Hawk.get("user");
                if (user == null) {
                    startActivity(new Intent(SplashActivity.this, LoginActivity.class));
                } else {
                    startActivity(new Intent(SplashActivity.this, MainActivity.class));
                }
            }
        }.start();
    }

}
