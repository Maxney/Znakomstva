package org.example.entity;

import java.util.Objects;

public class UserPhoto {
    private long idUserPhoto;
    private long idUser;

    private String adress;

    public long getIdUserPhoto() {
        return idUserPhoto;
    }

    public void setIdUserPhoto(long idUserPhoto) {
        this.idUserPhoto = idUserPhoto;
    }

    public long getIdUser() {
        return idUser;
    }

    public void setIdUser(long idUser) {
        this.idUser = idUser;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    @Override
    public String toString() {
        return "UserPhoto{" +
                "idUserPhoto=" + idUserPhoto +
                ", idUser=" + idUser +
                ", adress='" + adress + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserPhoto userPhoto = (UserPhoto) o;
        return idUserPhoto == userPhoto.idUserPhoto && idUser == userPhoto.idUser && adress.equals(userPhoto.adress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUserPhoto, idUser, adress);
    }

}
