package br.edu.unifor.ewallet.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.getbase.floatingactionbutton.FloatingActionButton;

import java.util.List;

import br.edu.unifor.ewallet.R;
import br.edu.unifor.ewallet.controllers.ContaController;
import br.edu.unifor.ewallet.fragments.FragmentCartao;
import br.edu.unifor.ewallet.fragments.FragmentContas;
import br.edu.unifor.ewallet.fragments.FragmentDespesas;
import br.edu.unifor.ewallet.fragments.FragmentHome;
import br.edu.unifor.ewallet.fragments.FragmentMetas;
import br.edu.unifor.ewallet.fragments.FragmentMovimentacoes;
import br.edu.unifor.ewallet.fragments.FragmentReceitas;
import br.edu.unifor.ewallet.models.Conta;
import br.edu.unifor.ewallet.models.TipoConta;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private Fragment frag;
    private FloatingActionButton mFabCartaoCredito;
    private FloatingActionButton mFabReceitas;
    private FloatingActionButton mFabDespesas;
    private FloatingActionButton mFabMetas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Cadastro de Conta");
        setSupportActionBar(toolbar);

        this.mFabCartaoCredito = (FloatingActionButton) findViewById(R.id.fab_cartao_credito);
        this.mFabReceitas = (FloatingActionButton) findViewById(R.id.fab_receitas);
        this.mFabDespesas = (FloatingActionButton) findViewById(R.id.fab_despesas);
        this.mFabMetas = (FloatingActionButton) findViewById(R.id.fab_metas);
        
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        // FRAGMENT
        frag = (FragmentHome) getSupportFragmentManager().findFragmentByTag("mainFrag");
        if (frag == null) {
            frag = new FragmentHome();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_main, frag, "mainFrag");
            ft.commit();
        }

        this.mFabCartaoCredito.setOnClickListener(onClickListener);
        this.mFabReceitas.setOnClickListener(onClickListener);
        this.mFabDespesas.setOnClickListener(onClickListener);
        this.mFabMetas.setOnClickListener(onClickListener);

        criarContasPadrao();

    }

    private void criarContasPadrao() {

        List<Conta> contas = Conta.listAll(Conta.class);
        if (contas.size() >= 2) {
            return;
        }

        Conta contaCorrente = new Conta();
        contaCorrente.setTitulo("Conta Corrente");
        contaCorrente.setSaldo(0d);
        contaCorrente.setTipoConta(TipoConta.CORRENTE);
        ContaController.insert(contaCorrente);

        Conta carteira = new Conta();
        carteira.setTitulo("Carteira");
        carteira.setSaldo(1000d);
        carteira.setTipoConta(TipoConta.CARTEIRA);
        ContaController.insert(carteira);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            frag = new FragmentHome();
        } else if (id == R.id.nav_contas) {
            frag = new FragmentContas();
        } else if (id == R.id.nav_movimentacoes) {
            frag = new FragmentMovimentacoes();
        } else if (id == R.id.nav_cartao) {
            frag = new FragmentCartao();
        }else if (id == R.id.nav_receitas) {
            frag = new FragmentReceitas();
        } else if (id == R.id.nav_despesas) {
            frag = new FragmentDespesas();
        } else if (id == R.id.nav_metas) {
            frag = new FragmentMetas();
        }

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.content_main, frag, "mainFrag");
        ft.commit();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch(v.getId()){
                case R.id.fab_cartao_credito:
                    startActivity(new Intent(MainActivity.this, InserirCartaoActivity.class));
                    break;
                case R.id.fab_receitas:
                    startActivity(new Intent(MainActivity.this, CadastroReceitaActivity.class));
                    break;
                case R.id.fab_despesas:
                    startActivity(new Intent(MainActivity.this, InserirDespesaActivity.class));
                    break;
                case R.id.fab_metas:
//                    startActivity(new Intent(MainActivity.this, InserirContaActivity.class));
                    break;
            }

        }
    };
}
