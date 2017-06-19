package com.taisbatuira.mure.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.taisbatuira.mure.ConceitoDAO;
import com.taisbatuira.mure.R;
import com.taisbatuira.mure.conceitos.Conceito;
import com.taisbatuira.mure.fragment.ExemploFragment;

import java.util.List;

/**
 * Created by taisbatuira on 17/06/17.
 */

public class ConceitoDidaticaActivity extends AppCompatActivity {
    private Conceito conceito;
    List<Conceito> conceitos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conceito);

        this.conceito = (Conceito) getIntent().getSerializableExtra("PROXIMO_CONCEITO");

        TextView campoTitulo = (TextView) findViewById(R.id.titulo);
        campoTitulo.setText(conceito.getTitulo());
        TextView campoConteudo = (TextView) findViewById(R.id.conteudo);
        campoConteudo.setText(conceito.getConteudo());

        FragmentTransaction tx = getSupportFragmentManager().beginTransaction();
        tx.replace(R.id.frame, new ExemploFragment(conceito));
        tx.commit();

    }

    public Conceito getConceito() {
        return this.conceito;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        if (posicao(conceito) < (conceitos.size())-1) {
            getMenuInflater().inflate(R.menu.menu_didatica, menu);
            return true;
        } else {
            return false;
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        Conceito proximo = proximo(conceito);

        Intent intent = new Intent(ConceitoDidaticaActivity.this,
                ConceitoDidaticaActivity.class);

        intent.putExtra("PROXIMO_CONCEITO", proximo);
        startActivity(intent);
        return super.onOptionsItemSelected(item);
    }


    private int posicao(Conceito conceito) {
        ConceitoDAO dao = new ConceitoDAO(this);
        List<Conceito> conceitos = dao.listaDeConceitos(ConceitoDAO.ORDEM_DIDATICA);
        this.conceitos = conceitos;

        for (int i = 0; i < conceitos.size(); i++) {
            if (this.conceito.getTitulo().equals(conceitos.get(i).getTitulo())) {
                return i;
            }
        }
        return 0;
    }

    private Conceito proximo(Conceito conceito) {

        int i = posicao(conceito);
        Conceito proximoConceito = conceitos.get(i+1);
        return proximoConceito;
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(ConceitoDidaticaActivity.this,MainActivity.class);
        startActivity(intent);
    }

}
