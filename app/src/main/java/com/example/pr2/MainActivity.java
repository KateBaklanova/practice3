package com.example.pr2;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MyApp";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast toast = Toast.makeText(getApplicationContext(), "Текст", Toast.LENGTH_SHORT);
        toast.show();
    }
    @Override
    protected void onResume(){
        setContentView(R.layout.activity_main);

        Toast toast = Toast.makeText(getApplicationContext(), "Текст", Toast.LENGTH_SHORT);
        toast.show();
        super.onResume();
        Log.d(TAG, "отладка");
        Log.i(TAG, "информация");
        Log.v(TAG, "подробности");
        Log.e(TAG, "ошибка");
        Log.w(TAG, "предупреждение");
    }
}

