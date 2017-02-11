package br.edu.unifor.ewallet.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import br.edu.unifor.ewallet.R;
import br.edu.unifor.ewallet.models.Conta;
import br.edu.unifor.ewallet.models.Receita;

/**
 * Created by alunor17 on 10/02/17.
 */

public class ListaReceitaAdapter extends BaseAdapter {

    private List<Receita> receitas;
    private Context context;
    private LayoutInflater inflater;

    public ListaReceitaAdapter(List<Receita> receitas, Context context) {
        this.receitas = receitas;
        this.context = context;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return receitas.size();
    }

    @Override
    public Object getItem(int i) {
        return receitas.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflater.inflate(R.layout.item_lista_receita, viewGroup, false);

        TextView txtTipoReceita = (TextView) view.findViewById(R.id.txtTipoReceita);
        TextView txtValorReceita = (TextView) view.findViewById(R.id.txtValorReceita);

        txtTipoReceita.setText(receitas.get(i).getTipoReceita().getString());
        txtValorReceita.setText(receitas.get(i).getValor()+"");

        return view;
    }

}
