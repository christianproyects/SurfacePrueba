package com.ik_2dm3.surfaceapp;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

/**
 * Created by ik_2dm3 on 30/01/2017.
 */
//creo la  clase hilo que se manifiesta su extension de Thread
public class Hilo extends Thread {

//boolean que indica si esta funcionando la aplicacion
    private boolean run= false;

    //creo un Hilo y una Vista de nombre thread y vista respectivamente
    private Hilo thread;
    private Vista vista;

    public Hilo(Vista vista){
        this.vista = vista;
    }

    public void setRunning (boolean run){
        this.run = run;
    }

    public void run() {
        //dentro del run creo la variable c de tipo Canvas(lienzo)
        Canvas c;
        //mientras el run esta en true..
        while (run) {
            c = null;
            try {
                //c vista canvas lock significa que se puede pintar en el canvas
                c = vista.getHolder().lockCanvas();
                //sincronizada con  el onDraw de la clase Vista.java va a pintar en c
                synchronized (vista) {
                    vista.onDraw(c);
                }
                }finally{
                if ( c!= null) {
                    //cuando el c(Canvas) deje de ser null el canvas se desbloquea y ya no se puede pintar.
                    vista.getHolder().unlockCanvasAndPost(c);
                }
                }
            }//cierre while

        }//cierre Run()

    }

