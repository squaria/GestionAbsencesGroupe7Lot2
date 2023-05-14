package ihm;

import java.awt.Color;
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import dao.ActionsAdministratifDAO;
import model.AbsencePhysique;

import javax.swing.JLabel;

/**
 * Classe interface du traitement des absence physiques
 * d'un etudiant avec creation des liens visios
 * 
 * @author Loic OUASSA, Mael PAROT
 * @version 1.0
 */
public class TraiterAbsencesPhysiquesIHM {

	private JFrame frame;
	private JTable table;
	private JLabel lblNewLabel_3_2;
	private JLabel lblNewLabel_3_3;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TraiterAbsencesPhysiquesIHM window = new TraiterAbsencesPhysiquesIHM();
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
	public TraiterAbsencesPhysiquesIHM() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		/**
		 * Creation de la JFrame
		 */
		frame = new JFrame();
		frame.setVisible(true);
		frame.setTitle("Absences classiques et physiques");
		frame.setBounds(100, 100, 1405, 765);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		ActionsAdministratifDAO actionAdmin = new ActionsAdministratifDAO();
		ArrayList<AbsencePhysique> listeAbsences = null;
		try {
			listeAbsences = actionAdmin.listeAbsencesPhysiquesAdmin();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		JPanel panel_7 = new JPanel();
		frame.getContentPane().add(panel_7);
		FlowLayout flowLayout = (FlowLayout) panel_7.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);

		/**
		 * Bouton retour pour la navigation du logiciel
		 */
		JButton btnNewButtonRetour = new JButton("Retour");
		btnNewButtonRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(IdEtTypeCompte.typeCompte == 2)
					new AdministratifIHM();
				else if(IdEtTypeCompte.typeCompte == 3)
					new GestionnaireIHM();
				frame.dispose();
			}
		});
		btnNewButtonRetour.setFont(new Font("Tahoma", Font.BOLD, 24));
		panel_7.add(btnNewButtonRetour);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		frame.getContentPane().add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{182, 10, 0};
		gbl_panel.rowHeights = new int[]{10, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		/**
		 * Table d'affichage des absences physiques
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
				{Boolean.FALSE, "DATEDEBUT", "DATEFIN", "GROUPE ETUDIANT", "ID ETUDIANT", "NOM ETUDIANT", "PRENOM ETUDIANT", "JUSTIFICATIF", "VALIDEE ADMIN"},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column"
			}
			
			
		) {
			/**
			 * Fixation des types variables des colonnes
			 */
			private static final long serialVersionUID = 1L;
			Class[] columnTypes = new Class[] {
				Boolean.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}

			/**
			 * Fixation des autorisations de modification par l'utilisateur
			 */
			boolean[] isCellEditable = new boolean[]{
                true, false, false, false, false, false, false, true, false
			};

	        public boolean isCellEditable(int rowIndex, int columnIndex) {
	            return isCellEditable[columnIndex];
	        }
        });

		/**
		 * Remplissage des lignes par la liste des absences physiques
		 */
		for(int i = 0; i<listeAbsences.size(); i++) {
			((DefaultTableModel) table.getModel()).addRow(
						new Object[]{Boolean.FALSE, listeAbsences.get(i).getDateDebut(), listeAbsences.get(i).getDateFin(), 
									listeAbsences.get(i).getGrpId(), listeAbsences.get(i).getEtuId(), listeAbsences.get(i).getNomEtu(), 
									listeAbsences.get(i).getPrenomEtu(), listeAbsences.get(i).getJustificatif(), 
									listeAbsences.get(i).getValideeAdmin()});
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
		
		JPanel panel_2 = new JPanel();
		frame.getContentPane().add(panel_2);
		
		JLabel lblNewLabel_7 = new JLabel("Lien pour la visio : ");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel_2.add(lblNewLabel_7);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField.setColumns(50);
		panel_2.add(textField);
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1);
		
		JButton btnNewButton = new JButton("Absence physique non valide");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int ligneNum = -1;
				/**
				 * Verification de textField non vierge 
				 * et des donnees entrees au format correct
				 */
				for(int i = 0; i < table.getRowCount(); i++) {
					Boolean CaseCochee = Boolean.valueOf(table.getValueAt(i, 0).toString());
					if(CaseCochee) {
						validerAbsencePhysique(i, (int) table.getValueAt(i, 3), (int) table.getValueAt(i, 4), false,
								table.getValueAt(i, 1).toString(), table.getValueAt(i, 2).toString(), 
								textField.getText());
						ligneNum = 1;
					}
				}
				if(ligneNum == -1)
					JOptionPane.showMessageDialog(new JFrame(), "Vous n'avez pas coche d'absence.", "Dialog",
							JOptionPane.ERROR_MESSAGE);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnNewButton.setForeground(Color.BLACK);
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Absence physique valide");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int ligneNum = -1;
				/**
				 * Verification de textField non vierge 
				 * et des donnees entrees au format correct
				 */
				if(textField.getText().length() > 0) {
				for(int i = 0; i < table.getRowCount(); i++) {
					Boolean CaseCochee = Boolean.valueOf(table.getValueAt(i, 0).toString());
					if(CaseCochee) {
						validerAbsencePhysique(i, (int) table.getValueAt(i, 3), (int) table.getValueAt(i, 4), true, 
								table.getValueAt(i, 1).toString(), table.getValueAt(i, 2).toString(), 
								textField.getText());
						ligneNum = 1;
					}
				}
				if(ligneNum == -1)
					JOptionPane.showMessageDialog(new JFrame(), "Vous n'avez pas coche d'absence.", "Dialog",
							JOptionPane.ERROR_MESSAGE);
				}
				else
					JOptionPane.showMessageDialog(new JFrame(), "Vous n'avez pas entre de lien visio.", "Dialog",
							JOptionPane.ERROR_MESSAGE);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel_1.add(btnNewButton_1);
		
		lblNewLabel_3_2 = new JLabel("");
		lblNewLabel_3_2.setForeground(Color.RED);
		lblNewLabel_3_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_1.add(lblNewLabel_3_2);
		
		lblNewLabel_3_3 = new JLabel("");
		lblNewLabel_3_3.setForeground(Color.RED);
		lblNewLabel_3_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_1.add(lblNewLabel_3_3);
	}

	/**
	 * Methode pour la validation ou non d'une absence physique
	 * @param ligneNum
	 * 			ligne cochee dans la table par l'utilisateur
	 * @param grpId
	 * 			id du groupe de l'etudiant
	 * @param etuId
	 * 			id de l'etudiant
	 * @param isValidee
	 * 			vrai si absence validee faux sinon
	 * @param dateDebut
	 * 			date de debut de la periode de l'absence physique
	 * @param dateFin
	 * 			date de fin de la periode de l'absence physique
	 * @param lienVisio
	 * 			lien visio pour l'acces au cours a distance
	 */
	public void validerAbsencePhysique(int ligneNum, int grpId, int etuId, boolean isValidee,
			String dateDebut, String dateFin, String lienVisio) {
		ActionsAdministratifDAO actionAdmin = new ActionsAdministratifDAO();
		try {
			int effectuee = actionAdmin.validerAbsencePhysique(ligneNum, grpId, etuId, isValidee, dateDebut, dateFin, lienVisio);
			if (effectuee >= 1 && isValidee)
				lblNewLabel_3_2.setText("Absence validee !");
			else if (effectuee >= 1 && !isValidee)
				lblNewLabel_3_2.setText("Absence invalidee !");
			else
				lblNewLabel_3_2.setText("Erreur cette absence n'existe pas ou a deja ete traitee !");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
