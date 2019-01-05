package com.example.nizar.animelist;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AnimeAdapter extends RecyclerView.Adapter<AnimeAdapter.ViewHolder>{
    ArrayList<Anime> listAnime;
    Context context;
    AnimeAdapter(Context context){
        this.context = context;
    }
    public ArrayList<Anime> getListAnime(){
        return listAnime;
    }
    public void setListAnime(ArrayList<Anime> listAnime){
        this.listAnime = listAnime;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view =
                LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.anime_item,viewGroup,false);
        return new ViewHolder(view);
    }
    @Override
    public int getItemCount() {
        return getListAnime().size();
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
    viewHolder.judul.setText(getListAnime().get(i).getJudul());
        viewHolder.relis.setText(getListAnime().get(i).getTanggal());

    viewHolder.genere.setText(getListAnime().get(i).getGenre());
        Glide.with(context)
                .load(getListAnime().get(i).getGambar())
                .into(viewHolder.imgPoster);
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tvJudul)
        TextView judul;
        @BindView(R.id.tvRelis)
        TextView relis;
        @BindView(R.id.imgAnime)
        ImageView imgPoster;
        @BindView(R.id.tvGenre)
        TextView genere;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);

        }
    }
}

