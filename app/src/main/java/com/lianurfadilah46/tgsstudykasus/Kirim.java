package com.lianurfadilah46.tgsstudykasus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by lianurfadilah46 on 4/11/2018.
 */

public class Kirim extends AppCompatActivity {

    TextView NamaPemesan, Transportasi, AsalTujuan, Tanggal, Waktu, Tempat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kirim);

        NamaPemesan = (TextView) findViewById(R.id.teks5);
        Transportasi = (TextView) findViewById(R.id.teks6);
        AsalTujuan = (TextView) findViewById(R.id.teks7);
        Tanggal = (TextView) findViewById(R.id.teks8);
        Waktu = (TextView) findViewById(R.id.teks9);
        Tempat = (TextView) findViewById(R.id.teks10);

        NamaPemesan.setText("Nama Pemesan : " + getIntent().getStringExtra("NmPemesan"));
        Transportasi.setText("Jenis Transportasi  : " + getIntent().getStringExtra("Transportasi"));
        AsalTujuan.setText("Asal dan Tujuan : " + getIntent().getStringExtra("Asal Tujuan"));
        Waktu.setText("Waktu : " + getIntent().getStringExtra("Waktu"));
        Tanggal.setText("Tanggal : " + getIntent().getStringExtra("Tanggal"));
        Tempat.setText("Tempat : " + getIntent().getStringExtra("Tempat"));

        Button tutup = (Button) findViewById(R.id.btn7);
        tutup.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                moveTaskToBack(true);
            }
        });
    }
    }
