package com.example.juan.ensayopsptspmt.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.example.juan.ensayopsptspmt.R;
import com.example.juan.ensayopsptspmt.entidades.ProjectosVo;

import java.util.ArrayList;

public class AdapterProjectos extends RecyclerView.Adapter<AdapterProjectos.AdapterViewHolder> implements View.OnClickListener{

    ArrayList<ProjectosVo> listaprojecto;
    View.OnClickListener listener;

    public AdapterProjectos(ArrayList<ProjectosVo> listaprojecto) {
        this.listaprojecto = listaprojecto;
    }

    @Override
    public AdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.modelo_adapter,null,false);
        view.setOnClickListener(this);
        return new AdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AdapterViewHolder holder, int position) {
        holder.nombre.setText(""+listaprojecto.get(position).getNombre());
        holder.numero.setText(""+listaprojecto.get(position).getId());
    }

    @Override
    public int getItemCount() {
        return listaprojecto.size();
    }

    public  void  setOnClickListener(View.OnClickListener listener){
        this.listener=listener;
    }
    @Override
    public void onClick(View view) {
        if (listener!=null){
            listener.onClick(view);
        }
    }

    public class AdapterViewHolder extends RecyclerView.ViewHolder {
        TextView nombre,numero;
        public AdapterViewHolder(View itemView) {
            super(itemView);
            nombre=itemView.findViewById(R.id.nombre);
            numero=itemView.findViewById(R.id.numero);
        }
    }
}
