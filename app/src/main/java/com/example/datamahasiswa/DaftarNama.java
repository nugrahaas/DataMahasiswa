package com.example.datamahasiswa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class DaftarNama extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar_nama);
    }

    public void inputData(View view) {
        Intent formTambah = new Intent(DaftarNama.this, FormTambah.class);
        startActivity(formTambah);
    }
}
