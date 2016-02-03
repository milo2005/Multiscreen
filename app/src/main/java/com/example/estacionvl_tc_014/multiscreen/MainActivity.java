package com.example.estacionvl_tc_014.multiscreen;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.estacionvl_tc_014.multiscreen.fragments.DetailFragment;
import com.example.estacionvl_tc_014.multiscreen.fragments.MasterFragment;

public class MainActivity extends AppCompatActivity {

    MasterFragment master;
    DetailFragment detail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_main);

        master = new MasterFragment();
        detail = new DetailFragment();

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.commit();

    }
}
