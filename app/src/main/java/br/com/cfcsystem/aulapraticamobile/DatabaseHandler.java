package br.com.cfcsystem.aulapraticamobile;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


/**
 * Created by user on 16/09/2014.
 */
public class DatabaseHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private String[] _tabela = {"LOGIN","AULA_PRATICA"};
    private String[] _tabela_old = {"LOGIN_OLD","COBRANCA_OLD"};

    //LoginController
    private static  final String DATABASE_NAME = "AulaPraticaDB";


    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        executaSQL(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        for (int i=0; i<_tabela_old.length; i++){
            try {
                db.execSQL("drop table " + _tabela_old[i]);
            }catch (Exception e){
                System.out.println("Erro drop table: "+ _tabela_old[i]+" "+e.getMessage());
            }
        }

        for (int i = 0; i <_tabela.length ; i++){
            try {
                db.execSQL("alter table " + _tabela[i] + " rename to " + _tabela_old[i]);
            }catch (Exception e){
                System.out.println("Erro alter table: "+ _tabela[i]+" "+e.getMessage());
            }
        }

        executaSQL(db);

        for (int i=0; i < _tabela.length ; i++){
            try {
                if ((_tabela[i].equals("COBRANCA")) && (oldVersion < 8)) {
                    db.execSQL("insert into " + _tabela[i] + " select *,'DOURADOS','MS',null as DT_PROXIMA,null,null,null,null from " + _tabela_old[i]);
                }else if ((_tabela[i].equals("COBRANCA"))  && (oldVersion < 10)) {
                    db.execSQL("insert into " + _tabela[i] + " select *,null from " + _tabela_old[i]);
                }else{
                    db.execSQL("insert into " + _tabela[i] + " select * from " + _tabela_old[i]);
                }
            }catch (Exception e){
                System.out.println("Erro insert into: "+ _tabela[i]+" "+e.getMessage());
            }
        }

        for (int i=0; i<_tabela_old.length; i++){
            try {
                db.execSQL("drop table " + _tabela_old[i]);
            }catch (Exception e){
                System.out.println("2 Erro drop table: "+ _tabela_old[i]+" "+e.getMessage());
            }
        }
    }

    private void executaSQL(SQLiteDatabase db) {

        //Entity: aluno
        try{
            db.execSQL("CREATE TABLE aluno (" +
                    " id integer NOT NULL PRIMARY KEY, " +
                    " nome varchar (100) NOT NULL, " +
                    " cpf varchar (14) NOT NULL, " +
                    " data_cadastro date, " +
                    " municipio varchar(70) NOT NULL, " +
                    " uf varchar(2)," +
                    " digital text, " +
                    " foto blob)");
        }catch (Exception e){
            System.out.println("Erro ao criar aluno: "+e.getMessage());
        }


        //Entity : agendamento
        try {
            db.execSQL("CREATE TABLE agendamento (" +
                    " id integer NOT NULL PRIMARY KEY, " +
                    " data_agendamento date, " +
                    " instrutor_codigo integer REFERENCES instrutor (codigo) ON UPDATE RESTRICT ON DELETE RESTRICT, " +
                    " veiculo_id integer REFERENCES veiculo (id) ON UPDATE RESTRICT ON DELETE RESTRICT, " +
                    " aluno_id integer REFERENCES aluno (id) ON UPDATE RESTRICT ON DELETE RESTRICT, " +
                    " categoria varchar (1))");
        }catch (Exception e){
            System.out.println("Erro ao criar agendamento: "+e.getMessage());
        }

        //Entity : agendamento_horario
        try {
            db.execSQL("CREATE TABLE agendamento_horario (" +
                    " id integer NOT NULL PRIMARY KEY, " +
                    " agendamento_id integer REFERENCES agendamento (id) ON UPDATE CASCADE ON DELETE CASCADE, " +
                    " inicio time, " +
                    " fim time, " +
                    " data_aula date, " +
                    " documento integer, " +
                    " validado varchar (1) NOT NULL DEFAULT 'N')");
        }catch (Exception e){
            System.out.println("Erro ao criar agendamento: "+e.getMessage());
        }

        //Entity : gps
        try {
            db.execSQL("CREATE TABLE gps(" +
                    "  id integer NOT NULL primary key," +
                    "  latitude numeric NOT NULL," +
                    "  longitude numeric NOT NULL," +
                    "  data_hora datetime NOT NULL," +
                    "  status_enviado varchar(1) NOT NULL DEFAULT 'N'," +
                    "  id_aula integer NOT NULL)");
        }catch (Exception e){
            System.out.println("Erro ao criar agendamento: "+e.getMessage());
        }

        //Entity : instrutor
        try {
            db.execSQL("CREATE TABLE instrutor(" +
                    "  codigo integer NOT NULL primary key," +
                    "  nome varchar(50)," +
                    "  digital text," +
                    "  foto blob)");
        }catch (Exception e){
            System.out.println("Erro ao criar agendamento: "+e.getMessage());
        }

        //Entity : instrutor
        try {
            db.execSQL("CREATE TABLE instrutor(" +
                    "  codigo integer NOT NULL primary key," +
                    "  nome varchar(50)," +
                    "  digital text," +
                    "  foto blob)");
        }catch (Exception e){
            System.out.println("Erro ao criar agendamento: "+e.getMessage());
        }
    }
}
