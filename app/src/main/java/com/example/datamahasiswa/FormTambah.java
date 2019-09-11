package com.example.datamahasiswa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class FormTambah extends AppCompatActivity {
    public static String EXTRA_PERSON = " extra_person";
    public static String ACTION = " Insert";

    EditText nomor,nama,alamat,jk,tanggal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_tambah);

        nomor = findViewById (R.id.et_nomor);
        nama = findViewById (R.id.et_nama);
        alamat = findViewById (R.id.et_alamat);
        jk = findViewById (R.id.et_jk);
        tanggal = findViewById (R.id.et_tanggal);

        Mahasiswa mahasiswa = getIntent ().getParcelableExtra (EXTRA_PERSON);

        if(!EXTRA_PERSON.equals (" Insert")){
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

        if(ACTION.equals (" Insert")){
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
