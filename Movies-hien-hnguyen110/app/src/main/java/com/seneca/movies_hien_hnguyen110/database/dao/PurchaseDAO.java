package com.seneca.movies_hien_hnguyen110.database.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.seneca.movies_hien_hnguyen110.models.Purchase;

import java.util.List;

@Dao
public interface PurchaseDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void createPurchase(Purchase purchase);

    @Query("SELECT * FROM purchase WHERE id = :id")
    Purchase getPurchase(int id);

    @Query("SELECT * FROM purchase")
    List<Purchase> getPurchases();

    @Update
    void updatePurchase(Purchase purchase);

    @Delete
    void deletePurchase(Purchase purchase);
}
