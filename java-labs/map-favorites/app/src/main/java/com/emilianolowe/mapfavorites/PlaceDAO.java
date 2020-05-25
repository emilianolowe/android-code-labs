package com.emilianolowe.mapfavorites;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

@Dao
public interface PlaceDAO {

    // allowing the insert of the same word multiple times by passing a
    // conflict resolution strategy
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Place place);

    @Query("DELETE FROM place_table")
    void deleteAll();

    @Query("SELECT * from place_table ORDER BY name ASC")
    LiveData < List<Place>> getPlaces();
}
