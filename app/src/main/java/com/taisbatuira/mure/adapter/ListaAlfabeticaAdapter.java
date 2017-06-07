package com.taisbatuira.mure.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.taisbatuira.mure.R;
import com.taisbatuira.mure.conceitos.Conceito;

import java.util.List;

/**
 * Created by taisbatuira on 07/06/17.
 */

public class ListaAlfabeticaAdapter extends BaseAdapter {

    private List<Conceito> conceitos;
    private Context context;

    public ListaAlfabeticaAdapter(Context context, List<Conceito> conceitos) {
        this.context = context;
        this.conceitos = conceitos;
    }

    @Override
    public int getCount() {
        return conceitos.size();
    }

    @Override
    public Object getItem(int posicao) {
        return conceitos.get(posicao);
    }

    @Override
    public long getItemId(int posicao) {
        return 0;
    }

    @Override
    public View getView(int posicao, View view, ViewGroup listView) {
        Conceito conceito = conceitos.get(posicao);

        View linha = LayoutInflater.from(this.context).inflate(R.layout.item_conceito_titulo, listView, false);

        TextView campoTitulo = (TextView) linha.findViewById(R.id.conceito_titulo);
        campoTitulo.setText(conceito.getTitulo());

        return linha;
    }
}
