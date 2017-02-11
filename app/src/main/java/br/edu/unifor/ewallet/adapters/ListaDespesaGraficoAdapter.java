package br.edu.unifor.ewallet.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

import br.edu.unifor.ewallet.R;
import br.edu.unifor.ewallet.controllers.DespesaController;
import br.edu.unifor.ewallet.models.Despesa;

/**
 * Created by alunor17 on 11/02/17.
 */

public class ListaDespesaGraficoAdapter extends BaseAdapter {
    private List<Despesa> despesas;
    private Context context;
    private LayoutInflater inflater;

    public ListaDespesaGraficoAdapter(List<Despesa> despesas, Context context) {
        this.despesas = despesas;
        this.context = context;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        if (despesas != null){
            return despesas.size();
        }

        return 0;
    }

    @Override
    public Object getItem(int i) {
        return despesas.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflater.inflate(R.layout.item_lista_despesa, viewGroup, false);


        TextView txtCategoriaDespesa = (TextView) view.findViewById(R.id.txtCategoriaDespesa);
        TextView txtValorDespesa = (TextView) view.findViewById(R.id.txtValorDespesa);
        TextView txtTipoContaDespesa = (TextView) view.findViewById(R.id.txtTipoContaDespesa);
        TextView txtDataDespesa = (TextView) view.findViewById(R.id.txtDataDespesa);

        TextView txtPorcentagem = (TextView) view.findViewById(R.id.txtPorcentagem);
        txtTipoContaDespesa.setText(String.format("%.2f",(despesas.get(i).getValor()/getValorTotal(despesas))*100) + " %");



        txtCategoriaDespesa.setText(despesas.get(i).getCategoria().getDescricao());
        txtValorDespesa.setText("R$ "+despesas.get(i).getValor());
//        txtTipoContaDespesa.setText( "");
        txtDataDespesa.setText("");



        return view;
    }
    private double getValorTotal(List<Despesa> despesasList){
        double valorTotal = 0;
        for (
                Despesa despesa : despesasList) {
            valorTotal += despesa.getValor();
        }



        return valorTotal;

    }


}
