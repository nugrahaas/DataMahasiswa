package com.example.datamahasiswa;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class RecyclerviewAdapter extends RecyclerView.Adapter<RecyclerviewAdapter.UserViewHolder> {
    Context context;
    OnUserClickListener listener;

    List<Mahasiswa> listMahasiswa;
    public RecyclerviewAdapter(Context context, List<Mahasiswa>listMahasiswaInfo,OnUserClickListener listener) {
        this.context=context;
        this.listMahasiswa=listMahasiswaInfo;
        this.listener=listener;
    }

    public interface OnUserClickListener{
        void onUserClick(Mahasiswa currentMahasiwa);

    }
    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.contain_daftar_nama,parent,false);
        UserViewHolder userViewHolder=new UserViewHolder(view);

        return userViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, final int position) {
        final Mahasiswa currentOrang = listMahasiswa.get (position);
        holder.nama.setText (currentOrang.getNama ());


        holder.crdv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onUserClick(currentOrang);
            }
        });


    }

    @Override
    public int getItemCount() {
        return listMahasiswa.size();

    }

    public class UserViewHolder extends RecyclerView.ViewHolder {
        CardView crdv;
        TextView nama;
        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            crdv = itemView.findViewById (R.id.card);
            nama = itemView.findViewById (R.id.nama);
        }
    }


}
