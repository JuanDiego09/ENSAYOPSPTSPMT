package com.example.juan.ensayopsptspmt.fragments;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.juan.ensayopsptspmt.R;
import com.example.juan.ensayopsptspmt.utilidades.Conexion;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link TimeLog.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link TimeLog#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TimeLog extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    Conexion conn;
    SQLiteDatabase db;

    Button btnRegistrarTime;
    String phaseR;
    String startR;
    String stopR;
    int interruptionR;
    int deltaR;
    String commentsR;

    EditText campoStart,campoInterruption,campoStop,campoDelta,campoComments;

    ArrayList arrayPhase;
    Spinner listaPhase;



    public TimeLog() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TimeLog.
     */
    // TODO: Rename and change types and number of parameters
    public static TimeLog newInstance(String param1, String param2) {
        TimeLog fragment = new TimeLog();
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
        View vista = inflater.inflate(R.layout.fragment_time_log, container, false);
        conn = new Conexion(getContext(),"Projectos",null,1);
        arrayPhase = new ArrayList();
        arrayPhase.add("PLAN");
        arrayPhase.add("DLD");
        arrayPhase.add("CODE");
        arrayPhase.add("COMPILE");
        arrayPhase.add("UT");
        arrayPhase.add("PM");

        listaPhase = vista.findViewById(R.id.spinnerPhaseTime);
        ArrayAdapter<CharSequence>adapterPhase = new ArrayAdapter(getContext(),R.layout.support_simple_spinner_dropdown_item,arrayPhase);
        listaPhase.setAdapter(adapterPhase);
        listaPhase.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position!= 0){
                    phaseR = arrayPhase.get(position).toString();
                    Toast.makeText(getContext(),"phase " + phaseR, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        campoStart = vista.findViewById(R.id.campoStartTime);
        campoInterruption = vista.findViewById(R.id.campoInterruptionTime);
        campoStop = vista.findViewById(R.id.campoStopTime);
        campoDelta = vista.findViewById(R.id.campoDeltaTme);
        campoComments = vista.findViewById(R.id.campoCommentsTime);
        btnRegistrarTime = vista.findViewById(R.id.btnRegistrarTime);
        btnRegistrarTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registrarTime();
            }
        });


        return vista;
    }

    private void registrarTime() {

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
