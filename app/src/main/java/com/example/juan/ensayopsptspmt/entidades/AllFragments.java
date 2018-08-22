package com.example.juan.ensayopsptspmt.entidades;

import com.example.juan.ensayopsptspmt.fragments.DefectLog;
import com.example.juan.ensayopsptspmt.fragments.TimeLog;
import com.example.juan.ensayopsptspmt.tabed.DefectsInjected;
import com.example.juan.ensayopsptspmt.tabed.DefectsRemove;
import com.example.juan.ensayopsptspmt.tabed.TimeInPhase;

public interface AllFragments extends
        DefectLog.OnFragmentInteractionListener,
        TimeLog.OnFragmentInteractionListener,
        TimeInPhase.OnFragmentInteractionListener,
        DefectsInjected.OnFragmentInteractionListener,
        DefectsRemove.OnFragmentInteractionListener {
}
