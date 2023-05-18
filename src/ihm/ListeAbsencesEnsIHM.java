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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import dao.ActionsProfesseurDAO;
import dao.ActionsAdministratifDAO;
import dao.ActionsGestionnaireDAO;
import model.Absence;
import model.Professeur;
import model.Profil;

import java.awt.Color;
import java.awt.Dimension;

/**
 * Classe interface de la liste des absences d'un enseignant
 * 
 * @author Loic OUASSA, Mael PAROT
 * @version 1.0
 */
public class ListeAbsencesEnsIHM {
	private JFrame frmAbsencesClassiquesEnseignant;
	private JTable table;
	private ActionsProfesseurDAO actionProf = new ActionsProfesseurDAO();
	private ActionsAdministratifDAO actionAdmin = new ActionsAdministratifDAO();
	private ActionsGestionnaireDAO actionGest = new ActionsGestionnaireDAO();
	private ArrayList<Absence> listeAbsencesP = null;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListeAbsencesEnsIHM window = new ListeAbsencesEnsIHM();
					window.frmAbsencesClassiquesEnseignant.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ListeAbsencesEnsIHM() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		/**
		 * Creation de la JFrame
		 */
		frmAbsencesClassiquesEnseignant = new JFrame();
		frmAbsencesClassiquesEnseignant.setVisible(true);
		frmAbsencesClassiquesEnseignant.setTitle("Absences classiques et physiques enseignant");
		frmAbsencesClassiquesEnseignant.setBounds(100, 100, 1405, 700);
		frmAbsencesClassiquesEnseignant.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAbsencesClassiquesEnseignant.getContentPane().setLayout(new BoxLayout(frmAbsencesClassiquesEnseignant.getContentPane(), BoxLayout.Y_AXIS));
		frmAbsencesClassiquesEnseignant.setExtendedState(JFrame.MAXIMIZED_BOTH);
		

		JPanel panel_91 = new JPanel();
		frmAbsencesClassiquesEnseignant.getContentPane().add(panel_91);
		panel_91.setLayout(new BoxLayout(panel_91, BoxLayout.X_AXIS));
		
		JPanel panel_3 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panel_91.add(panel_3);

		/**
		 * Bouton retour pour la navigation du logiciel
		 */
		JButton btnNewButtonRetour = new JButton("Retour");
		btnNewButtonRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(IdEtTypeCompte.typeCompte == 1)
					new EnseignantIHM();
				else if(IdEtTypeCompte.typeCompte == 2)
					new AdministratifIHM();
				frmAbsencesClassiquesEnseignant.dispose();
			}
		});
		btnNewButtonRetour.setFont(new Font("Tahoma", Font.BOLD, 24));
		panel_3.add(btnNewButtonRetour);
		
		JPanel panel_32 = new JPanel();
		FlowLayout flowLayout2 = (FlowLayout) panel_32.getLayout();
		flowLayout2.setAlignment(FlowLayout.RIGHT);
		panel_91.add(panel_32);
		
		JButton btnNewButtonRefresh = new JButton("Rafraichir");
		btnNewButtonRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refresh();
			}
		});
		btnNewButtonRefresh.setFont(new Font("Tahoma", Font.BOLD, 24));
		panel_32.add(btnNewButtonRefresh);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLUE);
		frmAbsencesClassiquesEnseignant.getContentPane().add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{182, 10, 0};
		gbl_panel.rowHeights = new int[]{10, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		/**
		 * Table d'affichage de la liste des absences d'un enseignant
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
				{"DATE", "NBHEURES", "NOM COURS", "TYPE"},
			},
			new String[] {
				"New column", "New column", "New column", "New column"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(40);
		table.getColumnModel().getColumn(1).setPreferredWidth(60);
		table.getColumnModel().getColumn(2).setPreferredWidth(50);
		
		if(IdEtTypeCompte.typeCompte == 1) {
			try {
				listeAbsencesP = actionProf.listeAbsencesProf();
				refresh();
			} catch (Exception e) {
				e.printStackTrace();
			}
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
		
		JPanel panel_1 = new JPanel();
		frmAbsencesClassiquesEnseignant.getContentPane().add(panel_1);

		/**
		 * Affichage de la selection d'un enseignant 
		 * si le type de compte est un administratif
		 */
		if(IdEtTypeCompte.typeCompte == 2) {
			JLabel lblNewLabel1 = new JLabel("Entrez un enseignant :");
			lblNewLabel1.setForeground(Color.BLACK);
			lblNewLabel1.setFont(new Font("Tahoma", Font.PLAIN, 18));
			panel_1.add(lblNewLabel1);
			
			JLabel lblNewLabel2 = new JLabel("Nom :");
			lblNewLabel2.setForeground(Color.BLACK);
			lblNewLabel2.setFont(new Font("Tahoma", Font.PLAIN, 18));
			panel_1.add(lblNewLabel2);
			
			JTextField textField = new JTextField();
			textField.setColumns(20);
			panel_1.add(textField);
			
			JLabel lblNewLabel3 = new JLabel("Prenom :");
			lblNewLabel3.setForeground(Color.BLACK);
			lblNewLabel3.setFont(new Font("Tahoma", Font.PLAIN, 18));
			panel_1.add(lblNewLabel3);
			
			JTextField textField1 = new JTextField();
			textField1.setColumns(20);
			panel_1.add(textField1);
			
			JLabel lblNewLabel4 = new JLabel("Email :");
			lblNewLabel4.setForeground(Color.BLACK);
			lblNewLabel4.setFont(new Font("Tahoma", Font.PLAIN, 18));
			panel_1.add(lblNewLabel4);
			
			JTextField textField2 = new JTextField();
			textField2.setColumns(20);
			panel_1.add(textField2);
			
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
			ListSelectionModel tableSelectionModel1 = table_1.getSelectionModel();
			tableSelectionModel1.setSelectionInterval(0, 0);
			table_1.setSelectionModel(tableSelectionModel1);
			table_1.repaint();
			

			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setViewportView(table_1);
			scrollPane.setViewportBorder(null);
			scrollPane.setPreferredSize(new Dimension(50,40));

			frmAbsencesClassiquesEnseignant.getContentPane().add(scrollPane);
			
			JPanel panel_31 = new JPanel();
			frmAbsencesClassiquesEnseignant.getContentPane().add(panel_31);
			
			JButton btnNewButton = new JButton("Selectionner");
			btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 24));
			btnNewButton.setForeground(Color.BLACK);
			panel_31.add(btnNewButton);
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					/**
					 * Recuperation de la ligne de la case cochee par l'utilisateur
					 * pour l'id SQL de la table corespondante
					 */
					int ligneNum = -1;
					for(int i = 0; i < table_1.getRowCount(); i++) {
						Boolean CaseCochee = Boolean.valueOf(table_1.getValueAt(i, 0).toString());
						if(CaseCochee)
							ligneNum = i;
					}
					
					((DefaultTableModel) table.getModel()).setRowCount(1);
					/**
					 * Verification de textField non vierge 
					 * et des donnees entrees au format correct
					 */
					if (textField.getText().length() > 0 && textField1.getText().length() > 0 
							&& textField2.getText().length() > 0) {
						try {
							listeAbsencesP = actionAdmin.listeAbsencesProf(new Profil(textField.getText(), textField1.getText(), textField2.getText()));
							refresh();
						} catch (Exception e1) {
							e1.printStackTrace();
						}
					} else if(ligneNum != -1) {
						try {
							listeAbsencesP = actionAdmin.listeAbsencesProf(new Profil(table_1.getValueAt(ligneNum, 1).toString(), 
									table_1.getValueAt(ligneNum, 2).toString(), table_1.getValueAt(ligneNum, 3).toString()));
							refresh();
						} catch (Exception e1) {
							e1.printStackTrace();
						}
					}
					else {
						JOptionPane.showMessageDialog(new JFrame(), "Tous les champs ne sont pas completes.", "Dialog",
								JOptionPane.ERROR_MESSAGE);
					}
				}
			});
		}		
	}
	
	/**
	 * Remplissage des lignes par la liste des absences enseignants
	 */
	public void refresh() {
		((DefaultTableModel) table.getModel()).setRowCount(1);
		for(int i = 0; i<listeAbsencesP.size(); i++) {
			((DefaultTableModel) table.getModel()).addRow(new Object[]{listeAbsencesP.get(i).getDate(), listeAbsencesP.get(i).getNbHeures(),
									listeAbsencesP.get(i).getNomCours(),listeAbsencesP.get(i).getType()});
		}
	}
}

	
