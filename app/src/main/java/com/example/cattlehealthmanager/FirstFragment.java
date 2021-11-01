package com.example.cattlehealthmanager;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cattlehealthmanager.databinding.FragmentFirstBinding;

import java.util.ArrayList;

public abstract class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;
    private  static final String TAG = "ListFragment";
    DatabaseHelper mDatabaseHelper;
    private RecyclerView recycler;
    RecyclerView mRecyclerView;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    @Override
    public void onCreate( Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        return new;
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler);
        mDatabaseHelper = new DatabaseHelper(RecyclerView);

        populateRecyclerView();
    }


    private void populateRecyclerView() {
        Log.d(TAG, "populateRecyclerView Displaying data in the RecyclerView");

        //getting data in a list
        Cursor data = mDatabaseHelper.getData();
        ArrayList<String> listData = new ArrayList<>();
        while(data.moveToNext()) {
            listData.add(data.getString(1));
        }
        ListAdapter adapter = new ListAdapter<>(this, android.R.layout.simple_list_item_1, listData);
        mRecyclerView.setAdapter(adapter);
    }

    /*public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });
    }*/

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


}