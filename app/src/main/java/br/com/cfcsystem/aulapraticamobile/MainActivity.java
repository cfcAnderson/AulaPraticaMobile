package br.com.cfcsystem.aulapraticamobile;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import br.com.cfcsystem.classes.Biometria;
import br.com.cfcsystem.classes.GPSThread;


public class MainActivity extends Activity {

    private Biometria biometria = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    /** Botão que inicia a Thread que pega a localização do GPS*/
    public void onGpsClick(View v) {

        GPSThread gpsThread = new GPSThread(MainActivity.this); /** Chama a Thread do GPS*/

        gpsThread.execute(); /**executa a Thread*/

    }

    public void onBiometriaClick(View v) {
        //startActivity(new Intent(getBaseContext(),MainActivity.this));

        //startActivity(new Intent(getBaseContext(),Biometria.class));

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                MainActivity.this);

        final View viewBiometria = View.inflate(this, R.layout.activity_biometria, null);


        alertDialogBuilder.setView(viewBiometria);
        alertDialogBuilder.setTitle("Instrutor");

        alertDialogBuilder
                .setCancelable(false)
                .setPositiveButton("OK",new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        biometria = new Biometria(MainActivity.this);
                       // biometria.getBiometria();
                    }
                })
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // se não for precionado ele apenas termina o dialog
                        // e fecha a janelinha

                        dialog.cancel();
                    }
                });

        AlertDialog alertDialog = alertDialogBuilder.create();

        alertDialog.show();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
