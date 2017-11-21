package com.dba_leidy.citas.clases_base;

import android.renderscript.Script;

import java.util.Date;

/**
 * Created by DBA-Leidy on 9/11/2017.
 */

public class paciente extends persona {

    private int pac_id;
    private int per_id;
    private String pac_tipo_sangre;


    public paciente(int us_id, String per_cedula, String per_nombres, String per_apellidos, Date per_fechan, String per_direccion, String per_telefono, String per_correo, int pac_id, int per_id, String pac_tipo_sangre) {
        super(us_id, per_cedula, per_nombres, per_apellidos, per_fechan, per_direccion, per_telefono, per_correo);
        this.pac_id = pac_id;
        this.per_id = per_id;
        this.pac_tipo_sangre = pac_tipo_sangre;
    }

    public int getPac_id() {
        return pac_id;
    }

    public void setPac_id(int pac_id) {
        this.pac_id = pac_id;
    }

    @Override
    public int getPer_id() {
        return per_id;
    }

    @Override
    public void setPer_id(int per_id) {
        this.per_id = per_id;
    }

    public String getPac_tipo_sangre() {
        return pac_tipo_sangre;
    }

    public void setPac_tipo_sangre(String pac_tipo_sangre) {
        this.pac_tipo_sangre = pac_tipo_sangre;
    }

}
