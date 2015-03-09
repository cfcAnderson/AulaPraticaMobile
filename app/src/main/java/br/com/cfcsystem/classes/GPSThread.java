package br.com.cfcsystem.classes;

import android.content.Context;
import android.os.AsyncTask;
import android.util.TimeUtils;
import android.widget.Toast;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

import br.com.cfcsystem.aulapraticamobile.MainActivity;

/**
 * Created by Androider on 18/02/2015.
 */
public class GPSThread extends AsyncTask<String, String, String>{

    /** variaveis privadas */
    private GPSTracker gpsTracker;
    private double latitude;
    private double longitude;
    private long time;
    private SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
    private boolean opt = false;

    /** Constructor */
    public GPSThread(Context activity) {
        /** Inicializa o gpsTracker e informa por parametro a activity que ele roda em background */
       gpsTracker = new GPSTracker(activity);
    }

    @Override
    protected String doInBackground(String... params) {
        /** fica em while até que a aula seja finalizada */
        while(!opt) {
            /** Pega a localização do usuário */
            gpsTracker.getLocation();
            if (gpsTracker.canGetLocation()) {
                /** Pega a Latitude */
                latitude = gpsTracker.getLatitude();
                /** Pega a Longitude */
                longitude = gpsTracker.getLongitude();
                /** Pega hora */
                time = gpsTracker.getTime();
            }
            System.out.println("Time: "+format.format(TimeUnit.MILLISECONDS.toHours(time))+ " | Latitude: "+latitude+" | Longitude: "+ longitude);
            /** Dá um threadzinha de sleep  em background */
            try {
                Thread.sleep(TimeUnit.SECONDS.toMillis(3));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
