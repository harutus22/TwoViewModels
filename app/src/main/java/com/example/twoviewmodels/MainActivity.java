package com.example.twoviewmodels;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView first, second;
    private MyViewModel firstViewModel, secondViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();

        createViewModel();
    }

    private void createViewModel() {
        firstViewModel = ViewModelProviders.of(this).get(MyViewModel.class);
        firstViewModel.getNumberOne().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                first.setText(String.valueOf(integer));
            }
        });

        secondViewModel = ViewModelProviders.of(this).get(MyViewModel.class);
        secondViewModel.getNumberTwo().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                second.setText(String.valueOf(integer));
            }
        });
    }

    private void findViews() {
        first = findViewById(R.id.firstNumber);
        second = findViewById(R.id.secondNumber);
    }

    public void firstMinus(View view){
        firstViewModel.miusOneFirst();
    }

    public void secondMinus(View view){
        secondViewModel.miusOneSecond();
    }

    public void firstPlus(View view){
        secondViewModel.plusOneFirst();
    }

    public void secondPlus(View view){
        secondViewModel.plusOneSecond();
    }
}
