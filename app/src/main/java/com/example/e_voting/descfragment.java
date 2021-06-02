package com.example.e_voting;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;


public class descfragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;
    String aadharNumData, locationData, imageURL2, ageData, phoneNumData;

    public descfragment() {

    }

    public descfragment(String aadharNumData, String locationData, String ageData, String phoneNumData, String imageURL2) {
        this.aadharNumData=aadharNumData;
        this.locationData=locationData;
        this.ageData=ageData;
        this.phoneNumData=phoneNumData;
        this.imageURL2=imageURL2;
    }

    public static descfragment newInstance(String param1, String param2) {
        descfragment fragment = new descfragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_descfragment, container, false);

        ImageView imageholder=view.findViewById(R.id.imageholder);
        TextView aadhar_num=view.findViewById(R.id.aadhar_num);
        TextView age=view.findViewById(R.id.age);
        TextView location=view.findViewById(R.id.location);
        TextView phone = view.findViewById(R.id.phone_no);

        aadhar_num.setText(aadharNumData);
        age.setText(ageData);
        location.setText(locationData);
        phone.setText(phoneNumData);
        Glide.with(getContext()).load(imageURL2).into(imageholder);


        return  view;
    }

    public void onBackPressed()
    {
        AppCompatActivity activity=(AppCompatActivity)getContext();
        activity.getSupportFragmentManager().beginTransaction().replace(R.id.wrapper,new recfragment()).addToBackStack(null).commit();

    }
}