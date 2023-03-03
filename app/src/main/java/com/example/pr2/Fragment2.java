package com.example.pr2;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;

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
import android.widget.Toast;

import java.util.HashMap;
import java.util.Random;

public class Fragment2 extends Fragment {


    public Fragment2() {
        super(R.layout.fragment2);
    }

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        getChildFragmentManager()
                .setFragmentResultListener("requestKey", this, new FragmentResultListener() {
                            @Override
                            public void onFragmentResult(@NonNull String
                                                                 requestKey, @NonNull Bundle bundle) {
                                String result = bundle.getString("bundleKey");
                            }
                        });
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

        getParentFragmentManager().setFragmentResultListener("requestKey", this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle bundle) {
                String result = bundle.getString("bundleKey");
            }});

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
            }
        });
    }

}

