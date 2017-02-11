package br.edu.unifor.ewallet.activities;

import android.support.v4.util.ArrayMap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Switch;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.DefaultValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import br.edu.unifor.ewallet.R;
import br.edu.unifor.ewallet.controllers.DespesaController;
import br.edu.unifor.ewallet.models.Despesa;

public class GraficoDespesasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grafico_despesas);

        PieChart chart = (PieChart) findViewById(R.id.chart);


        List<PieEntry> entries = new ArrayList<>();

//        ArrayList<Double> totalTipoDespesa = new ArrayList<>();

        HashMap<String, Float> map = new HashMap<String, Float>();


        for (Despesa despesa: DespesaController.getAll() ) {
            DecimalFormat df = new DecimalFormat("#.00");
            map.put(despesa.getTipoDespesa().getString() , verificaNumero(map.get(despesa.getTipoDespesa().getString())) + Float.valueOf(despesa.getValor().toString()));
        }

        Set<String> chaves = map.keySet();
        for (String chave : chaves) {
            if (chave != null){
                entries.add(new PieEntry(map.get(chave), chave));
            }
        }


//        entries.add(new PieEntry(18.5f, "Pink"));
//        entries.add(new PieEntry(26.7f, "Yellow"));
//        entries.add(new PieEntry(24.0f, "Red"));
//        entries.add(new PieEntry(30.8f, "Blue"));


        PieDataSet set = new PieDataSet(entries, "Election Results");
        set.setValueFormatter(new DefaultValueFormatter(2));
        set.setColors(ColorTemplate.VORDIPLOM_COLORS);
        PieData data = new PieData(set);
        chart.setData(data);
        chart.invalidate();
        data.setValueTextSize(15f);
    }
    public Float verificaNumero(Float n){
        if(n == null){
            return 0f;
        }
        return n;
    }
}
