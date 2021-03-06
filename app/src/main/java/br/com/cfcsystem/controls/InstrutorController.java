package br.com.cfcsystem.controls;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;

import br.com.cfcsystem.aulapraticamobile.DatabaseHandler;
import br.com.cfcsystem.entity.Instrutor;

public class InstrutorController extends Activity implements Serializable {

  private static DatabaseHandler dbHandler;
  private SQLiteDatabase db = null;
  private Cursor fila = null;
  public InstrutorController(DatabaseHandler dbHandler){
    this.dbHandler = dbHandler;
 }
  public void Insert(Instrutor instrutor){

        try {
            try {
                db = dbHandler.getWritableDatabase();
                ContentValues registro = new ContentValues();
                registro.put("codigo",instrutor.getCodigo());
                registro.put("nome",instrutor.getNome());
                registro.put("digital",instrutor.getDigital());
                registro.put("foto",instrutor.getFoto());
                db.insert("instrutor", null, registro);
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }finally {
            db.close();
        }

    }

  public void Update(Instrutor instrutor){
        try {
            try {
                db = dbHandler.getWritableDatabase();
                ContentValues registro = new ContentValues();
                registro.put("codigo",instrutor.getCodigo());
                registro.put("nome",instrutor.getNome());
                registro.put("digital",instrutor.getDigital());
                registro.put("foto",instrutor.getFoto());
                db.update("instrutor", registro, "codigo=" + instrutor.getCodigo(), null);
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
                db.delete("instrutor", "codigo="  + id, null);
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }finally {
            db.close();
        }
    }

  public ArrayList<Instrutor> getConsulta() {


        ArrayList<Instrutor> listaInstrutor = new ArrayList<Instrutor>();

        if (fila.moveToFirst()) {  //si ha devuelto 1 fila, vamos al primero (que es el unico)

            while (!fila.isAfterLast()){
                Instrutor instrutor = new Instrutor();
                instrutor.setCodigo(fila.getInt(0));
                instrutor.setNome(fila.getString(1));
                instrutor.setDigital(fila.getString(2));
                instrutor.setFoto(fila.getBlob(3));
                listaInstrutor.add(instrutor);
                fila.moveToNext();
            }

        } else {
            Toast.makeText(this, "N�o foi encontrado um registro",
                    Toast.LENGTH_SHORT).show();

        }

        db.close();
        return listaInstrutor;

    }

}