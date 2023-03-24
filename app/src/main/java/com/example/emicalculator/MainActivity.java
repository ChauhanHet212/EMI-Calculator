package com.example.emicalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.emicalculator.adapters.EMIAdapter;
import com.example.emicalculator.models.EMI;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText pEdt, rEdt, nEdt;
    Button calculateBtn, clearBtn;
    RecyclerView emiRecycler;
    LinearLayout emi_layout;
    List<EMI> emiList;
    EMIAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pEdt = findViewById(R.id.pEdt);
        rEdt = findViewById(R.id.rEdt);
        nEdt = findViewById(R.id.nEdt);
        calculateBtn = findViewById(R.id.calculateBtn);
        clearBtn = findViewById(R.id.clearBtn);
        emiRecycler = findViewById(R.id.emiRecycler);
        emi_layout = findViewById(R.id.emi_layout);

        calculateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!pEdt.getText().toString().isEmpty() && !rEdt.getText().toString().isEmpty() && !nEdt.getText().toString().isEmpty()) {
                    int amount = Integer.parseInt(pEdt.getText().toString());
                    float rate = Float.parseFloat(rEdt.getText().toString());
                    int month = Integer.parseInt(nEdt.getText().toString());
                    if (amount != 0 && rate != 0 && rate <=20 && month != 0 && month <= 400){
                        emiList = calculateEMI(amount, rate, month);

                        emiRecycler.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                        adapter = new EMIAdapter(MainActivity.this, emiList);
                        emiRecycler.setAdapter(adapter);
                        emi_layout.setVisibility(View.VISIBLE);
                    } else {
                        if (amount == 0){
                            pEdt.setError("Amount can't be 0");
                        }
                        if (rate == 0){
                            rEdt.setError("Rate can't be 0");
                        }
                        if (month == 0){
                            nEdt.setError("Tenure can't be 0");
                        }
                        if (rate > 20){
                            rEdt.setError("Maximum rate is 20");
                        }
                        if (month > 400){
                            nEdt.setError("Maximum months is 400");
                        }
                    }
                } else {
                    if (pEdt.getText().toString().isEmpty()){
                        pEdt.setError("Enter Amount");
                    }
                    if (rEdt.getText().toString().isEmpty()){
                        rEdt.setError("Enter Rate");
                    }
                    if (nEdt.getText().toString().isEmpty()){
                        nEdt.setError("Enter Tenure");
                    }
                }
            }
        });

        clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                emi_layout.setVisibility(View.GONE);
                emiList.clear();

                pEdt.setText("");
                rEdt.setText("");
                nEdt.setText("");
            }
        });
    }

    private List<EMI> calculateEMI(int amount, float rate, int month) {
        List<EMI> emilist = new ArrayList<>();

        rate = rate/12/100;
        int emi = (int) Math.round(amount * rate * (Math.pow(1 + rate, month) / (Math.pow(1 + rate, month) - 1)));

        for (int i = 0; i < month; i++) {
            int interest = Math.round(amount * rate);
            int principal = emi - interest;
            amount -= principal;

            emilist.add(new EMI(i+1, principal, interest, emi, amount));
        }

        return emilist;
    }
}