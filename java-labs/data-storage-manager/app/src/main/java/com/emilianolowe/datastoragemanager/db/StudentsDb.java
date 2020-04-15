package com.emilianolowe.datastoragemanager.db;

import com.emilianolowe.datastoragemanager.data.StudentDao;
import com.emilianolowe.datastoragemanager.data.StudentEntity;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {StudentEntity.class}, version = 1, exportSchema = false)
public abstract class StudentsDb extends RoomDatabase {

    public abstract StudentDao getStudentDao();


}
