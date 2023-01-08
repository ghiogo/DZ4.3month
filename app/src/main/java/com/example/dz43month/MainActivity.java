package com.example.dz43month;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    FragmentManager fragmentManager = getSupportFragmentManager();
    fragmentManager.beginTransaction()
            .add(R.id.fragment_container_view, new NamesFragment())
            .commit();

    }
}