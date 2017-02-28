package com.ik_2dm3.surfaceapp;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.Toast;

/**
 * Created by ik_2dm3 on 30/01/2017.
 */

//esta clase extienda de SurfaceView e implementa Callback de SurfaceHolder
public class Vista extends SurfaceView implements SurfaceHolder.Callback  {

    //se crea ela variable thread tipo Hilo

        private Hilo thread;

    //variables para controlar la posicion de mi circulo y el radio
        private int xcirculo=90;
        private int ycirculo=90;
        private int radio=40;






        public Vista(Context context) {
            super(context);
            getHolder().addCallback(this);
            thread = new Hilo(this);
        }






        @Override
        public void surfaceCreated(SurfaceHolder holder) {
            thread.setRunning(true);
            thread.start();
        }

        @Override
        public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

        }

        @Override
        public void surfaceDestroyed(SurfaceHolder holder) {

        }

        @Override
        //onDraw que va a pintar en c(Camvas)
        protected void onDraw (Canvas c){
            //utilizando un metodo draw predefinido pongo el fondo negro
            c.drawColor(Color.BLACK);

            //p(Paint) sera nuestro pincel
                Paint p = new Paint();
            //pintamos de azul el circulo de antes
            p.setColor(Color.BLUE);

            //dibujamos un circulo la posicion xcirculo, ycirculo y radio y hacemos referencia a nuestro pincel en la p
            c.drawCircle(xcirculo,ycirculo,radio,p);


    if (xcirculo < 500) {
        xcirculo++;
    } else if (xcirculo == 500 && ycirculo < 700) {
        ycirculo++;
    } else if (ycirculo == 700 && xcirculo >= 500&& xcirculo<600) {
        xcirculo++;

    } else if (xcirculo == 600) {
        xcirculo = 90;
        ycirculo = 90;
    }






        }

}
