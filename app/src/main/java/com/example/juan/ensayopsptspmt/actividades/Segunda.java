package com.example.juan.ensayopsptspmt.actividades;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
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

    public void onClick(View view) {
        Intent intent = new Intent(Segunda.this,Tercera.class);
        Bundle miBundle = new Bundle();


        switch (view.getId()){

            case R.id.btnTimeLog:
                miBundle.putInt("pantalla",1);
                intent.putExtra("bundle",miBundle);
                startActivity(intent);
                break;

            case R.id.btnDefectLog:
                miBundle.putInt("pantalla",2);
                intent.putExtra("bundle",miBundle);
                startActivity(intent);
                break;

            case R.id.btnPlanSumary:
                intent= new Intent(Segunda.this,TabedActivity.class);
                startActivity(intent);
                break;
        }
    }
}
