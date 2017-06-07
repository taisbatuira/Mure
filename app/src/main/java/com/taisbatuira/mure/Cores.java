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

        String[] coresAPI = new String[]{"import","public","class","new","extends","return"};
        highlighter.setColorForTheToken(coresAPI,"#cc7832");

        return highlighter.getHighlightedText(texto);
    }
}
