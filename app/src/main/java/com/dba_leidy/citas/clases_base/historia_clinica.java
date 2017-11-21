package com.dba_leidy.citas.clases_base;

import java.util.Date;

/**
 * Created by DBA-Leidy on 20/11/2017.
 */

public class historia_clinica {

    private int hc_id;
    private int pac_id;
    private int proc_id;
    private String hc_serial;
    private Date hc_fecha;
    private String hc_descripcion;

    public historia_clinica(int hc_id, int pac_id, int proc_id, String hc_serial, Date hc_fecha, String hc_descripcion) {
        this.hc_id = hc_id;
        this.pac_id = pac_id;
        this.proc_id = proc_id;
        this.hc_serial = hc_serial;
        this.hc_fecha = hc_fecha;
        this.hc_descripcion = hc_descripcion;
    }

    public int getHc_id() {
        return hc_id;
    }

    public void setHc_id(int hc_id) {
        this.hc_id = hc_id;
    }

    public int getPac_id() {
        return pac_id;
    }

    public void setPac_id(int pac_id) {
        this.pac_id = pac_id;
    }

    public int getProc_id() {
        return proc_id;
    }

    public void setProc_id(int proc_id) {
        this.proc_id = proc_id;
    }

    public String getHc_serial() {
        return hc_serial;
    }

    public void setHc_serial(String hc_serial) {
        this.hc_serial = hc_serial;
    }

    public Date getHc_fecha() {
        return hc_fecha;
    }

    public void setHc_fecha(Date hc_fecha) {
        this.hc_fecha = hc_fecha;
    }

    public String getHc_descripcion() {
        return hc_descripcion;
    }

    public void setHc_descripcion(String hc_descripcion) {
        this.hc_descripcion = hc_descripcion;
    }
}
