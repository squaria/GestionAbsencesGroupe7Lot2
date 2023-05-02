package ihm;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JTable;
import javax.swing.JTextField;

import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import dao.ActionsEtudiantDAO;
import dao.ActionsProfesseurDAO;
import model.Absence;
import model.Profil;

import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;

public class ListeAbsencesEtuIHM {

	private JFrame frmAbsencesClassiquesEt;
	private JTable table;
	private JLabel lblNewLabel;
	private ActionsEtudiantDAO actionEtu = new ActionsEtudiantDAO();
	private ActionsProfesseurDAO actionProf = new ActionsProfesseurDAO();
	private ArrayList<Absence> listeAbsences = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListeAbsencesEtuIHM window = new ListeAbsencesEtuIHM();
					window.frmAbsencesClassiquesEt.setVisible(true);
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
	public ListeAbsencesEtuIHM() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws Exception 
	 */
	private void initialize() {
		frmAbsencesClassiquesEt = new JFrame();
		frmAbsencesClassiquesEt.setVisible(true);
		frmAbsencesClassiquesEt.setTitle("Absences classiques et physiques");
		frmAbsencesClassiquesEt.setBounds(100, 100, 1400, 700);
		frmAbsencesClassiquesEt.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAbsencesClassiquesEt.getContentPane().setLayout(new BoxLayout(frmAbsencesClassiquesEt.getContentPane(), BoxLayout.Y_AXIS));
		frmAbsencesClassiquesEt.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		JPanel panel_3 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		frmAbsencesClassiquesEt.getContentPane().add(panel_3);
		
		JButton btnNewButtonRetour = new JButton("Retour");
		btnNewButtonRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(IdEtTypeCompte.typeCompte == 0)
					new EtudiantIHM();
				else if(IdEtTypeCompte.typeCompte == 1)
					new EnseignantIHM();
				frmAbsencesClassiquesEt.dispose();
			}
		});
		btnNewButtonRetour.setFont(new Font("Tahoma", Font.BOLD, 24));
		panel_3.add(btnNewButtonRetour);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		frmAbsencesClassiquesEt.getContentPane().add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{182, 10, 0};
		gbl_panel.rowHeights = new int[]{10, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		table = new JTable();
		table.setCellSelectionEnabled(true);
		table.setColumnSelectionAllowed(false);
		table.setFont(new Font("Times New Roman", Font.BOLD, 18));
		table.setForeground(Color.DARK_GRAY);
		table.setToolTipText("");
		table.setDragEnabled(true);
		
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{Boolean.FALSE, "DATE", "NBHEURES", "COURS", "TYPE", "JUSTIFICATIF", "VALIDEE ADMIN"}
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column", "New column", "New column"
			}
		) {
			private static final long serialVersionUID = 1L;
			Class[] columnTypes = new Class[] {
				Boolean.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			
			boolean[] isCellEditable = new boolean[]{
                    true, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return isCellEditable[columnIndex];
            }
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(15);
		table.getColumnModel().getColumn(0).setMinWidth(5);
		table.getColumnModel().getColumn(1).setPreferredWidth(40);
		table.getColumnModel().getColumn(2).setPreferredWidth(60);
		table.getColumnModel().getColumn(3).setPreferredWidth(50);
		table.getColumnModel().getColumn(4).setPreferredWidth(40);
		table.getColumnModel().getColumn(5).setPreferredWidth(220);
		
		JPanel panel_1 = new JPanel();
		frmAbsencesClassiquesEt.getContentPane().add(panel_1);

		if(IdEtTypeCompte.typeCompte == 0) {
			try {
				listeAbsences = actionEtu.listeAbsences(IdEtTypeCompte.id);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			refresh();
			JButton btnNewButton = new JButton("Declarer une absence physique");
			btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 24));
			btnNewButton.setForeground(Color.BLACK);
			panel_1.add(btnNewButton);
			
			JButton btnNewButton_1 = new JButton("Deposer un justificatif");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int ligneNum = -1;
					for(int i = 0; i < table.getRowCount(); i++) {
						Boolean CaseCochee = Boolean.valueOf(table.getValueAt(i, 0).toString());
						if(CaseCochee)
							ligneNum = i;
					}
					if(ligneNum != -1)
						new DeposerJustificatifIHM(ligneNum);
					else {
						JOptionPane.showMessageDialog(new JFrame(), "Vous n'avez pas coche d'absence.", "Dialog",
								JOptionPane.ERROR_MESSAGE);
					}
				}
			});
			btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
			panel_1.add(btnNewButton_1);
			
			JPanel panel_2 = new JPanel();
			frmAbsencesClassiquesEt.getContentPane().add(panel_2);
			
			lblNewLabel = new JLabel("");
			lblNewLabel.setForeground(Color.RED);
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
			panel_2.add(lblNewLabel);
			
			quotaNonRespecte();
		}
		else if(IdEtTypeCompte.typeCompte == 1) {
			JLabel lblNewLabel1 = new JLabel("Entrez un etudiant :");
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
			
			JButton btnNewButton = new JButton("Selectionner");
			btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 24));
			btnNewButton.setForeground(Color.BLACK);
			panel_1.add(btnNewButton);
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (textField.getText().length() > 0 && textField1.getText().length() > 0 
							&& textField2.getText().length() > 0) {
						try {
							listeAbsences = actionProf.listeAbsencesEtu(new Profil(textField.getText(), textField1.getText(), textField2.getText()));
							refresh();
						} catch (Exception e1) {
							e1.printStackTrace();
						}
					} else {
						JOptionPane.showMessageDialog(new JFrame(), "Tous les champs ne sont pas completes.", "Dialog",
								JOptionPane.ERROR_MESSAGE);
					}
				}
			});
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

	public void quotaNonRespecte() {
		try {
			float calcul = actionEtu.quotaNonRespecte(IdEtTypeCompte.id);
			if(calcul < 20)
				lblNewLabel.setText("Vous avez " + calcul + " heures d'absence, le quota est respecte.");
			else if(calcul >= 20 && calcul < 40)
				lblNewLabel.setText("Vous avez " + calcul + " heures d'absence, le quota n'est pas respecte ! Moyenne generale - 0.1 point.");
			if(calcul >= 40 && calcul < 60)
				lblNewLabel.setText("Vous avez " + calcul + " heures d'absence, le quota n'est pas respecte ! Moyenne generale - 0.2 point.");
			if(calcul > 60)
				lblNewLabel.setText("Vous avez " + calcul + " heures d'absence, le quota n'est pas respecte ! Redoublement ou exclusion possible.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void refresh() {
		for(int i = 0; i<listeAbsences.size(); i++) {
			((DefaultTableModel) table.getModel()).addRow(new Object[]{Boolean.FALSE, listeAbsences.get(i).getDate(), listeAbsences.get(i).getNbHeures(),
									listeAbsences.get(i).getNomCours(),listeAbsences.get(i).getType(),
									listeAbsences.get(i).getJustificatif(), listeAbsences.get(i).getValideeAdmin()});
		}
	}
}
