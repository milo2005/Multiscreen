package com.example.estacionvl_tc_014.multiscreen.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.estacionvl_tc_014.multiscreen.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends Fragment {

    TextView txt;
    String nombre;
    int color;

    public DetailFragment() {
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_detail, container, false);

        txt = (TextView) v.findViewById(R.id.txt_color);

        if(nombre!=null){
            txt.setText(nombre);
            txt.setBackgroundColor(color);
        }

        return v;
    }

    public void setColor(String nombre, int color){
        this.nombre = nombre;
        this.color = color;
        if(txt != null){
            txt.setText(nombre);
            txt.setBackgroundColor(color);
        }


    }

}
