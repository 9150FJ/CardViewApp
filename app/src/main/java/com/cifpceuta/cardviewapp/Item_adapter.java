package com.cifpceuta.cardviewapp;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Item_adapter extends RecyclerView.Adapter<Item_adapter.ViewHolder> {
    ArrayList<String> list_item;
    CardView cardView;

    int ordem=0;


    public Item_adapter(){}
    public Item_adapter(ArrayList<String> list_item) {
        this.list_item=list_item;


    }


    public void setFilterList(ArrayList<String> listaFiltrada){
        list_item = listaFiltrada;
        notifyDataSetChanged();
    }




    @NonNull
    @Override
    public Item_adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.element_layout,parent,false);
        return new Item_adapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Item_adapter.ViewHolder holder, int position) {
        holder.bindData(list_item.get(position));

    }

    @Override
    public int getItemCount() {
        return list_item.size();
    }

   public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvItem;
        Button btnBorrar;



       private Item_adapter adapter;

        public ViewHolder(@NonNull View itemView){
            super(itemView);

            tvItem=itemView.findViewById(R.id.tvItem); //Crear textview
            btnBorrar = itemView.findViewById(R.id.btnBorrar); //Crear boton en xml
            cardView = itemView.findViewById(R.id.general); //Crear estructura general

            btnBorrar.setOnClickListener(view -> {
                String texto_item = list_item.get(getAdapterPosition());
                Toast.makeText(itemView.getContext(), "Elemento eliminado "+texto_item,Toast.LENGTH_LONG).show();
                list_item.remove(getAdapterPosition());
                notifyItemRemoved(getAdapterPosition());
            });



        }

       void bindData(final String item){
           tvItem.setText(item);
       }



   }


}

