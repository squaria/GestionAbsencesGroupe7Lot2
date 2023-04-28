package ihm;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.JPanel;
import javax.swing.JTable;

import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.Color;
import dao.ActionsGestionnaireDAO;
import model.Cours;
import model.Professeur;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class GestionCoursIHM {

	private JFrame frmModificationDunCours;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_7;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_13;
	private JTextField textField_6;
	private JLabel lblNewLabel_3_2;
	private JLabel lblNewLabel_3_4;
	private JLabel lblNewLabel_3_5;
	private Cours cours = new Cours();
	private JTable table;
	private ActionsGestionnaireDAO actionGest = new ActionsGestionnaireDAO();
	private static int typeCompte;
	private static int id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestionCoursIHM window = new GestionCoursIHM(id, typeCompte);
					window.frmModificationDunCours.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GestionCoursIHM(int id, int typeCompte) {
		GestionCoursIHM.id = id;
		GestionCoursIHM.typeCompte = typeCompte;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmModificationDunCours = new JFrame();
		frmModificationDunCours.setTitle("Gestion des Cours");
		frmModificationDunCours.setBounds(100, 100, 1127, 731);
		frmModificationDunCours.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmModificationDunCours.getContentPane().setLayout(new BoxLayout(frmModificationDunCours.getContentPane(), BoxLayout.Y_AXIS));
		frmModificationDunCours.setVisible(true);
		
		JPanel panel_3 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		frmModificationDunCours.getContentPane().add(panel_3);
		
		JButton btnNewButtonRetour = new JButton("Retour");
		btnNewButtonRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(typeCompte == 1)
					new GestionnaireIHM(id);
				else if(typeCompte == 2)
					new AdministratifIHM(id);
				frmModificationDunCours.dispose();
			}
		});
		btnNewButtonRetour.setFont(new Font("Tahoma", Font.BOLD, 24));
		panel_3.add(btnNewButtonRetour);
		
		table = new JTable();
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.setRowSelectionAllowed(false);
		table.setCellSelectionEnabled(true);
		table.setColumnSelectionAllowed(true);
		table.setFont(new Font("Times New Roman", Font.BOLD, 18));
		table.setForeground(Color.DARK_GRAY);
		table.setToolTipText("");
		
		table.setModel(new DefaultTableModel(
			null,
			new String[] {
				"CHOIX", "NOM PROFESSEUR", "PRENOM PROFESSEUR", "EMAIL", "NUM TELEPHONE"
			}
			
			
		) {
			private static final long serialVersionUID = 1L;
			Class[] columnTypes = new Class[] {
				Boolean.class, Object.class, Object.class, Object.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			
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
		
		for(int i = 0; i<listeProf.size(); i++) {
			((DefaultTableModel) table.getModel()).addRow(
						new Object[]{Boolean.FALSE, listeProf.get(i).getNom(), 
								listeProf.get(i).getPrenom(), listeProf.get(i).getEmail(), 
								listeProf.get(i).getNumTelephone()});
		}
		ListSelectionModel tableSelectionModel = table.getSelectionModel();
		tableSelectionModel.setSelectionInterval(0, 0);
		table.setSelectionModel(tableSelectionModel);
		table.repaint();
		

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(table);
		scrollPane.setViewportBorder(null);
		scrollPane.setPreferredSize(new Dimension(50,40));

		frmModificationDunCours.getContentPane().add(scrollPane);
		
		
		JPanel panel_5 = new JPanel();
		frmModificationDunCours.getContentPane().add(panel_5);
		panel_5.setLayout(new FlowLayout(FlowLayout.LEADING, 5, 5));
		
		JPanel panel_13 = new JPanel();
		panel_5.add(panel_13);
		
		JLabel lblNewLabel_1_1 = new JLabel("Supprimer un cours");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel_13.add(lblNewLabel_1_1);
		
		JPanel panel_15 = new JPanel();
		panel_5.add(panel_15);
		
		JLabel lblNewLabel_2_1 = new JLabel("Nom :");
		lblNewLabel_2_1.setForeground(new Color(255, 128, 0));
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_15.add(lblNewLabel_2_1);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_6.setColumns(10);
		panel_15.add(textField_6);
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField_6.getText().length() > 0) {
					supprCours(textField_6.getText());
				} else {
					JOptionPane.showMessageDialog(new JFrame(), "Tous les champs ne sont pas completes.", "Dialog",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnSupprimer.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel_15.add(btnSupprimer);
		
		lblNewLabel_3_2 = new JLabel("");
		lblNewLabel_3_2.setForeground(Color.RED);
		lblNewLabel_3_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_15.add(lblNewLabel_3_2);
		
		JPanel panel_6 = new JPanel();
		FlowLayout flowLayout_4 = (FlowLayout) panel_6.getLayout();
		flowLayout_4.setHgap(20);
		flowLayout_4.setAlignment(FlowLayout.LEFT);
		frmModificationDunCours.getContentPane().add(panel_6);
		
		JPanel panel_10_1 = new JPanel();
		panel_6.add(panel_10_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Creer un cours");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel_10_1.add(lblNewLabel_1_2);
		
		JPanel panel_11_1 = new JPanel();
		panel_6.add(panel_11_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Nv Nom :");
		lblNewLabel_2_2.setForeground(new Color(255, 128, 0));
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_11_1.add(lblNewLabel_2_2);
		
		textField_7 = new JTextField();
		textField_7.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_7.setColumns(10);
		panel_11_1.add(textField_7);
		
		JLabel lblNewLabel_3_1 = new JLabel("(selectionner enseignant dans la table)");
		lblNewLabel_3_1.setForeground(new Color(255, 128, 0));
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_11_1.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_4_1 = new JLabel("Nv Heures Amphi :");
		lblNewLabel_4_1.setForeground(new Color(255, 128, 0));
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_11_1.add(lblNewLabel_4_1);
		
		textField_9 = new JTextField();
		textField_9.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_9.setColumns(10);
		panel_11_1.add(textField_9);
		
		JPanel panel_7 = new JPanel();
		FlowLayout flowLayout_5 = (FlowLayout) panel_7.getLayout();
		flowLayout_5.setHgap(20);
		flowLayout_5.setAlignment(FlowLayout.LEFT);
		frmModificationDunCours.getContentPane().add(panel_7);
		
		JPanel panel_12 = new JPanel();
		panel_7.add(panel_12);
		
		JLabel lblNewLabel_5_1 = new JLabel("Nv Heures Td :");
		lblNewLabel_5_1.setForeground(new Color(255, 128, 0));
		lblNewLabel_5_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_12.add(lblNewLabel_5_1);
		
		textField_10 = new JTextField();
		textField_10.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_10.setColumns(10);
		panel_12.add(textField_10);
		
		JLabel lblNewLabel_6_1 = new JLabel("Nv Heures Tp :");
		lblNewLabel_6_1.setForeground(new Color(255, 128, 0));
		lblNewLabel_6_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_12.add(lblNewLabel_6_1);
		
		textField_11 = new JTextField();
		textField_11.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_11.setColumns(10);
		panel_12.add(textField_11);
		
		JLabel lblNewLabel_7_1 = new JLabel("Nv Heures Examen :");
		lblNewLabel_7_1.setForeground(new Color(255, 128, 0));
		lblNewLabel_7_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_12.add(lblNewLabel_7_1);
		
		textField_12 = new JTextField();
		textField_12.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_12.setColumns(10);
		panel_12.add(textField_12);
		
		JPanel panel_9_1 = new JPanel();
		panel_7.add(panel_9_1);
		
		JButton btnGroupe_1 = new JButton("Creer");
		btnGroupe_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				float[] tab = new float[] {0, 0, 0, 0};
				
				String[] tabTxt = new String[] {textField_9.getText(), 
						textField_10.getText(), textField_11.getText(), 
						textField_12.getText()};
				for(int i = 0; i < 4; i++) {
					if(!tabTxt[i].equals("") && cours.isFloatHeure(tabTxt[i]))
						tab[i] = Float.parseFloat(tabTxt[i]);
				}
				
				int ligneNum = -1;
				for(int i = 0; i < table.getRowCount(); i++) {
					Boolean CaseCochee = Boolean.valueOf(table.getValueAt(i, 0).toString());
					if(CaseCochee)
						ligneNum = i;
				}
				
				if (textField_7.getText().length() > 0 && ligneNum != -1) {
					creerCours(new Cours(textField_7.getText(), ligneNum+1, tab[0], tab[1],
							tab[2], tab[3]));
				} else {
					JOptionPane.showMessageDialog(new JFrame(), "Tous les champs ne sont pas completes ou pas de professeur selectionne.", "Dialog",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnGroupe_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel_9_1.add(btnGroupe_1);
		
		lblNewLabel_3_4 = new JLabel("");
		lblNewLabel_3_4.setForeground(Color.RED);
		lblNewLabel_3_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_9_1.add(lblNewLabel_3_4);
		
		JPanel panel_1 = new JPanel();
		panel_1.setAlignmentY(Component.TOP_ALIGNMENT);
		FlowLayout flowLayout1 = (FlowLayout) panel_1.getLayout();
		flowLayout1.setHgap(20);
		flowLayout1.setAlignment(FlowLayout.LEFT);
		frmModificationDunCours.getContentPane().add(panel_1);
		
		JPanel panel_10 = new JPanel();
		panel_1.add(panel_10);
		
		JLabel lblNewLabel_1 = new JLabel("Modifier un cours");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel_10.add(lblNewLabel_1);
		
		JPanel panel_11 = new JPanel();
		panel_1.add(panel_11);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Nom :");
		lblNewLabel_2_1_1.setForeground(new Color(255, 128, 0));
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_11.add(lblNewLabel_2_1_1);
		
		textField_13 = new JTextField();
		textField_13.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_13.setColumns(10);
		panel_11.add(textField_13);
		
		JPanel panel_14 = new JPanel();
		panel_1.add(panel_14);
		
		JLabel lblNewLabel_2 = new JLabel("Nv Nom :");
		lblNewLabel_2.setForeground(new Color(255, 128, 0));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_14.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField.setColumns(10);
		panel_14.add(textField);
		
		JLabel lblNewLabel_3 = new JLabel("(selectionner enseignant dans la table)");
		lblNewLabel_3.setForeground(new Color(255, 128, 0));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_14.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Nv Heures Amphi :");
		lblNewLabel_4.setForeground(new Color(255, 128, 0));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_14.add(lblNewLabel_4);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_2.setColumns(10);
		panel_14.add(textField_2);
		
		JPanel panel_31 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_31.getLayout();
		flowLayout_1.setHgap(20);
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		frmModificationDunCours.getContentPane().add(panel_31);
		
		JPanel panel = new JPanel();
		panel_31.add(panel);
		
		JLabel lblNewLabel_5 = new JLabel("Nv Heures Td :");
		lblNewLabel_5.setForeground(new Color(255, 128, 0));
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel.add(lblNewLabel_5);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_3.setColumns(10);
		panel.add(textField_3);
		
		JLabel lblNewLabel_6 = new JLabel("Nv Heures Tp :");
		lblNewLabel_6.setForeground(new Color(255, 128, 0));
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel.add(lblNewLabel_6);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_4.setColumns(10);
		panel.add(textField_4);
		
		JLabel lblNewLabel_7 = new JLabel("Nv Heures Examen :");
		lblNewLabel_7.setForeground(new Color(255, 128, 0));
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel.add(lblNewLabel_7);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_5.setColumns(10);
		panel.add(textField_5);
		
		JPanel panel_9 = new JPanel();
		panel_31.add(panel_9);
		
		JButton btnGroupe = new JButton("Modifier");
		btnGroupe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				float[] tab = new float[] {0, 0, 0, 0};
				String[] tabTxt = new String[] {textField_2.getText(), 
						textField_3.getText(), textField_4.getText(), 
						textField_5.getText()};
				for(int i = 0; i < 4; i++) {
					if(!tabTxt[i].equals("") && cours.isFloatHeure(tabTxt[i]))
						tab[i] = Float.parseFloat(tabTxt[i]);
				}
				
				int ligneNum = -1;
				for(int i = 0; i < table.getRowCount(); i++) {
					Boolean CaseCochee = Boolean.valueOf(table.getValueAt(i, 0).toString());
					if(CaseCochee)
						ligneNum = i;
				}
				
				if (textField_13.getText().length() > 0) {
					modCours(new Cours(textField.getText(), ligneNum+1, tab[0], tab[1],
							tab[2], tab[3]), textField_13.getText());
				} else {
					JOptionPane.showMessageDialog(new JFrame(), "Tous les champs ne sont pas completes ou pas de professeur selectionne.", "Dialog",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnGroupe.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel_9.add(btnGroupe);
		
		lblNewLabel_3_5 = new JLabel("");
		lblNewLabel_3_5.setForeground(Color.RED);
		lblNewLabel_3_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_9.add(lblNewLabel_3_5);
	}
	
	public void supprCours(String nomCours)
	{
		try {
			int effectuee = actionGest.supprCours(nomCours);
			if (effectuee == 1)
				lblNewLabel_3_2.setText("Cours supprime !");
			else
				lblNewLabel_3_2.setText("Erreur ce cours n'existe pas !");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
	
	public void creerCours(Cours cours) {
		try {
			int effectuee = actionGest.creerCours(cours);
			if (effectuee == 1)
				lblNewLabel_3_4.setText("Cours cree !");
			else
				lblNewLabel_3_4.setText("Erreur ce cours n'existe pas !");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void modCours(Cours cours, String nomCours) {
		try {
			int effectuee = actionGest.modCours(cours, nomCours);
			if (effectuee == 1)
				lblNewLabel_3_5.setText("Cours modifie !");
			else
				lblNewLabel_3_5.setText("Erreur ce cours n'existe pas !");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
