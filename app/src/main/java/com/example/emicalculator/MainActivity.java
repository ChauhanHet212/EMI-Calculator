package com.example.emicalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.emicalculator.adapters.EMIAdapter;
import com.example.emicalculator.adapters.ViewPagerAdapter;
import com.example.emicalculator.fragments.BalanceFragment;
import com.example.emicalculator.fragments.HomeFragment;
import com.example.emicalculator.fragments.InterestFragment;
import com.example.emicalculator.fragments.PaymentFragment;
import com.example.emicalculator.fragments.PrincipalFragment;
import com.example.emicalculator.models.EMI;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    TabLayout tab;
    ViewPager pager;
    ViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tab = findViewById(R.id.tab);
        pager = findViewById(R.id.pager);

        adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new HomeFragment(), "Home");
        adapter.addFragment(new PrincipalFragment(), "Principal");
        adapter.addFragment(new InterestFragment(), "Interest");
        adapter.addFragment(new PaymentFragment(), "Payment");
        adapter.addFragment(new BalanceFragment(), "Balance");
        pager.setAdapter(adapter);
        tab.setupWithViewPager(pager);
    }
}