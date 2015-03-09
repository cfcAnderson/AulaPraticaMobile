package br.com.cfcsystem.controls;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;

import br.com.cfcsystem.aulapraticamobile.DatabaseHandler;
import br.com.cfcsystem.entity.DataGps;
import br.com.cfcsystem.entity.Instrutor;

/**
 * Created by user on 16/09/2014.
 */
public class DataGpsController extends Activity implements Serializable {

    private static DatabaseHandler dbHandler;
    private SQLiteDatabase db = null;
    private Cursor fila = null;


    public DataGpsController(DatabaseHandler dbHandler){
        this.dbHandler = dbHandler;
        //db = dbHandler.getWritableDatabase();
    }

    public void Close(){
        Close();
    }

    public void Insert(DataGps dataGps){

        try {
            try {
                db = dbHandler.getWritableDatabase();
                ContentValues registro = new ContentValues();
                registro.put("id",dataGps.getId());
                registro.put("idAula",dataGps.getIdAula());
                registro.put("hora",dataGps.getHora());
                registro.put("latitude",dataGps.getLatitude());
                registro.put("longitude",dataGps.getLongitude());

                db.insert("datagps", null, registro);
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }finally {
            db.close();
        }

    }

    public void Update(DataGps dataGps){
        try {
            try {
                db = dbHandler.getWritableDatabase();
                ContentValues registro = new ContentValues();
                registro.put("id",dataGps.getId());
                registro.put("idAula",dataGps.getIdAula());
                registro.put("hora",dataGps.getHora());
                registro.put("latitude",dataGps.getLatitude());
                registro.put("longitude",dataGps.getLongitude());
                db.update("datagps", registro, "id=" + dataGps.getId(), null);
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }finally {
            db.close();
        }
    }

    /**
     *
     * @param codigo
     * "todos" or codigo do instrutor a ser deletado
     */

    public void Delete(String codigo){
        try {
            try {
                db = dbHandler.getWritableDatabase();
                ContentValues registro = new ContentValues();
                if (codigo.equals("todos")){
                    db.delete("datagps", null, null);
                }else {
                    db.delete("datagps", "id=" + codigo, null);
                }
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }finally {
            db.close();
        }
    }

    public Boolean setConsulta(String campos, String parametro){
        //dbHandler = new DatabaseHandler(this);

        db = dbHandler.getReadableDatabase();

        //String dni = et1.getText().toString();
        try {
            fila = db.rawQuery("select " + campos + " from instrutor " + parametro, null);
        }catch (Exception e){
            e.printStackTrace();
        }

        if (fila.moveToFirst()){
            return true;
        }else{
            return false;
        }
    }

    public ArrayList<Instrutor> getConsulta() {


        ArrayList<Instrutor> listaGps= new ArrayList<Instrutor>();

        if (fila.moveToFirst()) {  //si ha devuelto 1 fila, vamos al primero (que es el unico)

            while (!fila.isAfterLast()){
                Instrutor instrutor = new Instrutor();

                listaGps.add(instrutor);
                fila.moveToNext();
            }

        } else {
            Toast.makeText(this, "Não existe um dado para esse codigo",
                    Toast.LENGTH_SHORT).show();
        }

        db.close();
        return listaGps;

    }

}
