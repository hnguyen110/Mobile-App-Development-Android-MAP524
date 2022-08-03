package com.seneca.movies_hien_hnguyen110.database;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.seneca.movies_hien_hnguyen110.database.dao.PurchaseDAO;
import com.seneca.movies_hien_hnguyen110.models.Purchase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@androidx.room.Database(entities = {Purchase.class}, version = 1, exportSchema = false)
public abstract class Database extends RoomDatabase {
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);
    private static volatile Database INSTANCE;

    public static Database getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (Database.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    Database.class, "database")
                            .allowMainThreadQueries()
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    public abstract PurchaseDAO purchaseDAO();
}
