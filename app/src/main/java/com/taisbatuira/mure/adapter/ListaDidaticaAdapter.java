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

public class ListaDidaticaAdapter extends BaseAdapter {

    private List<Conceito> conceitos;
    private Context context;

    public ListaDidaticaAdapter(Context context, List<Conceito> conceitos) {
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

        String tipo = conceito.getTipo();

        if (tipo.equals("titulo")) {
            View linha_titulo = LayoutInflater.from(context).inflate(R.layout.item_conceito_titulo, listView, false);

            TextView campoTitulo = (TextView) linha_titulo.findViewById(R.id.conceito_titulo);
            campoTitulo.setText(conceito.getTitulo());

            return linha_titulo;

        } else {
            View linha_subtitulo = LayoutInflater.from(context).inflate(R.layout.item_conceito_subtitulo, listView, false);

            TextView campoTitulo = (TextView) linha_subtitulo.findViewById(R.id.conceito_subtitulo);
            campoTitulo.setText(conceito.getTitulo());

            return linha_subtitulo;
        }

    }
}
