package com.example.blood;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.blood.Adapter.DoctorAdapter;
import com.example.blood.Model.DoctorModel;

import java.util.ArrayList;

public class CallDoctorActivity extends AppCompatActivity {

    ListView listdoc;
    ArrayList<DoctorModel> doctorModels = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call_doctor);
        listdoc = findViewById(R.id.dlist);
        doctorModels.add(new DoctorModel("Dr.N.K Gupta","9878426871","Surgeon"));
        doctorModels.add(new DoctorModel("Dr.Anil Malhotra","9815364977","Eye Specialist"));
        doctorModels.add(new DoctorModel("Dr.A.K Singal","9729314183","Skin Specialist"));
        doctorModels.add(new DoctorModel("Dr.Amit Srivastava","9914033108","Child Specialist"));
        DoctorAdapter doctorAdapter = new DoctorAdapter(this,R.layout.custom_doctor_list,doctorModels);
        listdoc.setAdapter(doctorAdapter);
    }
}
