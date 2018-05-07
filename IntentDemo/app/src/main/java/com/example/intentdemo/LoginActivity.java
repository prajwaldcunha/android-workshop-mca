package com.example.intentdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Prajwal on 24-03-2018.
 */

public class LoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_actvity);
        String data=getIntent().getExtras().getString("username");
        TextView textView=findViewById(R.id.textView);
        textView.setText("hello "+data);
        Log.i("tag","text displayed");
    }
}
