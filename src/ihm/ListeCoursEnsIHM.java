package ihm;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import dao.ActionsProfesseurDAO;
import model.Cours;

import java.awt.Color;

/**
 * Classe interface de la liste des cours d'un enseignant
 * 
 * @author Loic OUASSA, Mael PAROT
 * @version 1.0
 */
public class ListeCoursEnsIHM {
	private JFrame frmAbsencesClassiquesEnseignant;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListeCoursEnsIHM window = new ListeCoursEnsIHM();
					window.frmAbsencesClassiquesEnseignant.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws Exception 
	 */
	public ListeCoursEnsIHM() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws Exception 
	 */
	private void initialize() {
		/**
		 * Creation de la JFrame
		 */
		frmAbsencesClassiquesEnseignant = new JFrame();
		frmAbsencesClassiquesEnseignant.setVisible(true);
		frmAbsencesClassiquesEnseignant.setTitle("Liste cours professeur");
		frmAbsencesClassiquesEnseignant.setBounds(100, 100, 1405, 700);
		frmAbsencesClassiquesEnseignant.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAbsencesClassiquesEnseignant.getContentPane().setLayout(new BoxLayout(frmAbsencesClassiquesEnseignant.getContentPane(), BoxLayout.Y_AXIS));
		frmAbsencesClassiquesEnseignant.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		ActionsProfesseurDAO actionProf = new ActionsProfesseurDAO();
		ArrayList<Cours> listeCours = null;
		try {
			listeCours = actionProf.listeCoursProf(IdEtTypeCompte.id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		JPanel panel_3 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		frmAbsencesClassiquesEnseignant.getContentPane().add(panel_3);

		/**
		 * Bouton retour pour la navigation du logiciel
		 */
		JButton btnNewButtonRetour = new JButton("Retour");
		btnNewButtonRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new EnseignantIHM();
				frmAbsencesClassiquesEnseignant.dispose();
			}
		});
		btnNewButtonRetour.setFont(new Font("Tahoma", Font.BOLD, 24));
		panel_3.add(btnNewButtonRetour);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		frmAbsencesClassiquesEnseignant.getContentPane().add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{182, 10, 0};
		gbl_panel.rowHeights = new int[]{10, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		/**
		 * Table d'affichage de la liste des cours d'un enseignant
		 */
		table = new JTable();
		table.setCellSelectionEnabled(true);
		table.setColumnSelectionAllowed(false);
		table.setFont(new Font("Times New Roman", Font.BOLD, 18));
		table.setForeground(Color.DARK_GRAY);
		table.setToolTipText("");
		table.setDragEnabled(true);
		
		table.setModel(new DefaultTableModel(
			/**
			 * Creation des titres des colonnes
			 */
			new Object[][] {
				{"NOM COURS", "NBHEURES AMPHI", "NBHEURES TD", "NBHEURES TP", "NBHEURES EXAMEN"},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column"
			}
			) {
			
				private static final long serialVersionUID = 1L;

				/**
				 * Fixation des autorisations de modification par l'utilisateur
				 */
				boolean[] isCellEditable = new boolean[]{
	                    false, false, false, false, false
	            };
	
	            public boolean isCellEditable(int rowIndex, int columnIndex) {
	                return isCellEditable[columnIndex];
	            }
		});
		
		/**
		 * Remplissage des lignes par la liste des cours d'un enseignant
		 */
		for(int i = 0; i<listeCours.size(); i++) {
			((DefaultTableModel) table.getModel()).addRow(new Object[]{listeCours.get(i).getNom(),
					listeCours.get(i).getNbHeuresAmphi(), listeCours.get(i).getNbHeuresTD(),
					listeCours.get(i).getNbHeuresTP(), listeCours.get(i).getNbHeuresExamen()});
		}
		ListSelectionModel tableSelectionModel = table.getSelectionModel();
		tableSelectionModel.setSelectionInterval(0, 0);
		table.setSelectionModel(tableSelectionModel);
		table.repaint();
		GridBagConstraints gbc_table = new GridBagConstraints();
		gbc_table.gridheight = 2;
		gbc_table.gridwidth = 2;
		gbc_table.insets = new Insets(0, 0, 0, 5);
		gbc_table.fill = GridBagConstraints.BOTH;
		gbc_table.gridx = 0;
		gbc_table.gridy = 0;
		panel.add(table, gbc_table);
		
		
		
		

	}
}

	
