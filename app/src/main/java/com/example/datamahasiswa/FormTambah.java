package com.example.datamahasiswa;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class FormTambah extends AppCompatActivity {
    public static String EXTRA_PERSON = " extra_person";
    public static String ACTION = "Insert";

    protected OnBackPressedListener onBackPressedListener;

    public interface OnBackPressedListener {
        void doBack();
    }

    public void setOnBackPressedListener(OnBackPressedListener onBackPressedListener) {
        this.onBackPressedListener = onBackPressedListener;
    }

    @Override
    public void onBackPressed() {
        if (onBackPressedListener != null)
            onBackPressedListener.doBack();
        else
            super.onBackPressed();
    }

    EditText nomor,nama,alamat,jk,tanggal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_tambah);


        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        nomor = findViewById (R.id.et_nomor);
        nama = findViewById (R.id.et_nama);
        alamat = findViewById (R.id.et_alamat);
        jk = findViewById (R.id.et_jk);
        tanggal = findViewById (R.id.et_tanggal);

        if(getIntent().hasExtra("Update")) {
            Mahasiswa mahasiswa = getIntent ().getParcelableExtra (EXTRA_PERSON);
            nomor.setText (mahasiswa.getNomor ()+"");
            nama.setText (mahasiswa.getNama ()+"");
            alamat.setText (mahasiswa.getAlamat ()+"");
            tanggal.setText (mahasiswa.getTanggal ()+"");
            jk.setText (mahasiswa.getJeniskelamin ()+"");
        }



    }

    public void simpanData(View view) {
        DatabaseHelper db = new DatabaseHelper(this);
        Mahasiswa currentMahasiswa = new Mahasiswa ();

        if(!getIntent().hasExtra("Update")) {
            currentMahasiswa.setNomor(Integer.parseInt(nomor.getText().toString()));
            currentMahasiswa.setNama (nama.getText().toString ());
            currentMahasiswa.setAlamat (alamat.getText().toString ());
            currentMahasiswa.setJeniskelamin (jk.getText().toString ());
            currentMahasiswa.setTanggal (tanggal.getText().toString ());
            db.insert(currentMahasiswa);
        }else{
            currentMahasiswa.setNomor(Integer.parseInt(nomor.getText().toString()));
            currentMahasiswa.setNama (nama.getText().toString ());
            currentMahasiswa.setAlamat (alamat.getText().toString ());
            currentMahasiswa.setJeniskelamin (jk.getText().toString ());
            currentMahasiswa.setTanggal (tanggal.getText().toString ());
            db.update(currentMahasiswa);
        }
        Intent simpanData = new Intent(FormTambah.this, DaftarNama.class);
        startActivity(simpanData);
    }
}
