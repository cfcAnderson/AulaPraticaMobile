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

/**
 * Created by user on 16/09/2014.
 */
public class InstrutorController extends Activity implements Serializable {

    private static DatabaseHandler dbHandler;
    private SQLiteDatabase db = null;
    private Cursor fila = null;


    public InstrutorController(DatabaseHandler dbHandler){
        this.dbHandler = dbHandler;
        //db = dbHandler.getWritableDatabase();
    }

    public void Close(){
        Close();
    }

    public void Insert(Instrutor instrutor){

        try {
            try {
                db = dbHandler.getWritableDatabase();
                ContentValues registro = new ContentValues();
                registro.put("codigo",instrutor.getCodigo());
                registro.put("nome",instrutor.getNome());
                registro.put("biometria",instrutor.getBiometria());
                registro.put("picture",instrutor.getPicture());

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
                registro.put("biometria",instrutor.getBiometria());
                registro.put("picture",instrutor.getPicture());
                db.update("instrutor", registro, "codigo=" + instrutor.getCodigo(), null);
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
                    db.delete("instrutor", null, null);
                }else {
                    db.delete("instrutor", "codigo=" + codigo, null);
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


        ArrayList<Instrutor> listaInstrutor = new ArrayList<Instrutor>();

        if (fila.moveToFirst()) {  //si ha devuelto 1 fila, vamos al primero (que es el unico)

            while (!fila.isAfterLast()){
                Instrutor instrutor = new Instrutor();

                listaInstrutor.add(instrutor);
                fila.moveToNext();
            }

        } else {
            Toast.makeText(this, "Não existe um instrutor para esse codigo",
                    Toast.LENGTH_SHORT).show();

        }

        db.close();
        return listaInstrutor;

    }




}
