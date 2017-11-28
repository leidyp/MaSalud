package com.dba_leidy.citas.fragments;

import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AlertDialog;
import android.util.Log;
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
import com.dba_leidy.citas.clases_base.paciente;
import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

import java.util.Calendar;
import com.dba_leidy.citas.clases_base.constantes;
/**
 * Created by DBA-Leidy on 10/11/2017.
 */

public class f_paciente extends Fragment implements CalendarDatePickerDialogFragment.OnDateSetListener {

    private DatePicker datePicker;
    private Calendar calendar;
    private TextView dateView;
    private Button button;
    private int year, month, day;

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

    Crud c;


    String[] TS= {"A+","A-","B+","B-","AB+","AB-","O+","O-"};
    MaterialBetterSpinner medC;
    MaterialBetterSpinner TipoS;
    int positionT = -1;
    int positionM = -1;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //returning our layout file
        //change R.layout.yourlayoutfilename for each of your fragments
        return inflater.inflate(R.layout.fragment_paciente, container, false);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        medC = (MaterialBetterSpinner) getView().findViewById(R.id.medicoc);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_dropdown_item_1line, constantes.MEDICOSN);

        medC.setAdapter(arrayAdapter);
        medC.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                positionM = position;
            }
        });

        TipoS = (MaterialBetterSpinner) getView().findViewById(R.id.tiposangre);
        ArrayAdapter<String> arrayAdapter1 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_dropdown_item_1line, TS);

        TipoS.setAdapter(arrayAdapter1);
        TipoS.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                positionT = position;
                Log.i("TIPOS",TS[positionT]);
            }
        });

        dateView = (TextView)getView().findViewById(R.id.fechan);
        button = (Button)getView().findViewById(R.id.insert_patient);
        c = new Crud(getContext());
        //you can set the title for your toolbar here for different fragments different titles
        getActivity().setTitle("Registro Paciente");

        dateView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                int year = Calendar.getInstance().get(Calendar.YEAR);
                int month = Calendar.getInstance().get(Calendar.MONTH);
                int day = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
                CalendarDay date = new CalendarDay();
                CalendarDatePickerDialogFragment cdp = new CalendarDatePickerDialogFragment()
                        .setOnDateSetListener(f_paciente.this)
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
                insertPatient();
            }
        });
    }

    @Override
    public void onDateSet(CalendarDatePickerDialogFragment dialog, int year, int monthOfYear, int dayOfMonth) {
        monthOfYear += 1;
        dayOfMonth += 1;
        String mes = "" + (monthOfYear < 10 ? "0"+monthOfYear : monthOfYear);
        String dia = "" + (dayOfMonth < 10 ? "0"+dayOfMonth : dayOfMonth);
        dateView.setText(year+"-"+ mes +"-"+dia);
    }
    public void insertPatient() {
        cedula = (EditText) getView().findViewById(R.id.cedulam);
        ced = cedula.getText().toString().trim();
        nombre = (EditText) getView().findViewById(R.id.nombrem);
        nom = nombre.getText().toString().trim();
        apellido = (EditText) getView().findViewById(R.id.apellidom);
        apell = apellido.getText().toString().trim();
        direccion = (EditText) getView().findViewById(R.id.direccionm);
        dir = direccion.getText().toString().trim();
        telefono = (EditText) getView().findViewById(R.id.telefonom);
        tel = telefono.getText().toString().trim();
        correo = (EditText) getView().findViewById(R.id.correom);
        cor = correo.getText().toString().trim();
        fech = dateView.getText().toString().trim();
        if(ced.equals("") || nom.equals("") || apell.equals("") || tel.equals("") || cor.equals("") || fech.equals("Fecha de Nacimiento") || positionM==-1 || positionT==-1){
            AlertDialog.Builder builder = new AlertDialog.Builder(getContext(), R.style.AppCompatAlertDialogStyle);
            builder.setTitle("Alerta");
            builder.setMessage("Complete todos los campos");
            builder.setPositiveButton("OK", null);
            builder.show();
        }
        else{
            AlertDialog.Builder builder = new AlertDialog.Builder(getContext(), R.style.AppCompatAlertDialogStyle);
            builder.setTitle("Alerta");
            builder.setMessage("¿Esta seguro de registrar este paciente?");
            builder.setPositiveButton("OK",new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogo1, int id) {
                    paciente p = new paciente(ced,nom,apell,fech,dir,tel,cor,TS[positionT],constantes.MEDICOS.get(positionM).getMed_id());
                    c.InsertarPaciente(p);
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
