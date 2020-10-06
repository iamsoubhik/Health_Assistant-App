package com.example.blood.Adapter;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;

import com.example.blood.Model.DoctorModel;
import com.example.blood.Model.HospitalStaffModel;
import com.example.blood.R;

import java.util.ArrayList;
import java.util.List;

public class HospitalStaffAdapter extends ArrayAdapter {
    Context mctx;
    int resource;
    List<HospitalStaffModel> hospitalStaffModels;

    public HospitalStaffAdapter( Context mctx, int resource, List<HospitalStaffModel> hospitalStaffModels) {
        super(mctx, resource, hospitalStaffModels);
        this.mctx = mctx;
        this.resource=resource;
        this.hospitalStaffModels = hospitalStaffModels;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = LayoutInflater.from(mctx).inflate(R.layout.custom_hospital_staff,parent,false);
        TextView amname = v.findViewById(R.id.hname);
        TextView amnumber = v.findViewById(R.id.hphone);
        TextView rhname = v.findViewById(R.id.hrname);
        Button btncall = v.findViewById(R.id.btnhcall);


        HospitalStaffModel hospitalStaffModel = hospitalStaffModels.get(position);
        amname.setText(hospitalStaffModel.getHospitalName());
        amnumber.setText(hospitalStaffModel.getHelplinenumber());
        rhname.setText(hospitalStaffModel.getReceptionistName());
        final String number = amnumber.getText().toString();
        final String newnum = "tel:"+number;

        btncall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse(newnum));
                if(ActivityCompat.checkSelfPermission(mctx, Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED){
                    requestPermission();
                }else{
                    mctx.startActivity(intent);
                }
            }
        });
        return v;
    }
    private void requestPermission(){
        ActivityCompat.requestPermissions((Activity) mctx,new String[]{Manifest.permission.CALL_PHONE},1);
    }
}
