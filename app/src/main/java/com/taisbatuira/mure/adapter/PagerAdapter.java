package com.taisbatuira.mure.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.taisbatuira.mure.fragment.ListaAlfabeticaFragment;
import com.taisbatuira.mure.fragment.ListaDidaticaFragment;

/**
 * Created by taisbatuira on 07/06/17.
 */

public class PagerAdapter extends FragmentStatePagerAdapter {
    private ListaAlfabeticaFragment fragmentAlfabetica;
    private ListaDidaticaFragment fragmentDidatica;


    public PagerAdapter(FragmentManager fm, ListaAlfabeticaFragment fragmentAlfabetica, ListaDidaticaFragment fragmentDidatica) {
        super(fm);
        this.fragmentAlfabetica = fragmentAlfabetica;
        this.fragmentDidatica = fragmentDidatica;

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
            return fragmentDidatica;
        } else {
            return fragmentAlfabetica;
        }
    }

    @Override
    public int getCount() {
        return 2;
    }


}
