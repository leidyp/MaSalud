package com.dba_leidy.citas.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import com.codetroopers.betterpickers.calendardatepicker.CalendarDatePickerDialogFragment;
import com.codetroopers.betterpickers.calendardatepicker.MonthAdapter.CalendarDay;
import com.dba_leidy.citas.Crud;
import com.dba_leidy.citas.R;
import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

import java.util.Calendar;

/**
 * Created by DBA-Leidy on 22/11/2017.
 */

public class f_medico extends Fragment implements CalendarDatePickerDialogFragment.OnDateSetListener {

    private DatePicker datePicker;
    private Calendar calendar;
    private TextView dateView;
    private Button button;
    private int year, month, day;
    Crud c;

    String[] SPINNERLIST = {"User1", "User2", "User3"};
    String[] SPINNERLISTE = {"Medicina General", "Cardiología", "Hematología", "Neurología", "Pediatría"};
    MaterialBetterSpinner usuar;
    MaterialBetterSpinner espec;
    int positionP = -1;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //returning our layout file
        //change R.layout.yourlayoutfilename for each of your fragments
        return inflater.inflate(R.layout.fragment_medico, container, false);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        usuar = (MaterialBetterSpinner) getView().findViewById(R.id.usuariom);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_dropdown_item_1line, SPINNERLIST);

        espec = (MaterialBetterSpinner) getView().findViewById(R.id.especialidad);
        ArrayAdapter<String> arrayAdapter1 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_dropdown_item_1line, SPINNERLISTE);

        dateView = (TextView) getView().findViewById(R.id.fechanm);
        c = new Crud(getContext());

        usuar.setAdapter(arrayAdapter);
        usuar.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                positionP = position;
            }
        });

        espec.setAdapter(arrayAdapter1);
        espec.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                positionP = position;
            }
        });
        getActivity().setTitle("Registro Medicos");

        dateView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                int year = Calendar.getInstance().get(Calendar.YEAR);
                int month = Calendar.getInstance().get(Calendar.MONTH);
                int day = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
                CalendarDay date = new CalendarDay();
                CalendarDatePickerDialogFragment cdp = new CalendarDatePickerDialogFragment()
                        .setOnDateSetListener(f_medico.this)
                        .setFirstDayOfWeek(Calendar.SUNDAY)
                        .setPreselectedDate(year,month, day)
                        .setDateRange(null,date)
                        .setDoneText("OK")
                        .setCancelText("Cancelar");
                cdp.show(getActivity().getSupportFragmentManager(),"Fecha de nacimiento");
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

    public void insertPatient() {

    }
}
