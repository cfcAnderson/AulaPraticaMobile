package br.com.cfcsystem.classes;

import android.app.DialogFragment;
import android.content.Context;

import com.nitgen.SDK.AndroidBSP.NBioBSPJNI;

public class Biometria implements NBioBSPJNI.CAPTURE_CALLBACK{

    private NBioBSPJNI				bsp;
    private NBioBSPJNI.Export       exportEngine;
    private NBioBSPJNI.IndexSearch  indexSearch;
    private DialogFragment sampleDialogFragment;
    private Context context = null;


    public Biometria(Context context){
        this.context = context;
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
        }
    }

    public String getBiometria(){

        new Thread(new Runnable() {

            public void run() {

                OnCapture1(10000);

            }
        }).start();
        return null;
    }

    String msg = "";
    public synchronized void OnCapture1(int timeout){

        NBioBSPJNI.FIR_HANDLE hCapturedFIR, hAuditFIR;
        NBioBSPJNI.CAPTURED_DATA capturedData;

        hCapturedFIR = bsp.new FIR_HANDLE();
        hAuditFIR = bsp.new FIR_HANDLE();
        capturedData = bsp.new CAPTURED_DATA();

        bsp.Capture(NBioBSPJNI.FIR_PURPOSE.ENROLL,hCapturedFIR,timeout, hAuditFIR, capturedData, null,0, null);

        if (bsp.IsErrorOccured())  {
            msg = "NBioBSP Capture Error: " + bsp.GetErrorCode();
        }else{
            System.out.println("biometria: "+ hCapturedFIR.toString());
        }

    }


    @Override
    public int OnCaptured(NBioBSPJNI.CAPTURED_DATA captured_data) {
        return 0;
    }

    @Override
    public void OnConnected() {

    }

    @Override
    public void OnDisConnected() {

    }
}
