package com.dba_leidy.citas.clases_base;

import java.util.UUID;

/**
 * Created by DBA-Leidy on 9/11/2017.
 */

public class usuario {
    private int us_id;
    private String us_nombre;
    private String us_user;
    private String us_password;

    public usuario() {}

    public usuario(int us_id,  String nombre,  String user, String password) {
        this.us_id = us_id;
        this.us_nombre = nombre;
        this.us_user = user;
        this.us_password= password;
    }

    public int getUs_id() {
        return us_id;
    }

    public void setUs_id(int id) {
        this.us_id = id;
    }

    public String getUs_nombre() {
        return us_nombre;
    }

    public void setUs_nombre(String nombre) {
        this.us_nombre = nombre;
    }

    public String getUs_user() {
        return us_user;
    }

    public void setUs_user(String user) {
        this.us_user = user;
    }

    public String getUs_password() {
        return us_password;
    }

    public void setUs_password(String password) {
        this.us_password = password;
    }
}