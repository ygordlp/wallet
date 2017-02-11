package br.edu.unifor.ewallet.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import br.edu.unifor.ewallet.R;
import br.edu.unifor.ewallet.adapters.ListaCategoriasAdapter;
import br.edu.unifor.ewallet.adapters.ListaDespesaAdapter;
import br.edu.unifor.ewallet.controllers.CategoriaController;
import br.edu.unifor.ewallet.controllers.DespesaController;

/**
 * Created by Naldo on 2/11/2017.
 */

public class FragmentCategorias extends Fragment {

    private View rootview;
    private ListView listViewCategorias;
    private ListaCategoriasAdapter listaCategoriasAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.fragment_categorias, container, false);
        this.listViewCategorias = (ListView) rootview.findViewById(R.id.listViewCategorias);
        this.listaCategoriasAdapter = new ListaCategoriasAdapter(CategoriaController.getAll(), rootview.getContext());

        this.listViewCategorias.setAdapter(this.listaCategoriasAdapter);


        return rootview;
    }
}
