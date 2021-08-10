package edu.co.icesi.semana1ecoa;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    String alfa = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        miFuncion(this);
    }

    public void miFuncion( AppCompatActivity param1 ){

    }

}