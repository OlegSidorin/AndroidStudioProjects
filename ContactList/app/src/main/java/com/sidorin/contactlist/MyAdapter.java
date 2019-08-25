package com.sidorin.contactlist;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    int selected_position = -1;

    private ArrayList<MyData> data;

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView tv_name, tv_surname, tv_type;
        public ImageView img_contact;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            tv_name = (TextView) itemView.findViewById(R.id.tv_name);
            tv_surname = (TextView) itemView.findViewById(R.id.tv_surname);
            tv_type = (TextView) itemView.findViewById(R.id.tv_type);
            img_contact = (ImageView) itemView.findViewById(R.id.iPhoto);
        }

        @Override
        public void onClick(View view) {

            if (getAdapterPosition() == RecyclerView.NO_POSITION) return;

            // обновляем в соответствии с выделением
            notifyItemChanged(selected_position);
            selected_position = getAdapterPosition();
            notifyItemChanged(selected_position);

        }
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
        holder.itemView.setBackgroundColor(selected_position == position ? Color.GREEN : Color.WHITE);
        holder.tv_name.setText(item.name);
        holder.tv_surname.setText(item.surname);
        holder.tv_type.setText(item.who);

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

    }

    @Override
    public int getItemCount() {
        return data.size();
    }


}
