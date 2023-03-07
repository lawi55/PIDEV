package Services;

import Entities.Publication;
import Entities.Save;
import Utils.MyDB;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class ServiceSaves implements IService<Save> {
    Connection cnx;

    public ServiceSaves() {
        cnx = MyDB.getInstance().getCnx();
    }

    @Override
    public void ajouter(Save save) throws SQLException {
        String req = "INSERT INTO saves(id_user,id_post) VALUES("
                + "'" + save.getIduser() + "','" + save.getIdpost() + "')";
        Statement st = cnx.createStatement();
        st.executeUpdate(req);
    }

    @Override
    public void modifier(Save save) throws SQLException {

    }

    @Override
    public void supprimer(Save save) throws SQLException {

    }

    @Override
    public List<Save> recuperer() throws SQLException {
        return null;
    }
}
