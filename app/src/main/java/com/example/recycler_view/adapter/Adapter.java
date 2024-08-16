package com.example.recycler_view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recycler_view.R;
import com.example.recycler_view.model.Compromisso;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    private List<Compromisso> listaCompromissos;

    public Adapter(List<Compromisso> lista){
        this.listaCompromissos = lista;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemLista = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_lista, parent, false);
        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Compromisso compromissoItem = listaCompromissos.get(position);
        holder.titulo.setText(compromissoItem.getTitulo());
        holder.data.setText(compromissoItem.getData());
        holder.horario.setText(compromissoItem.getHorario());
    }

    @Override
    public int getItemCount() {
        return listaCompromissos.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView titulo;
        TextView data;
        TextView horario;
        public MyViewHolder(@NonNull View itemView){
            super(itemView);
            titulo = itemView.findViewById(R.id.textViewTitulo);
            data = itemView.findViewById(R.id.textViewData);
            horario = itemView.findViewById(R.id.textViewHorario);
        }
    }

}
