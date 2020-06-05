package com.yxjme.flycoroundview.sqllite;


import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class UserBean {

    /*设置自增的id*/
    @Id(autoincrement = true)
    private long id;

    private String Name;

    private int age ;

    private String info ;

    @Generated(hash = 43415617)
    public UserBean(long id, String Name, int age, String info) {
        this.id = id;
        this.Name = Name;
        this.age = age;
        this.info = info;
    }

    @Generated(hash = 1203313951)
    public UserBean() {
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return this.Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getInfo() {
        return this.info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
