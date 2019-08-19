package com.sidorin.contactlist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private ArrayList<MyData> data;

    public interface OnMyDataEditListener {
        void onEditData(ArrayList<MyData> data, int position);

    }

    private OnMyDataEditListener onMyDataEditListener;
    public void setOnMyDataEditListener(OnMyDataEditListener onMyDataEditListener){
        this.onMyDataEditListener = onMyDataEditListener;
    }

    public MyAdapter(ArrayList<MyData> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_item, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(itemView);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder holder, final int position) {
        final MyData item = data.get(position);
        holder.tv_name.setText(item.name);
        holder.tv_surname.setText(item.surname);
        holder.tv_type.setText(item.who);

        holder.btn_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(view.getContext(), String.format("EDIT %s", item.surname), Toast.LENGTH_SHORT).show();
                onMyDataEditListener.onEditData(data,position);
            }
        });
        holder.btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), String.format("Удален контакт %s", item.surname), Toast.LENGTH_SHORT).show();
                data.remove(position);
                // MyAdapter.this.notifyDataSetChanged(); // заново
                MyAdapter.this.notifyItemRemoved(position);
                MyAdapter.this.notifyItemRangeChanged(position, data.size() - position);
            }
        });

        switch (item.gender) {
            case "f":
                holder.img_contact.setImageResource(R.drawable.ic_female);
                break;
            case "m":
                holder.img_contact.setImageResource(R.drawable.ic_male);
                break;
            default:
                holder.img_contact.setImageResource(R.drawable.ic_portrait_black_24dp);
        }
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
        public ImageView img_contact;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_name = (TextView) itemView.findViewById(R.id.tv_name);
            tv_surname = (TextView) itemView.findViewById(R.id.tv_surname);
            btn_edit = (Button) itemView.findViewById(R.id.btn_edit);
            btn_delete = (Button) itemView.findViewById(R.id.btn_delete);
            tv_type = (TextView) itemView.findViewById(R.id.tv_type);
            img_contact = (ImageView) itemView.findViewById(R.id.iPhoto);
        }
    }
}
