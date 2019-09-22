package com.example.backstage.common;

import java.util.Date;
import java.util.Objects;

public class Basic extends PageBean{

    private String delete_flag;
    private String stage;
    private String image;
    private String file;
    private Date create_date;
    private Date last_update_date;

    public String getDelete_flag() {
        return delete_flag;
    }

    public void setDelete_flag(String delete_flag) {
        this.delete_flag = delete_flag;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    public Date getLast_update_date() {
        return last_update_date;
    }

    public void setLast_update_date(Date last_update_date) {
        this.last_update_date = last_update_date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Basic basic = (Basic) o;
        return Objects.equals(delete_flag, basic.delete_flag) &&
                Objects.equals(stage, basic.stage) &&
                Objects.equals(image, basic.image) &&
                Objects.equals(file, basic.file) &&
                Objects.equals(create_date, basic.create_date) &&
                Objects.equals(last_update_date, basic.last_update_date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(delete_flag, stage, image, file, create_date, last_update_date);
    }

    @Override
    public String toString() {
        return "Basic{" +
                "delete_flag='" + delete_flag + '\'' +
                ", stage='" + stage + '\'' +
                ", image='" + image + '\'' +
                ", file='" + file + '\'' +
                ", create_date=" + create_date +
                ", last_update_date=" + last_update_date +
                '}';
    }
}
