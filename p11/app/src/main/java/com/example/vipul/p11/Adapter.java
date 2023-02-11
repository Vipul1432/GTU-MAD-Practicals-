package com.example.vipul.p11;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    Context ctx;
    List<Model> models;
    private ArrayList list;
    public Adapter(Context ctx, List<Model> models, ArrayList list) {
        this.ctx = ctx;
        this.models = models;
        this.list = list;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v =
                LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
        return new ViewHolder(v);
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder,
                                 @SuppressLint("RecyclerView") int position) {
        holder.mTvName.setText(models.get(position).getName());
        Log.e("Name : ",models.get(position).getName());
        holder.mTvAdd.setText(models.get(position).getAddress());
        holder.img.setImageURI((Uri) list.get(position));
        holder.btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                models.remove(position);
                list.remove(position);
                notifyDataSetChanged();
            }
        });

    }
    @Override
    public int getItemCount() {
        return models.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView mTvName,mTvAdd;
        ImageView img;
        Button btnRemove;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mTvName = itemView.findViewById(R.id.txtName);
            mTvAdd = itemView.findViewById(R.id.txtAddress);
            img=itemView.findViewById(R.id.img);
            btnRemove = itemView.findViewById(R.id.remvoeItem);
        }
    }
}
