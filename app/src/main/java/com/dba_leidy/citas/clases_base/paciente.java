package com.dba_leidy.citas.clases_base;

import android.renderscript.Script;

import java.util.Date;

/**
 * Created by DBA-Leidy on 9/11/2017.
 */

public class paciente extends persona {

    private int pac_id;
    private String pac_tipo_sangre;
    private int med_id_cabecera;

    public paciente(String per_cedula, String per_nombres, String per_apellidos, String per_fechan, String per_direccion, String per_telefono, String per_correo, String pac_tipo_sangre, int med_cab) {
        super(per_cedula, per_nombres, per_apellidos, per_fechan, per_direccion, per_telefono, per_correo);
        this.pac_tipo_sangre = pac_tipo_sangre;
        this.med_id_cabecera = med_cab;
    }

    public int getPac_id() {
        return pac_id;
    }

    public void setPac_id(int pac_id) {
        this.pac_id = pac_id;
    }

    public String getPac_tipo_sangre() {
        return pac_tipo_sangre;
    }

    public void setPac_tipo_sangre(String pac_tipo_sangre) {
        this.pac_tipo_sangre = pac_tipo_sangre;
    }

    public int getMed_cab() {
        return med_id_cabecera;
    }

    public void setMed_cab(int med_cab) {
        this.med_id_cabecera = med_cab;
    }
}
