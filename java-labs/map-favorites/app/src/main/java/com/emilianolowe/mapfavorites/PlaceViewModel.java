package com.emilianolowe.mapfavorites;

import android.app.Application;

import java.util.List;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class PlaceViewModel extends AndroidViewModel {

    private PlaceRepository mRepository;

    private LiveData<List<Place>> allPlaces;

    public PlaceViewModel (Application application) {
        super(application);
        mRepository = new PlaceRepository(application);
        allPlaces = mRepository.getAllPlaces();
    }

    LiveData<List<Place>> getAllPlaces() { return allPlaces; }

    public void insert(Place place) { mRepository.insert(place); }
}
