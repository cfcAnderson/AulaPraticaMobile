package br.com.cfcsystem.controls;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;

import br.com.cfcsystem.aulapraticamobile.DatabaseHandler;
import br.com.cfcsystem.entity.AgendamentoHorario;

public class AgendamentoHorarioController extends Activity implements Serializable {

  private static DatabaseHandler dbHandler;
  private SQLiteDatabase db = null;
  private Cursor fila = null;
  public AgendamentoHorarioController(DatabaseHandler dbHandler){
    this.dbHandler = dbHandler;
 }
  public void Insert(AgendamentoHorario agendamentoHorario){

        try {
            try {
                db = dbHandler.getWritableDatabase();
                ContentValues registro = new ContentValues();
                registro.put("id",agendamentoHorario.getId());
                registro.put("agendamento_id",agendamentoHorario.getAgendamentoId());
                registro.put("inicio",agendamentoHorario.getInicio());
                registro.put("fim",agendamentoHorario.getFim());
                registro.put("data_aula",agendamentoHorario.getDataAula());
                registro.put("documento",agendamentoHorario.getDocumento());
                registro.put("validado",agendamentoHorario.getValidado());
                db.insert("agendamento_horario", null, registro);
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }finally {
            db.close();
        }

    }

  public void Update(AgendamentoHorario agendamentoHorario){
        try {
            try {
                db = dbHandler.getWritableDatabase();
                ContentValues registro = new ContentValues();
                registro.put("id",agendamentoHorario.getId());
                registro.put("agendamento_id",agendamentoHorario.getAgendamentoId());
                registro.put("inicio",agendamentoHorario.getInicio());
                registro.put("fim",agendamentoHorario.getFim());
                registro.put("data_aula",agendamentoHorario.getDataAula());
                registro.put("documento",agendamentoHorario.getDocumento());
                registro.put("validado",agendamentoHorario.getValidado());
                db.update("agendamento_horario", registro, "id=" + agendamentoHorario.getId(), null);
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
                db.delete("agendamento_horario", "id="  + id, null);
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }finally {
            db.close();
        }
    }

  public ArrayList<AgendamentoHorario> getConsulta() {


        ArrayList<AgendamentoHorario> listaAgendamentoHorario = new ArrayList<AgendamentoHorario>();

        if (fila.moveToFirst()) {  //si ha devuelto 1 fila, vamos al primero (que es el unico)

            while (!fila.isAfterLast()){
                AgendamentoHorario agendamentoHorario = new AgendamentoHorario();
                agendamentoHorario.setId(fila.getInt(0));
                agendamentoHorario.setAgendamentoId(fila.getInt(1));
                agendamentoHorario.setInicio(fila.getString(2));
                agendamentoHorario.setFim(fila.getString(3));
                agendamentoHorario.setDataAula(fila.getString(4));
                agendamentoHorario.setDocumento(fila.getInt(5));
                agendamentoHorario.setValidado(fila.getString(6));
                listaAgendamentoHorario.add(agendamentoHorario);
                fila.moveToNext();
            }

        } else {
            Toast.makeText(this, "N�o foi encontrado um registro",
                    Toast.LENGTH_SHORT).show();

        }

        db.close();
        return listaAgendamentoHorario;

    }

}