package com.taisbatuira.mure.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.taisbatuira.mure.R;

/**
 * Created by taisbatuira on 17/06/17.
 */

public class AutoriaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_autoria);

        final String P1 = "\t\t\t\t"; // PARAGRAFO
        String autoriaConteudo = P1 + "Esta aplicação e seu conteúdo são de autoria própria.\n" +
                 P1 + "Os conceitos aqui apresentados encontram-se disponíveis em: ";
        String autoriaLink = "https://desvendandomobile.wordpress.com";

        TextView campoAutoriaTitulo = (TextView) findViewById(R.id.autoria_titulo);
        campoAutoriaTitulo.setText("Autoria");
        TextView campoAutoriaConteudo = (TextView) findViewById(R.id.autoria_conteudo);
        campoAutoriaConteudo.setText(autoriaConteudo);
        TextView campoAutoriaLink = (TextView) findViewById(R.id.autoria_link);
        campoAutoriaLink.setText(autoriaLink);
    }
}
