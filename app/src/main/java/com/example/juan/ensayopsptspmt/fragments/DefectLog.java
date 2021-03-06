package com.example.juan.ensayopsptspmt.fragments;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.juan.ensayopsptspmt.R;
import com.example.juan.ensayopsptspmt.entidades.ProjectosVo;
import com.example.juan.ensayopsptspmt.utilidades.Conexion;
import com.example.juan.ensayopsptspmt.utilidades.Utilidades;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link DefectLog.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link DefectLog#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DefectLog extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    int i =0;
    int pausa;
    boolean primero;
    CountDownTimer time;

    Conexion conn;
    SQLiteDatabase db;

    String typeR;
    String injectedR;
    String removeR;
    String dateR1;
    String dateR2;
    String fixTimeR;
    String descriptionR;


    ArrayList arrayType;
    ArrayList arrayInjected;
    ArrayList arrayRemoved;

    Spinner listaType,listaInjected,listaRemoved;
    TextView campoDate,campoFixTime,campoDefectDeescription;
    Button btnDate,btnRegistrar;
    Button btnStart,btnStop,btnRestart;


    public DefectLog() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DefectLog.
     */
    // TODO: Rename and change types and number of parameters
    public static DefectLog newInstance(String param1, String param2) {
        DefectLog fragment = new DefectLog();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.fragment_defect_log, container, false);
        conn = new Conexion(getContext(),"Projectos",null,1);
        campoDate = vista.findViewById(R.id.campoDateDefec);
        campoDefectDeescription = vista.findViewById(R.id.campoDefectDescrip);
        campoFixTime = vista.findViewById(R.id.campoFixTimeDefec);

        arrayType = new ArrayList();
        arrayType.add("Documentation");
        arrayType.add("Syntax");
        arrayType.add("Build");
        arrayType.add("Package");
        arrayType.add("Assigment");
        arrayType.add("Interface");
        arrayType.add("Checking");
        arrayType.add("Data");
        arrayType.add("Function");
        arrayType.add("System");
        arrayType.add("Environment");
        listaType = vista.findViewById(R.id.spinnerType);
        ArrayAdapter<CharSequence> adapterType = new ArrayAdapter(getContext(),R.layout.support_simple_spinner_dropdown_item,arrayType);
        listaType.setAdapter(adapterType);
        listaType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position != 0 ){
                    typeR = arrayType.get(position).toString();
                    Toast.makeText(getContext(),"type " + typeR, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        arrayInjected = new ArrayList();
        arrayInjected.add("PLAN");
        arrayInjected.add("DLD");
        arrayInjected.add("CODE");
        arrayInjected.add("COMPILE");
        arrayInjected.add("UT");
        arrayInjected.add("PM");
        listaInjected = vista.findViewById(R.id.spinnerPhaseInje);
        ArrayAdapter<CharSequence>adapterInjected = new ArrayAdapter(getContext(),R.layout.support_simple_spinner_dropdown_item,arrayInjected);
        listaInjected.setAdapter(adapterInjected);
        listaInjected.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position != 0 ){
                    injectedR = arrayInjected.get(position).toString();
                    Toast.makeText(getContext(),"injected " + injectedR, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        arrayRemoved = new ArrayList();
        arrayRemoved.add("PLAN");
        arrayRemoved.add("DLD");
        arrayRemoved.add("CODE");
        arrayRemoved.add("COMPILE");
        arrayRemoved.add("UT");
        arrayRemoved.add("PM");
        listaRemoved = vista.findViewById(R.id.spinnerPhaseRemov);
        ArrayAdapter<CharSequence> adapterRemoved  = new ArrayAdapter(getContext(),R.layout.support_simple_spinner_dropdown_item,arrayRemoved);
        listaRemoved.setAdapter(adapterRemoved);
        listaRemoved.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position != 0 ){
                    removeR = arrayRemoved.get(position).toString();
                    Toast.makeText(getContext(),"removed " + removeR, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        btnDate = vista.findViewById(R.id.btnDateDefe);
        btnDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                asignarFecha1();
            }
        });

        btnRegistrar = vista.findViewById(R.id.btnRegistrarDefect);
        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registrarDefect();
            }
        });
        btnStart=vista.findViewById(R.id.btnStartDefec);
        btnStop=vista.findViewById(R.id.btnStopDefec);
        btnRestart=vista.findViewById(R.id.btnRestartDefec);


        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                time=new CountDownTimer(720000 ,1000) {
                    @Override
                    public void onTick(long l) {

                        //if (primero==false){
                        i++;
                        //primero=true;
                        //}else{
                        // primero=false;
                        //}
                        campoFixTime.setText(" "+ i);

                    }

                    @Override
                    public void onFinish() {

                    }
                };
                time.start();
            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pausa=i;
                time.cancel();
            }
        });

        btnRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i=0;
                time.cancel();
                time.start();
            }
        });
        return vista;
    }

    private void registrarDefect() {

        db = conn.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Utilidades.CAMPO_ID_DEFECT, ProjectosVo.idUso);
        values.put(Utilidades.CAMPO_DATE,dateR1);
        values.put(Utilidades.CAMPO_TYPE,typeR);
        values.put(Utilidades.CAMPO_PHASE_INJECTED, injectedR);
        values.put(Utilidades.CAMPO_PHASE_REMOVE, removeR);
        values.put(Utilidades.CAMPO_FIX_TIME, campoFixTime.getText().toString());
        values.put(Utilidades.CAMPO_DEFECT_DESCRIPCION, campoDefectDeescription.getText().toString());
        db.insert(Utilidades.TABLA_DEFECT, Utilidades.CAMPO_ID, values);
        Toast.makeText(getContext(), "Se Registro con exito", Toast.LENGTH_SHORT).show();
        //Toast.makeText(getContext(), "llene los campos", Toast.LENGTH_SHORT).show();
    }

    private void asignarFecha1() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
        Date date = new Date();
        dateR1 = dateFormat.format(date);
        campoDate.setText(dateR1);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
