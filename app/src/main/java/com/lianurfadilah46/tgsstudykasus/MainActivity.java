package com.lianurfadilah46.tgsstudykasus;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Button btnwaktu, btntgl,btnpesan;
    int mYear, mMonth, mDay, mHour, mMinute;
    EditText tekswaktu, tekstgl, nama, tempat;
    String[] AsalTujuan, transportasi;
    Spinner s1, s2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        s1 = (Spinner) findViewById(R.id.spinner1);
        s2 = (Spinner) findViewById(R.id.spinner2);
        btnwaktu = (Button) findViewById(R.id.btn1);
        btntgl = (Button) findViewById(R.id.btn2);
        btnpesan = (Button) findViewById(R.id.btn5);
        nama = (EditText) findViewById(R.id.teks1);
        tempat = (EditText) findViewById(R.id.teks2);
        tekswaktu = (EditText) findViewById(R.id.teks3);
        tekstgl = (EditText) findViewById(R.id.teks4);


        transportasi = getResources().getStringArray(R.array.transportasi);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.
                simple_spinner_dropdown_item, transportasi);
        s2.setAdapter(adapter1);
        s2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                int index = arg0.getSelectedItemPosition();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(getBaseContext(), "Silahkan pilih jenis transportasi",
                        Toast.LENGTH_SHORT).show();
            }
        });

        AsalTujuan = getResources().getStringArray(R.array.AsalTujuan);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.
                simple_spinner_dropdown_item, AsalTujuan);
        s1.setAdapter (adapter);
        s1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3)
            {
                int index = arg0.getSelectedItemPosition();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(getBaseContext(), "Silahkan masukkan asal dan tujuan",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void btnwaktu(View view) {
        final Calendar c = Calendar.getInstance();
        mHour = c.get(Calendar.HOUR_OF_DAY);
        mMinute = c.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int hourOfDay, int minute) {
                tekswaktu.setText(hourOfDay + ":" + minute);
            }
        }, mHour, mMinute, false);
        timePickerDialog.show();
    }

    public void btntgl(View view) {
        final Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog
                (this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
                tekstgl.setText(dayOfMonth + "/" + monthOfYear + "/" + year);
            }
        }, mYear, mMonth, mDay);
        datePickerDialog.show();
    }

    public void btnpesan (View view){
        String tujuan = s1.getSelectedItem().toString();
        String transport = s2.getSelectedItem().toString();
        Intent intent = new Intent(this, Kirim.class);
        intent.putExtra("NmPemesan", nama.getText().toString());
        intent.putExtra("Tempat", tempat.getText().toString());
        intent.putExtra("Waktu", tekswaktu.getText().toString());
        intent.putExtra("Tanggal", tekstgl.getText().toString());
        intent.putExtra("Transportasi", transport);
        intent.putExtra("Asal Tujuan", tujuan);
        startActivity(intent);
    }
}
