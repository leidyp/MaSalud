package com.dba_leidy.citas.clases_base;

import java.util.Date;

/**
 * Created by DBA-Leidy on 9/11/2017.
 */

public class medico extends persona {

    private int med_id;
    private String med_especialidad;

    public medico(){}

    public medico(String per_cedula, String per_nombres, String per_apellidos, String per_fechan, String per_direccion, String per_telefono, String per_correo, int med_id, String med_especialidad) {
        super(per_cedula, per_nombres, per_apellidos, per_fechan, per_direccion, per_telefono, per_correo);
        this.med_id = med_id;
        this.med_especialidad = med_especialidad;
    }

    public int getMed_id() {
        return med_id;
    }

    public void setMed_id(int med_id) {
        this.med_id = med_id;
    }

    public String getMed_especialidad() {
        return med_especialidad;
    }

    public void setMed_especialidad(String med_especialidad) {
        this.med_especialidad = med_especialidad;
    }
}
