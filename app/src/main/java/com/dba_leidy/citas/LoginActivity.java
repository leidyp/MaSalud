package com.dba_leidy.citas;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.dba_leidy.citas.clases_base.constantes;


public class LoginActivity extends AppCompatActivity {
    EditText user;
    EditText pass;
    private Crud db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        db = new Crud(this);
        // db.LeerUsuario();

        user = (EditText) findViewById(R.id.username);
        pass = (EditText) findViewById(R.id.password);

        if (getIntent().getBooleanExtra("EXIT", false)) {
            finish();
        }
    }

    public void ValidateLogin(View view) {
        Log.i("---> Bcountlo: ", "entro");
        Log.i("---> Bcountlo: ", ""+ constantes.URLAPI);
        String usua = user.getText().toString().trim();
        String contrasena = pass.getText().toString().trim();
        //usuario usuario;
        if (!usua.equals("") && !contrasena.equals("")) {
            db.iniciarSesion(usua,contrasena);
        } else {
            AlertDialog.Builder builder =
                    new AlertDialog.Builder(this, R.style.AppCompatAlertDialogStyle);
            builder.setTitle("Alerta");
            builder.setMessage("Los campos estan vacios, Introduzca contenido para continuar.");
            builder.setPositiveButton("OK", null);
            builder.show();
        }
    }

}

