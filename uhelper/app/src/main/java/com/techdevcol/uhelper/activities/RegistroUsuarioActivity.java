package com.techdevcol.uhelper.activities;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.techdevcol.uhelper.R;
import com.techdevcol.uhelper.adapters.SectionStatePagerAdapterRegistro;
import com.techdevcol.uhelper.fragments.FragmentRegistro1;
import com.techdevcol.uhelper.fragments.FragmentRegistro2;
import com.techdevcol.uhelper.fragments.FragmentRegistro3;
import com.techdevcol.uhelper.fragments.FragmentRegistro4;


public class RegistroUsuario1Activity extends AppCompatActivity {


    private SectionStatePagerAdapterRegistro sectionStatePager;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_usuario1);

        sectionStatePager = new SectionStatePagerAdapterRegistro(getSupportFragmentManager());
        viewPager = (ViewPager) findViewById(R.id.container);


    }


    private void setudViewPager(ViewPager viewPager) {
        SectionStatePagerAdapterRegistro adapterRegistro = new SectionStatePagerAdapterRegistro(getSupportFragmentManager());
        adapterRegistro.addFragment(new FragmentRegistro1());
        adapterRegistro.addFragment(new FragmentRegistro2());
        adapterRegistro.addFragment(new FragmentRegistro3());
        adapterRegistro.addFragment(new FragmentRegistro4());
        viewPager.setAdapter(adapterRegistro);


    }


    public void setViewPager(int fragmenNumber) {
        viewPager.setCurrentItem(fragmenNumber);
    }

}
