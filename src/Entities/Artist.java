/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author MSI
 */
public class Artist {
   private int id,artistid;
    private  String nom , prenom,mail,pass;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getArtistid() {
        return artistid;
    }

    public void setArtistid(int artistid) {
        this.artistid = artistid;
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

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Artist() {
    }

    public Artist(int id, int artistid, String nom, String prenom, String mail, String pass) {
        this.id = id;
        this.artistid = artistid;
        this.nom = nom;
        this.prenom = prenom;
        this.mail = mail;
        this.pass = pass;
    }

    @Override
    public String toString() {
        return "Artist{" + "id=" + id + ", artistid=" + artistid + ", nom=" + nom + ", prenom=" + prenom + ", mail=" + mail + ", pass=" + pass + '}';
    }
    
}
