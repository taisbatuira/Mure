package com.taisbatuira.mure;

import android.content.Context;
import android.os.Bundle;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.taisbatuira.mure.conceitos.Conceito;

/**
 * Created by taisbatuira on 16/06/17.
 */

public class Firebase {

    public static void consultouConteudo(String nomeDoFragment, Conceito conceito, Context context){
        FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(context);
        Bundle bundle = new Bundle();
        bundle.putString(FirebaseAnalytics.Param.ITEM_ID, conceito.getTitulo());
        bundle.putString(FirebaseAnalytics.Param.CONTENT_TYPE, nomeDoFragment);
        firebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle);
    }
}
