package com.example.datamahasiswa;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class DetailData extends AppCompatActivity {
    public static String EXTRA_PERSON = " extra_person";
    EditText nomor,nama,alamat,tanggal,jk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);

        Mahasiswa mahasiswa = getIntent ().getParcelableExtra (EXTRA_PERSON);

        setContentView (R.layout.activity_detail_data);
        nomor = findViewById (R.id.det_nomor);
        nama = findViewById (R.id.det_nama);
        alamat = findViewById (R.id.det_alamat);
        tanggal = findViewById (R.id.det_tanggal);
        jk = findViewById (R.id.det_jk);



        nomor.setText (mahasiswa.getNomor ()+"");
        nama.setText (mahasiswa.getNama ()+"");
        alamat.setText (mahasiswa.getAlamat ()+"");
        tanggal.setText (mahasiswa.getTanggal ()+"");
        jk.setText (mahasiswa.getJeniskelamin ()+"");
    }
}
