package com.zky.basics.api.room.bean;

/**
 * Created by lk
 * Date 2019-11-18
 * Time 09:42
 * Detail:
 */

public class UserTest {

    private Long id;
    private String name;
    private int age;


    public UserTest(Long id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }


    public UserTest() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
