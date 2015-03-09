package br.com.cfcsystem.controls;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;

import br.com.cfcsystem.aulapraticamobile.DatabaseHandler;
import br.com.cfcsystem.entity.Veiculo;

public class VeiculoController extends Activity implements Serializable {

  private static DatabaseHandler dbHandler;
  private SQLiteDatabase db = null;
  private Cursor fila = null;
  public VeiculoController(DatabaseHandler dbHandler){
    this.dbHandler = dbHandler;
 }
  public void Insert(Veiculo veiculo){

        try {
            try {
                db = dbHandler.getWritableDatabase();
                ContentValues registro = new ContentValues();
                registro.put("id",veiculo.getId());
                registro.put("placa",veiculo.getPlaca());
                registro.put("nome",veiculo.getNome());
                registro.put("marca",veiculo.getMarca());
                registro.put("modelo",veiculo.getModelo());
                db.insert("veiculo", null, registro);
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }finally {
            db.close();
        }

    }

  public void Update(Veiculo veiculo){
        try {
            try {
                db = dbHandler.getWritableDatabase();
                ContentValues registro = new ContentValues();
                registro.put("id",veiculo.getId());
                registro.put("placa",veiculo.getPlaca());
                registro.put("nome",veiculo.getNome());
                registro.put("marca",veiculo.getMarca());
                registro.put("modelo",veiculo.getModelo());
                db.update("veiculo", registro, "id=" + veiculo.getId(), null);
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
                db.delete("veiculo", "id="  + id, null);
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }finally {
            db.close();
        }
    }

  public ArrayList<Veiculo> getConsulta() {


        ArrayList<Veiculo> listaVeiculo = new ArrayList<Veiculo>();

        if (fila.moveToFirst()) {  //si ha devuelto 1 fila, vamos al primero (que es el unico)

            while (!fila.isAfterLast()){
                Veiculo veiculo = new Veiculo();
                veiculo.setId(fila.getInt(0));
                veiculo.setPlaca(fila.getString(1));
                veiculo.setNome(fila.getString(2));
                veiculo.setMarca(fila.getString(3));
                veiculo.setModelo(fila.getString(4));
                listaVeiculo.add(veiculo);
                fila.moveToNext();
            }

        } else {
            Toast.makeText(this, "N�o foi encontrado um registro",
                    Toast.LENGTH_SHORT).show();

        }

        db.close();
        return listaVeiculo;

    }

}