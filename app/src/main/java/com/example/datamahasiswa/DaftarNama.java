package com.example.datamahasiswa;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.List;

public class DaftarNama extends AppCompatActivity implements View.OnClickListener,RecyclerviewAdapter.OnUserClickListener {

    RecyclerView.LayoutManager layoutManager;
    RecyclerView recyclerView;
    Context context;
    List<Mahasiswa> listMahasiswa;
    boolean test = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar_nama);


        recyclerView = findViewById (R.id.recyclerView);
        layoutManager = new LinearLayoutManager (this);
        recyclerView.setLayoutManager (layoutManager);

        setupRecyclerView();

    }

    public void inputData(View view) {
        Intent formTambah = new Intent(DaftarNama.this, FormTambah.class);
        startActivity(formTambah);
    }

    private void setupRecyclerView() {
        DatabaseHelper db=new DatabaseHelper(this);
        listMahasiswa=db.selectUserData();

        RecyclerviewAdapter adapter=new  RecyclerviewAdapter(this,listMahasiswa,this);

        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.tv_input){
            inputData(v);
        }

    }

    @Override
    public void onUserClick(final Mahasiswa currentMahasiwa) {

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Pilih Menu");

            String[] animals = {"Lihat Data", "Update Data", "Hapus Data"};
            builder.setItems(animals, new DialogInterface.OnClickListener() {

                @Override
                public void onClick(DialogInterface dialog, int which) {
                    switch (which) {
                        case 0:
                            Mahasiswa mPerson = new Mahasiswa ();
                            mPerson.setNomor (currentMahasiwa.getNomor ());
                            mPerson.setNama (currentMahasiwa.getNama ());
                            mPerson.setTanggal (currentMahasiwa.getTanggal ());
                            mPerson.setJeniskelamin (currentMahasiwa.getJeniskelamin ());
                            mPerson.setAlamat (currentMahasiwa.getAlamat ());
                            Intent detail = new Intent(DaftarNama.this, DetailData.class);
                            detail.putExtra(DetailData.EXTRA_PERSON,mPerson);
                            startActivity(detail);
                            break;
                        case 1:
                            Mahasiswa mahasiswa = new Mahasiswa ();
                            FormTambah.ACTION = " Update";
                            mahasiswa.setNomor (currentMahasiwa.getNomor ());
                            mahasiswa.setNama (currentMahasiwa.getNama ());
                            mahasiswa.setTanggal (currentMahasiwa.getTanggal ());
                            mahasiswa.setJeniskelamin (currentMahasiwa.getJeniskelamin ());
                            mahasiswa.setAlamat (currentMahasiwa.getAlamat ());
                            Intent update = new Intent(DaftarNama.this, FormTambah.class);
                            update.putExtra(FormTambah.EXTRA_PERSON,mahasiswa);
                            startActivity(update);
                            break;
                        case 2:
                            DatabaseHelper db=new DatabaseHelper(DaftarNama.this);
                            db.delete(currentMahasiwa.getNama ());
                            setupRecyclerView();
                            break;
                    }
                }
            });

// create and show the alert dialog
            AlertDialog dialog = builder.create();
            dialog.show();
        }


}
