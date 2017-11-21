package com.dba_leidy.citas.esquemas;

import android.provider.BaseColumns;

/**
 * Created by DBA-Leidy on 9/11/2017.
 */

public class e_paciente {

    public static abstract class PacienteData implements BaseColumns {
        public static final String TABLE_NAME ="paciente";

        public static final String PAC_ID = "pac_id";
        public static final String PAC_CEDULA = "pac_cedula";
        public static final String PAC_NOMBRE = "pac_nombre";
        public static final String PAC_APELLIDO= "pac_apellido";
        public static final String PAC_TELEFONO = "pac_telefono";
        public static final String PAC_FECHA_N = "pac_fecha_n";


        public static final String SQL_CREATE_ENTRIES =
                    " CREATE TABLE " + TABLE_NAME + " (" +
                    PAC_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    PAC_CEDULA + " VARCHAR(50), " +
                    PAC_NOMBRE + " VARCHAR(50), " +
                    PAC_APELLIDO + " VARCHAR(50), " +
                    PAC_TELEFONO + " VARCHAR(50), " +
                    PAC_FECHA_N + " VARCHAR(50), " +
                    " UNIQUE (" + PAC_ID + "));";

        public static final String SQL_DELETE_ENTRIES =
                "DROP TABLE IF EXISTS " + TABLE_NAME;
    }
}
