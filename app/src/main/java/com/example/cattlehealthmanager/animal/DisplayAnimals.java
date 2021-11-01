package com.example.cattlehealthmanager.animal;

import android.os.Bundle;
import android.widget.TextView;

import com.example.cattlehealthmanager.DatabaseHelper;
import com.example.cattlehealthmanager.R;
import com.example.cattlehealthmanager.ui.AnimalList;

public class DisplayAnimals extends AnimalList {
    private DatabaseHelper db;

    TextView Tag_No;
    TextView Category;
    TextView Weight;
    TextView Gender;
    TextView Method_Obtained;
    TextView DOB;
    TextView Father_Tag;
    TextView Mother_Tag;
    int id_To_Update = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_animals2);
    }

    private void setContentView(int display_animals2) {
    }

}
