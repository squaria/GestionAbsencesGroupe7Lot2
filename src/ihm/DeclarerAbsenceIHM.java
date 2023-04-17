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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import dao.ActionsProfesseurDAO;
import model.Absence;
import model.Etudiant;
import model.Note;

public class DeclarerAbsenceIHM {

	private JFrame frame;
	private static int coursId;
	private ActionsProfesseurDAO actionProf = new ActionsProfesseurDAO();
	private JTable table;
	private JLabel lblNewLabel_3_2;
	private JLabel lblNewLabel_3_3;
	private static float nbHeures;
	private static int groupe;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeclarerAbsenceIHM window = new DeclarerAbsenceIHM(coursId, nbHeures, groupe);
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
	public DeclarerAbsenceIHM(int coursId, float nbHeures, int groupe) {
		DeclarerAbsenceIHM.coursId = coursId;
		DeclarerAbsenceIHM.nbHeures = nbHeures;
		DeclarerAbsenceIHM.groupe = groupe;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Gestion des Cours");
		frame.setBounds(100, 100, 1427, 731);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
		frame.setVisible(true);
		
		ArrayList<Etudiant> listeEtudiant = null;
		try {
			listeEtudiant = actionProf.listeEtudiant(groupe);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		JPanel panel_4 = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panel_4.getLayout();
		flowLayout_2.setHgap(500);
		frame.getContentPane().add(panel_4);
		
		JPanel panel_2 = new JPanel();
		panel_4.add(panel_2);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Declarer une absence pour un cours");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 45));
		panel_2.add(lblNewLabel_1_1_1);
		
		JPanel panel_5 = new JPanel();
		frame.getContentPane().add(panel_5);
		panel_5.setLayout(new FlowLayout(FlowLayout.LEADING, 60, 5));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		frame.getContentPane().add(panel);
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
				{Boolean.FALSE, "NOM ETUDIANT", "PRENOM ETUDIANT", "EMAIL", "FILIERE", "GROUPE"},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column", "New column"
			}
			
			
		) {
			private static final long serialVersionUID = 1L;
			Class[] columnTypes = new Class[] {
				Boolean.class, Object.class, Object.class, Object.class, Object.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			
			boolean[] isCellEditable = new boolean[]{
                true, false, false, false, false, false
			};

	        public boolean isCellEditable(int rowIndex, int columnIndex) {
	            return isCellEditable[columnIndex];
	        }
        });
		
		for(int i = 0; i<listeEtudiant.size(); i++) {
			((DefaultTableModel) table.getModel()).addRow(
						new Object[]{Boolean.FALSE, listeEtudiant.get(i).getNom(), 
								listeEtudiant.get(i).getPrenom(), listeEtudiant.get(i).getEmail(),
								listeEtudiant.get(i).getFiliere(), listeEtudiant.get(i).getGroupe()});
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
		
		
		JPanel panel_13 = new JPanel();
		panel_5.add(panel_13);
		
		JLabel lblNewLabel_1_1 = new JLabel("Declarer une absence");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel_13.add(lblNewLabel_1_1);
		
		JPanel panel_15 = new JPanel();
		panel_5.add(panel_15);
		
		JButton btnDeclarer = new JButton("Declarer Absence Classique");
		btnDeclarer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				declarer("Classique");
			}
		});
		btnDeclarer.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel_5.add(btnDeclarer);
		
		JPanel panel_1 = new JPanel();
		panel_5.add(panel_1);
		
		JButton btnSupprimer = new JButton("Declarer Absence Physique");
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				declarer("Physique");
			}
		});
		btnSupprimer.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel_1.add(btnSupprimer);
		
		lblNewLabel_3_2 = new JLabel("");
		lblNewLabel_3_2.setForeground(Color.RED);
		lblNewLabel_3_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_1.add(lblNewLabel_3_2);
		
		lblNewLabel_3_3 = new JLabel("");
		lblNewLabel_3_3.setForeground(Color.RED);
		lblNewLabel_3_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_1.add(lblNewLabel_3_3);
		
	}

	public void creerAbsence(Absence absence) {
		
		try {
			int effectuee = actionProf.creerAbsence(absence);
			if (effectuee == 1)
				lblNewLabel_3_2.setText("Absence cree !");
			else
				lblNewLabel_3_2.setText("Erreur cet etudiant n'existe pas !");
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	
	public void noteZero(Note note) {
			try {
				int effectuee = actionProf.noteZero(note);
				if (effectuee == 1)
					lblNewLabel_3_3.setText("Note mise a zero !");
				else
					lblNewLabel_3_3.setText("Erreur !");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
	}

	public void declarer(String type) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate localDate = LocalDate.now();
		int ligneNum = -1;
		for(int i = 0; i < table.getRowCount(); i++) {
			Boolean CaseCochee = Boolean.valueOf(table.getValueAt(i, 0).toString());
			if(CaseCochee) {
				ligneNum = i;
				creerAbsence(new Absence(dtf.format(localDate), 
						nbHeures, coursId, type, null, null));
				noteZero(new Note(ligneNum, coursId, 0, dtf.format(localDate)));
			}
		}
		if(ligneNum == -1)
			JOptionPane.showMessageDialog(new JFrame(), "Vous n'avez pas coche d'etudiant.", "Dialog",
					JOptionPane.ERROR_MESSAGE);
	}
}
