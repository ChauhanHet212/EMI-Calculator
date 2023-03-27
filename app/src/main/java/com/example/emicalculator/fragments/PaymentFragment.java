package com.example.emicalculator.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.emicalculator.R;
import com.example.emicalculator.adapters.RecyclerAdapter;
import com.example.emicalculator.models.EMI;

import java.util.ArrayList;
import java.util.List;

public class PaymentFragment extends Fragment {

    TextView paymentText;
    LinearLayout paymentLinear;
    RecyclerView paymentRecycler;
    RecyclerAdapter adapter;
    List<EMI> emiList = new ArrayList<>();

    public PaymentFragment(){
    }

    public PaymentFragment(List<EMI> emiList){
        this.emiList = emiList;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_payment, container, false);

        paymentText = view.findViewById(R.id.paymentText);
        paymentLinear = view.findViewById(R.id.paymentLinear);
        paymentRecycler = view.findViewById(R.id.paymentRecycler);

        if (emiList.isEmpty()){
            paymentText.setVisibility(View.VISIBLE);
            paymentLinear.setVisibility(View.GONE);
        } else {
            paymentText.setVisibility(View.GONE);
            paymentLinear.setVisibility(View.VISIBLE);
            paymentRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
            adapter = new RecyclerAdapter(getContext(), emiList, 3);
            paymentRecycler.setAdapter(adapter);
        }

        return view;
    }
}
