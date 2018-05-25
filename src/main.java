
import config.Reader;
import controleur.CtrlPrincipal;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modele.dao.Jdbc;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Classe Main - S'exécute au lancement de l'appli - Contient les connexions à
 * la DB -
 *
 * @author ydurand v1.0
 */
public class main {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws SQLException {

        

        // get the property value and print it out
        InputStream input = main.class.getResourceAsStream("config/accessDB.properties");
        String driver = Reader.readString("sgbd.driver");
        String jdbc = Reader.readString("sgbd.jdbc");
        String pass = Reader.readString("sgbd.pass");
        String databasename = Reader.readString("sgbd.databasename");
        String login = Reader.readString("sgbd.login");
        String password = Reader.readString("sgbd.password");
        Jdbc.creer(driver, jdbc, pass, databasename, login, password); 
        if (input != null) {
            try {
                input.close();
            } catch (final IOException e) {
                e.printStackTrace();
            }
        }

        CtrlPrincipal ctrlPrincipal;

        try {
            Jdbc.getInstance().connecter();
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Main - connexion à la BDD - pilote JDBC non trouvé", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Main - connexion à la BDD", JOptionPane.ERROR_MESSAGE);
        }

        // Pour lancer l'application, instancier le contrôleur principal
        ctrlPrincipal = new CtrlPrincipal();
        ctrlPrincipal.action();

    }
}
