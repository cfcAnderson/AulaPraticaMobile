package br.com.cfcsystem.controls;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;

import br.com.cfcsystem.aulapraticamobile.DatabaseHandler;
import br.com.cfcsystem.entity.Agendamento;

public class AgendamentoController extends Activity implements Serializable {

  private static DatabaseHandler dbHandler;
  private SQLiteDatabase db = null;
  private Cursor fila = null;
  public AgendamentoController(DatabaseHandler dbHandler){
    this.dbHandler = dbHandler;
 }
  public void Insert(Agendamento agendamento){

        try {
            try {
                db = dbHandler.getWritableDatabase();
                ContentValues registro = new ContentValues();
                registro.put("id",agendamento.getId());
                registro.put("data_agendamento",agendamento.getDataAgendamento());
                registro.put("instrutor_codigo",agendamento.getInstrutorCodigo());
                registro.put("veiculo_id",agendamento.getVeiculoId());
                registro.put("aluno_id",agendamento.getAlunoId());
                registro.put("categoria",agendamento.getCategoria());
                db.insert("agendamento", null, registro);
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }finally {
            db.close();
        }

    }

  public void Update(Agendamento agendamento){
        try {
            try {
                db = dbHandler.getWritableDatabase();
                ContentValues registro = new ContentValues();
                registro.put("id",agendamento.getId());
                registro.put("data_agendamento",agendamento.getDataAgendamento());
                registro.put("instrutor_codigo",agendamento.getInstrutorCodigo());
                registro.put("veiculo_id",agendamento.getVeiculoId());
                registro.put("aluno_id",agendamento.getAlunoId());
                registro.put("categoria",agendamento.getCategoria());
                db.update("agendamento", registro, "id=" + agendamento.getId(), null);
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
                db.delete("agendamento", "id="  + id, null);
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }finally {
            db.close();
        }
    }

  public ArrayList<Agendamento> getConsulta() {


        ArrayList<Agendamento> listaAgendamento = new ArrayList<Agendamento>();

        if (fila.moveToFirst()) {  //si ha devuelto 1 fila, vamos al primero (que es el unico)

            while (!fila.isAfterLast()){
                Agendamento agendamento = new Agendamento();
                agendamento.setId(fila.getInt(0));
                agendamento.setDataAgendamento(fila.getString(1));
                agendamento.setInstrutorCodigo(fila.getInt(2));
                agendamento.setVeiculoId(fila.getInt(3));
                agendamento.setAlunoId(fila.getInt(4));
                agendamento.setCategoria(fila.getString(5));
                listaAgendamento.add(agendamento);
                fila.moveToNext();
            }

        } else {
            Toast.makeText(this, "N�o foi encontrado um registro",
                    Toast.LENGTH_SHORT).show();

        }

        db.close();
        return listaAgendamento;

    }

}