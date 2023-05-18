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
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import dao.ActionsAdministratifDAO;
import model.Absence;
import javax.swing.JLabel;

/**
 * Classe interface du traitement des absences
 * 
 * @author Loic OUASSA, Mael PAROT
 * @version 1.0
 */
public class TraiterAbsencesIHM {

	private JFrame frame;
	private JTable table;
	private JLabel lblNewLabel_3_2;
	private JLabel lblNewLabel_3_3;
	ActionsAdministratifDAO actionAdmin = new ActionsAdministratifDAO();
	ArrayList<Absence> listeAbsences = new ArrayList<>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TraiterAbsencesIHM window = new TraiterAbsencesIHM();
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
	public TraiterAbsencesIHM() {
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
		
		JPanel panel_91 = new JPanel();
		frame.getContentPane().add(panel_91);
		panel_91.setLayout(new BoxLayout(panel_91, BoxLayout.X_AXIS));
		
		JPanel panel_7 = new JPanel();
		panel_91.add(panel_7);
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
		panel.setBackground(Color.WHITE);
		frame.getContentPane().add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{182, 10, 0};
		gbl_panel.rowHeights = new int[]{10, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		/**
		 * Table d'affichage des absences
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
				{Boolean.FALSE, "DATE", "NBHEURES", "NOM ETUDIANT", "PRENOM ETUDIANT", "COURS", "TYPE", "JUSTIFICATIF", "VALIDEE ADMIN"},
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
		table.getColumnModel().getColumn(0).setPreferredWidth(40);
		table.getColumnModel().getColumn(1).setPreferredWidth(60);
		table.getColumnModel().getColumn(3).setPreferredWidth(100);
		table.getColumnModel().getColumn(4).setPreferredWidth(50);
		table.getColumnModel().getColumn(5).setPreferredWidth(40);
		table.getColumnModel().getColumn(6).setPreferredWidth(200);
		
		
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
		
		refresh();
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1);
		
		JButton btnNewButton = new JButton("Absence non valide");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int ligneNum = -1;
				/**
				 * Recuperation de la ligne de la case cochee par l'utilisateur
				 * pour l'id SQL de la table correspondante
				 */
				for(int i = 0; i < table.getRowCount(); i++) {
					Boolean CaseCochee = Boolean.valueOf(table.getValueAt(i, 0).toString());
					if(CaseCochee) {
						validerAbsence(listeAbsences.get(i-1).getAbsId(), false);
						refresh();
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
		
		JButton btnNewButton_1 = new JButton("Absence valide");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int ligneNum = -1;
				/**
				 * Recuperation de la ligne de la case cochee par l'utilisateur
				 * pour l'id SQL de la table correspondante
				 */
				for(int i = 0; i < table.getRowCount(); i++) {
					Boolean CaseCochee = Boolean.valueOf(table.getValueAt(i, 0).toString());
					if(CaseCochee) {
						validerAbsence(listeAbsences.get(i-1).getAbsId(), true);
						refresh();
						ligneNum = 1;
					}
				}
				if(ligneNum == -1)
					JOptionPane.showMessageDialog(new JFrame(), "Vous n'avez pas coche d'absence.", "Dialog",
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
	 * Methode pour la validation ou non de l'absence par l'administratif
	 * @param absId
	 * 			id de l'absence cochee
	 * @param isValidee
	 * 			vrai si absence validee faux sinon
	 */
	public void validerAbsence(int absId, boolean isValidee) {
		ActionsAdministratifDAO actionAdmin = new ActionsAdministratifDAO();
		try {
			int effectuee = actionAdmin.validerAbsence(absId, isValidee);
			if (effectuee == 1)
				lblNewLabel_3_2.setText("Absence validee ou non validee !");
			else
				lblNewLabel_3_2.setText("Erreur cette absence n'existe pas ou a deja ete traitee !");
			if(actionAdmin.absenceExamenValidee(absId)) {
				int effectuee2 = actionAdmin.declancherRatrapages(absId);
				if(effectuee2 == 1)
					lblNewLabel_3_3.setText("Note zero supprimee et rattrapage declanche !");
				else
					lblNewLabel_3_2.setText("Erreur !");
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void refresh() {
		((DefaultTableModel) table.getModel()).setRowCount(1);
		
		try {
			listeAbsences = actionAdmin.listeAbsencesAdmin();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		/**
		 * Remplissage des lignes par la liste des absences
		 */
		for(int i = 0; i<listeAbsences.size(); i++) {
			((DefaultTableModel) table.getModel()).addRow(
						new Object[]{Boolean.FALSE, listeAbsences.get(i).getDate(), listeAbsences.get(i).getNbHeures(),
									listeAbsences.get(i).getNomEtu(), listeAbsences.get(i).getPrenomEtu(), 
									listeAbsences.get(i).getNomCours(), listeAbsences.get(i).getType(),
									listeAbsences.get(i).getJustificatif(), listeAbsences.get(i).getValideeAdmin()});
		}
	}

}
