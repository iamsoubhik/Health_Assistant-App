package com.example.blood;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.blood.Model.OrganDonationModel;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class OrganDonationActivity extends AppCompatActivity {
    EditText name,email,phone,age,address;
    Button register;
    Spinner s;
    ArrayList<String> organpart = new ArrayList<>();
    OrganDonationModel organDonationModel;
    static String organ = "";
    DatabaseReference refg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_organ_donation);

        name = findViewById(R.id.editText6);
        email = findViewById(R.id.editText7);
        phone = findViewById(R.id.editText8);
        age = findViewById(R.id.editText9);
        address = findViewById(R.id.editText10);
        register =findViewById(R.id.button7);
        s = findViewById(R.id.spinner);
        refg= FirebaseDatabase.getInstance().getReference().child("OrganDonation");

        organpart.add("Select Organ");
        organpart.add("Eyes");
        organpart.add("Kidney");
        organpart.add("Lungs");
        organpart.add("Liver");
        organpart.add("Heart");

        ArrayAdapter arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,organpart);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s.setAdapter(arrayAdapter);
        final boolean[] b = {false};

        s.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                b[0] = true;
                return false;
            }
        });
        s.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (!b[0]) {
                    return;
                }
                organ = organpart.get(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n = name.getText().toString().trim();
                String e = email.getText().toString().trim();
                String p = phone.getText().toString().trim();
                String a = age.getText().toString().trim();
                String ad = address.getText().toString().trim();
                organDonationModel = new OrganDonationModel(n,e,p,a,ad,organ);
                refg.push().setValue(organDonationModel);
            }
        });

    }
}
