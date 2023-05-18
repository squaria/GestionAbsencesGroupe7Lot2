package ihm;

import java.awt.Color;
import java.awt.EventQueue;
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
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import dao.ActionsAdministratifDAO;
import dao.PlanningDAO;
import model.PlanningGroupe;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.FlowLayout;

/**
 * Classe interface du planning d'un groupe d'etudiant
 * 
 * @author Loic OUASSA, Mael PAROT
 * @version 1.0
 */
public class LienVisioAEntrerIHM {

	private JFrame frmCoursNonTraites;
	private JTable table;
	private JTextField textField;
	private ArrayList<PlanningGroupe> planningGroupe;
	private JLabel lblNewLabel_3_2;
	private static int idGroupe;
	private static String dateDebut;
	private static String dateFin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LienVisioAEntrerIHM window = new LienVisioAEntrerIHM(idGroupe, dateDebut, dateFin);
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
	public LienVisioAEntrerIHM(int idGroupe, String dateDebut, String dateFin) {
		LienVisioAEntrerIHM.idGroupe = idGroupe;
		LienVisioAEntrerIHM.dateDebut = dateDebut;
		LienVisioAEntrerIHM.dateFin = dateFin;
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
		frmCoursNonTraites = new JFrame();
		frmCoursNonTraites.setVisible(true);
		frmCoursNonTraites.setTitle("Planning de groupe");
		frmCoursNonTraites.setBounds(100, 100, 1409, 751);
		frmCoursNonTraites.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCoursNonTraites.getContentPane().setLayout(new BoxLayout(frmCoursNonTraites.getContentPane(), BoxLayout.Y_AXIS));
		frmCoursNonTraites.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		JPanel panel_91 = new JPanel();
		frmCoursNonTraites.getContentPane().add(panel_91);
		panel_91.setLayout(new BoxLayout(panel_91, BoxLayout.X_AXIS));

		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panel_91.add(panel_1);

		/**
		 * Bouton retour pour la navigation du logiciel
		 */
		JButton btnNewButton = new JButton("Retour");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TraiterAbsencesPhysiquesIHM();
				frmCoursNonTraites.dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 24));
		panel_1.add(btnNewButton);
		
		JPanel panel_32 = new JPanel();
		FlowLayout flowLayout2 = (FlowLayout) panel_32.getLayout();
		flowLayout2.setAlignment(FlowLayout.RIGHT);
		panel_91.add(panel_32);
		
		JButton btnNewButtonRefresh = new JButton("Rafraichir");
		btnNewButtonRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				afficherPlanning(idGroupe, dateDebut, dateFin);
			}
		});
		btnNewButtonRefresh.setFont(new Font("Tahoma", Font.BOLD, 24));
		panel_32.add(btnNewButtonRefresh);		

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		frmCoursNonTraites.getContentPane().add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] {182, 10, 0};
		gbl_panel.rowHeights = new int[] {20, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		/**
		 * Table d'affichage du planning d'un groupe
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
				{Boolean.FALSE, "INTITULE", "NOM PROFESSEUR", "DATE", "DEBUT DU COURS", "FIN DU COURS"},
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
		gbc_table.gridheight = 2;
		gbc_table.gridwidth = 2;
		gbc_table.insets = new Insets(0, 0, 0, 5);
		gbc_table.fill = GridBagConstraints.BOTH;
		gbc_table.gridx = 0;
		gbc_table.gridy = 0;
		panel.add(table, gbc_table);
		
		afficherPlanning(idGroupe, dateDebut, dateFin);
		
		JPanel panel_21 = new JPanel();
		frmCoursNonTraites.getContentPane().add(panel_21);
		
		JLabel lblNewLabel_7 = new JLabel("Lien pour la visio : ");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel_21.add(lblNewLabel_7);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField.setColumns(50);
		panel_21.add(textField);
		
		JButton btnNewButton1 = new JButton("Creer lien visio");
		btnNewButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int ligneNum = -1;
				/**
				 * Recuperation de la ligne de la case cochee par l'utilisateur
				 * pour l'id SQL de la table correspondante
				 */
				for(int i = 0; i < table.getRowCount(); i++) {
					Boolean CaseCochee = Boolean.valueOf(table.getValueAt(i, 0).toString());
					if(CaseCochee && textField.getText().length() > 0) {
						creerLienVisio(i, textField.getText());
					}
				}
				if(ligneNum == -1)
					JOptionPane.showMessageDialog(new JFrame(), "Vous n'avez pas coche de cours.", "Dialog",
							JOptionPane.ERROR_MESSAGE);
			}
		});
		btnNewButton1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnNewButton1.setForeground(Color.BLACK);
		panel_21.add(btnNewButton1);
		

		lblNewLabel_3_2 = new JLabel("");
		lblNewLabel_3_2.setForeground(Color.RED);
		lblNewLabel_3_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_21.add(lblNewLabel_3_2);
		
	}
	
	/**
	 * Methode pour l'affichage du planning de groupe 
	 * entre la date de debut et la date de fin des cours
	 * @param groupe
	 * 			groupe du planning selectionne
	 * @param dateDebut
	 * 			date de debut de selection
	 * @param dateFin
	 * 			date de fin de selection
	 */
	public void afficherPlanning(int groupe, String dateDebut, String dateFin) {
		PlanningDAO planning = new PlanningDAO();
		
		try {
			planningGroupe = planning.planningGroupe(groupe, dateDebut, dateFin);
			if(planningGroupe != null) {
				((DefaultTableModel) table.getModel()).setRowCount(1);
				/**
				 * Remplissage des lignes par la liste des cours du planning de groupe
				 * avec transformation des heures decimales en heures sexagesimales
				 */
				for(int i = 0; i<planningGroupe.size(); i++) {
					double heureDebutDecimal = planningGroupe.get(i).getHeureDebut();
					double heureFinDecimal = planningGroupe.get(i).getHeureFin();
					int heureDebutHeures = (int) heureDebutDecimal;
					int heureDebutMinutes = (int) (heureDebutDecimal * 60) % 60;
					String heureDebut = String.format("%sH%s", heureDebutHeures, heureDebutMinutes);
					int heureFinHeures = (int) heureFinDecimal;
					int heureFinMinutes = (int) (heureFinDecimal * 60) % 60;
					String finDebut = String.format("%sH%s", heureFinHeures, heureFinMinutes);
					
					((DefaultTableModel) table.getModel()).addRow(
							new Object[]{Boolean.FALSE, planningGroupe.get(i).getCoursNom(), planningGroupe.get(i).getProfNom(),
									planningGroupe.get(i).getDate(), heureDebut, finDebut});
				}
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	
	public void creerLienVisio(int idCours, String lienVisio) {
		ActionsAdministratifDAO actionAdmin = new ActionsAdministratifDAO();
		try {
			int effectuee = actionAdmin.creerLienVisio(idCours, idGroupe, dateDebut, dateFin, lienVisio);
			if (effectuee == 1)
				lblNewLabel_3_2.setText("Lien visio cree !");
			else
				lblNewLabel_3_2.setText("Erreur ce cours n'existe pas !");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
