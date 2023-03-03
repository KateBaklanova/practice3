package com.example.pr2;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Random;

public class MainActivity2 extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment2, container, false);
    }

    @Override
    public void onResume(){
        super.onResume();
        HashMap<Integer, String> c = new HashMap<>();

        c.put(0, "Яблоко");
        c.put(1, "Банан");
        c.put(2, "Ананас");

        HashMap<Integer, String> a = new HashMap<>();

        a.put(0, "Apple");
        a.put(1, "Banana");
        a.put(2, "Pineapple");

        Random random = new Random();
        Integer b= random.nextInt(3 - 1) + 1;

        TextView text = getView().findViewById(R.id.t2);
        text.setText(c.get(b));

        EditText myTextBox = (EditText) getView().findViewById(R.id.t1);
        myTextBox.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            public Integer m(HashMap<Integer, String> c, String s){
                for (HashMap.Entry entry : c.entrySet()) {
                    Integer k = (Integer)entry.getKey();
                    String v = (String)entry.getValue();
                    if (s==v) {
                        return k;
                    }
                }
                return 0;
            }

            public void afterTextChanged(Editable s) {
                if (m(a,c.get(b)) ==b)
                {
                    text.setText("ВЕРНО");
                }
                else{
                    text.setText("НЕВЕРНО");
                }
                ActivityResultLauncher<Intent> mStartForResult = registerForActivityResult(
                        new ActivityResultContracts.StartActivityForResult(),
                        new ActivityResultCallback<ActivityResult>() {
                            @Override
                            public void onActivityResult(ActivityResult result) {
                                // обработка result
                            }
                        });
            }
        });
    }



}