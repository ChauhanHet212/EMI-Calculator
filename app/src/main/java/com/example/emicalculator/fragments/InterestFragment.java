package com.example.emicalculator.fragments;

import static com.example.emicalculator.fragments.HomeFragment.emiList;

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

public class InterestFragment extends Fragment {

    TextView interestText;
    LinearLayout interestLinear;
    RecyclerView interestRecycler;
    RecyclerAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_interest, container, false);

        interestText = view.findViewById(R.id.interestText);
        interestLinear = view.findViewById(R.id.interestLinear);
        interestRecycler = view.findViewById(R.id.interestRecycler);

        if (emiList.isEmpty()){
            interestText.setVisibility(View.VISIBLE);
            interestLinear.setVisibility(View.GONE);
        } else {
            interestText.setVisibility(View.GONE);
            interestLinear.setVisibility(View.VISIBLE);
            interestRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
            adapter = new RecyclerAdapter(getContext(), emiList, 2);
            interestRecycler.setAdapter(adapter);
        }

        return view;
    }
}
