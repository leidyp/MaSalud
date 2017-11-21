package com.dba_leidy.citas.esquemas;

import android.provider.BaseColumns;

/**
 * Created by DBA-Leidy on 9/11/2017.
 */

public class e_medico {

    public static abstract class MedicoData implements BaseColumns {
        public static final String TABLE_NAME ="medico";

        public static final String MED_ID = "med_id";
        public static final String MED_CEDULA = "med_cedula";
        public static final String MED_NOMBRE = "med_nombre";
        public static final String MED_APELLIDO= "med_apellido";
        public static final String MED_TELEFONO = "med_telefono";
        public static final String MED_FECHA_N = "med_fecha_n";
        public static final String MED_OCUPACION = "med_ocupacion";
    }
}
