package br.edu.unifor.ewallet.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import br.edu.unifor.ewallet.R;
import br.edu.unifor.ewallet.models.Categoria;

/**
 * Created by Naldo on 2/11/2017.
 */

public class ListaCategoriasAdapter extends BaseAdapter {
    private List<Categoria> categorias;
    private Context context;
    private LayoutInflater inflater;

    public ListaCategoriasAdapter(List<Categoria> categorias, Context context) {
        this.categorias = categorias;
        this.context = context;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        if (categorias != null){
            return categorias.size();
        }

        return 0;
    }

    @Override
    public Categoria getItem(int i) {
        return categorias.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflater.inflate(R.layout.item_lista_categoria, viewGroup, false);

        TextView txtCategoriaDespesa = (TextView) view.findViewById(R.id.txtDescricaoItemCategoria);
        txtCategoriaDespesa.setText(categorias.get(i).getDescricao());
        return view;
    }
}
