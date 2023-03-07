package Entities;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class Publication {
    private int id;
    private int artiste_id;
    private int likes;
    private String description;
    private String photo;
    private String time;
    private String photoArtiste;


    public Publication() {
    }

    public Publication(int id, int artiste_id, int likes, String description, String photo, String time, String photoArtiste) {
        this.id = id;
        this.artiste_id = artiste_id;
        this.likes = likes;
        this.description = description;
        this.photo = photo;
        this.time = time;
        this.photoArtiste = photoArtiste;
    }

    public Publication(int artiste_id, String description, String photo, String photoArtiste) {
        this.artiste_id = artiste_id;
        this.description = description;
        this.photo = photo;
        this.photoArtiste = photoArtiste;
    }

    public Publication(int artiste_id, String description, String photo) {
        this.artiste_id = artiste_id;
        this.description = description;
        this.photo = photo;
    }

    public Publication(String description, String photo) {
        this.description = description;
        this.photo = photo;
    }

    public String getPhotoArtiste() {
        return photoArtiste;
    }

    public void setPhotoArtiste(String photoArtiste) {
        this.photoArtiste = photoArtiste;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getArtiste_id() {
        return artiste_id;
    }

    public void setArtiste_id(int artiste_id) {
        this.artiste_id = artiste_id;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getSeconds() {
        LocalTime time1 = LocalTime.now();
        int s = time1.getSecond();
        int s1 = Integer.parseInt(time.substring(17, 18));
        return s - s1;
    }

    public int getMinutes() {
        LocalTime time1 = LocalTime.now();
        int s = time1.getMinute();
        int s1 = Integer.parseInt(time.substring(14, 15));
        return s - s1;
    }

    public int getHours() {
        LocalTime time1 = LocalTime.now();
        int s = time1.getHour();
        int s1 = Integer.parseInt(time.substring(11, 12));
        return s - s1;
    }

    public int getDays() {
        LocalDate date1 = LocalDate.now();
        int s = date1.getDayOfMonth();
        int s1 = Integer.parseInt(time.substring(8, 9));
        return s - s1;
    }

    public int getMonths() {
        LocalDate date1 = LocalDate.now();
        int s = date1.getMonthValue();
        int s1 = Integer.parseInt(time.substring(5, 6));
        return s - s1;
    }

    public int getYears() {
        LocalDate date1 = LocalDate.now();
        int s = date1.getYear();
        int s1 = Integer.parseInt(time.substring(0, 3));
        return s - s1;
    }

    @Override
    public String toString() {
        return "Publication{" +
                "id=" + id +
                ", artiste_id=" + artiste_id +
                ", likes=" + likes +
                ", description='" + description + '\'' +
                ", photo='" + photo + '\'' +
                '}';
    }
}
