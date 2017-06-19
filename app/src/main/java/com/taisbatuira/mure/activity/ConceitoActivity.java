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

public class ConceitoActivity extends AppCompatActivity {

    private Conceito conceito;
    List<Conceito> conceitos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conceito);

        this.conceito = (Conceito) getIntent().getSerializableExtra("CONCEITO_CONSULTADO");
        System.out.println("1: " + this.conceito.getTitulo());

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
        getMenuInflater().inflate(R.menu.menu_didatica, menu);

        if (posicao(this.conceito) == 0) {
            menu.findItem(R.id.menu_anterior).setVisible(false);
        } else if (posicao(this.conceito) == (conceitos.size()-1)) {
            menu.findItem(R.id.menu_proximo).setVisible(false);
        }

        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        Intent intent = new Intent(ConceitoActivity.this,
                ConceitoActivity.class);

        switch (item.getItemId()) {
            case R.id.menu_anterior:
                Conceito anterior = anterior(this.conceito);
                intent.putExtra("CONCEITO_CONSULTADO", anterior);
                startActivity(intent);
                return true;

            case R.id.menu_proximo:
                Conceito proximo = proximo(this.conceito);
                intent.putExtra("CONCEITO_CONSULTADO", proximo);
                startActivity(intent);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private int posicao(Conceito conceito) {
        ConceitoDAO dao = new ConceitoDAO(this);
        List<Conceito> conceitos = dao.listaDeConceitos(ConceitoDAO.ORDEM_DIDATICA);
        this.conceitos = conceitos;

        for (int i = 0; i < conceitos.size(); i++) {
            if (conceito.getTitulo().equals(conceitos.get(i).getTitulo())) {
                return i;
            }
        }
        return 0;
    }

    private Conceito anterior(Conceito conceito) {

        int i = posicao(this.conceito);
        if (i > 0) {
            Conceito conceitoAnterior = conceitos.get(i-1);
            System.out.println(this.conceito.getTitulo());
            System.out.println("anterior: " + conceitoAnterior.getTitulo());
            return conceitoAnterior;
        }
        return conceito ;
    }

    private Conceito proximo(Conceito conceito) {

        int i = posicao(conceito);
        Conceito proximoConceito = conceitos.get(i+1);
        return proximoConceito;
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(ConceitoActivity.this,MainActivity.class);
        startActivity(intent);
    }

}