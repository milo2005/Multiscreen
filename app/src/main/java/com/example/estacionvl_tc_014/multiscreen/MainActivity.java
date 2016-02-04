package com.example.estacionvl_tc_014.multiscreen;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.estacionvl_tc_014.multiscreen.fragments.DetailFragment;
import com.example.estacionvl_tc_014.multiscreen.fragments.MasterFragment;

public class MainActivity extends AppCompatActivity implements MasterFragment.MasterI {

    MasterFragment master;
    DetailFragment detail;

    boolean phone, land;
    String colores[];
    int coloresHex[];

    int pos = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_main);

        master = new MasterFragment();
        detail = new DetailFragment();

        phone = getResources().getBoolean(R.bool.phone);
        land = getResources().getBoolean(R.bool.land);

        colores = getResources().getStringArray(R.array.colores);
        coloresHex = getResources().getIntArray(R.array.colores_hex);


        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.container1, master);

        if(!phone && land)
            ft.replace(R.id.container2, detail);

        ft.commit();

    }

    @Override
    public void onColorSelected(int color) {

        pos = color;
        detail.setColor(colores[color], coloresHex[color]);
        if(phone || (!phone && !land)){
            putFragment(R.id.container1, detail);
        }

    }

    @Override
    public void onBackPressed() {

        if(pos>=0 && (phone || (!phone && !land)) ){
            putFragment(R.id.container1, master);
            pos = -1;
        }else{
            super.onBackPressed();
        }



    }

    public void putFragment(int container, Fragment fragment){
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(container, fragment);
        ft.commit();
    }
}
