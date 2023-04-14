package org.example.entity;

import java.util.Objects;

public class LikeUser {

    private Long idLikeUser;
    private Long idUser;
    private Long idLikePhoto;

    public LikeUser(Long idLikeUser, Long idUser, Long idLikePhoto) {
        this.idLikeUser = idLikeUser;
        this.idUser = idUser;
        this.idLikePhoto = idLikePhoto;
    }

    public Long getIdLikeUser() {
        return idLikeUser.longValue();
    }

    public void setIdLikeUser(Long idLikeUser) {
        this.idLikeUser = idLikeUser;
    }

    public Long getIdUser() {
        return idUser.longValue();
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public Long getIdLikePhoto() {
        return idLikePhoto.longValue();
    }

    public void setIdLikePhoto(Long idLikePhoto) {
        this.idLikePhoto = idLikePhoto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LikeUser likeUser = (LikeUser) o;
        return idUser.equals(likeUser.idUser) &&
                idLikePhoto.equals(likeUser.idLikePhoto);
    }

    @Override
    public String toString() {
        return "LikeUser{" +
                ", idUser=" + idUser +
                ", idLikePhoto=" + idLikePhoto +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(idLikeUser, idUser, idLikePhoto);
    }

}
