package com.example.backstage.pojo;

import com.example.backstage.common.Basic;

import java.util.Objects;

public class User extends Basic {

    private String id;
    private String nick_name;
    private String user_name;
    private String pass_word;
    private String school_id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNick_name() {
        return nick_name;
    }

    public void setNick_name(String nick_name) {
        this.nick_name = nick_name;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPass_word() {
        return pass_word;
    }

    public void setPass_word(String pass_word) {
        this.pass_word = pass_word;
    }

    public String getSchool_id() {
        return school_id;
    }

    public void setSchool_id(String school_id) {
        this.school_id = school_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(nick_name, user.nick_name) &&
                Objects.equals(user_name, user.user_name) &&
                Objects.equals(pass_word, user.pass_word) &&
                Objects.equals(school_id, user.school_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, nick_name, user_name, pass_word, school_id);
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", nick_name='" + nick_name + '\'' +
                ", user_name='" + user_name + '\'' +
                ", pass_word='" + pass_word + '\'' +
                ", school_id='" + school_id + '\'' +
                '}';
    }
}
