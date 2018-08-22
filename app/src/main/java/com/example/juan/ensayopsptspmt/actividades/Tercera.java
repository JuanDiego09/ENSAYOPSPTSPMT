package com.example.juan.ensayopsptspmt.actividades;

import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.juan.ensayopsptspmt.R;
import com.example.juan.ensayopsptspmt.entidades.AllFragments;
import com.example.juan.ensayopsptspmt.fragments.DefectLog;
import com.example.juan.ensayopsptspmt.fragments.TimeLog;

public class Tercera extends AppCompatActivity implements AllFragments{

    Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tercera);

        Bundle miBundle = getIntent().getBundleExtra("bundle");
        switch (miBundle.getInt("pantalla")){
            case 1:
                fragment = new TimeLog();
                getSupportFragmentManager().beginTransaction().replace(R.id.contenedorTercera,fragment).commit();
                break;

            case 2:
                fragment = new DefectLog();
                getSupportFragmentManager().beginTransaction().replace(R.id.contenedorTercera,fragment).commit();
                break;
        }

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
