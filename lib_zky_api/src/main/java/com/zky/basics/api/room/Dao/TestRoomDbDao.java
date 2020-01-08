package com.zky.basics.api.room.Dao;

import android.arch.persistence.room.*;
import com.zky.basics.api.room.bean.TestRoomDb;

import java.util.List;

/**
 * Created by lk
 * Date 2020-01-08
 * Time 10:39
 * Detail:
 */
@Dao
public interface TestRoomDbDao {

    @Query("SELECT * FROM test")
    List<TestRoomDb> getAll();

    @Query("SELECT * FROM test WHERE u_id IN (:userIds)")
    List<TestRoomDb> loadAllByIds(int[] userIds);

    @Query("SELECT * FROM test WHERE u_id = (:userIds)")
    List<TestRoomDb> loadAllByKey(int userIds);


    @Query("SELECT * FROM test WHERE user_name LIKE :first AND " +
            "user_name LIKE :last LIMIT 1")
    TestRoomDb findByName(String first, String last);

    @Insert
    void insertAll(TestRoomDb... users);

    @Delete
    void delete(TestRoomDb user);

    @Update()
    int updateUsers(TestRoomDb... users);

    @Query("select * from test")
    List<TestRoomDb> getUsers();

}
