package com.emilianolowe.mapfavorites;

import android.content.Context;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Place.class}, version = 1, exportSchema = false)
public abstract class MapsDatabase extends RoomDatabase {

    public abstract PlaceDAO placeDAO();

    private static volatile MapsDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static MapsDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (MapsDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            MapsDatabase.class, "maps_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}

