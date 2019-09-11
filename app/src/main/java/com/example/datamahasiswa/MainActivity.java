package com.example.datamahasiswa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void lihatData(View view) {
        Intent daftarNama = new Intent(MainActivity.this, DaftarNama.class);
        startActivity(daftarNama);
    }

    public void inputData(View view) {
        Intent formTambah = new Intent(MainActivity.this, FormTambah.class);
        startActivity(formTambah);
    }

    public void informasi(View view) {
        Intent info = new Intent(MainActivity.this, Informasi.class);
        startActivity(info);
    }
}
