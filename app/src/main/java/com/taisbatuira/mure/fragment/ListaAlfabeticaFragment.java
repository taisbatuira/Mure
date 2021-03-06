package com.taisbatuira.mure.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.taisbatuira.mure.activity.ConceitoActivity;
import com.taisbatuira.mure.ConceitoDAO;
import com.taisbatuira.mure.Firebase;
import com.taisbatuira.mure.R;
import com.taisbatuira.mure.adapter.ListaAlfabeticaAdapter;
import com.taisbatuira.mure.conceitos.Conceito;

import java.util.List;


/**
 * Created by taisbatuira on 06/06/17.
 */

public class ListaAlfabeticaFragment extends Fragment {

    private ListView lista;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View layout = inflater.inflate(R.layout.fragment_lista_alfabetica, container, false);

        this.lista = (ListView) layout.findViewById(R.id.lista_alfabetica);

        registerForContextMenu(this.lista);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView,
                                    View view, int posicao, long id) {

                Conceito conceito = (Conceito) adapterView.getItemAtPosition(posicao);
                Intent i = new Intent(getActivity(), ConceitoActivity.class);
                i.putExtra("CONCEITO_CONSULTADO",conceito);
                startActivity(i);

                Firebase.consultouConteudo("LISTA ALFABÉTICA",conceito,getActivity());
            }
        });
        return layout;
    }

    @Override
    public void onResume() {
        super.onResume();
        carregaLista();
    }

    private void carregaLista() {
        ConceitoDAO dao = new ConceitoDAO(getActivity());
        List<Conceito> conceitos = dao.listaDeConceitos(ConceitoDAO.ORDEM_ALFABETICA);

        ListaAlfabeticaAdapter adapter = new ListaAlfabeticaAdapter(getActivity(), conceitos);

        lista.setAdapter(adapter);
    }

}
