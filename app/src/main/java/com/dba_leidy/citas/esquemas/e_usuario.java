package com.dba_leidy.citas.esquemas;

import android.provider.BaseColumns;

/**
 * Created by DBA-Leidy on 9/11/2017.
 */

public class e_usuario {
    public static abstract class UsuarioData implements BaseColumns {

        public static final String TABLE_NAME ="usuario";

        public static final String US_ID = "us_id";
        public static final String US_CEDULA = "us_cedula";
        public static final String US_NOMBRE = "us_nombre";
        public static final String US_USER = "us_user";
        public static final String US_PASSWORD = "us_password";


        public static final String SQL_CREATE_ENTRIES =
                "CREATE TABLE " + TABLE_NAME + " (" +
                        US_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        US_CEDULA + " INTEGER, " +
                        US_NOMBRE + " VARCHAR(50), " +
                        US_USER + " VARCHAR(50), " +
                        US_PASSWORD + " VARCHAR(50), " +
                        " UNIQUE (" + US_ID + "))";

        public static final String SQL_DELETE_ENTRIES =
                "DROP TABLE IF EXISTS " + TABLE_NAME;

    }

}
