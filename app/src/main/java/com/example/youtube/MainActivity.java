package com.example.youtube;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity);
        Button btnjava=(Button)findViewById(R.id.button1);
        btnjava.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        Intent intent= null;

        switch (v .getId()){

            case R.id.button1 :

                intent =new Intent(this,StandaloneActivity.class);


        }


    }
}
