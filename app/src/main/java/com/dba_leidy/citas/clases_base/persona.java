package com.dba_leidy.citas.clases_base;

import java.util.Date;

/**
 * Created by DBA-Leidy on 19/11/2017.
 */

public class persona {
    private int per_id;
    private int us_id;
    private String per_cedula;
    private String per_nombres;
    private String per_apellidos;
    private Date per_fechan;
    private String per_direccion;
    private String per_telefono;
    private String per_correo;

    public persona(int us_id, String per_cedula, String per_nombres, String per_apellidos, Date per_fechan, String per_direccion, String per_telefono, String per_correo) {
        this.us_id = us_id;
        this.per_cedula = per_cedula;
        this.per_nombres = per_nombres;
        this.per_apellidos = per_apellidos;
        this.per_fechan = per_fechan;
        this.per_direccion = per_direccion;
        this.per_telefono = per_telefono;
        this.per_correo = per_correo;
    }


    public int getPer_id() {
        return per_id;
    }

    public void setPer_id(int per_id) {
        this.per_id = per_id;
    }

    public int getUs_id() {
        return us_id;
    }

    public void setUs_id(int us_id) {
        this.us_id = us_id;
    }

    public String getPer_cedula() {
        return per_cedula;
    }

    public void setPer_cedula(String per_cedula) {
        this.per_cedula = per_cedula;
    }

    public String getPer_nombres() {
        return per_nombres;
    }

    public void setPer_nombres(String per_nombres) {
        this.per_nombres = per_nombres;
    }

    public String getPer_apellidos() {
        return per_apellidos;
    }

    public void setPer_apellidos(String per_apellidos) {
        this.per_apellidos = per_apellidos;
    }

    public Date getPer_fechan() {
        return per_fechan;
    }

    public void setPer_fechan(Date per_fechan) {
        this.per_fechan = per_fechan;
    }

    public String getPer_direccion() {
        return per_direccion;
    }

    public void setPer_direccion(String per_direccion) {
        this.per_direccion = per_direccion;
    }

    public String getPer_telefono() {
        return per_telefono;
    }

    public void setPer_telefono(String per_telefono) {
        this.per_telefono = per_telefono;
    }

    public String getPer_correo() {
        return per_correo;
    }

    public void setPer_correo(String per_correo) {
        this.per_correo = per_correo;
    }


}

