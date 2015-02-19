package br.com.cfcsystem.aulapraticamobile;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import br.com.cfcsystem.classes.Biometria;


public class MainActivity extends Activity {

    private Biometria biometria = new Biometria();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button bttInit = (Button) findViewById(R.id.initAula);

        bttInit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //chamar a thread!
            }
        });

    }

    public void onBiometriaClick(View v){

        //startActivity(new Intent(getBaseContext(),Biometria.class));

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                MainActivity.this);

        final View viewBiometria = View.inflate(this, R.layout.activity_biometria, null);


        alertDialogBuilder.setView(viewBiometria);
        alertDialogBuilder.setTitle("Legendas");

        alertDialogBuilder
                .setCancelable(false)
                .setPositiveButton("OK",new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        biometria.getBiometria();
                    }
                })
                .setNegativeButton("Instrutor", new DialogInterface.OnClickListener() {
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
