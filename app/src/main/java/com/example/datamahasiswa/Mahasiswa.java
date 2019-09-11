package com.example.datamahasiswa;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

public class Mahasiswa implements Parcelable {
    String nama,jeniskelamin,alamat,tanggal;
    int nomor;

    public Mahasiswa() {
        this.nama = nama;
        this.jeniskelamin = jeniskelamin;
        this.alamat = alamat;
        this.nomor = nomor;
        this.tanggal = tanggal;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJeniskelamin() {
        return jeniskelamin;
    }

    public void setJeniskelamin(String jeniskelamin) {
        this.jeniskelamin = jeniskelamin;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public int getNomor() {
        return nomor;
    }

    public void setNomor(int nomor) {
        this.nomor = nomor;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString (this.nama);
        dest.writeString (this.jeniskelamin);
        dest.writeString (this.alamat);
        dest.writeString (this.tanggal);
        dest.writeInt (this.nomor);
    }

    protected Mahasiswa(Parcel in) {
        this.nama = in.readString ();
        this.jeniskelamin = in.readString ();
        this.alamat = in.readString ();
        this.tanggal = in.readString ();
        this.nomor = in.readInt ();
    }

    public static final Parcelable.Creator<Mahasiswa> CREATOR = new Parcelable.Creator<Mahasiswa> () {
        @Override
        public Mahasiswa createFromParcel(Parcel source) {
            return new Mahasiswa (source);
        }

        @Override
        public Mahasiswa[] newArray(int size) {
            return new Mahasiswa[size];
        }
    };
}
