package Entities;

public class Commentaire {
    private int id;
    private int publication_id;
    private String contenu;
    private String photoUser;
    private int id_user;
    private int likes;

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public Commentaire() {
    }

    public Commentaire(int id, int publication_id, String contenu) {
        this.id = id;
        this.publication_id = publication_id;
        this.contenu = contenu;
    }

    public Commentaire(int publication_id, String contenu) {
        this.publication_id = publication_id;
        this.contenu = contenu;
    }

    public String getPhotoUser() {
        return photoUser;
    }

    public void setPhotoUser(String photoUser) {
        this.photoUser = photoUser;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPublication_id() {
        return publication_id;
    }

    public void setPublication_id(int publication_id) {
        this.publication_id = publication_id;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public Commentaire(int publication_id, String contenu, int id_user) {
        this.publication_id = publication_id;
        this.contenu = contenu;
        this.id_user = id_user;
    }
}
