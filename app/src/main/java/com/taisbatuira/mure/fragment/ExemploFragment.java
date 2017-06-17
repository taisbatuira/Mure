package com.taisbatuira.mure.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.taisbatuira.mure.Cores;
import com.taisbatuira.mure.R;
import com.taisbatuira.mure.conceitos.Conceito;

/**
 * Created by taisbatuira on 19/05/17.
 */

@SuppressLint("ValidFragment")
public class ExemploFragment extends Fragment {

    private Conceito conceito;

    public ExemploFragment(Conceito conceito) {
        this.conceito = conceito;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        Cores corDoTexto = new Cores();

        View layoutExemplo = inflater.inflate(R.layout.fragment_exemplo, container,false);

        TextView campoExemplo = (TextView) layoutExemplo.findViewById(R.id.exemplo);
        campoExemplo.setText(Html.fromHtml(corDoTexto.colore(conceito.getExemplo())));

        System.out.println(getActivity().toString());

        return layoutExemplo;
    }
}
