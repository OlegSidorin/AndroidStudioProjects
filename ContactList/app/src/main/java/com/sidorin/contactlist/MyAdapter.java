package com.sidorin.contactlist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private ArrayList<MyData> data;
    public interface OnMyDataEditListener {
        public void OnEditData(ArrayList<MyData> data, int position);
    }
    private OnMyDataEditListener onMyDataEditListener;

    public MyAdapter(ArrayList<MyData> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemview = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_item, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(itemview);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder holder, final int position) {
        final MyData item = data.get(position);
        holder.tv_name.setText(item.name);
        holder.tv_surname.setText(item.surname);
        holder.btn_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), String.format("EDIT %s", item.surname), Toast.LENGTH_SHORT).show();
                // onMyDataEditListener.OnEditData(data,position);
            }
        });
        holder.btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), String.format("DELETE %s", item.surname), Toast.LENGTH_SHORT).show();
                data.remove(position);
                // MyAdapter.this.notifyDataSetChanged(); // заново
                MyAdapter.this.notifyItemRemoved(position);
                MyAdapter.this.notifyItemRangeChanged(position,data.size()-position);
            }
        });
       // holder.tv_type.setText(item.type);

        /*
        switch (item.type) {
            case 0:
                holder.iv_type.setImageResource(R.drawable.ic_coder);
                break;
            default:
                holder.iv_type.setImageResource(R.drawable.ic_default);
        }
        */
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView tv_name, tv_surname, tv_type;
        public Button btn_edit, btn_delete;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_name = itemView.findViewById(R.id.tv_name);
            tv_surname = itemView.findViewById(R.id.tv_surname);
            btn_edit = itemView.findViewById(R.id.btn_edit);
            btn_delete = itemView.findViewById(R.id.btn_delete);
            tv_type = itemView.findViewById(R.id.tv_type);
        }
    }
}
