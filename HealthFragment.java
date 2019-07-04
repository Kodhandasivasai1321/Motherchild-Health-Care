package com.example.lenovo.myhealth;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class HealthFragment extends Fragment {


    public HealthFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_health, container, false);
        Button button=v.findViewById(R.id.month_one);
        Button b2=v.findViewById(R.id.month_two);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                swapFragment();
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                swappyFragment();

            }
        });
        return v;



    }
    private void swapFragment(){

        MonthOne monthfrag=new MonthOne();
        FragmentTransaction fragmentTransaction=getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.content_frame,monthfrag);
        fragmentTransaction.commit();


    }

    private void swappyFragment(){

        MonthTwo monthTwo=new MonthTwo();
        FragmentTransaction fragmentTransaction=getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.content_frame,monthTwo);
        fragmentTransaction.commit();
    }

}
