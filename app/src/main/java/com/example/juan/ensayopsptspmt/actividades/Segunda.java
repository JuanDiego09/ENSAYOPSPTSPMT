package com.example.juan.ensayopsptspmt.actividades;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.juan.ensayopsptspmt.R;

public class Segunda extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);

        Bundle miBundle=getIntent().getBundleExtra("dato");

        if (miBundle!=null){
            Toast.makeText(getApplicationContext()," "+miBundle.getInt("id"),Toast.LENGTH_SHORT).show();
        }
    }
}
