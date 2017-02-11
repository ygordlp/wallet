package br.edu.unifor.ewallet.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import br.edu.unifor.ewallet.R;
import br.edu.unifor.ewallet.controllers.DespesaController;
import br.edu.unifor.ewallet.models.Conta;
import br.edu.unifor.ewallet.models.Despesa;
import br.edu.unifor.ewallet.util.Util;

/**
 * Created by Renan on 11/02/2017.
 */

public class HomeListAdapter extends BaseAdapter implements DatePickerDialog.OnDateSetListener {

    private Context context;
    private List<Conta> contas;
    private List<Despesa> despesas;
    private LayoutInflater inflater;
    private Date dateSelected = new Date();
    Calendar now = Calendar.getInstance();
    Activity activity;

    public HomeListAdapter(Context context, List<Conta> contas, Activity activity, List<Despesa> despesas) {
        this.context = context;
        this.contas = contas;
        this.despesas = despesas;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return contas.size()+despesas.size()+2;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        if (position == 0){
            view = inflater.inflate(R.layout.item_list_home_header, parent, false);

            TextView txtTitulo = (TextView) view.findViewById(R.id.txtTitleContas);
            txtTitulo.setText("Contas");
        } else if (position <= contas.size()){
            view = inflater.inflate(R.layout.item_lista_conta, parent, false);

            TextView txtTitulo = (TextView) view.findViewById(R.id.txtTitleConta);
            TextView txtTipo = (TextView) view.findViewById(R.id.txtTypeConta);
            TextView txtSaldo = (TextView) view.findViewById(R.id.txtSaldoContaItem);

            txtTitulo.setText(contas.get(position - 1).getTitulo());
            txtTipo.setText(contas.get(position - 1).getTipoConta().getString());
            txtSaldo.setText(contas.get(position - 1).getSaldo()+"");
        } else if (position == contas.size() +1){
            view = inflater.inflate(R.layout.item_list_home_header, parent, false);

            TextView txtTitulo = (TextView) view.findViewById(R.id.txtTitleContas);
            txtTitulo.setText("Despesas do mês (" + Util.getMonthName(dateSelected) + "/" + Util.getYear(dateSelected) + ")");
            txtTitulo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    DatePickerDialog dpd = DatePickerDialog.newInstance(
                            HomeListAdapter.this,
                            now.get(Calendar.YEAR),
                            now.get(Calendar.MONTH),
                            now.get(Calendar.DAY_OF_MONTH)
                    );
                    dpd.show(activity.getFragmentManager(), "Datepickerdialog");
                }
            });
        } else {
            view = inflater.inflate(R.layout.item_lista_despesa, parent, false);

            TextView txtCategoriaDespesa = (TextView) view.findViewById(R.id.txtCategoriaDespesa);
            TextView txtValorDespesa = (TextView) view.findViewById(R.id.txtValorDespesa);
            TextView txtTipoContaDespesa = (TextView) view.findViewById(R.id.txtTipoContaDespesa);
            TextView txtDataDespesa = (TextView) view.findViewById(R.id.txtDataDespesa);

            txtCategoriaDespesa.setText(despesas.get(position - 2 - contas.size()).getCategoria().getDescricao());
            txtValorDespesa.setText("R$ "+despesas.get(position - 2 - contas.size()).getValor());
            txtTipoContaDespesa.setText( despesas.get(position - 2 - contas.size()).getConta().getTipoConta().getString());
            txtDataDespesa.setText(despesas.get(position - 2 - contas.size()).getDateBr());
        }
        return view;
    }

    @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
        String date = ""+(monthOfYear+1)+"/"+dayOfMonth+"/"+year;
        dateSelected = new Date(Date.parse(date));
        despesas = DespesaController.getDespesasDoMes(dateSelected);
//        monthFilter = Util.getMonthName(dateSelected);
        notifyDataSetChanged();
    }
}
