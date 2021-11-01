package com.example.cattlehealthmanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Medicals extends AppCompatActivity implements View.OnClickListener {

    public CardView card6, card7, card8, card9, card10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicals);

        card6 = (CardView) findViewById(R.id.card6);
        card7 = (CardView) findViewById(R.id.card7);
        card8 = (CardView) findViewById(R.id.card8);
        card9 = (CardView) findViewById(R.id.card9);
        card10 = (CardView) findViewById(R.id.card10);

        card6.setOnClickListener(this);
        card7.setOnClickListener(this);
        card8.setOnClickListener(this);
        card9.setOnClickListener(this);
        card10.setOnClickListener(this);

        /*Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);*/
    }

    @Override
    public void onClick(View view) {

        Intent i;

        switch (view.getId()) {
            case R.id.card6:
                i = new Intent(this,VaccinationSchedule.class);
                startActivity(i);
                break;

            case R.id.card7:
                i = new Intent(this,TickControl.class);
                startActivity(i);
                break;

            case R.id.card8:
                i = new Intent(this,MonthlyReport.class);
                startActivity(i);
                break;

            case R.id.card9:
                i = new Intent(this,Treatment.class);
                startActivity(i);
                break;

            case R.id.card10:
                i = new Intent(this,Calving.class);
                startActivity(i);
                break;
        }

    }
}