package controleur;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modele.dao.RepresentationDao;
import modele.metier.Representation;
import vue.VueRepresentation;

/**
 * Contrôleur permettant l'affichage et la sélection des représentation dans la
 * vueRepresentation
 *
 * @author ydurand v1.0
 */
public class CtrlRepresentation extends ControleurGenerique implements WindowListener, MouseListener {

    private final RepresentationDao RepresentationDao = new RepresentationDao();
    private List<Representation> arrObjRepresentations;

    public CtrlRepresentation(CtrlPrincipal ctrlPrincipal) throws SQLException {
        super(ctrlPrincipal);
        vue = new VueRepresentation();
        afficherRepresentation();
        vue.addWindowListener(this);
    }
    
    /*
    * Methode pour quitter l'application
    */
    public void menuFichierQuitter() throws SQLException {
        this.getCtrlPrincipal().action(EnumAction.MENU_QUITTER);
    }    
    
    /*
    * Methode pour quitter la vue des représentation    
    */
    public void representationQuitter() throws SQLException {
        this.getCtrlPrincipal().action(EnumAction.REPRESENTATION_QUITTER);
    }

    //méthode pour afficher la liste des représentation via la methode sel
    public void afficherRepresentation() throws SQLException {
        String msg = ""; // message à afficher en cas d'erreur
        ((VueRepresentation) vue).getModeleTableRepresentation().setRowCount(0);
        String[] titresColonnes = {"Groupe", "Lieu", "Date", "Heure Debut", "Heure Fin"};
        ((VueRepresentation) vue).getModeleTableRepresentation().setColumnIdentifiers(titresColonnes);
        try {
            String[] ligneDonnees = new String[5];
            arrObjRepresentations = RepresentationDao.getAll();
            for (Representation uneRepresentation : arrObjRepresentations) {
                ligneDonnees[0] = uneRepresentation.getGroupe().getNomGroupe();
                ligneDonnees[1] = uneRepresentation.getLieu().getNomLieu();
                ligneDonnees[2] = uneRepresentation.getDateRepresentation();
                ligneDonnees[3] = uneRepresentation.getHeureDebutRepresentation();
                ligneDonnees[4] = uneRepresentation.getHeureFinRepresentation();
                ((VueRepresentation) vue).getModeleTableRepresentation().addRow(ligneDonnees);
            } 
        } catch (SQLException ex) {
            msg = "CtrlRepresentation - representationAfficher() - " + ex.getMessage();
            JOptionPane.showMessageDialog(vue, msg, "Affichage des représentations", JOptionPane.ERROR_MESSAGE);
            }
        }
    

    @Override
    public void windowOpened(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowClosing(WindowEvent e) {
        try {
            menuFichierQuitter();
        } catch (SQLException ex) {
            Logger.getLogger(CtrlMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void windowClosed(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowIconified(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowActivated(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
