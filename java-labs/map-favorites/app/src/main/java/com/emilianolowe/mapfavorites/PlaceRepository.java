package com.emilianolowe.mapfavorites;

import android.app.Application;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Database;

public class PlaceRepository {

    private PlaceDAO placeDAO;
    private LiveData<List<Place>> allPlaces;

    // Note that in order to unit test the WordRepository, you have to remove the Application
    // dependency. This adds complexity and much more code, and this sample is not about testing.
    // See the BasicSample in the android-architecture-components repository at
    // https://github.com/googlesamples
    PlaceRepository(Application application) {
        MapsDatabase db = MapsDatabase.getDatabase(application);
        placeDAO = db.placeDAO();
        allPlaces = placeDAO.getPlaces();
    }

    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
    LiveData<List<Place>> getAllPlaces() {
        return allPlaces;
    }

    // You must call this on a non-UI thread or your app will throw an exception. Room ensures
    // that you're not doing any long running operations on the main thread, blocking the UI.
    void insert(final Place place) {
        MapsDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                placeDAO.insert(place);
            }
        });
    }
}
