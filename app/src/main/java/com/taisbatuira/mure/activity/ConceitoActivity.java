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
    private Conceito proximoConceito;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conceito);

//        Intent intent = getIntent();
//        String from = intent.getStringExtra("CONCEITO_CONSULTADO");
//        if ("CONCEITO_CONSULTADO".equals(from)) {
//            this.conceito = (Conceito) intent.getSerializableExtra("CONCEITO_CONSULTADO");
//        } else {
//            this.conceito = (Conceito) intent.getSerializableExtra("PROXIMO_CONCEITO");
//        }

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
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        Conceito proximo = proximo(conceito);

        Intent intent = new Intent(ConceitoActivity.this,
                ConceitoDidaticaActivity.class);

        intent.putExtra("PROXIMO_CONCEITO", proximo);
        startActivity(intent);
        return super.onOptionsItemSelected(item);
    }

    private Conceito proximo(Conceito conceito) {

        ConceitoDAO dao = new ConceitoDAO(this);
        List<Conceito> conceitos = dao.listaDeConceitos(ConceitoDAO.ORDEM_DIDATICA);

        Conceito proximoConceito = null;

        for (int i = 0; i < conceitos.size(); i++) {
            if (this.conceito.getTitulo().equals(conceitos.get(i).getTitulo())) {
                proximoConceito = conceitos.get(i + 1);
                return proximoConceito;
            }
        }
        return null;
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(ConceitoActivity.this,MainActivity.class);
        startActivity(intent);
    }
}