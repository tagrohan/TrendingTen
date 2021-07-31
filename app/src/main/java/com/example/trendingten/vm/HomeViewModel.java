package com.example.trendingten.vm;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.trendingten.models.Thumbnail;
import com.example.trendingten.service.ApiCalls;

import java.util.List;

public class HomeViewModel extends AndroidViewModel implements ApiCalls.HomeCallBack {

    private MutableLiveData<List<Thumbnail>> thumbnail;

    public HomeViewModel(@NonNull Application application) {
        super(application);
    }

    public MutableLiveData<List<Thumbnail>> getThumbnail() {
        if (thumbnail == null) {
            thumbnail = new MutableLiveData<>();
        }
        return thumbnail;
    }

    public void invokeHomeApi() {
        new ApiCalls(this).getContent();
    }

    @Override
    public void dataAvailable(List<Thumbnail> thumbnails) {
        if (!thumbnails.isEmpty()) {
            thumbnail.setValue(thumbnails);
        }
    }
}
