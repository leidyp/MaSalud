package com.dba_leidy.citas;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.widget.Toast;

import com.dba_leidy.citas.clases_base.paciente;
import com.dba_leidy.citas.clases_base.usuario;
import com.dba_leidy.citas.esquemas.*;

import java.util.ArrayList;

/**
 * Created by DBA-Leidy on 8/11/2017.
 */

public class Crud {
    private Context context;

    public Crud(){}

    public Crud(Context context){
        this.context=context;
    }

    public void LeerUsuario(){

        ConexionBD mDbHelper = new ConexionBD(this.context);
        SQLiteDatabase db1 = mDbHelper.getReadableDatabase();
        String[] projection = {
                e_usuario.UsuarioData.US_ID,
                e_usuario.UsuarioData.US_CEDULA,
                e_usuario.UsuarioData.US_NOMBRE,
                e_usuario.UsuarioData.US_USER,
                e_usuario.UsuarioData.US_PASSWORD
        };
        String x ="select * from usuario";
        Cursor c = db1.rawQuery(x,null);
        Log.i("---> Bcount: ", ""+c.getCount());
        Log.i("Scount: ", ""+ x);
        if( c == null || c.getCount() == 0) {
            InsertarUsuario();
            Log.i("---> BcountC: ", "Usuario Creado");
        } else{
             Log.i("---> BcountE: ", "Ya existe el usuario");
         }
        c.close();
    }

    public void InsertarUsuario(){
        ConexionBD mDbHelper = new ConexionBD(this.context);
        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        usuario us = new usuario(1001,"Leidy Acuna","lacuna","12345");

            ContentValues cv = new ContentValues();
            //cv.put(e_usuario.UsuarioData.US_CEDULA, us.getUs_cedula());
            cv.put(e_usuario.UsuarioData.US_NOMBRE, us.getUs_nombre() );
            cv.put(e_usuario.UsuarioData.US_USER,   us.getUs_user() );
            cv.put(e_usuario.UsuarioData.US_PASSWORD, us.getUs_password() );
            long rowID = db.insert(e_usuario.UsuarioData.TABLE_NAME, null, cv);

        db.close();
    }

    public usuario ValidarLogin(String user, String password){

        usuario usua = new usuario();
        ConexionBD mDbHelper = new ConexionBD(this.context);
        SQLiteDatabase db1 = mDbHelper.getReadableDatabase();
        String x ="select * from usuario where us_user='" + user + "' and us_password='" + password +"'";
        Cursor c = db1.rawQuery(x,null);
        Log.i("---> ValidarL: ", ""+c.getCount());
        Log.i("LOGIN: ", ""+ x);
        if(c.getCount() != 0) {
            c.moveToFirst();
            usua.setUs_id(c.getInt(0));
            //usua.setUs_cedula(c.getInt(1));
            usua.setUs_nombre(c.getString(2));
            usua.setUs_user(c.getString(3));
            usua.setUs_password(c.getString(4));
        } else{
            usua.setUs_id(0);
            //usua.setUs_cedula(0);
            usua.setUs_nombre("");
            usua.setUs_user("");
            usua.setUs_password("");
        }
        c.close();
        return usua;
    }

    public String LeerPaciente(paciente pacc){

      /*  String alerta= "";
        ConexionBD mDbHelper = new ConexionBD(this.context);
        SQLiteDatabase db1 = mDbHelper.getReadableDatabase();
        String[] projection = {
                e_paciente.PacienteData.PAC_CEDULA,
                e_paciente.PacienteData.PAC_NOMBRE,
                e_paciente.PacienteData.PAC_APELLIDO,
                e_paciente.PacienteData.PAC_TELEFONO,
                e_paciente.PacienteData.PAC_FECHA_N
        };
        String x = "select " + e_paciente.PacienteData.PAC_CEDULA + " from paciente where " + e_paciente.PacienteData.PAC_CEDULA + "='";
        Log.i("S: ", ""+ x);
        Cursor c = db1.rawQuery(x,null);
        Log.i("---> B: ", ""+c.getCount());
        if(c.getCount() == 0) {
            boolean alert =InsertarPaciente(pacc);
            if (!alert){
                alerta="Error, intente de nuevo";
            }else{
                alerta="Paciente registrado con exito.";
            }
        } else{
            alerta="Paciente existente, ingrese otro.";
            Log.i("--->paciente: ", "Ya existe el paciente");
        }
        c.close();*/
        return null;
    }

    public boolean InsertarPaciente(paciente pacc){
        boolean alert = true;
        ConexionBD mDbHelper = new ConexionBD(this.context);
        SQLiteDatabase db = mDbHelper.getWritableDatabase();
        try{
            ContentValues cv = new ContentValues();
           /* cv.put(e_paciente.PacienteData.PAC_CEDULA, pacc.getPac_cedula());
            cv.put(e_paciente.PacienteData.PAC_NOMBRE, pacc.getPac_nombre());
            cv.put(e_paciente.PacienteData.PAC_APELLIDO, pacc.getPac_apellido());
            cv.put(e_paciente.PacienteData.PAC_TELEFONO, pacc.getPac_telefono());
            cv.put(e_paciente.PacienteData.PAC_FECHA_N, pacc.getPac_fecha_n());*/
            long rowID = db.insert(e_paciente.PacienteData.TABLE_NAME, null, cv);
        }
        catch (Exception e){
            alert = false;
        }

        db.close();
        return alert;
    }

}

        //LeerUsuario();
        /*SQLiteDatabase db1 = mDbHelper.getReadableDatabase();
        String user="lacuna";
        String password="12345";
        String[] projection = {
                e_usuario.UsuarioData.US_ID,
                e_usuario.UsuarioData.US_CEDULA,
                e_usuario.UsuarioData.US_NOMBRE,
                e_usuario.UsuarioData.US_USER,
                e_usuario.UsuarioData.US_PASSWORD
        };
        String where = e_usuario.UsuarioData.US_USER + "= '?'";
        String[] whereArgs = {user};
        String x ="select * from usuario where us_user='" + user + "' and us_password='" + password +"'";
        //String x ="select * from " +e_usuario.UsuarioData.TABLE_NAME + " where " + e_usuario.UsuarioData.US_USER + "='" +user+ "'";
        // Cursor c = db1.query(e_usuario.UsuarioData.TABLE_NAME, projection, where, whereArgs, null, null, null);*//**//**//**//*
       // String[] whereArgs = {user};
        Cursor c = db1.rawQuery(x,null);
        c.moveToFirst();
        Log.i("---> Bcount: ", ""+c.getCount());
        Log.i("Scount: ", ""+ x);
        if( c != null || c.getCount() <=0) {
            c.moveToFirst();
            Log.i("---> Bcount: ", ""+c.getString(3));

            //Log.i("---> Bcount: ", ""+c.getString(3));
            //Log.i("---> Bcount: ", ""+c.getString(4));
            c.close();
        }*/
//-----------------------------------------------------------------

   /* private SQLiteDatabase db;
    private DBHelper dbHelper;

    public static final String DB_NAME = "salud.db";
    public static final int DB_VERSION = 1;

    public Crud(Context context) {
        dbHelper = new DBHelper(context);
    }

    private void openReadableDB() {
        db = dbHelper.getReadableDatabase();
    }

    private void openWriteableDB() {
        db = dbHelper.getWritableDatabase();
        System.out.print("insert2 ");
    }

    private void closeDB() {
        if(db!=null){
            db.close();
        }
    }


    private static class DBHelper extends SQLiteOpenHelper {

        public DBHelper(Context context) {
            super(context, DB_NAME, null, DB_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(e_usuario.UsuarioData.SQL_CREATE_ENTRIES);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }

    private ContentValues MapperContentValues(usuario us) {
        ContentValues cv = new ContentValues();
//        cv.put(e_usuario.UsuarioData.US_ID, us.getUs_id());
        cv.put(e_usuario.UsuarioData.US_CEDULA, us.getUs_cedula());
        cv.put(e_usuario.UsuarioData.US_NOMBRE,  '\''+ us.getUs_nombre() + '\'');
        Log.i("Base de datos: ", "mapper.");
        cv.put(e_usuario.UsuarioData.US_USER,  '\''+ us.getUs_user() + '\'');
        cv.put(e_usuario.UsuarioData.US_PASSWORD,  '\''+ us.getUs_password() + '\'');

        return cv;
    }

    public long insertUsuario(usuario us) {
        System.out.print("insert1 " + us.getUs_id());
        this.openWriteableDB();
        System.out.print("insert3 " + us.getUs_id());
        Log.i("Base de datos: ", "Insertando Clientes.");
        long rowID = db.insert(e_usuario.UsuarioData.TABLE_NAME, null, MapperContentValues(us));
        this.closeDB();
        // System.out.print("inserto " + rowID);
        Log.i("Base de datos: ", "inserto " + rowID);
        return rowID;
    }

    public  usuario buscarUsuario1(String user, String password) {
        this.openWriteableDB();
        Cursor c = db.rawQuery("select us_user, us_password from usuario where us_user='"
                                + user + "'and us_password='" + password +"'", null);
    }




    public  usuario buscarUsuario(String user) {
        usuario usua = new usuario();
        this.openReadableDB();
        *//*String[] projection = {
                e_usuario.UsuarioData.US_ID,
                e_usuario.UsuarioData.US_CEDULA,
                e_usuario.UsuarioData.US_NOMBRE,
                e_usuario.UsuarioData.US_USER,
                e_usuario.UsuarioData.US_PASSWORD
        };
        String where = e_usuario.UsuarioData.US_USER + "= '?'";
        String[] whereArgs = {user};
        Cursor c = db.query(e_usuario.UsuarioData.TABLE_NAME, projection, where, whereArgs, null, null, null);*//*
        String[] whereArgs = {user};
        Cursor c = db.rawQuery("select * from " +e_usuario.UsuarioData.TABLE_NAME,null);
        c.moveToFirst();
        Log.i("---> Bcount: ", ""+c.getCount());
        String x ="select * from " +e_usuario.UsuarioData.TABLE_NAME + " where " + e_usuario.UsuarioData.US_USER + "='" +user+ "'";
        Log.i("Scount: ", ""+ x);
        if( c != null || c.getCount() <=0) {
            c.moveToFirst();
            if(user.equals(c.getString(3))){
                usua = new usuario();
                usua.setUs_id(c.getInt(0));
                usua.setUs_cedula(c.getInt(1));
                usua.setUs_nombre(c.getString(2));
                usua.setUs_user(c.getString(3));
                usua.setUs_password(c.getString(4));
            }
             //Log.i("---> Bcount: ", ""+c.getString(3));
             //Log.i("---> Bcount: ", ""+c.getString(4));
            c.close();
        }
        this.closeDB();
        Log.i("---> Bcount: ",""+ usua.getUs_user());
        return usua;
    }
}*/

   /*
   private ContentValues MapperContentValues(usuario usuario) {
        ContentValues cv = new ContentValues();
        cv.put(e_usuario.UsuarioData.US_ID, usuario.getUs_cedula());
        cv.put(e_usuario.UsuarioData.US_CEDULA, usuario.getUs_cedula());
        cv.put(e_usuario.UsuarioData.US_NOMBRE, usuario.getUs_nombre());
        cv.put(e_usuario.UsuarioData.US_USER, usuario.getUs_user());
        cv.put(e_usuario.UsuarioData.US_PASSWORD, usuario.getUs_password());

        return cv;
    }



   public long insertDataUsuario() {

        SQLiteDatabase dbb = myhelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(e_usuario.UsuarioData.US_ID, "10001");
        contentValues.put(e_usuario.UsuarioData.US_CEDULA, 1094832264);
        contentValues.put(e_usuario.UsuarioData.US_NOMBRE, "Leidy Acuña");
        contentValues.put(e_usuario.UsuarioData.US_USER, "lacuna");
        contentValues.put(e_usuario.UsuarioData.US_PASSWORD, "12345");

        long id = dbb.insert(e_usuario.UsuarioData.TABLE_NAME, null, contentValues);

        return id;
    }

    static class myDbHelper extends SQLiteOpenHelper {
        *//*private static final String DATABASE_NAME = "salud";
        private static final String nombre_table = "usuario";
        private static final String camp1 = "id_usuario";
        private static final String camp2 = "cedula";
        private static final String camp3 = "nombre";
        private static final String camp4 = "user";
        private static final String camp5 = "password";*//*

        public static final int DATABASE_VERSION = 1;
        public static final String DATABASE_NAME = "Lawyers.db";

        public LawyersDbHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        private static final int Version_BD = 1;

        private static final String crear_table = "CREATE TABLE " + nombre_table +
                " ("+camp1+ " INTEGER PRIMARY KEY AUTOINCREMENT, " + camp2 + " INTEGER ," + camp3 + " VARCHAR(50));"
                + camp4 + "VARCHAR(50));" + camp5 + "VARCHAR(50));";

        private static final String borra_tabla = "DROP TABLE IF EXISTS USUARIO";

        private Context context;



        public myDbHelper(Context context) {
            super(context, DATABASE_NAME, null, Version_BD);
            this.context = context;
        }

        public myDbHelper(Context context) {
            super();
        }

        public void onCreate(SQLiteDatabase db) {
            try {
                db.execSQL(crear_table);
            } catch (Exception e) {

            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            try {
                db.execSQL(borra_tabla);
                onCreate(db);
            } catch (Exception e) {

            }
        }
    }

    public ArrayList llenar_lista(){
        ArrayList <String> lista = new ArrayList<>();
        SQLiteDatabase dbb = myhelper.getWritableDatabase();
        String qr = "Select * from personal";
        Cursor dat = dbb.rawQuery(qr,null);

        lista.add("Ide       Nombre      Direc");
        if(dat.moveToFirst()){
            do {
                lista.add(dat.getString(0)+ "-" + dat.getString(1)+ "-"+ dat.getString(2));
            }while(dat.moveToNext());
        }
        return lista;
    }


}*/
