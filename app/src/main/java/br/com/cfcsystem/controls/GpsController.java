package br.com.cfcsystem.controls;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;

import br.com.cfcsystem.aulapraticamobile.DatabaseHandler;
import br.com.cfcsystem.entity.Gps;

public class GpsController extends Activity implements Serializable {

  private static DatabaseHandler dbHandler;
  private SQLiteDatabase db = null;
  private Cursor fila = null;
  public GpsController(DatabaseHandler dbHandler){
    this.dbHandler = dbHandler;
 }
  public void Insert(Gps gps){

        try {
            try {
                db = dbHandler.getWritableDatabase();
                ContentValues registro = new ContentValues();
                registro.put("id",gps.getId());
                registro.put("latitude",gps.getLatitude());
                registro.put("longitude",gps.getLongitude());
                registro.put("data_hora",gps.getDataHora());
                registro.put("status_enviado",gps.getStatusEnviado());
                registro.put("id_aula",gps.getIdAula());
                db.insert("gps", null, registro);
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }finally {
            db.close();
        }

    }

  public void Update(Gps gps){
        try {
            try {
                db = dbHandler.getWritableDatabase();
                ContentValues registro = new ContentValues();
                registro.put("id",gps.getId());
                registro.put("latitude",gps.getLatitude());
                registro.put("longitude",gps.getLongitude());
                registro.put("data_hora",gps.getDataHora());
                registro.put("status_enviado",gps.getStatusEnviado());
                registro.put("id_aula",gps.getIdAula());
                db.update("gps", registro, "id=" + gps.getId(), null);
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }finally {
            db.close();
        }
    }

  public void Delete(Integer id){
        try {
            try {
                db = dbHandler.getWritableDatabase();
                ContentValues registro = new ContentValues();
                db.delete("gps", "id="  + id, null);
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }finally {
            db.close();
        }
    }

  public ArrayList<Gps> getConsulta() {


        ArrayList<Gps> listaGps = new ArrayList<Gps>();

        if (fila.moveToFirst()) {  //si ha devuelto 1 fila, vamos al primero (que es el unico)

            while (!fila.isAfterLast()){
                Gps gps = new Gps();
                gps.setId(fila.getInt(0));
                gps.setLatitude(fila.getDouble(1));
                gps.setLongitude(fila.getDouble(2));
                gps.setDataHora(fila.getString(3));
                gps.setStatusEnviado(fila.getString(4));
                gps.setIdAula(fila.getInt(5));
                listaGps.add(gps);
                fila.moveToNext();
            }

        } else {
            Toast.makeText(this, "N�o foi encontrado um registro",
                    Toast.LENGTH_SHORT).show();

        }

        db.close();
        return listaGps;

    }

}