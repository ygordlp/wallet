package br.edu.unifor.ewallet.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import br.edu.unifor.ewallet.R;
import br.edu.unifor.ewallet.adapters.HomeListAdapter;
import br.edu.unifor.ewallet.controllers.ContaController;
import br.edu.unifor.ewallet.controllers.DespesaController;

/**
 * Created by alunor17 on 04/02/17.
 */

public class FragmentHome extends Fragment {

    private View rootview;
    private ListView listHome;
    private HomeListAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.fragment_home, container, false);

        adapter = new HomeListAdapter(getContext(), ContaController.getAll(), DespesaController.getAll());
        listHome = (ListView) rootview.findViewById(R.id.listHome);

        listHome.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        return rootview;
    }
}
