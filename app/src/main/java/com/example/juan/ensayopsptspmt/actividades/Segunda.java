package com.example.juan.ensayopsptspmt.actividades;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.juan.ensayopsptspmt.R;

public class Segunda extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);
    }

    public void onClick(View view) {
        Intent intent = new Intent(getApplicationContext(),Tercera.class);
        Intent intent1 = new Intent(getApplicationContext(),TabedActivity.class);
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
                startActivity(intent1);
                break;
        }
    }
}
