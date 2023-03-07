/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import javafx.scene.control.DatePicker;

;import java.time.LocalDate;

public class User {
    private int id ;
    private String nom,prenom,password,mail,cin,tel;
    private LocalDate date;
    private UserType Type;
    private int blocked;

    public int getBlocked() {
        return blocked;
    }

    public void setBlocked(int blocked) {
        this.blocked = blocked;
    }

    public static User currentUser=null;
    public User() {
    }

    public User(int id, String nom, String prenom,LocalDate date,String cin,String tel,  String password, String mail,UserType Type ) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.date=date;
        this.cin=cin;
        this.tel=tel;
        this.password = password;
        this.mail = mail;
        this.Type=Type;
    }

    public UserType getType() {
        return Type;
    }

    public String getCin() {
        return cin;
    }



    public void setCin(String cin) {
        this.cin = cin;
    }

    public void setType(UserType type) {
        Type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMail() {
        return mail;
    }

    public String getTel() {
        return tel;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", password='" + password + '\'' +
                ", mail='" + mail + '\'' +
                ", cin='" + cin + '\'' +
                ", tel='" + tel + '\'' +
                ", date=" + date +
                ", Type=" + Type +
                '}';
    }
}
