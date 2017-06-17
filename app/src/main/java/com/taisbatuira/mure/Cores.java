package com.taisbatuira.mure;

import com.github.akshay_naik.texthighlighterapi.TextHighlighter;

/**
 * Created by taisbatuira on 13/04/17.
 */

public class Cores extends TextHighlighter {

    public String colore(String texto) {

        TextHighlighter highlighter = new TextHighlighter();

        highlighter.setColorForTheToken("nome", "#ff0000");
        highlighter.setColorForTheToken("Text", "purple");
        highlighter.setColorForTheToken("Highlighter", "blue");

        String[] padraoLaranja = new String[]{"import","public","private","protected","class","package","new","extends","return", "static","void", "int", "double", "boolean", "(int", "if", "else", "for", "while", "do", "this.", "true", "String"};
        highlighter.setColorForTheToken(padraoLaranja,"#cc7832");

        String[] padraoAzul = new String[]{"out"};
        highlighter.setColorForTheToken(padraoAzul,"#0000FF");

        return highlighter.getHighlightedText(texto);
    }
}
