package com.ik_2dm3.surfaceapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;

import static android.R.attr.width;
import static com.ik_2dm3.surfaceapp.R.attr.height;

public class MainActivity extends AppCompatActivity {

    //declaramos la variable Vista de nombre vista.
    public Vista vista =null;
    @Override
    //dejamos el onCreate por defecto
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //esto setContentView lo comentamos porque no es necesario
        // setContentView(R.layout.activity_main);

        //defino vista como una nueva Vista en la clase
        vista = new Vista(this);
        //hago un setContentView a mi nueva vista, puedo quitar el primer setContentview.
        setContentView(vista);


    }
}
