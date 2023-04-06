package org.example.entity;

import java.util.Objects;

public class LikeUser {

    private long idLikeUser;
    private long idUser;
    private long idLikePhoto;

    public long getIdLikeUser() {
        return idLikeUser;
    }

    public void setIdLikeUser(long idLikeUser) {
        this.idLikeUser = idLikeUser;
    }

    public long getIdUser() {
        return idUser;
    }

    public void setIdUser(long idUser) {
        this.idUser = idUser;
    }

    public long getIdLikePhoto() {
        return idLikePhoto;
    }

    public void setIdLikePhoto(long idLikePhoto) {
        this.idLikePhoto = idLikePhoto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LikeUser likeUser = (LikeUser) o;
        return idLikeUser == likeUser.idLikeUser && idUser == likeUser.idUser && idLikePhoto == likeUser.idLikePhoto;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idLikeUser, idUser, idLikePhoto);
    }

}
