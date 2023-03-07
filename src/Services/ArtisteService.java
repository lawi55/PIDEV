package Services;

import Entities.Artiste;
import Entities.Commentaire;
import Entities.Publication;
import Utils.MyDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ArtisteService implements IService<Artiste> {

    Connection cnx;
    public ArtisteService() {
        cnx = MyDB.getInstance().getCnx();
    }


    @Override
    public void ajouter(Artiste artiste) throws SQLException {

    }

    @Override
    public void modifier(Artiste artiste) throws SQLException {

    }

    @Override
    public void supprimer(Artiste artiste) throws SQLException {

    }

    public int recupurerId(String string) throws SQLException {
        String s = "select Artiste_ID from artiste where nom like " + "'" + string + "'";
        Statement st = cnx.createStatement();
        ResultSet rs = st.executeQuery(s);
        int s1 = 0;
        while (rs.next()) {
            s1 = rs.getInt("Artiste_ID");
        }
        return s1;
    }

    public List<Artiste> recuperer() throws SQLException {
        List<Artiste> strings = new ArrayList<>();
        String s = "select * from artiste";
        Statement st = cnx.createStatement();
        ResultSet rs = st.executeQuery(s);
        while (rs.next()) {
            Artiste artiste = new Artiste();
            artiste.setArtiste_ID(rs.getInt("Artiste_ID"));
            artiste.setNom(rs.getString("nom"));
            strings.add(artiste);
        }
        return strings;
    }
    public List<String> search(String string) throws SQLException {
        List<String> strings = new ArrayList<>();
        String s = "select nom from artiste where nom like " + "'" + string +"%'";
        Statement st = cnx.createStatement();
        ResultSet rs = st.executeQuery(s);
        while (rs.next()) {
            String s1 = rs.getString("nom");
            strings.add(s1);
        }
        return strings;
    }

}

