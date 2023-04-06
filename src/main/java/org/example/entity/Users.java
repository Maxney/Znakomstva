package org.example.entity;

import java.util.List;
import java.util.Objects;

public class Users {
    private long id;
    private String login;
    private String password;
    private String alias;
    private int age;
    private String discription;
    private List<String> searchInterests;

    public Users(long id,String login,String password,String alias,
                 int age,String discription,List<String> searchInterests) {
        this.id=id;
        this.login=login;
        this.password=password;
        this.alias=alias;
        this.age=age;
        this.discription=discription;
        this.searchInterests=searchInterests;
    }
    public Users(){

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<String> getSearchInterests() {
        return searchInterests;
    }

    public void setSearchInterests(List<String> searchInterests) {
        this.searchInterests = searchInterests;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users = (Users) o;
        return id == users.id && age == users.age && login.equals(users.login)
                && password.equals(users.password) && alias.equals(users.alias)
                && discription.equals(users.discription)
                && searchInterests.equals(users.searchInterests);
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", alias='" + alias + '\'' +
                ", age=" + age +
                ", discription='" + discription + '\'' +
                ", searchInterests=" + searchInterests +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, password, alias, age, discription, searchInterests);
    }
}
