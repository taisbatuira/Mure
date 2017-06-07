package com.taisbatuira.mure;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.taisbatuira.mure.conceitos.Conceito;
import com.taisbatuira.mure.fragment.ExemploFragment;

public class ConceitoActivity extends AppCompatActivity {

    private Conceito conceito;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conceito);

        this.conceito = (Conceito) getIntent().getSerializableExtra("CONCEITO_CONSULTADO");

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
}

