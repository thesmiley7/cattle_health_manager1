package com.example.cattlehealthmanager.animal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.cattlehealthmanager.DatabaseHelper;
import com.example.cattlehealthmanager.R;
import com.example.cattlehealthmanager.databinding.ActivityMyAnimalsBinding;
import com.example.cattlehealthmanager.ui.main.SectionsPagerAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;


public class MyAnimals extends AppCompatActivity {

    private ActivityMyAnimalsBinding binding;
    private ListView obj;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_first);

        binding = ActivityMyAnimalsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = binding.viewPager;
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = binding.tabs;
        tabs.setupWithViewPager(viewPager);
        FloatingActionButton fab = binding.fab;

    }

    public void onClick(View view) {
        startActivity(new Intent(MyAnimals.this, AddAnimal.class));
    }
}