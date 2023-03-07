package Entities;

public class Save {
    private int id;
    private int idpost;
    private int iduser;

    public Save() {
    }

    public Save(int idpost, int iduser) {
        this.idpost = idpost;
        this.iduser = iduser;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdpost() {
        return idpost;
    }

    public void setIdpost(int idpost) {
        this.idpost = idpost;
    }

    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    @Override
    public String toString() {
        return "Save{" +
                "id=" + id +
                ", idpost=" + idpost +
                ", iduser=" + iduser +
                '}';
    }
}
