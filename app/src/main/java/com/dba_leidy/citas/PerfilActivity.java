package com.dba_leidy.citas;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.dba_leidy.citas.clases_base.constantes;
import com.dba_leidy.citas.fragments.f_cita;
import com.dba_leidy.citas.fragments.f_medico;
import com.dba_leidy.citas.fragments.f_paciente;
import com.dba_leidy.citas.fragments.f_perfil;
import com.dba_leidy.citas.fragments.f_recepcionista;
import com.dba_leidy.citas.Crud;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class PerfilActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    TextView cedula;
    TextView nombre;
    int positionP = -1;
    private Bundle sesion;
    Crud db = new Crud();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        db.LeerMedicos();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        // Obtengo el Bundle del Intent
        Log.i("cedula p",""+getIntent().getExtras().getInt("cedula"));
        this.sesion = getIntent().getExtras();
        displaySelectedScreen(R.id.perfil);


       /* rol = (MaterialBetterSpinner) findViewById(R.id.rol);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, SPINNERLIST);

        rol.setAdapter(arrayAdapter);
        rol.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                positionP = position;
            }
        });*/

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.perfil, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        displaySelectedScreen(item.getItemId());



        /*// Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.person_black) {
            Toast.makeText(getApplicationContext(), "Perfil de usuario!",
                    Toast.LENGTH_LONG).show();
        } else if (id == R.id.group_add) {
            Toast.makeText(getApplicationContext(), "Pacientes!",
                    Toast.LENGTH_LONG).show();
        } else if (id == R.id.contacts_black) {
            Toast.makeText(getApplicationContext(), "Medicos!",
                    Toast.LENGTH_LONG).show();
        } else if (id == R.id.content_paste) {
            Toast.makeText(getApplicationContext(), "Citas!",
                    Toast.LENGTH_LONG).show();
        }*//*else if (id == R.id.content_paste) {

        } else if (id == R.id.nav_send) {

        }*//*

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);*/
        return true;
    }

    private void displaySelectedScreen(int itemId) {
        Bundle bundle = this.sesion;
        //creating fragment object
        Fragment fragment = null;

        //initializing the fragment object which is selected
        switch (itemId) {
            case R.id.perfil:
                fragment = new f_perfil();
                fragment.setArguments(bundle);
                break;
            case R.id.recepcionista:
                fragment = new f_recepcionista();
                fragment.setArguments(bundle);
                break;
            case R.id.paciente:
                fragment = new f_paciente();
                break;
            case R.id.medico:
                fragment = new f_medico();
                break;
            case R.id.citam:
                fragment = new f_cita();
                break;
        }

        //replacing the fragment
        if (fragment != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_frame, fragment);
            ft.commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
    }
}
