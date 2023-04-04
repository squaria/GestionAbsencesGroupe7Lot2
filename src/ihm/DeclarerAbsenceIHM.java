package ihm;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
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

public class DeclarerAbsenceIHM {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private static int coursId;
	private ActionsProfesseurDAO actionProf = new ActionsProfesseurDAO();
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeclarerAbsenceIHM window = new DeclarerAbsenceIHM(coursId);
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
	public DeclarerAbsenceIHM(int coursId) {
		DeclarerAbsenceIHM.coursId = coursId;
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
		/*
		ArrayList<Absence> listeAbsences = null;
		try {
			listeAbsences = actionAdmin.listeAbsencesAdmin();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/
		
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
		/*
		table = new JTable();
		table.setCellSelectionEnabled(true);
		table.setColumnSelectionAllowed(false);
		table.setFont(new Font("Times New Roman", Font.BOLD, 18));
		table.setForeground(Color.DARK_GRAY);
		table.setToolTipText("");
		table.setDragEnabled(true);
		
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{Boolean.FALSE, "DATE", "NBHEURES", "NOM ETUDIANT", "PRENOM ETUDIANT", "COURS", "TYPE", "JUSTIFICATIF", "VALIDEE ADMIN"},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column"
			}
			
			
		) {
			private static final long serialVersionUID = 1L;
			Class[] columnTypes = new Class[] {
				Boolean.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			
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
		
		for(int i = 0; i<listeEtudiant.size(); i++) {
			((DefaultTableModel) table.getModel()).addRow(
						new Object[]{Boolean.FALSE, listeAbsences.get(i).getDate(), listeAbsences.get(i).getNbHeures(),
									listeAbsences.get(i).getNomEtu(), listeAbsences.get(i).getPrenomEtu(), 
									listeAbsences.get(i).getNomCours(), listeAbsences.get(i).getType(),
									listeAbsences.get(i).getJustificatif(), listeAbsences.get(i).getValideeAdmin()});
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
		*/
		JPanel panel_13 = new JPanel();
		panel_5.add(panel_13);
		
		JLabel lblNewLabel_1_1 = new JLabel("Declarer une absence");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel_13.add(lblNewLabel_1_1);
		
		JPanel panel_15 = new JPanel();
		panel_5.add(panel_15);
		
		JLabel lblNewLabel_2_1 = new JLabel("Nombre d'heures d'absence :");
		lblNewLabel_2_1.setForeground(new Color(255, 128, 0));
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_15.add(lblNewLabel_2_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField.setColumns(10);
		panel_15.add(textField);
		
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
				if (textField.getText().length() > 0 && textField_1.getText().length() > 0) {
					DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
					LocalDate localDate = LocalDate.now();
					System.out.println(dtf.format(localDate));
					creerAbsence(new Absence(dtf.format(localDate), 
							Float.valueOf(textField.getText()), coursId, textField_1.getText(), null, null));
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
