package org.example.entity;

import java.util.Objects;

public class UserPhoto {
    private Long idUserPhoto;
    private Long idUser;

    private String adress;

    public UserPhoto(Long idUserPhoto, Long idUser, String adress) {
        this.idUserPhoto = idUserPhoto;
        this.idUser = idUser;
        this.adress = adress;
    }

    public Long getIdUserPhoto() {
        return idUserPhoto.longValue();
    }

    public void setIdUserPhoto(long idUserPhoto) {
        this.idUserPhoto = idUserPhoto;
    }

    public Long getIdUser() {
        return idUser.longValue();
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
                ", idUser=" + idUser +
                ", adress='" + adress + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserPhoto userPhoto = (UserPhoto) o;
        return Objects.equals(idUser, userPhoto.idUser) && Objects.equals(adress, userPhoto.adress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUserPhoto, idUser, adress);
    }

}
