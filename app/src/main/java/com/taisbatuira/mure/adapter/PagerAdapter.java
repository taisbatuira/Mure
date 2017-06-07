package com.taisbatuira.mure.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.taisbatuira.mure.fragment.ListaAlfabeticaFragment;
import com.taisbatuira.mure.fragment.ListaOrdenadaFragment;

/**
 * Created by taisbatuira on 07/06/17.
 */

public class PagerAdapter extends FragmentStatePagerAdapter {
    private ListaAlfabeticaFragment fragmentAlfabetica;
    private ListaOrdenadaFragment fragmentOrdenada;


    public PagerAdapter(FragmentManager fm, ListaAlfabeticaFragment fragmentAlfabetica, ListaOrdenadaFragment fragmentOrdenada) {
        super(fm);
        this.fragmentAlfabetica = fragmentAlfabetica;
        this.fragmentOrdenada = fragmentOrdenada;

    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return "Didática";
        } else {
            return "Alfabética";
        }
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return fragmentOrdenada;
        } else {
            return fragmentAlfabetica;
        }
    }

    @Override
    public int getCount() {
        return 2;
    }


}
