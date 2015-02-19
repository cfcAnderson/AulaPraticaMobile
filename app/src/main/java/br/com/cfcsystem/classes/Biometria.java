package br.com.cfcsystem.classes;

import com.nitgen.SDK.AndroidBSP.NBioBSPJNI;

public class Biometria{

    private NBioBSPJNI				bsp;
    private NBioBSPJNI.Export       exportEngine;
    private NBioBSPJNI.IndexSearch  indexSearch;

    public Biometria(){
        InitData();
    }

    private void InitData(){
        NBioBSPJNI.CURRENT_PRODUCT_ID = 0;
        if(bsp==null){
            bsp = new NBioBSPJNI("010701-613E5C7F4CC7C4B0-72E340B47E034015");
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

    public String getBiometria(){
        return null;
    }


}
