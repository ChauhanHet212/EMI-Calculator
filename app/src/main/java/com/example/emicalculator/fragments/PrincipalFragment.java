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

public class PrincipalFragment extends Fragment {

    TextView principalText;
    LinearLayout principalLinear;
    RecyclerView principalRecycler;
    RecyclerAdapter adapter;
    List<EMI> emiList = new ArrayList<>();

    public PrincipalFragment(){
    }

    public PrincipalFragment(List<EMI> emiList){
        this.emiList = emiList;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_principal, container, false);

        principalText = view.findViewById(R.id.principalText);
        principalLinear = view.findViewById(R.id.principalLinear);
        principalRecycler = view.findViewById(R.id.principalRecycler);

        if (emiList.isEmpty()){
            principalText.setVisibility(View.VISIBLE);
            principalLinear.setVisibility(View.GONE);
        } else {
            principalText.setVisibility(View.GONE);
            principalLinear.setVisibility(View.VISIBLE);
            principalRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
            adapter = new RecyclerAdapter(getContext(), emiList, 1);
            principalRecycler.setAdapter(adapter);
        }

        return view;
    }
}
