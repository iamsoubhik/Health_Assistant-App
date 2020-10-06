package com.example.blood;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.blood.Adapter.HospitalStaffAdapter;
import com.example.blood.Model.HospitalStaffModel;

import java.util.ArrayList;
import java.util.List;

public class HospitalStaffActivity extends AppCompatActivity {
    ListView hlist;
    List<HospitalStaffModel> hospitalStaffModels = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital_staff);
        hlist = findViewById(R.id.hlist);

        hospitalStaffModels.add(new HospitalStaffModel("Appolo Hospital","Sweta Yadav","18605001066"));
        hospitalStaffModels.add(new HospitalStaffModel("Satyam Hospital","Rakesh Sharma","0181-2470200"));
        hospitalStaffModels.add(new HospitalStaffModel("Fortis Hospital","Rekha Lahiri","01615222333"));
        hospitalStaffModels.add(new HospitalStaffModel("Narayana Hospital","Aaksha Tripathi","18602080208"));
        hospitalStaffModels.add(new HospitalStaffModel("Gurunanak Hospital","Malini Sengupta","18605001066"));

        HospitalStaffAdapter  hospitalStaffAdapter = new HospitalStaffAdapter(this,R.layout.custom_hospital_staff,hospitalStaffModels);
        hlist.setAdapter(hospitalStaffAdapter);

    }
}
