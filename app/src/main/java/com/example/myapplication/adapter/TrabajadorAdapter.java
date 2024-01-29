package com.example.myapplication.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

import java.util.List;
import java.util.Map;

public class TrabajadorAdapter extends RecyclerView.Adapter<TrabajadorAdapter.ViewHolder>{

    public TrabajadorAdapter(List<Map<String, Object>> items) {
        this.items = items;
    }

    List<Map<String, Object>> items;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.iten, parent, false);
        return new ViewHolder(inflate);
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.titleTxt.setText( "#"+ position +" " +items.get(position).get("iddatabase") +
                " " + items.get(position).get("idempresa") + " " + items.get(position).get("idtrabajador")  +
                " " + items.get(position).get("detalle")  +
                " " + items.get(position).get("nombres")  );

    }

    @Override
    public int getItemCount() {
        return items.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView titleTxt;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTxt = itemView.findViewById(R.id.titleTxt);
        }
    }


}
