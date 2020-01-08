package com.zky.basics.api.room;


import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.migration.Migration;
import android.content.Context;
import android.os.Environment;
import com.zky.basics.api.room.Dao.TestRoomDbDao;
import com.zky.basics.api.room.bean.TestRoomDb;

import java.io.File;

/**
 * Created by lk
 * Date 2019-12-25
 * Time 15:45
 * Detail:
 */
@Database(entities = {TestRoomDb.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase INSTANCE;//创建单例

    public abstract TestRoomDbDao testRoomDbDao();

   public static AppDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                 String path= Environment.getExternalStorageDirectory()+ File.separator+"test"+File.separator+"db"+File.separator+"test.db";
                    INSTANCE = Room.databaseBuilder(
                            context,
                            AppDatabase.class, path)
                            .addCallback(sOnOpenCallback)
                            .addMigrations(MIGRATION_1_2)
                            .allowMainThreadQueries()
                            .build();
                }
            }
        }
        return INSTANCE;
    }


    static final Migration MIGRATION_1_2 = new Migration(1, 2) {
        @Override
        public void migrate(SupportSQLiteDatabase database) {

        }
    };

    private static RoomDatabase.Callback sOnOpenCallback =
            new RoomDatabase.Callback() {
                @Override
                public void onOpen(SupportSQLiteDatabase db) {
                    super.onOpen(db);
                }
            };


}
