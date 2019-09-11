package com.example.datamahasiswa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class FormTambah extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_tambah);
    }

    public void simpanData(View view) {
        Intent simpanData = new Intent(FormTambah.this, DaftarNama.class);
        startActivity(simpanData);
    }
}
