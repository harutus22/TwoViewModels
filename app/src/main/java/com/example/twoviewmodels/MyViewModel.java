package com.example.twoviewmodels;

import android.view.View;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.Random;

public class MyViewModel extends ViewModel {
    private MutableLiveData<Integer> number;
    private MutableLiveData<Integer> numberTwo;

    MutableLiveData<Integer> getNumberOne(){
        if(number == null){
            number = new MutableLiveData<>();
            number.setValue(generateNumber());
        }
        return number;
    }

    MutableLiveData<Integer> getNumberTwo(){
        if(numberTwo == null){
            numberTwo = new MutableLiveData<>();
            numberTwo.setValue(generateNumber());
        }
        return numberTwo;
    }

    private int generateNumber(){
        return new Random().nextInt(100) + 1;
    }

    public void plusOneFirst(){
        if(number.getValue() != null) {
            number.setValue(number.getValue() + 1);
        }
    }

    public void miusOneFirst(){
        if(number.getValue() != null) {
            number.setValue(number.getValue() - 1);
        }
    }

    public void plusOneSecond(){
        if(numberTwo.getValue() != null) {
            numberTwo.setValue(numberTwo.getValue() + 1);
        }
    }

    public void miusOneSecond(){
        if(numberTwo.getValue() != null) {
            numberTwo.setValue(numberTwo.getValue() - 1);
        }
    }


}
