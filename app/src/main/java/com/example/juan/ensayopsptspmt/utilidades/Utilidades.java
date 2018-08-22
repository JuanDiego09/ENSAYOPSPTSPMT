package com.example.juan.ensayopsptspmt.utilidades;

public class Utilidades {

    public static final String TABLA_TIME = "time_log";
    public static final String CAMPO_ID = "id";
    public static final String CAMPO_PHASE = "phase";
    public static final String CAMPO_START = "start";
    public static final String CAMPO_INTERRUPTION = "interruption";
    public static final String CAMPO_STOP = "stop";
    public static final String CAMPO_DELTA = "delta";
    public static final String CAMPO_COMMENTS = "comments";
    public static final String CREAR_TABLA_TIME = "create table "+TABLA_TIME
            +" ( "+CAMPO_ID+" INT AUTOINCREMENT, "+CAMPO_PHASE +" VARCHAR, "
            +CAMPO_START+" DATE, "+ CAMPO_INTERRUPTION +" TIME, "
            +CAMPO_STOP+" TIME, "+CAMPO_DELTA+" TIME, "+CAMPO_COMMENTS+" VARCHAR)";



    public static final String TABLA_DEFECT = "defect_log";
    public static final String CAMPO_ID_DEFECT = "id";
    public static final String CAMPO_DATE = "date";
    public static final String CAMPO_TYPE = "type";
    public static final String CAMPO_PHASE_INJECTED = "phase_inject";
    public static final String CAMPO_PHASE_REMOVE = "phase_remove";
    public static final String CAMPO_FIX_TIME = "fix";
    public static final String CAMPO_DEFECT_DESCRIPCION = "description";
    public static final String CREAR_TABLA_DEFECT = "create table "+TABLA_DEFECT
            +" ( "+CAMPO_ID_DEFECT+" INT , "+CAMPO_DATE +" DATE, "
            +CAMPO_TYPE+" VARCHAR, "+ CAMPO_PHASE_INJECTED +" VARCHAR, "
            +CAMPO_PHASE_REMOVE+" VARCHAR, "+CAMPO_FIX_TIME+" TIME, "+CAMPO_DEFECT_DESCRIPCION+" VARCHAR)";



    public static final String TABLA_PROJECT = "Project Plan Summary.";
    public static final String CAMPO_ID_PROJECT = "id";
    public static final String CAMPO_TIME_PHASE = "time_phase";
    public static final String CAMPO_DEFECT_INJECTED_PHASE = "type";
    public static final String CAMPO_REMOVED_PHASE = "phase_inject";
    public static final String CREAR_TABLA_PROJECT = "create table "+TABLA_PROJECT
            +" ( "+CAMPO_ID_PROJECT+" INT , "+CAMPO_TIME_PHASE +" INT, "
            +CAMPO_DEFECT_INJECTED_PHASE+" INT, "+CAMPO_REMOVED_PHASE+" INT)";

}
