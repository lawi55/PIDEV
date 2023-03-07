package Services;

import Entities.Commentaire;
import Entities.Publication;
import Utils.MyDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CommentaireService implements IService<Commentaire> {

    Connection cnx;

    public CommentaireService() {
        cnx = MyDB.getInstance().getCnx();
    }


    @Override
    public void ajouter(Commentaire commentaire) throws SQLException {
        String req = "INSERT INTO commentaire(publication_id,contenu,id_user,photoUser) VALUES("
                + "'" + commentaire.getPublication_id() + "','" + commentaire.getContenu() + "','" + commentaire.getId_user() + "','" + commentaire.getPhotoUser() + "')";
        Statement st = cnx.createStatement();
        st.executeUpdate(req);
    }

    @Override
    public void modifier(Commentaire commentaire) throws SQLException {
        String req = "UPDATE publication SET contenu = ? where id_comment = ?";
        PreparedStatement ps = cnx.prepareStatement(req);
        ps.setString(1, commentaire.getContenu());
        ps.setInt(2, commentaire.getId());
        ps.executeUpdate();

    }

    @Override
    public void supprimer(Commentaire commentaire) throws SQLException {
        String req = "DELETE FROM commentaire where id_comment = ?";
        PreparedStatement ps = cnx.prepareStatement(req);
        ps.setInt(1, commentaire.getId());
        ps.executeUpdate();
    }


    @Override
    public List<Commentaire> recuperer() throws SQLException {
        List<Commentaire> commentaires = new ArrayList<>();
        String s = "select * from commentaire ";
        Statement st = cnx.createStatement();
        ResultSet rs = st.executeQuery(s);
        while (rs.next()) {
            Commentaire p = new Commentaire();
            p.setPublication_id(rs.getInt("publication_id"));
            p.setId(rs.getInt("id_comment"));
            p.setContenu(rs.getString("contenu"));
            p.setPhotoUser(rs.getString("photoUser"));
            commentaires.add(p);
        }
        return commentaires;
    }


    public List<Commentaire> recupererparId(int id) throws SQLException {
        List<Commentaire> commentaires = new ArrayList<>();
        String req = "select * from commentaire where publication_id = ?";
        PreparedStatement ps = cnx.prepareStatement(req);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Commentaire p = new Commentaire();
            p.setPublication_id(rs.getInt("publication_id"));
            p.setId(rs.getInt("id_comment"));
            p.setContenu(rs.getString("contenu"));
            p.setPhotoUser(rs.getString("photoUser"));
            commentaires.add(p);
        }
        return commentaires;
    }

    public int counting(int pid) throws SQLException {
        int i;
        String req = "select count(*) from commentaire where publication_id="+pid;
        Statement st = cnx.createStatement();
        ResultSet rs = st.executeQuery(req);
        rs.next();
        i= rs.getInt(1);
        return i;
    }

    public void addLike(Commentaire commentaire) throws SQLException {
        String req = "UPDATE commentaire SET likes=likes+1 where id_comment =?";
        PreparedStatement ps = cnx.prepareStatement(req);
        ps.setInt(1, commentaire.getId());
        ps.executeUpdate();
    }

    public void removeLike(Commentaire commentaire) throws SQLException {
        String req = "UPDATE commentaire SET likes=likes-1 where id_comment =?";
        PreparedStatement ps = cnx.prepareStatement(req);
        ps.setInt(1, commentaire.getId());
        ps.executeUpdate();
    }
}
