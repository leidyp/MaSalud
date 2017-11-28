package com.dba_leidy.citas.fragments;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.codetroopers.betterpickers.calendardatepicker.CalendarDatePickerDialogFragment;
import com.codetroopers.betterpickers.calendardatepicker.MonthAdapter.CalendarDay;
import com.dba_leidy.citas.Crud;
import com.dba_leidy.citas.R;
import com.dba_leidy.citas.clases_base.constantes;
import com.dba_leidy.citas.clases_base.paciente;
import com.dba_leidy.citas.clases_base.recepcionista;
import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

import java.util.Calendar;

/**
 * Created by DBA-Leidy on 22/11/2017.
 */

public class f_recepcionista extends Fragment implements CalendarDatePickerDialogFragment.OnDateSetListener {

    private DatePicker datePicker;
    private Calendar calendar;
    private TextView dateView;
    private Button button;
    private int year, month, day;
    Crud c;

    EditText usuario;
    EditText contraseña;
    EditText cedula;
    EditText nombre;
    EditText apellido;
    EditText fecha;
    EditText direccion;
    EditText telefono;
    EditText correo;

    String usua;
    String contra;
    String ced;
    String nom;
    String apell;
    String tel;
    String dir;
    String fech;
    String cor;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //returning our layout file
        //change R.layout.yourlayoutfilename for each of your fragments
        return inflater.inflate(R.layout.fragment_recepcionista, container, false);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        dateView = (TextView) getView().findViewById(R.id.fechanr);
        button = (Button)getView().findViewById(R.id.insert_recep);
        c = new Crud(getContext());

        getActivity().setTitle("Registro Recepcionistas");

        dateView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                int year = Calendar.getInstance().get(Calendar.YEAR);
                int month = Calendar.getInstance().get(Calendar.MONTH);
                int day = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
                CalendarDay date = new CalendarDay();
                CalendarDatePickerDialogFragment cdp = new CalendarDatePickerDialogFragment()
                        .setOnDateSetListener(f_recepcionista.this)
                        .setFirstDayOfWeek(Calendar.SUNDAY)
                        .setPreselectedDate(year,month, day)
                        .setDateRange(null,date)
                        .setDoneText("OK")
                        .setCancelText("Cancelar");
                cdp.show(getActivity().getSupportFragmentManager(),"Fecha de nacimiento");
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                insertRecepcionista();
            }
        });

    }

    @Override
    public void onDateSet(CalendarDatePickerDialogFragment dialog, int year, int monthOfYear, int dayOfMonth) {
        monthOfYear += 1;
        dayOfMonth += 1;
        String mes = "" + (monthOfYear < 10 ? "0" + monthOfYear : monthOfYear);
        String dia = "" + (dayOfMonth < 10 ? "0" + dayOfMonth : dayOfMonth);
        dateView.setText(year + "-" + mes + "-" + dia);
    }

    public void insertRecepcionista() {

        usuario = (EditText) getView().findViewById(R.id.usuario);
        usua = usuario.getText().toString().trim();
        contraseña = (EditText) getView().findViewById(R.id.contraseña);
        contra = contraseña.getText().toString().trim();
        cedula = (EditText) getView().findViewById(R.id.cedular);
        ced = cedula.getText().toString().trim();
        nombre = (EditText) getView().findViewById(R.id.nombrer);
        nom = nombre.getText().toString().trim();
        apellido = (EditText) getView().findViewById(R.id.apellidor);
        apell = apellido.getText().toString().trim();
        direccion = (EditText) getView().findViewById(R.id.direccionr);
        dir = direccion.getText().toString().trim();
        telefono = (EditText) getView().findViewById(R.id.telefonor);
        tel = telefono.getText().toString().trim();
        correo = (EditText) getView().findViewById(R.id.correor);
        cor = correo.getText().toString().trim();
        fech = dateView.getText().toString().trim();
        if(usua.equals("") || contra.equals("") || ced.equals("") || nom.equals("") || apell.equals("") || dir.equals("") || tel.equals("") || cor.equals("") || fech.equals("Fecha de Nacimiento")){
            AlertDialog.Builder builder = new AlertDialog.Builder(getContext(), R.style.AppCompatAlertDialogStyle);
            builder.setTitle("Alerta");
            builder.setMessage("Complete todos los campos");
            builder.setPositiveButton("OK", null);
            builder.show();
        }
        else{
            AlertDialog.Builder builder = new AlertDialog.Builder(getContext(), R.style.AppCompatAlertDialogStyle);
            builder.setTitle("Alerta");
            builder.setMessage("¿Esta seguro de registrar este recepcionista?");
            builder.setPositiveButton("OK",new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogo1, int id) {
                    recepcionista r = new recepcionista(ced,nom,apell,fech,dir,tel,cor,usua,contra);
                    c.InsertarRecepcionista(r);
                }
            });
            builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogo1, int id) {
                    dialogo1.cancel();
                }
            });
            builder.show();

        }

    }
}
