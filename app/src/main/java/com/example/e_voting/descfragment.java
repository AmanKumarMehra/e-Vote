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
    String aadharNumData, locationData, imageURL2, ageData, phoneNumData, verified;

    public descfragment() {

    }

    public descfragment(String aadharNumData, String locationData, String ageData, String phoneNumData, String verified,String imageURL2) {
        this.aadharNumData=aadharNumData;
        this.locationData=locationData;
        this.ageData=ageData;
        this.phoneNumData=phoneNumData;
        this.verified=verified;
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
        TextView aadhar_num_holder=view.findViewById(R.id.aadhar_num_holder);
        TextView ageholder=view.findViewById(R.id.ageholder);
        TextView locationholder=view.findViewById(R.id.locationholder);
        TextView phone_no_holder = view.findViewById(R.id.phone_no_holder);
        TextView verifiedholder = view.findViewById(R.id.verifiedholder);

        aadhar_num_holder.setText(aadharNumData);
        ageholder.setText(ageData);
        locationholder.setText(locationData);
        phone_no_holder.setText(phoneNumData);
        Glide.with(getContext()).load(imageURL2).into(imageholder);

        if(verified.equals("true")){
            verifiedholder.setText("Verified User");
        }
        else{
            verifiedholder.setText("Not Verified");
        }

        return  view;
    }

    public void onBackPressed()
    {
        AppCompatActivity activity=(AppCompatActivity)getContext();
        activity.getSupportFragmentManager().beginTransaction().replace(R.id.wrapper,new recfragment()).addToBackStack(null).commit();

    }
}