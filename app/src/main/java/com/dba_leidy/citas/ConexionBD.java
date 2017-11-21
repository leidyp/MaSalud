package com.dba_leidy.citas;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.dba_leidy.citas.esquemas.*;

/**
 * Created by DBA-Leidy on 10/11/2017.
 */

public class ConexionBD extends SQLiteOpenHelper {
    // If you change the database schema, you must increment the database version.
    public static final int DATABASE_VERSION = 2;
    public static final String DATABASE_NAME = "salud.db";

    public ConexionBD(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    public void onCreate(SQLiteDatabase db) {
        Log.i("sql",""+ e_usuario.UsuarioData.SQL_CREATE_ENTRIES);
        db.execSQL(e_usuario.UsuarioData.SQL_CREATE_ENTRIES);
        db.execSQL(e_paciente.PacienteData.SQL_CREATE_ENTRIES);

        Log.i("------","registro todo");
    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        db.execSQL(e_usuario.UsuarioData.SQL_DELETE_ENTRIES);
        onCreate(db);
    }
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
}

