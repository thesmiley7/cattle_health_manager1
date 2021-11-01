package com.example.cattlehealthmanager.animal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.cattlehealthmanager.DatabaseHelper;
import com.example.cattlehealthmanager.R;

import java.util.ArrayList;
import java.util.List;

public class AddAnimal extends AppCompatActivity {
    public static final String TAG = "AddAnimal";
    private final Context mContext;

    private Spinner spinnerBreed;
    private Button addani;

    //The database fields
    private SQLiteDatabase mDatabase;
    private DatabaseHelper mDatabaseHelper;
    private Context context;
    private String[] mAllColumns = { DatabaseHelper.COLUMN_TAG_NO,
            DatabaseHelper.COLUMN_CATEGORY, DatabaseHelper.COLUMN_WEIGHT, DatabaseHelper.COLUMN_GENDER,
            DatabaseHelper.COLUMN_METHOD_OBTAINED, DatabaseHelper.COLUMN_DATE_OF_BIRTH,
            DatabaseHelper.COLUMN_FATHER_TAG, DatabaseHelper.COLUMN_MOTHER_TAG
    };

    public AddAnimal(Context context) {
        this.mContext = context;
        mDatabaseHelper = new DatabaseHelper(context);

        //open the database
        try{
            open();
        } catch (SQLException e) {
            Log.e(TAG, "SQLException when opening the database" + e.getMessage());
            e.printStackTrace();
        }
    }

    public void open() throws SQLException {
        mDatabase = mDatabaseHelper.getWritableDatabase();
    }

    public void close() {
        mDatabaseHelper.close();
    }

    public void createAnimal(String tagNo, String category, String weight, String gender, String methodObtained, String dob, String fatherTag, String motherTag) {
        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.COLUMN_TAG_NO, tagNo);
        values.put(DatabaseHelper.COLUMN_CATEGORY, category);
        values.put(DatabaseHelper.COLUMN_WEIGHT, weight);
        values.put(DatabaseHelper.COLUMN_METHOD_OBTAINED, methodObtained);
        values.put(DatabaseHelper.COLUMN_DATE_OF_BIRTH,dob);
        values.put(DatabaseHelper.COLUMN_FATHER_TAG, fatherTag);
        values.put(DatabaseHelper.COLUMN_MOTHER_TAG, motherTag);
        long insertId = mDatabase.insert(DatabaseHelper.TABLE_ANIMALS, null, values);
        Cursor cursor = mDatabase.query(DatabaseHelper.TABLE_ANIMALS, mAllColumns,
                DatabaseHelper.COLUMN_TAG_NO + " = " + insertId, null, null, null, null);
        cursor.moveToFirst();
        Animal newAnimal = cursorToAnimal(cursor);
        cursor.close();
        return newAnimal;

    }

    private Animal cursorToAnimal(Cursor cursor) {
    }

    public void deleteAnimal(AddAnimal animal) {
        long tag_no = animal.getId();
        System.out.println("the deleted animal has the tag number: " + tag_no);
        mDatabase.delete(DatabaseHelper.TABLE_ANIMALS, DatabaseHelper.COLUMN_TAG_NO + " = " + tag_no,null);
    }

    public List<Animal> getAllAnimals() {
        List<Animal> animalList = new ArrayList<Animal>();

        Cursor cursor = mDatabase.query(DatabaseHelper.TABLE_ANIMALS,
                mAllColumns, null, null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Animal animal = cursorToAnimal(cursor);
            animalList.add(animal);
            cursor.moveToNext();
        }
        //make sure cursor closes
        cursor.close();
        return animalList;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_animal);
        addani = (Button) findViewById(R.id.addani);
        mDatabaseHelper = new DatabaseHelper(this);

        spinnerBreed = findViewById(R.id.category_spin);

        String[] category = getResources().getStringArray(R.array.categories);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, category);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerBreed.setAdapter(adapter);


        spinnerBreed = findViewById(R.id.method_obtained);

        String[] method_ob = getResources().getStringArray(R.array.method_ob);
        adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, method_ob);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerBreed.setAdapter(adapter);

        //setting the add button
        addani.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newEntry = addani.getText().toString();
                if (addani.length() != 0) {
                    AddData(newEntry);
                    addani.setText("");
                } else {
                    toastmessage("You need to put something in the field");
                }
            }
        });
    }

    public void onRadioButtonClicked(View v) {

        boolean checked = ((RadioButton) v).isChecked();
        String str="";
        // Check which radio button was clicked
        switch(v.getId()) {
            case R.id.male:
                if(checked)
                    str = "Male Selected";
                break;
            case R.id.female:
                if(checked)
                    str = "Female Selected";
                break;

        }
        Toast.makeText(getApplicationContext(), str, Toast.LENGTH_SHORT).show();
    }


    //adding to the database
    public void AddData(String newEntry) {
        boolean insertData = mDatabaseHelper.TABLE_ANIMALS(newEntry);

        if (insertData) {
            toastmessage("Data Successfully Inserted");
        } else {
            toastmessage("Something Went Wrong");
        }
    }

    private void toastmessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }


}