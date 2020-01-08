package com.zky.basics.api.room.bean;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by lk
 * Date 2020-01-08
 * Time 10:38
 * Detail:
 */
@Entity(tableName = "test")
public class TestRoomDb {
    @PrimaryKey
    public int u_id;
    @ColumnInfo(name = "user_name")
    public String name;
    public int age;
    public String sex;
    public String type;


    public int getU_id() {
        return u_id;
    }

    public void setU_id(int u_id) {
        this.u_id = u_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
