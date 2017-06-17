package com.taisbatuira.mure;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.taisbatuira.mure.adapter.PagerAdapter;
import com.taisbatuira.mure.fragment.ListaAlfabeticaFragment;
import com.taisbatuira.mure.fragment.ListaDidaticaFragment;

/**
 * Created by taisbatuira on 07/06/17.
 */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListaDidaticaFragment didaticaFragment = new ListaDidaticaFragment();
        ListaAlfabeticaFragment alfabeticaFragment = new ListaAlfabeticaFragment();

        TabLayout tabs = (TabLayout) findViewById(R.id.tabs);
        ViewPager pager = (ViewPager) findViewById(R.id.pager);
        PagerAdapter pagerAdapter = new PagerAdapter(getSupportFragmentManager(),alfabeticaFragment,didaticaFragment);
        pager.setAdapter(pagerAdapter);
        tabs.setupWithViewPager(pager);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = new Intent(MainActivity.this,
                AutoriaActivity.class);
        startActivity(intent);
        return super.onOptionsItemSelected(item);
    }




}
