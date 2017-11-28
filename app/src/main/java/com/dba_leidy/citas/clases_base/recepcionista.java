package com.dba_leidy.citas.clases_base;

import java.util.Date;

/**
 * Created by DBA-Leidy on 20/11/2017.
 */

public class recepcionista extends persona {

    private int rec_id;
    private String us_user;
    private String us_password;


    public recepcionista(String per_cedula, String per_nombres, String per_apellidos, String per_fechan, String per_direccion, String per_telefono, String per_correo, String us_user, String us_password) {
        super(per_cedula, per_nombres, per_apellidos, per_fechan, per_direccion, per_telefono, per_correo);
        this.us_user = us_user;
        this.us_password = us_password;
    }


    public int getRec_id() {
        return rec_id;
    }

    public void setRec_id(int rec_id) {
        this.rec_id = rec_id;
    }


    public String getUs_user() {
        return us_user;
    }

    public void setUs_user(String us_user) {
        this.us_user = us_user;
    }

    public String getUs_password() {
        return us_password;
    }

    public void setUs_password(String us_password) {
        this.us_password = us_password;
    }

}
