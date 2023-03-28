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

public class EMIAdapter extends RecyclerView.Adapter<EMIAdapter.ViewHolder> {

    Context context;
    List<EMI> emiList;

    public EMIAdapter(Context context, List<EMI> emiList) {
        this.context = context;
        this.emiList = emiList;
    }

    @NonNull
    @Override
    public EMIAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.emi_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull EMIAdapter.ViewHolder holder, int position) {

        Animation animation = AnimationUtils.loadAnimation(context, R.anim.fall_down_anim);
        holder.itemView.startAnimation(animation);

        holder.emi_month.setText(String.valueOf(emiList.get(position).getMonth()));
        holder.emi_principal.setText(String.valueOf(emiList.get(position).getPrincipal()));
        holder.emi_interest.setText(String.valueOf(emiList.get(position).getInterest()));
        holder.emi_tpayment.setText(String.valueOf(emiList.get(position).getT_payment()));
        holder.emi_balance.setText(String.valueOf(emiList.get(position).getBalance()));
    }

    @Override
    public int getItemCount() {
        return emiList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView emi_month, emi_principal, emi_interest, emi_tpayment, emi_balance;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            emi_month = itemView.findViewById(R.id.emi_month);
            emi_principal = itemView.findViewById(R.id.emi_principal);
            emi_interest = itemView.findViewById(R.id.emi_interest);
            emi_tpayment = itemView.findViewById(R.id.emi_tpayment);
            emi_balance = itemView.findViewById(R.id.emi_balance);
        }
    }
}
