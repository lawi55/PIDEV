package Entities;

public class Artiste {
    private int Artiste_ID;
    private String nom;
    private String prenom;
    private String username;
    private String photo;
    private String password;

    public Artiste(String nom, String prenom, String username, String photo, String password) {
        this.nom = nom;
        this.prenom = prenom;
        this.username = username;
        this.photo = photo;
        this.password = password;
    }

    public Artiste() {
    }

    public Artiste(int artiste_ID, String nom, String prenom, String username, String photo, String password) {
        Artiste_ID = artiste_ID;
        this.nom = nom;
        this.prenom = prenom;
        this.username = username;
        this.photo = photo;
        this.password = password;
    }

    public int getArtiste_ID() {
        return Artiste_ID;
    }

    public void setArtiste_ID(int artiste_ID) {
        Artiste_ID = artiste_ID;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Artiste{" +
                "Artiste_ID=" + Artiste_ID +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", username='" + username + '\'' +
                ", photo='" + photo + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
