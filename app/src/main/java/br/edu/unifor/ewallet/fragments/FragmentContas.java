package br.edu.unifor.ewallet.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.Iterator;

import br.edu.unifor.ewallet.R;
import br.edu.unifor.ewallet.adapters.ListaContaAdapter;
import br.edu.unifor.ewallet.models.Conta;

/**
 * Created by alunor17 on 04/02/17.
 */

public class FragmentContas extends Fragment {

    private View rootview;
    private ListView listViewContas;
    private ListaContaAdapter listaContaAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.rootview = inflater.inflate(R.layout.fragment_contas, container, false);
        this.listViewContas = (ListView) rootview.findViewById(R.id.listViewConta);
        this.listaContaAdapter = new ListaContaAdapter(Conta.listAll(Conta.class), rootview.getContext());

        this.listViewContas.setAdapter(this.listaContaAdapter);
        return rootview;
    }
}
