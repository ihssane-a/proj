package vendredi;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class ihm2 {
	   static JMenu modif = new JMenu("modifier");
    private static final String[] OPTIONS = {
    		"Résultats 1ère journée de finale de la CAN 2022",
    		"Résultats 2e journée de finale de la CAN 2022",
    		"Résultats 3e journée de finale de la CAN 2022",
            "Résultats Huitièmes de finale de la CAN 2022",
            "Résultats Quarts de la CAN 2022",
            "Résultat Demi-finales finale de la CAN 2022",
            "Résultat petite finale de la CAN 2022",
            "Résultat Finale finale de la CAN 2022"};
       
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;

    private static JTextArea textArea;
    private static JTable table;
    private static Object[][][] data;

    public static void main(String[] args) {
    	
        // Initialisation des données des tableaux
        data = new Object[][][]{
      	 
       	  {
       		  
       	  }, 
        	
        	
        	
        	
        	{}, 
        	
        	
        	{},  
        	
        	
        	
        	{},
               
                {},
                
                {},
                
                {},
                
                {}
        };
        

        // Création de la fenêtre principale
        JFrame frame = new JFrame("Résultats de la Coupe d'Afrique des Nations 2022");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 506);
        frame.setLocationRelativeTo(null);
     
        // Création des
        // onglets
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.setForeground(new Color(255, 255, 255));
        tabbedPane.setBackground(new Color(0, 0, 128));
        tabbedPane.setFont(new Font("Tahoma", Font.BOLD, 15));
        tabbedPane.setTabPlacement(JTabbedPane.LEFT);
        frame.getContentPane().add(tabbedPane);
      
for(int i =0;i<8;i++) {
	tabbedPane.addTab((OPTIONS[i]), createTable(data[i]));
	String filePath = "C:\\Users\\HP\\eclipse-workspace\\vendredi\\option_"+i+".txt";
    File file = new File(filePath);
    
    try {
        BufferedReader br = new BufferedReader(new FileReader(file));
        // get the first line
        // get the columns name from the first line
        // set columns name to the jtable model
        String firstLine = br.readLine().trim();
        String[] columnsName = firstLine.split(";");
        DefaultTableModel model = (DefaultTableModel)table.getModel();
        model.setColumnIdentifiers(columnsName);
        
        // get lines from txt file
        Object[] tableLines = br.lines().toArray();
        
        // extratct data from lines
        // set data to jtable model
        for(int i1 = 0; i1 < tableLines.length; i1++)
        {
            String line = tableLines[i1].toString().trim();
            String[] dataRow = line.split("/");
            model.addRow(dataRow);
        }
        
        
    } catch (Exception ex) {
     
    }

}
        // Ajout des onglets avec leur contenu
        
 
        // Ajout de la zone de texte en bas de la fenêtre
        textArea = new JTextArea();
        textArea.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 14));
        textArea.setEditable(false);
        frame.getContentPane().add(textArea, BorderLayout.SOUTH);

        // Création du menu
        JMenuBar menuBar = new JMenuBar();
        menuBar.setForeground(new Color(255, 255, 255));
        menuBar.setBackground(new Color(0, 0, 128));
        frame.setJMenuBar(menuBar);


     modif = new JMenu("modifier");
        modif.setBackground(new Color(128, 128, 255));
        modif.setForeground(new Color(255, 255, 255));
        modif.setVisible(false);
        modif.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
           
            }
        });
        menuBar.add(modif);
        
        
    

        
        
        
        JMenu fileMenu = new JMenu("Fichier");
        fileMenu.setBackground(new Color(128, 128, 255));
        fileMenu.setForeground(new Color(255, 255, 255));
        menuBar.add(fileMenu);

        JMenuItem exitMenuItem = new JMenuItem("Quitter");
        exitMenuItem.setBackground(new Color(128, 128, 255));
        exitMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        fileMenu.add(exitMenuItem);

        JMenu editMenu = new JMenu("ADMIN");
        editMenu.setForeground(new Color(255, 255, 255));
        menuBar.add(editMenu);

        JMenuItem clearMenuItem = new JMenuItem("se connecter");
        clearMenuItem.setFont(new Font("Segoe UI", Font.BOLD, 12));
        clearMenuItem.setBackground(new Color(114, 125, 235));
        clearMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
         ihm2 i = new ihm2();
         i.setVisible(true);
            }
        });
        editMenu.add(clearMenuItem);

        // Affichage de la fenêtre
        frame.setVisible(true);
    }


    private static JScrollPane createTable(Object[][] data) {
        String[] columnNames = {"Equipe 1", "Score 1", "Score 2", "Equipe 2"};
        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        return scrollPane;
    }


	public static JMenu getmodif() {
		 modif.setVisible(true);
		 

		return modif;
	}




}