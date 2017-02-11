package br.edu.unifor.ewallet.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.DefaultValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import br.edu.unifor.ewallet.R;
import br.edu.unifor.ewallet.adapters.ListaDespesaAdapter;
import br.edu.unifor.ewallet.adapters.ListaDespesaGraficoAdapter;
import br.edu.unifor.ewallet.controllers.DespesaController;
import br.edu.unifor.ewallet.models.Despesa;
import br.edu.unifor.ewallet.models.TipoDespesa;


public class FragmentDespesasGrafico extends Fragment {

    private View rootview;
    private ListView listViewDespesas;
    private ListaDespesaGraficoAdapter listaDespesaGraficoAdapter;
    private List<Despesa> despesasGrafico = new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.fragment_despesas_grafico, container, false);

        this.listViewDespesas = (ListView) rootview.findViewById(R.id.listDespesasGrafico);


        PieChart chart = (PieChart) rootview.findViewById(R.id.chart);
        List<PieEntry> entries = new ArrayList<>();

        HashMap<String, Float> map = new HashMap<String, Float>();

        for (Despesa despesa: DespesaController.getAll() ) {
            map.put(despesa.getTipoDespesa().getString() , verificaNumero(map.get(despesa.getTipoDespesa().getString())) + Float.valueOf(despesa.getValor().toString()));
        }

        Set<String> chaves = map.keySet();
        for (String chave : chaves) {
            if (chave != null){
                Despesa novaDespesa = new Despesa();
                novaDespesa.setTipoDespesa(TipoDespesa.getValue(chave));
                novaDespesa.setValor(Double.parseDouble(map.get(chave).toString()));
                despesasGrafico.add(novaDespesa);

                entries.add(new PieEntry(map.get(chave), chave));
            }
        }



        PieDataSet set = new PieDataSet(entries, "Election Results");
        set.setValueFormatter(new DefaultValueFormatter(2));
        set.setColors(ColorTemplate.VORDIPLOM_COLORS);
        PieData data = new PieData(set);
        chart.setData(data);
        chart.invalidate();
        data.setValueTextSize(15f);

        this.listaDespesaGraficoAdapter = new ListaDespesaGraficoAdapter(despesasGrafico, rootview.getContext());

        this.listViewDespesas.setAdapter(this.listaDespesaGraficoAdapter);
        return rootview;
    }

    public Float verificaNumero(Float n){
        if(n == null){
            return 0f;
        }
        return n;
    }


}
