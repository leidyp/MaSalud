package com.dba_leidy.citas.esquemas;

import android.provider.BaseColumns;

/**
 * Created by DBA-Leidy on 9/11/2017.
 */

public class e_cita {
    public static abstract class CitaData implements BaseColumns {
        public static final String TABLE_NAME ="cita";

        public static final String CITA_ID = "cita_id";
        public static final String MED_ID = "med_id";
        public static final String PAC_ID = "pac_id";
        public static final String CITA_FECHA = "cita_fecha";
        public static final String MED_OCUPACION = "med_ocupacion";
    }
}
