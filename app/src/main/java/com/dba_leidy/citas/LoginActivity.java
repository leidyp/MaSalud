package com.dba_leidy.citas;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.dba_leidy.citas.clases_base.usuario;


public class LoginActivity extends AppCompatActivity {
    EditText user;
    EditText pass;
    private Crud db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        db = new Crud(this);
        db.LeerUsuario();

        user = (EditText) findViewById(R.id.username);
        pass = (EditText) findViewById(R.id.password);

        if (getIntent().getBooleanExtra("EXIT", false)) {
            finish();
        }
    }


    public void ValidateLogin(View view) {
        String usua = user.getText().toString().trim();
        String contrasena = pass.getText().toString().trim();
        usuario usuario;
        if (!usua.equals("") && !contrasena.equals("")) {
            usuario = db.ValidarLogin(usua,contrasena);
            Log.i("---> Bcountlo: ", ""+usuario.getUs_user());
            if (usua.equals(usuario.getUs_user()) && contrasena.equals(usuario.getUs_password())) {
                Intent intent = new Intent(getApplicationContext(), PerfilActivity.class);
                //intent.putExtra("cedula",usuario.getUs_cedula());
                intent.putExtra("nombre",usuario.getUs_nombre());
                intent.putExtra("user",usuario.getUs_user());
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);

            } else {
                AlertDialog.Builder builder =
                        new AlertDialog.Builder(this, R.style.AppCompatAlertDialogStyle);
                builder.setTitle("Alerta");
                builder.setMessage("Usuario o Contraseña incorrectos.");
                builder.setPositiveButton("OK", null);
                builder.show();
            }
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

