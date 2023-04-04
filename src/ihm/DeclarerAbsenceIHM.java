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
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import dao.ActionsProfesseurDAO;
import model.Absence;
import model.Etudiant;

public class DeclarerAbsenceIHM {

	private JFrame frame;
	private JTextField textField_1;
	private static int coursId;
	private ActionsProfesseurDAO actionProf = new ActionsProfesseurDAO();
	private JTable table;
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
		frame.setBounds(100, 100, 1127, 731);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
		frame.setVisible(true);
		
		ArrayList<Etudiant> listeEtudiant = null;
		try {
			listeEtudiant = actionProf.listeEtudiant(groupe);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
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
						new Object[]{Boolean.FALSE, listeEtudiant.get(i).getNom()});
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
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Type d'absence (Classique/Physique) :");
		lblNewLabel_2_1_1.setForeground(new Color(255, 128, 0));
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_15.add(lblNewLabel_2_1_1);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_1.setColumns(10);
		panel_15.add(textField_1);
		
		JPanel panel_1 = new JPanel();
		panel_5.add(panel_1);
		
		JButton btnSupprimer = new JButton("Declarer");
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField_1.getText().length() > 0) {
					DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
					LocalDate localDate = LocalDate.now();
					System.out.println(dtf.format(localDate));
					creerAbsence(new Absence(dtf.format(localDate), 
							nbHeures, coursId, textField_1.getText(), null, null));
				} else {
					JOptionPane.showMessageDialog(new JFrame(), "Tous les champs ne sont pas completes.", "Dialog",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnSupprimer.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel_1.add(btnSupprimer);
		
		JLabel lblNewLabel_3_2 = new JLabel("");
		lblNewLabel_3_2.setForeground(Color.RED);
		lblNewLabel_3_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_1.add(lblNewLabel_3_2);
		
	}

	public void creerAbsence(Absence absence) {
		
		
	}

}
