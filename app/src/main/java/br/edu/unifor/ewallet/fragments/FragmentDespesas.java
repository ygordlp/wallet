package br.edu.unifor.ewallet.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

import br.edu.unifor.ewallet.R;
import br.edu.unifor.ewallet.adapters.ListaContaAdapter;
import br.edu.unifor.ewallet.adapters.ListaDespesaAdapter;
import br.edu.unifor.ewallet.controllers.DespesaController;
import br.edu.unifor.ewallet.models.Conta;
import br.edu.unifor.ewallet.models.Despesa;

/**
 * Created by alunor17 on 04/02/17.
 */

public class FragmentDespesas extends Fragment {


    private View rootview;
    private ListView listViewDespesas;
    private ListaDespesaAdapter listaDespesaAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.fragment_despesas, container, false);
        this.listViewDespesas = (ListView) rootview.findViewById(R.id.listViewDespesa);
        this.listaDespesaAdapter = new ListaDespesaAdapter(DespesaController.getAll(), rootview.getContext());

        this.listViewDespesas.setAdapter(this.listaDespesaAdapter);


        return rootview;
    }
}
