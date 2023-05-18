package ihm;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import dao.ActionsGestionnaireDAO;
import dao.ActionsProfesseurDAO;
import dao.PlanningDAO;
import model.Absence;
import model.Planning;
import model.PlanningEnseignant;
import model.Professeur;

import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * Classe interface du planning d'un enseignant
 * 
 * @author Loic OUASSA, Mael PAROT
 * @version 1.0
 */
public class PlanningEnseignantIHM {

	private JFrame frmCoursNonTraites;
	private JTable table;
	private JTextField textField_1;
	private ArrayList<PlanningEnseignant> planningProf;
	private ActionsGestionnaireDAO actionGest = new ActionsGestionnaireDAO();
	private ActionsProfesseurDAO actionProf = new ActionsProfesseurDAO();
	private ArrayList<Date> listeDate = new ArrayList<>();
	private Planning planning = new Planning();
	private float nbHeures;
	private int groupe;
	private int ligneNum_1 = -1;
	private Date date;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTable table_1;
	private JLabel lblNewLabel_3_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PlanningEnseignantIHM window = new PlanningEnseignantIHM();
					window.frmCoursNonTraites.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PlanningEnseignantIHM() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		/**
		 * Creation de la JFrame
		 */
		frmCoursNonTraites = new JFrame();
		frmCoursNonTraites.setVisible(true);
		frmCoursNonTraites.setTitle("Planning enseignant");
		frmCoursNonTraites.setBounds(100, 100, 1409, 751);
		frmCoursNonTraites.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCoursNonTraites.getContentPane().setLayout(new BoxLayout(frmCoursNonTraites.getContentPane(), BoxLayout.Y_AXIS));
		frmCoursNonTraites.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		JPanel panel_2 = new JPanel();
		frmCoursNonTraites.getContentPane().add(panel_2);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.Y_AXIS));
		
		JPanel panel_7 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_7.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panel_2.add(panel_7);

		/**
		 * Bouton retour pour la navigation du logiciel
		 */
		JButton btnNewButton = new JButton("Retour");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(IdEtTypeCompte.typeCompte == 1)
					new EnseignantIHM();
				else if(IdEtTypeCompte.typeCompte == 2)
					new AdministratifIHM();
				else if(IdEtTypeCompte.typeCompte == 3)
					new GestionnaireIHM();
				frmCoursNonTraites.dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 24));
		panel_7.add(btnNewButton);
		
		JPanel panel_4 = new JPanel();
		panel_2.add(panel_4);

		JPanel panel_6 = new JPanel();
		panel_2.add(panel_6);
		panel_6.setLayout(new BoxLayout(panel_6, BoxLayout.X_AXIS));
		
		JLabel lblEntrezLeGroupe = new JLabel("Selection du planning :  ");
		lblEntrezLeGroupe.setForeground(Color.BLUE);
		lblEntrezLeGroupe.setFont(new Font("Times New Roman", Font.BOLD, 26));
		lblEntrezLeGroupe.setAlignmentX(0.5f);
		panel_4.add(lblEntrezLeGroupe);
		

		if(IdEtTypeCompte.typeCompte == 2 || IdEtTypeCompte.typeCompte == 3) {
			/**
			 * Table d'affichage de la liste des professeurs
			 */
			table_1 = new JTable();
			table_1.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
			table_1.setRowSelectionAllowed(false);
			table_1.setCellSelectionEnabled(true);
			table_1.setColumnSelectionAllowed(true);
			table_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
			table_1.setForeground(Color.DARK_GRAY);
			table_1.setToolTipText("");
			
			table_1.setModel(new DefaultTableModel(
				/**
				 * Creation des titres des colonnes
				 */
				null,
				new String[] {
					"CHOIX", "NOM PROFESSEUR", "PRENOM PROFESSEUR", "EMAIL", "NUM TELEPHONE"
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
			ListSelectionModel tableSelectionModel = table_1.getSelectionModel();
			tableSelectionModel.setSelectionInterval(0, 0);
			table_1.setSelectionModel(tableSelectionModel);
			table_1.repaint();
			

			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setViewportView(table_1);
			scrollPane.setViewportBorder(null);
			scrollPane.setPreferredSize(new Dimension(50,40));

			panel_6.add(scrollPane);
		}
		
		JLabel lblNewLabel_1 = new JLabel("Date de debut (JJ/MM/AAAA) : ");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel_4.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_1.setColumns(5);
		panel_4.add(textField_1);
		
		JLabel lblNewLabel_3 = new JLabel("/");
		lblNewLabel_3.setForeground(Color.BLACK);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel_4.add(lblNewLabel_3);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_3.setColumns(5);
		panel_4.add(textField_3);
		
		JLabel lblNewLabel_4 = new JLabel("/");
		lblNewLabel_4.setForeground(Color.BLACK);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel_4.add(lblNewLabel_4);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_4.setColumns(5);
		panel_4.add(textField_4);
		
		JPanel panel_3 = new JPanel();
		panel_2.add(panel_3);
		
		JLabel lblNewLabel_2 = new JLabel("Date de fin (JJ/MM/AAAA) : ");
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel_3.add(lblNewLabel_2);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_5.setColumns(5);
		panel_3.add(textField_5);
		
		JLabel lblNewLabel_5 = new JLabel("/");
		lblNewLabel_5.setForeground(Color.BLACK);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel_3.add(lblNewLabel_5);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_6.setColumns(5);
		panel_3.add(textField_6);
		
		JLabel lblNewLabel_6 = new JLabel("/");
		lblNewLabel_6.setForeground(Color.BLACK);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel_3.add(lblNewLabel_6);
		
		textField_7 = new JTextField();
		textField_7.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_7.setColumns(5);
		panel_3.add(textField_7);
		
		JButton btnNewButton_1 = new JButton("Afficher planning");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**
				 * Verification de textField non vierge 
				 * et des donnees entrees au format correct
				 */
				if (textField_1.getText().length() > 0 && textField_3.getText().length() > 0 &&
						textField_4.getText().length() > 0 && textField_5.getText().length() > 0 &&
						textField_6.getText().length() > 0 && textField_7.getText().length() > 0 &&
						planning.isIntDay(textField_1.getText(), textField_3.getText(), textField_4.getText()) && 
						planning.intMonth(textField_3.getText()) != 0 && planning.intYear(textField_4.getText()) != 0 && 
						planning.isIntDay(textField_5.getText(), textField_5.getText(), textField_6.getText()) &&
						planning.intMonth(textField_6.getText()) != 0 && planning.intYear(textField_7.getText()) != 0 ) {
					String dateDebut = textField_1.getText() + "/" + textField_3.getText() + "/" + textField_4.getText();
					String dateFin = textField_5.getText() + "/" + textField_6.getText() + "/" + textField_7.getText();
					afficherPlanning(dateDebut, dateFin);
				} else {
					JOptionPane.showMessageDialog(new JFrame(), "Tous les champs ne sont pas completes ou ne sont pas des entiers.", "Dialog",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel_3.add(btnNewButton_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("");
		lblNewLabel_3_2.setForeground(Color.RED);
		lblNewLabel_3_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_3.add(lblNewLabel_3_2);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		frmCoursNonTraites.getContentPane().add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] {182, 10, 0};
		gbl_panel.rowHeights = new int[] {15, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		/**
		 * Table d'affichage du planning d'un enseignant
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
				{Boolean.FALSE, "INTITULE", "GROUPE", "DATE", "DEBUT DU COURS", "FIN DU COURS"},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column", "New column"
			}
		) {
			/**
			 * Fixation des types variables des colonnes
			 */
			private static final long serialVersionUID = 1L;
			Class[] columnTypes = new Class[] {
				Boolean.class, Object.class, Object.class, Object.class, Object.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}

			/**
			 * Fixation des autorisations de modification par l'utilisateur
			 */
			boolean[] isCellEditable = new boolean[]{
                true, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return isCellEditable[columnIndex];
            }
	});
		table.getColumnModel().getColumn(0).setPreferredWidth(100);
		table.getColumnModel().getColumn(1).setPreferredWidth(100);
		
		

		
		ListSelectionModel tableSelectionModel = table.getSelectionModel();
		tableSelectionModel.setSelectionInterval(0, 0);
		table.setSelectionModel(tableSelectionModel);
		table.repaint();
		GridBagConstraints gbc_table = new GridBagConstraints();
		gbc_table.fill = GridBagConstraints.HORIZONTAL;
		gbc_table.gridheight = 1;
		gbc_table.weighty = 0;
		gbc_table.gridwidth = 2;
		gbc_table.insets = new Insets(0, 0, 0, 5);
		gbc_table.gridx = 0;
		gbc_table.gridy = 0;
		panel.add(table, gbc_table);
		
		JPanel panel_1 = new JPanel();
		frmCoursNonTraites.getContentPane().add(panel_1);
		
		JButton btnNewButton_1_1 = new JButton("Declarer une absence pour ce cours");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int ligneNum = -1;
				/**
				 * Recuperation de la ligne de la case cochee par l'utilisateur
				 * pour l'id SQL de la table corespondante
				 */
				for(int i = 0; i < table.getRowCount(); i++) {
					Boolean CaseCochee = Boolean.valueOf(table.getValueAt(i, 0).toString());
					if(CaseCochee) {
						ligneNum = i;
						nbHeures = (float) table.getValueAt(i, 5) - (float) table.getValueAt(i, 4);
						groupe = (int) table.getValueAt(i, 2);
					}
				}
				if(ligneNum != -1 && IdEtTypeCompte.typeCompte == 1) {
					new DeclarerAbsenceIHM(ligneNum, nbHeures, groupe);
					frmCoursNonTraites.dispose();
				}
				else if(ligneNum != -1 && IdEtTypeCompte.typeCompte != 1) {
					declarerAbsenceProf(ligneNum);
				}
				else {
					JOptionPane.showMessageDialog(new JFrame(), "Vous n'avez pas coche d'absence.", "Dialog",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel_1.add(btnNewButton_1_1);
		

		lblNewLabel_3_5 = new JLabel("");
		lblNewLabel_3_5.setForeground(Color.RED);
		lblNewLabel_3_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_1.add(lblNewLabel_3_5);
		
	}
	
	/**
	 * Methode pour la declaration des absences d'un professeur
	 * @param profId
	 * 			id du professeur
	 */
	public void declarerAbsenceProf(int coursId) {
		date = listeDate.get(coursId);
		/**
		 * Recuperation de la date locale de l'ordinateur de l'utilisateur
		 * et formatage de cette date pour la compatibilite SQL
		 */
		Format formatter = new SimpleDateFormat("dd/MM/yyyy");
		String dateStr = formatter.format(date);
		
		try {
			int effectuee = actionProf.creerAbsence(new Absence(dateStr, 
					nbHeures, coursId, "Professeur", null, null), 0, ligneNum_1);
			if (effectuee == 1)
				lblNewLabel_3_5.setText("Absence cree !");
			else
				lblNewLabel_3_5.setText("Erreur ce professeur n'existe pas !");
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	/**
	 * Methode pour l'affichage du planning d'un enseignant
	 * entre la date de debut et la date de fin des cours
	 * @param dateDebut
	 * 			date de debut de selection
	 * @param dateFin
	 * 			date de fin de selection
	 */
	@SuppressWarnings("unchecked")
	public void afficherPlanning(String dateDebut, String dateFin) {
		PlanningDAO planning = new PlanningDAO();
		Object[] listeObj = {-1,-1};
		try {
			((DefaultTableModel) table.getModel()).setRowCount(1);
			if(IdEtTypeCompte.typeCompte == 1) {
				listeObj = planning.planningProf(IdEtTypeCompte.id, dateDebut, dateFin);
			}
			else {
				/**
				 * Recuperation de la ligne de la case cochee par l'utilisateur
				 * pour l'id SQL de la table corespondante
				 */
				for(int i = 0; i < table_1.getRowCount(); i++) {
					Boolean CaseCochee = Boolean.valueOf(table_1.getValueAt(i, 0).toString());
					if(CaseCochee)
						ligneNum_1 = i+1;
				}
				listeObj = planning.planningProf(ligneNum_1, dateDebut, dateFin);

			}
			planningProf = (ArrayList<PlanningEnseignant>) listeObj[0];
			listeDate = (ArrayList<Date>) listeObj[1];
			if(planningProf != null) {

				/**
				 * Remplissage des lignes par la liste des cours du planning d'un enseignant
				 */
				for(int i = 0; i<planningProf.size(); i++) {
					((DefaultTableModel) table.getModel()).addRow(
							new Object[]{Boolean.FALSE, planningProf.get(i).getCoursNom(), planningProf.get(i).getGrpId(),
									planningProf.get(i).getDate(), planningProf.get(i).getHeureDebut(), planningProf.get(i).getHeureFin()});
				}
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
}
