package ihm;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.ActionsAdministratifDAO;
import dao.ActionsGestionnaireDAO;
import model.Absence;
import model.Professeur;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.BoxLayout;

/**
 * Classe interface du remplacement des professeurs absents
 * 
 * @author Loic OUASSA, Mael PAROT
 * @version 1.0
 */
public class RemplacerProfAbsentIHM {

	private JFrame frame;
	private JTable table;
	private JTable table_1;
	private ActionsAdministratifDAO actionAdmin = new ActionsAdministratifDAO();
	private ActionsGestionnaireDAO actionGest = new ActionsGestionnaireDAO();
	private JLabel lblNewLabel_3_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RemplacerProfAbsentIHM window = new RemplacerProfAbsentIHM();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RemplacerProfAbsentIHM() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

		
		
		ArrayList<Absence> listeAbsProf = null;
		try {
			listeAbsProf = actionAdmin.listeAbsencesProfRemplacant();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel);
		
		/**
		 * Bouton retour pour la navigation du logiciel
		 */
		JButton btnNewButtonRetour = new JButton("Retour");
		btnNewButtonRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(IdEtTypeCompte.typeCompte == 2)
						new AdministratifIHM();
					else if(IdEtTypeCompte.typeCompte == 3)
						new GestionnaireIHM();
					frame.dispose();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		btnNewButtonRetour.setFont(new Font("Tahoma", Font.BOLD, 24));
		panel.add(btnNewButtonRetour);
		
		JLabel lblNewLabel = new JLabel("Selectionner l'enseignant a remplacer :");
		panel.add(lblNewLabel);
		
		table = new JTable();
		table.setBounds(27, 40, 358, 48);
		table.setModel(new DefaultTableModel(
			null,
			new String[] {
				"Selection", "Nom", "Prenom", "Cours Nom", "Date Absence"
			}
		) {
			private static final long serialVersionUID = 1L;
			Class[] columnTypes = new Class[] {
				Boolean.class, Object.class, Object.class, Object.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			/**
			 * Fixation des autorisations de modification par l'utilisateur
			 */
			boolean[] isCellEditable = new boolean[]{
				true, false, false, false, false
			};

	        public boolean isCellEditable(int rowIndex, int columnIndex) {
	            return isCellEditable[columnIndex];
	        }
		});
		table.setSurrendersFocusOnKeystroke(true);
		table.setForeground(Color.BLACK);
		table.setFont(new Font("Tahoma", Font.PLAIN, 16));
		table.setBackground(new Color(255, 255, 255));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(table);
		scrollPane.setViewportBorder(null);
		scrollPane.setPreferredSize(new Dimension(50,40));

		panel.add(scrollPane);
		
		for(int i = 0; i<listeAbsProf.size(); i++) {
			((DefaultTableModel) table.getModel()).addRow(
						new Object[]{Boolean.FALSE, listeAbsProf.get(i).getNomProf(), listeAbsProf.get(i).getPrenomProf(),
								listeAbsProf.get(i).getNomCours(), listeAbsProf.get(i).getDate()});
		}
		
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));

		JLabel lblNewLabel_1 = new JLabel("Selectionner l'enseignant remplacant :");
		panel_1.add(lblNewLabel_1);
		
		table_1 = new JTable();
		table_1.setBounds(27, 148, 358, 48);
		table_1.setModel(new DefaultTableModel(
				/**
				 * Creation des titres des colonnes
				 */
				null,
				new String[] {
					"Selection", "Nom", "Prenom", "Email", "Num Telephone"
				}
			) {
				/**
				 * Fixation des types variables des colonnes
				 */
				private static final long serialVersionUID = 1L;
				Class[] columnTypes = new Class[] {
					Boolean.class, Object.class, Object.class, Object.class, Object.class
				};
				public Class getColumnClass(int columnIndex) {
					return columnTypes[columnIndex];
				}
				
				/**
				 * Fixation des autorisations de modification par l'utilisateur
				 */
				boolean[] isCellEditable = new boolean[]{
	                true, false, false, false, false
				};

		        public boolean isCellEditable(int rowIndex, int columnIndex) {
		            return isCellEditable[columnIndex];
		        }
	        });
		table_1.setSurrendersFocusOnKeystroke(true);
		table_1.setForeground(Color.BLACK);
		table_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		table_1.setBackground(new Color(255, 255, 255));
		
		ArrayList<Professeur> listeProf = null;
		
		try {
			listeProf = actionGest.getListeProfesseur();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		/**
		 * Remplissage des lignes par la liste des professeurs
		 */
		for(int i = 0; i<listeProf.size(); i++) {
			((DefaultTableModel) table_1.getModel()).addRow(
						new Object[]{Boolean.FALSE, listeProf.get(i).getNom(), 
								listeProf.get(i).getPrenom(), listeProf.get(i).getEmail(), 
								listeProf.get(i).getNumTelephone()});
		}
		
		
		
		JScrollPane scrollPane1 = new JScrollPane();
		scrollPane1.setViewportView(table_1);
		scrollPane1.setViewportBorder(null);
		scrollPane1.setPreferredSize(new Dimension(50, 80));

		panel_1.add(scrollPane1);
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2);
		
		JButton btnNewButton = new JButton("Validation");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**
				 * Recuperation de la ligne de la case cochee par l'utilisateur
				 * pour l'id SQL de la table corespondante
				 */
				int ligneNum = 0;
				String date = "";
				for(int i = 0; i < table.getRowCount(); i++) {
					Boolean CaseCochee = Boolean.valueOf(table.getValueAt(i, 0).toString());
					if(CaseCochee) {
						date = table.getValueAt(i, 3).toString();
						ligneNum = i+1;
					}
				}
				/**
				 * Recuperation de la ligne de la case cochee par l'utilisateur
				 * pour l'id SQL de la table corespondante
				 */
				int ligneNum_2 = 0;
				for(int i = 0; i < table_1.getRowCount(); i++) {
					Boolean CaseCochee = Boolean.valueOf(table_1.getValueAt(i, 0).toString());
					if(CaseCochee)
						ligneNum_2 = i+1;
				}
				/**
				 * Verification de textField non vierge 
				 * et des donnees entrees au format correct
				 */
				if (ligneNum != -1 && ligneNum_2 != -1) {
					remplacerProf(ligneNum, ligneNum_2, date);
				} else {
					JOptionPane.showMessageDialog(new JFrame(), "Tous les champs ne sont pas completes ou pas de professeur selectionne.", "Dialog",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnNewButton.setBounds(327, 232, 85, 21);
		panel_2.add(btnNewButton);

		
		lblNewLabel_3_5 = new JLabel("");
		lblNewLabel_3_5.setForeground(Color.RED);
		lblNewLabel_3_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_2.add(lblNewLabel_3_5);
	}	
	
	/**
	 * Methode pour le remplacement d'un professeur absent
	 * @param profId
	 * 			id du professeur absent
	 * @param profIdRemp
	 * 			id du professeur remplacant
	 * @param date
	 * 			date de l'absence
	 */
	public void remplacerProf(int profId, int profIdRemp, String date) {
		try {
			int effectuee = actionAdmin.remplacerProf(profId, profIdRemp, date);
			if (effectuee >= 1)
				lblNewLabel_3_5.setText("Professeur remplace !");
			else
				lblNewLabel_3_5.setText("Erreur ce professeur n'existe pas ou aucun cours a la date de l'absence !");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

