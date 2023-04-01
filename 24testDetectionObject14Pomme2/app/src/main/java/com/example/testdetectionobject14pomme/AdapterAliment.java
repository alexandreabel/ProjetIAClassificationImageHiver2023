package com.example.testdetectionobject14pomme;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterAliment extends RecyclerView.Adapter<AdapterAliment.ViewHolderAliment>
{
    List<Aliment> liste;

    public AdapterAliment(List<Aliment> l)
    {
        liste = l;
    }


    @NonNull
    @Override
    public AdapterAliment.ViewHolderAliment onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.layout_aliment, parent, false);
        return new AdapterAliment.ViewHolderAliment(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterAliment.ViewHolderAliment holder, int position) {
        Aliment u = liste.get(position);
        holder.tvNomUtilisateur.setText(u.nom_aliment + "\n " +"prix :"+ u.prix_aliment + " $");
    }

    @Override
    public int getItemCount() {
        return liste.size();
    }

    public class ViewHolderAliment extends RecyclerView.ViewHolder
    {
        TextView tvNomUtilisateur;

        public ViewHolderAliment(@NonNull View itemView) {
            super(itemView);

            tvNomUtilisateur = itemView.findViewById(R.id.tvNomUtilisateur);
        }//methode classe interne ViewHolderAliment

    }//  classe interne ViewHolderAliment
}//classe AdapterAliment
