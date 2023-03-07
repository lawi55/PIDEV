package Services;

import Entities.Publication;
import Utils.MyDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PublicationService implements IService<Publication> {

    Connection cnx;

    public PublicationService() {
        cnx = MyDB.getInstance().getCnx();
    }

    @Override
    public void ajouter(Publication publication) throws SQLException {
        String req = "INSERT INTO publication(Artiste_ID,photoArtiste,Description,photo) VALUES("
                + "'" + publication.getArtiste_id() + "','" + publication.getPhotoArtiste() + "','" + publication.getDescription() + "','" + publication.getPhoto() + "')";
        Statement st = cnx.createStatement();
        st.executeUpdate(req);
    }

    @Override
    public void modifier(Publication publication) throws SQLException {
        String req = "UPDATE publication SET description = ?, photo = ? where id_pub = ?";
        PreparedStatement ps = cnx.prepareStatement(req);
        ps.setString(1, publication.getDescription());
        ps.setString(2, publication.getPhoto());
        ps.setInt(3, publication.getId());
        ps.executeUpdate();

    }


    @Override
    public void supprimer(Publication publication) throws SQLException {
        String req = "DELETE FROM publication where ID_pub = ?";
        PreparedStatement ps = cnx.prepareStatement(req);
        ps.setInt(1, publication.getId());
        ps.executeUpdate();
    }

    @Override
    public List<Publication> recuperer() throws SQLException {
        List<Publication> publications = new ArrayList<>();
        String s = "select * from publication";
        Statement st = cnx.createStatement();
        ResultSet rs = st.executeQuery(s);
        while (rs.next()) {
            Publication p = new Publication();
            p.setId(rs.getInt("id_pub"));
            p.setArtiste_id(rs.getInt("Artiste_ID"));
            p.setDescription(rs.getString("description"));
            p.setPhoto(rs.getString("photo"));
            p.setLikes(rs.getInt("Likes"));
            p.setPhotoArtiste(rs.getString("photoArtiste"));
            publications.add(p);
        }
        return publications;
    }

    public String recupererphoto(int id) throws SQLException{
        String req = "select photo from publication where ID_pub="+id;
        Statement st = cnx.createStatement();
        ResultSet rs = st.executeQuery(req);
        rs.next();
        String i= rs.getString("photo");
        return i;
    }
    public String recupererfollowers(int id) throws SQLException{
        String req = "select followers from publication where ID="+id;
        Statement st = cnx.createStatement();
        ResultSet rs = st.executeQuery(req);
        rs.next();
        String i= rs.getString("followers");
        return i;
    }

    public List<Publication> recupererParId(int id) throws SQLException {
        List<Entities.Publication> publications = new ArrayList<>();
        String req = "select * from publication where Artiste_ID = ?";
        PreparedStatement ps = cnx.prepareStatement(req);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Entities.Publication p = new Entities.Publication();
            p.setId(rs.getInt("id_pub"));
            p.setArtiste_id(rs.getInt("Artiste_ID"));
            p.setDescription(rs.getString("description"));
            p.setPhoto(rs.getString("photo"));
            p.setLikes(rs.getInt("Likes"));
            p.setPhotoArtiste(rs.getString("photoArtiste"));
            publications.add(p);
        }
        return publications;
    }

    public void addLike(Publication publication) throws SQLException {
        String req = "UPDATE publication SET Likes=Likes+1 where ID_pub =?";
        PreparedStatement ps = cnx.prepareStatement(req);
        ps.setInt(1, publication.getId());
        ps.executeUpdate();
    }

    public void removeLike(Publication publication) throws SQLException {
        String req = "UPDATE publication SET Likes=Likes-1 where ID_pub =?";
        PreparedStatement ps = cnx.prepareStatement(req);
        ps.setInt(1, publication.getId());
        ps.executeUpdate();
    }

    public void artistePic(Publication publication) throws SQLException {
        String req = "SELECT from artiste photo where Artiste_ID = ?";
        PreparedStatement ps = cnx.prepareStatement(req);
        ps.setInt(1, publication.getArtiste_id());
        ps.executeUpdate();
    }

}
