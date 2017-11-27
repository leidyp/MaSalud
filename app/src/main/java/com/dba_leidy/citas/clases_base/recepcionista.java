package com.dba_leidy.citas.clases_base;

import java.util.Date;

/**
 * Created by DBA-Leidy on 20/11/2017.
 */

public class recepcionista extends persona {

    private int rec_id;


    public recepcionista(String per_cedula, String per_nombres, String per_apellidos, String per_fechan, String per_direccion, String per_telefono, String per_correo, int rec_id) {
        super(per_cedula, per_nombres, per_apellidos, per_fechan, per_direccion, per_telefono, per_correo);
        this.rec_id = rec_id;
    }

    public int getRec_id() {
        return rec_id;
    }

    public void setRec_id(int rec_id) {
        this.rec_id = rec_id;
    }


}
