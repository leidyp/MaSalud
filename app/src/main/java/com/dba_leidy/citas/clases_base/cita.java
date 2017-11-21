package com.dba_leidy.citas.clases_base;

import java.util.Date;

/**
 * Created by DBA-Leidy on 9/11/2017.
 */

public class cita {
    private String cita_id;
    private String med_id;
    private String pac_id;
    private String rec_id;
    private Date cita_fecha;
    private String cita_hora;
    private String cita_estado;
    private String cita_descripcion;

    public cita(String cita_id, String med_id, String pac_id, String rec_id, Date cita_fecha, String cita_hora, String cita_estado, String cita_descripcion) {
        this.cita_id = cita_id;
        this.med_id = med_id;
        this.pac_id = pac_id;
        this.rec_id = rec_id;
        this.cita_fecha = cita_fecha;
        this.cita_hora = cita_hora;
        this.cita_estado = cita_estado;
        this.cita_descripcion = cita_descripcion;
    }

    public String getCita_id() {
        return cita_id;
    }

    public void setCita_id(String cita_id) {
        this.cita_id = cita_id;
    }

    public String getMed_id() {
        return med_id;
    }

    public void setMed_id(String med_id) {
        this.med_id = med_id;
    }

    public String getPac_id() {
        return pac_id;
    }

    public void setPac_id(String pac_id) {
        this.pac_id = pac_id;
    }

    public String getRec_id() {
        return rec_id;
    }

    public void setRec_id(String rec_id) {
        this.rec_id = rec_id;
    }

    public Date getCita_fecha() {
        return cita_fecha;
    }

    public void setCita_fecha(Date cita_fecha) {
        this.cita_fecha = cita_fecha;
    }

    public String getCita_hora() {
        return cita_hora;
    }

    public void setCita_hora(String cita_hora) {
        this.cita_hora = cita_hora;
    }

    public String getCita_estado() {
        return cita_estado;
    }

    public void setCita_estado(String cita_estado) {
        this.cita_estado = cita_estado;
    }

    public String getCita_descripcion() {
        return cita_descripcion;
    }

    public void setCita_descripcion(String cita_descripcion) {
        this.cita_descripcion = cita_descripcion;
    }



}
