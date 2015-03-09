package br.com.cfcsystem.controls;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;

import br.com.cfcsystem.aulapraticamobile.DatabaseHandler;
import br.com.cfcsystem.entity.Aluno;

public class AlunoController extends Activity implements Serializable {

  private static DatabaseHandler dbHandler;
  private SQLiteDatabase db = null;
  private Cursor fila = null;
  public AlunoController(DatabaseHandler dbHandler){
    this.dbHandler = dbHandler;
 }
  public void Insert(Aluno aluno){

        try {
            try {
                db = dbHandler.getWritableDatabase();
                ContentValues registro = new ContentValues();
                registro.put("id",aluno.getId());
                registro.put("nome",aluno.getNome());
                registro.put("cpf",aluno.getCpf());
                registro.put("data_cadastro",aluno.getDataCadastro());
                registro.put("municipio",aluno.getMunicipio());
                registro.put("uf",aluno.getUf());
                registro.put("digital",aluno.getDigital());
                registro.put("foto",aluno.getFoto());
                db.insert("aluno", null, registro);
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }finally {
            db.close();
        }

    }

  public void Update(Aluno aluno){
        try {
            try {
                db = dbHandler.getWritableDatabase();
                ContentValues registro = new ContentValues();
                registro.put("id",aluno.getId());
                registro.put("nome",aluno.getNome());
                registro.put("cpf",aluno.getCpf());
                registro.put("data_cadastro",aluno.getDataCadastro());
                registro.put("municipio",aluno.getMunicipio());
                registro.put("uf",aluno.getUf());
                registro.put("digital",aluno.getDigital());
                registro.put("foto",aluno.getFoto());
                db.update("aluno", registro, "id=" + aluno.getId(), null);
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
                db.delete("aluno", "id="  + id, null);
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }finally {
            db.close();
        }
    }

  public ArrayList<Aluno> getConsulta() {


        ArrayList<Aluno> listaAluno = new ArrayList<Aluno>();

        if (fila.moveToFirst()) {  //si ha devuelto 1 fila, vamos al primero (que es el unico)

            while (!fila.isAfterLast()){
                Aluno aluno = new Aluno();
                aluno.setId(fila.getInt(0));
                aluno.setNome(fila.getString(1));
                aluno.setCpf(fila.getString(2));
                aluno.setDataCadastro(fila.getString(3));
                aluno.setMunicipio(fila.getString(4));
                aluno.setUf(fila.getString(5));
                aluno.setDigital(fila.getString(6));
                aluno.setFoto(fila.getBlob(7));
                listaAluno.add(aluno);
                fila.moveToNext();
            }

        } else {
            Toast.makeText(this, "N�o foi encontrado um registro",
                    Toast.LENGTH_SHORT).show();

        }

        db.close();
        return listaAluno;

    }

}