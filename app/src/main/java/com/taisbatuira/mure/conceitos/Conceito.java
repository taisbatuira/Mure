package com.taisbatuira.mure.conceitos;

import java.io.Serializable;

/**
 * Created by taisbatuira on 13/04/17.
 */

public class Conceito implements Serializable{
    private String ordem;
    private String titulo;
    private String conteudo;
    private String exemplo;
    private String tipo;

    public void setOrdem(String ordem) {
        this.ordem = ordem;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public void setExemplo(String exemplo) {
        this.exemplo = exemplo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }


    public String getOrdem() {
        return ordem;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getConteudo() {
        return conteudo;
    }

    public String getExemplo() {
        return exemplo;
    }

    public String getTipo() {
        return tipo;
    }
}
