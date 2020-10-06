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

import com.example.blood.Model.AmbulanceModel;
import com.example.blood.R;

import java.util.List;

public class AmbulanceAdapter extends ArrayAdapter {
    Context mtcx;
    int resource;
    List<AmbulanceModel> ambulanceModels;

    public AmbulanceAdapter(Context mtcx, int resource,List<AmbulanceModel> ambulanceModels) {
        super(mtcx, resource, ambulanceModels);
        this.resource = resource;
        this.mtcx =mtcx;
        this.ambulanceModels = ambulanceModels;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = LayoutInflater.from(mtcx).inflate(R.layout.custom_ambulance_list,parent,false);
        TextView amname = v.findViewById(R.id.amname);
        TextView amnumber = v.findViewById(R.id.amnumber);
        Button btncall = v.findViewById(R.id.btnacall);


        AmbulanceModel ambulanceModel = ambulanceModels.get(position);
        amname.setText(ambulanceModel.getName());
        amnumber.setText(ambulanceModel.getNumber());
        final String number = amnumber.getText().toString().trim();
        final String newnum = "tel:"+number;

        btncall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse(newnum));
                if(ActivityCompat.checkSelfPermission(mtcx,Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED){
                    requestPermission();
                }else{
                    mtcx.startActivity(intent);
                }
            }
        });
        return v;
    }
    private void requestPermission(){
        ActivityCompat.requestPermissions((Activity) mtcx,new String[]{Manifest.permission.CALL_PHONE},1);
    }
}
