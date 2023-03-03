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

public class MainActivity extends Fragment {
    private static final String TAG = "MyApp";

    public MainActivity() {
        super(R.layout.fragment1);
    }



    public void onResume(){

        super.onResume();
        Log.d(TAG, "отладка");
        Log.i(TAG, "информация");
        Log.v(TAG, "подробности");
        Log.e(TAG, "ошибка");
        Log.w(TAG, "предупреждение");

        Button button = (Button) getView().findViewById(R.id.button);
        button.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                System.out.println("kdm");
                Log.i(TAG, "Вы нажали на кнопку, программно");
            }
        });

    }

    public void Messages(View view){
        Log.i(TAG, "Вы нажали на кнопку, декларативно");
    }

    public void Play(View view){

    }



}


