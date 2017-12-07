
import controleur.CtrlRepresentation;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modele.dao.Jdbc;
import vue.VueRepresentation;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ydurand
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Jdbc.creer("com.mysql.jdbc.Driver", "jdbc:mysql:", "//localhost/", "festival", "root", "joliverie");
        try {
            Jdbc.getInstance().connecter();
            VueRepresentation uneVue = new VueRepresentation();
            CtrlRepresentation unControleur = new CtrlRepresentation(uneVue);
            // afficher la vue
            uneVue.setVisible(true);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Main - classe JDBC non trouvée");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Main - échec de connexion");
        } 
    }
    
}
