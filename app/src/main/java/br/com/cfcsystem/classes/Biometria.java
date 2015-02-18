package br.com.cfcsystem.classes;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.nitgen.SDK.AndroidBSP.NBioBSPJNI;

import br.com.cfcsystem.aulapraticamobile.R;

public class Biometria extends Activity {

    private NBioBSPJNI				bsp;
    private NBioBSPJNI.Export       exportEngine;
    private NBioBSPJNI.IndexSearch  indexSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_biometria);

        InitData();
    }

    private void InitData(){
        NBioBSPJNI.CURRENT_PRODUCT_ID = 0;
        if(bsp==null){
            bsp = new NBioBSPJNI("010701-613E5C7F4CC7C4B0-72E340B47E034015", this);
            String msg = null;
            if (bsp.IsErrorOccured())
                msg = "NBioBSP Error: " + bsp.GetErrorCode();
            else  {
                msg = "SDK Version: " + bsp.GetVersion();
                exportEngine = bsp.new Export();
                indexSearch = bsp.new IndexSearch();
            }
            //tvVer.setText(msg);
        }

        //sampleDialogFragment = new SampleDialogFragment();
        //userDialog = new UserDialog();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_biometria, menu);
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
