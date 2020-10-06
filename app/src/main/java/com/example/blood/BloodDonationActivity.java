package com.example.blood;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.blood.Model.BloodDonationModel;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class BloodDonationActivity extends AppCompatActivity {
    EditText name,email,phone,age,address;
    Button ap,am,ab,o,bp,reg;
    BloodDonationModel bloodDonationModel;
    static String bloodgroup="";
    DatabaseReference refg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blood_donation);
        name = findViewById(R.id.editText);
        email = findViewById(R.id.editText2);
        phone = findViewById(R.id.editText3);
        age = findViewById(R.id.editText4);
        address = findViewById(R.id.editText5);
        refg= FirebaseDatabase.getInstance().getReference().child("Member");

        ap = findViewById(R.id.button);
        am = findViewById(R.id.button2);
        ab = findViewById(R.id.button3);
        o = findViewById(R.id.button4);
        bp = findViewById(R.id.button5);
        reg = findViewById(R.id.button6);




        ap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bloodgroup = ap.getText().toString();
            }
        });
        am.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bloodgroup = am.getText().toString();
            }
        });
        ab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bloodgroup = ab.getText().toString();
            }
        });
        o.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bloodgroup = o.getText().toString();
            }
        });
        bp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bloodgroup = bp.getText().toString();
            }
        });
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 String n = name.getText().toString().trim();
                 String e = email.getText().toString().trim();
                 String p = phone.getText().toString().trim();
                 String a = age.getText().toString().trim();
                 String ad = address.getText().toString().trim();
                bloodDonationModel = new BloodDonationModel(n,e,p,a,ad,bloodgroup);
                refg.push().setValue(bloodDonationModel);
                Toast.makeText(BloodDonationActivity.this, "Your data has been saved successfully", Toast.LENGTH_SHORT).show();
            }
        });


    }
}
