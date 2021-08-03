package com.example.trendingten.vm;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.trendingten.models.Card;
import com.example.trendingten.service.ApiCalls;

import java.util.Collections;
import java.util.List;

public class ShortViewModel extends AndroidViewModel implements ApiCalls.ShortCallBack {
    private MutableLiveData<List<Card>> cards;

    public ShortViewModel(@NonNull Application application) {
        super(application);
    }

    public MutableLiveData<List<Card>> getCards() {
        if (cards == null) {
            cards = new MutableLiveData<>();
        }
        return cards;
    }

    public void invokeShortApi() {
        new ApiCalls(this).getCards();
    }


    @Override
    public void dataAvailable(List<Card> cardsData, int code) {
//        Collections.shuffle(cardsData);
        cards.setValue(cardsData);
    }
}
