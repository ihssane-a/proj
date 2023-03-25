package vendredi;




import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ihm extends JFrame {
private JButton addButton, modifyButton, deleteButton;
    
    public ihm() {
        // Créer les boutons
        addButton = new JButton("Ajouter");
        addButton.setBounds(10, 44, 100, 23);
        modifyButton = new JButton("Modifier");
        modifyButton.setBounds(126, 44, 110, 23);
        deleteButton = new JButton("Supprimer");
        deleteButton.setBounds(268, 44, 112, 23);
        
        // Ajouter les boutons à un JPanel
        JPanel panel = new JPanel();
        panel.setBackground(new Color(128, 128, 255));
        panel.setLayout(null);
        panel.add(addButton);
        panel.add(modifyButton);
        panel.add(deleteButton);
        
        // Ajouter le JPanel à la JFrame
        getContentPane().add(panel);
        
        // Paramètres de la JFrame
        setTitle("ADMIN");
        setSize(406, 167);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new ihm();
    }
    }