package com.example.blood;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.blood.Adapter.AmbulanceAdapter;
import com.example.blood.Model.AmbulanceModel;

import java.util.ArrayList;
import java.util.List;

public class CallAmbulanceActivity extends AppCompatActivity {

    ListView alist;
    List<AmbulanceModel> list = new ArrayList<>();
    AmbulanceModel ambulanceModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call_ambulance);
        alist = findViewById(R.id.amlist);
        list.add(new AmbulanceModel("Ravi Kumar","01824444079"));
        list.add(new AmbulanceModel("Shyam Nayak","01824501227"));
        list.add(new AmbulanceModel("Happy Singh","01824501227"));
        list.add(new AmbulanceModel("Babu Tripathi","01824444079"));

        AmbulanceAdapter ambulanceAdapter = new AmbulanceAdapter(this,R.layout.custom_ambulance_list,list);
        alist.setAdapter(ambulanceAdapter);
    }
}
