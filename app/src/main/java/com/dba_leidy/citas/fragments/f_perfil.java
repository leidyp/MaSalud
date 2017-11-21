package com.dba_leidy.citas.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dba_leidy.citas.R;


/**
 * Created by DBA-Leidy on 10/11/2017.
 */

public class f_perfil extends Fragment {

    int ced;
    Bundle datauser;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //returning our layout file
        //change R.layout.yourlayoutfilename for each of your fragments
        ced = getArguments().getInt("cedula");
        datauser = getArguments();
        View v = inflater.inflate(R.layout.fragment_perfil, container, false);
        return v;

    }
    public void mostrarDetalle(String texto) {

        TextView txtDetalle = (TextView)getView().findViewById(R.id.cedulam);
        txtDetalle.setText(""+ced);

        txtDetalle.setText(texto);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView cedul = (TextView)getView().findViewById(R.id.cedulam);
        cedul.setText(""+ datauser.getInt("cedula"));

        TextView nomb = (TextView)getView().findViewById(R.id.nombre);
        nomb.setText(""+ datauser.getString("nombre"));

        TextView us = (TextView)getView().findViewById(R.id.user);
        us.setText(""+ datauser.getString("user"));
        //you can set the title for your toolbar here for different fragments different titles
        getActivity().setTitle("Perfil");
    }
}
