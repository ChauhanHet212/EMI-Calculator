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

public class BalanceFragment extends Fragment {

    TextView balanceText;
    LinearLayout balanceLinear;
    RecyclerView balanceRecycler;
    RecyclerAdapter adapter;
    List<EMI> emiList = new ArrayList<>();

    public BalanceFragment(){
    }

    public BalanceFragment(List<EMI> emiList){
        this.emiList = emiList;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_balance, container, false);

        balanceText = view.findViewById(R.id.balanceText);
        balanceLinear = view.findViewById(R.id.balanceLinear);
        balanceRecycler = view.findViewById(R.id.balanceRecycler);

        if (emiList.isEmpty()){
            balanceText.setVisibility(View.VISIBLE);
            balanceLinear.setVisibility(View.GONE);
        } else {
            balanceText.setVisibility(View.GONE);
            balanceLinear.setVisibility(View.VISIBLE);
            balanceRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
            adapter = new RecyclerAdapter(getContext(), emiList, 4);
            balanceRecycler.setAdapter(adapter);
        }

        return view;
    }
}
