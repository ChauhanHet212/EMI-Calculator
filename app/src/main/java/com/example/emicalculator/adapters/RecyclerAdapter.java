package com.example.emicalculator.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.emicalculator.R;
import com.example.emicalculator.models.EMI;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    Context context;
    List<EMI> emiList;
    int i;

    public RecyclerAdapter(Context context, List<EMI> emiList, int i) {
        this.context = context;
        this.emiList = emiList;
        this.i = i;
    }

    @NonNull
    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.recycler_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.ViewHolder holder, int position) {

        Animation animation = AnimationUtils.loadAnimation(context, R.anim.fall_down_anim);
        holder.itemView.startAnimation(animation);

        holder.item_month.setText(String.valueOf(emiList.get(position).getMonth()));
        if (i == 1){
            holder.item_value.setText(String.valueOf(emiList.get(position).getPrincipal()));
        } else if (i == 2){
            holder.item_value.setText(String.valueOf(emiList.get(position).getInterest()));
        } else if (i == 3){
            holder.item_value.setText(String.valueOf(emiList.get(position).getT_payment()));
        } else if (i == 4){
            holder.item_value.setText(String.valueOf(emiList.get(position).getBalance()));
        }
    }

    @Override
    public int getItemCount() {
        return emiList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView item_month, item_value;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            item_month = itemView.findViewById(R.id.item_month);
            item_value = itemView.findViewById(R.id.item_value);
        }
    }
}
