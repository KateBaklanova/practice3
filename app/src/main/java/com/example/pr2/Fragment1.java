package com.example.pr2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.app.Activity;
import android.app.LauncherActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class Fragment1 extends Fragment {
    private static final String TAG = "MyApp";

    public Fragment1() {
        super(R.layout.fragment1);
    }

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        Toast toast = Toast.makeText(getActivity().getApplicationContext(),
                "Тост 1", Toast.LENGTH_SHORT);
        toast.show();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        // super.onCreateView(inflater, container, savedInstanceState);
        Toast toast = Toast.makeText(getActivity().getApplicationContext(),
                "Тост 2", Toast.LENGTH_SHORT);
        toast.show();
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    public void onViewStateRestored (Bundle savedInstanceState){
        super.onViewStateRestored(savedInstanceState);
        Toast toast = Toast.makeText(getActivity().getApplicationContext(),
                "Тост 3", Toast.LENGTH_SHORT);
        toast.show();
    }

    public void onStart(){
        super.onStart();
        Toast toast = Toast.makeText(getActivity().getApplicationContext(),
                "Тост 4", Toast.LENGTH_SHORT);
    }

    public void onResume(){

        super.onResume();
        Toast toast = Toast.makeText(getActivity().getApplicationContext(),
                "Тост 5", Toast.LENGTH_SHORT);

        Button button = (Button) getView().findViewById(R.id.button);
        button.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                System.out.println("kdm");
                Log.i(TAG, "Вы нажали на кнопку, программно");
            }
        });

    }

    public void onPause (){
        super.onPause();
        Toast toast = Toast.makeText(getActivity().getApplicationContext(),
                "Тост 6", Toast.LENGTH_SHORT);
    }

    public void onStop (){
        super.onStop();
        Toast toast = Toast.makeText(getActivity().getApplicationContext(),
                "Тост 7", Toast.LENGTH_SHORT);
    }

    public void Messages(View view){
        Log.i(TAG, "Вы нажали на кнопку, декларативно");
    }

    public void Play(View view){

    }



}


