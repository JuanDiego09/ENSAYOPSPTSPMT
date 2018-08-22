package com.example.juan.ensayopsptspmt;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.juan.ensayopsptspmt.actividades.Segunda;
import com.example.juan.ensayopsptspmt.actividades.TabedActivity;
import com.example.juan.ensayopsptspmt.adapter.AdapterProjectos;
import com.example.juan.ensayopsptspmt.entidades.ProjectosVo;
import com.example.juan.ensayopsptspmt.utilidades.Conexion;
import com.example.juan.ensayopsptspmt.utilidades.Utilidades;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText nombre, tiempo;
    Conexion conn;
    SQLiteDatabase bd;
    String campoNombre;
    int numero = 0, tiempocampo;
    ProjectosVo miProjectosVo;
    ArrayList<ProjectosVo> listaProject;
    RecyclerView recyclerView;
    AdapterProjectos miProjectos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nombre = findViewById(R.id.nombreRegistro);
        tiempo = findViewById(R.id.tiempoRegistro);
        recyclerView = findViewById(R.id.recyclerProyector);
        conn = new Conexion(getApplicationContext(), "Projectos", null, 1);
        listaProject = new ArrayList();
        consulta();



    }

    public void onCLick(View view) {
        bd = conn.getWritableDatabase();


        if (!(nombre.getText().toString().equals("") || tiempo.getText().toString().equals(""))) {
            campoNombre = nombre.getText().toString();
            tiempocampo = Integer.parseInt(tiempo.getText().toString());
            ContentValues values = new ContentValues();
            values.put(Utilidades.CAMPO_NOMBRE, campoNombre);
            values.put(Utilidades.CAMPO_TIEMPO, tiempocampo);
            values.put(Utilidades.CAMPO_ID_PROJECT, numero++);
            bd.insert(Utilidades.TABLA_PROJECT, Utilidades.CAMPO_ID_PROJECT, values);
            Toast.makeText(getApplicationContext(), "Se Registro con exito", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "llene los campos", Toast.LENGTH_SHORT).show();
        }

        consulta();
    }

    private void consulta() {
        miProjectos = null;
        listaProject.clear();
        bd = conn.getReadableDatabase();

        Cursor cursor = bd.rawQuery(" SELECT * FROM " + Utilidades.TABLA_PROJECT, null);

        while (cursor.moveToNext()) {
            miProjectosVo = new ProjectosVo();
            miProjectosVo.setId(cursor.getInt(0));
            miProjectosVo.setNombre(cursor.getString(1));
            miProjectosVo.setTiempo(cursor.getInt(2));
            numero = cursor.getInt(0);
            listaProject.add(miProjectosVo);
        }
        numero++;
        miProjectos = new AdapterProjectos(listaProject);
        recyclerView.setAdapter(miProjectos);


        miProjectos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle miBundle=new Bundle();
                miBundle.putInt("id",listaProject.get(recyclerView.getChildAdapterPosition(view)).getId());
                Intent mIntent=new Intent(MainActivity.this,Segunda.class);
                mIntent.putExtra("dato",miBundle);
                startActivity(mIntent);
            }
        });
    }
}
