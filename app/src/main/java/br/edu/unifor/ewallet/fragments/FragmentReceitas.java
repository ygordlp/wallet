package br.edu.unifor.ewallet.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import br.edu.unifor.ewallet.R;
import br.edu.unifor.ewallet.adapters.ListaReceitaAdapter;
import br.edu.unifor.ewallet.models.Receita;

/**
 * Created by alunor17 on 04/02/17.
 */

public class FragmentReceitas extends Fragment {

    private View rootview;
    private ListView listViewReceita;
    private ListaReceitaAdapter listaReceitaAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.rootview = inflater.inflate(R.layout.fragment_receitas, container, false);
        this.listViewReceita = (ListView) rootview.findViewById(R.id.listViewReceita);
        this.listaReceitaAdapter = new ListaReceitaAdapter(Receita.listAll(Receita.class), rootview.getContext());

        this.listViewReceita.setAdapter(this.listaReceitaAdapter);
        return rootview;
    }
}
