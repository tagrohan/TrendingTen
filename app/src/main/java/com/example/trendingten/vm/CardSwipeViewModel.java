package com.example.trendingten.vm;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.trendingten.models.CardData;
import com.example.trendingten.util.Utility;

import java.util.ArrayList;
import java.util.List;

public class CardSwipeViewModel extends AndroidViewModel {

    private MutableLiveData<List<CardData>> data;

    public CardSwipeViewModel(@NonNull Application application) {
        super(application);
    }

    public MutableLiveData<List<CardData>> getData() {
        if (data == null) {
            data = new MutableLiveData<>();
        }
        return data;
    }

    public void updateData(int position) {
        if (position == 0) {
            data.setValue(Utility.getFirst());
        } else if (position == 1) {
            data.setValue(Utility.getSecond());
        } else {
            data.setValue(new ArrayList<>());
        }
    }

}
