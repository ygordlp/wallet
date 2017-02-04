package br.edu.unifor.ewallet.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.edu.unifor.ewallet.R;

/**
 * Created by alunor17 on 04/02/17.
 */

public class FragmentReceitas extends Fragment {

    private View rootview;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.fragement_receitas, container, false);
        return rootview;
    }
}
