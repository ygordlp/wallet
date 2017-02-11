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

/**
 * Created by alunor17 on 10/02/17.
 */

public class ListaContaAdapter extends BaseAdapter {

    private List<Conta> contas;
    private Context context;
    private LayoutInflater inflater;

    public ListaContaAdapter(List<Conta> contas, Context context) {
        this.contas = contas;
        this.context = context;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return contas.size();
    }

    @Override
    public Object getItem(int i) {
        return contas.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflater.inflate(R.layout.item_lista_conta, viewGroup, false);

        TextView txtTituloConta = (TextView) view.findViewById(R.id.txtTitleConta);
        TextView txtTipoConta = (TextView) view.findViewById(R.id.txtTypeConta);
        TextView txtSaldoConta = (TextView) view.findViewById(R.id.txtSaldoContaItem);

        txtTituloConta.setText(contas.get(i).getTitulo());
        txtTipoConta.setText(contas.get(i).getTipoConta().getString());
        txtSaldoConta.setText(contas.get(i).getSaldo()+"");

        return view;
    }

}
