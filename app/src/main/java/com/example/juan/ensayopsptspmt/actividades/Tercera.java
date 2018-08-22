package com.example.juan.ensayopsptspmt.actividades;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.juan.ensayopsptspmt.R;
import com.example.juan.ensayopsptspmt.fragments.DefectLog;
import com.example.juan.ensayopsptspmt.fragments.TimeLog;

public class Tercera extends AppCompatActivity {

    Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tercera);

        Bundle miBundle = this.getIntent().getBundleExtra("dundle");
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
}
