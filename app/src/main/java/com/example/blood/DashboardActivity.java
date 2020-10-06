package com.example.blood;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class DashboardActivity extends AppCompatActivity {
ConstraintLayout blood,organ,callambulance,calldoctor,hospitalstaff,map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        blood = findViewById(R.id.blood);
        organ = findViewById(R.id.organ);
        callambulance = findViewById(R.id.ambulance);
        calldoctor = findViewById(R.id.doctor);
        hospitalstaff = findViewById(R.id.hospitalstaff);
        map = findViewById(R.id.map);

        blood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DashboardActivity.this,BloodDonationActivity.class));
            }
        });
        organ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DashboardActivity.this,OrganDonationActivity.class));
            }
        });
        callambulance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DashboardActivity.this,CallAmbulanceActivity.class));
            }
        });
        calldoctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DashboardActivity.this,CallDoctorActivity.class));
            }
        });

        hospitalstaff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DashboardActivity.this,HospitalStaffActivity.class));
            }
        });

        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DashboardActivity.this,MapActivity.class));
            }
        });
    }
}
