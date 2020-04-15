package com.emilianolowe.datastoragemanager.data;


import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface StudentDao {

    @Insert
    void insertStudent(StudentEntity student);

    @Query("SELECT * FROM bts_students")
    List <StudentEntity> readAll();
}
