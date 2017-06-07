package com.taisbatuira.mure;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.taisbatuira.mure.conceitos.Conceito;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by taisbatuira on 13/04/17.
 */

public class ConceitoDAO extends SQLiteOpenHelper{

    public static final String ORDEM_ALFABETICA = "titulo asc";
    public static final String ORDEM_DIDATICA = "ordem asc";

    public ConceitoDAO(Context context) {
        super(context,"mure", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        String tabela = "create table conceitos (ordem double, titulo varchar, conteudo text, exemplo text, tipo varchar);";
        db.execSQL(tabela);

        insere(db, 1.0, "HELLO WORLD!",
                "\t\t\t\tA linguagem que usaremos para exemplificação é o Java, considerado o pai da Orientação a Objetos.\n" +
                        "\t\t\t\tA história dessa linguagem pode ser consultada em  http://www.java.com/en/javahistory/\n" +
                        " \n" +
                        "\t\t\t\tJava não possui muitas regras, o que o torna simples.\n" +
                        "\t\t\t\tAlgumas regras iniciais:\n" +
                        "\t\t\t\t- O Java é case sensitive. Como boas práticas, usamos letra Maiúscula para nomes de classes e minúsculas para atritubos e métodos.\n" +
                        "\t\t\t\t- Toda linha deve ser finalizada com ponto-e-vírgula (;)\n" +
                        "\t\t\t\t- A aplicação java tem como ponto de entrada o main.\n" +
                        "\t\t\t\t- Manter dados e comportamentos próximos, respeitando a semântica.\n",
                "class MeuPrograma {\n" +
                        "<br/>&emsp;&emsp; public static void main(String[] args) {\n" +
                        "<br/>&emsp;&emsp;&emsp; System.out.println(\"Hello World!\");\n" +
                        "<br/>&emsp;&emsp; }\n" +
                        "<br/>&emsp; }\n",
                "titulo");

        insere(db, 2.0, "CLASSE",
                "\t\t\t\tUma classe é um conjunto de informações que especificam como deve ser o objeto a ser criado.\n" +
                        "\n" +
                        "\t\t\t\tAs propriedades deste objeto são definidas através dos atributos, cujos comportamentos são determinados ou manipulados através dos métodos (funções).\n"+
                        "\n" +
                        "\t\t\t\tPor exemplo, a Classe seria o manual de construção de um determinado modelo de carro.",
                "public class Animal",
                "titulo");

        insere(db, 3.0, "VARIÁVEL",
                "bla",
                "String nome = \"Tais\"",
                "subtitulo");
    }

    private void insere (SQLiteDatabase banco, Double ordem, String titulo, String conteudo, String exemplo, String categoria) {
        ContentValues cv = new ContentValues();

        cv.put("ordem", ordem);
        cv.put("titulo", titulo);
        cv.put("conteudo", conteudo);
        cv.put("exemplo", exemplo);
        cv.put("tipo", categoria);
        banco.insertOrThrow("conceitos",null,cv);
    }

    public List<Conceito> listaDeConceitos(String ordem){
        ArrayList<Conceito> lista = new ArrayList<>();
        String query = "select * from conceitos order by " + ordem + ";";
        Cursor cursor = getReadableDatabase().rawQuery(query,null);
        while (cursor.moveToNext()){
            Conceito conceito = criaConceitoNoBanco(cursor);
            lista.add(conceito);
        }
        cursor.close();
        return lista;
    }



    private Conceito criaConceitoNoBanco (Cursor cursor){
        Conceito conceito = new Conceito();

        String ordemCursor = cursor.getString(cursor.getColumnIndex("ordem"));
        conceito.setOrdem(ordemCursor);
        String tituloCursor = cursor.getString(cursor.getColumnIndex("titulo"));
        conceito.setTitulo(tituloCursor);
        String conteudoCursor = cursor.getString(cursor.getColumnIndex("conteudo"));
        conceito.setConteudo(conteudoCursor);
        String exemploCursor = cursor.getString(cursor.getColumnIndex("exemplo"));
        conceito.setExemplo(exemploCursor);
        String tipoCursor = cursor.getString(cursor.getColumnIndex("tipo"));
        conceito.setTipo(tipoCursor);
        return conceito;
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists conceitos");
        onCreate(db);
    }
}
