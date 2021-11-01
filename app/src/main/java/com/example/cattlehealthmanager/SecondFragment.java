package com.example.cattlehealthmanager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.charts.Pie;
import com.example.cattlehealthmanager.databinding.FragmentSecondBinding;



public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;
    AnyChartView anyChartView;

    String[] categories = ("Bull", "Heafer", "Oxen", "Calve", "Cow", "Tollie");
    int numbers = (5, 10, 7, 4 ,5 ,3);



    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState

    ) {

        binding = FragmentSecondBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.id.any_chart_view);

        anyChartView = findViewById(R.id.any_chart_view);

        setupPieChart();
    }

    public void setupPieChart() {
        Pie pie = AnyChart.pie();
    }


    /*public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
            }
        });
    } */

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}