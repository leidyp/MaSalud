package com.dba_leidy.citas.clases_base;

import java.util.Date;

/**
 * Created by DBA-Leidy on 20/11/2017.
 */

public class recepcionista extends persona {

    private int rec_id;
    private int per_id;


    public recepcionista(int us_id, String per_cedula, String per_nombres, String per_apellidos, Date per_fechan, String per_direccion, String per_telefono, String per_correo, int rec_id, int per_id) {
        super(us_id, per_cedula, per_nombres, per_apellidos, per_fechan, per_direccion, per_telefono, per_correo);
        this.rec_id = rec_id;
        this.per_id = per_id;
    }

    public int getRec_id() {
        return rec_id;
    }

    public void setRec_id(int rec_id) {
        this.rec_id = rec_id;
    }

    @Override
    public int getPer_id() {
        return per_id;
    }

    @Override
    public void setPer_id(int per_id) {
        this.per_id = per_id;
    }

}
