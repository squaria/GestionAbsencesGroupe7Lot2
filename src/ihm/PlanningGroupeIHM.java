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
import javax.swing.table.DefaultTableModel;

import dao.PlanningDAO;
import model.PlanningGroupe;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class PlanningGroupeIHM {

	private JFrame frmCoursNonTraites;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private ArrayList<PlanningGroupe> planningGroupe;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PlanningGroupeIHM window = new PlanningGroupeIHM();
					window.frmCoursNonTraites.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @param id 
	 * @throws Exception 
	 */
	public PlanningGroupeIHM() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws Exception 
	 */
	private void initialize() {
		frmCoursNonTraites = new JFrame();
		frmCoursNonTraites.setVisible(true);
		frmCoursNonTraites.setTitle("Planning de groupe");
		frmCoursNonTraites.setBounds(100, 100, 1409, 751);
		frmCoursNonTraites.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmCoursNonTraites.getContentPane().setLayout(new BoxLayout(frmCoursNonTraites.getContentPane(), BoxLayout.Y_AXIS));
		
		JPanel panel_2 = new JPanel();
		frmCoursNonTraites.getContentPane().add(panel_2);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.Y_AXIS));
		
		JPanel panel_4 = new JPanel();
		panel_2.add(panel_4);
		
		JLabel lblEntrezLeGroupe = new JLabel("Selection du planning :  ");
		lblEntrezLeGroupe.setForeground(Color.BLUE);
		lblEntrezLeGroupe.setFont(new Font("Times New Roman", Font.BOLD, 26));
		lblEntrezLeGroupe.setAlignmentX(0.5f);
		panel_4.add(lblEntrezLeGroupe);
		
		JLabel lblNewLabel = new JLabel("Numero groupe : ");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel_4.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField.setColumns(10);
		panel_4.add(textField);
		
		JLabel lblNewLabel_1 = new JLabel("Date de debut (JJ/MM/AAAA) : ");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel_4.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_1.setColumns(10);
		panel_4.add(textField_1);
		
		JPanel panel_3 = new JPanel();
		panel_2.add(panel_3);
		
		JLabel lblNewLabel_2 = new JLabel("Date de fin (JJ/MM/AAAA) : ");
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel_3.add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_2.setColumns(10);
		panel_3.add(textField_2);
		
		JButton btnNewButton_1 = new JButton("Afficher planning");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField.getText().length() > 0 && textField_1.getText().length() > 0 
						&& textField_2.getText().length() > 0) {
					afficherPlanning(Integer.valueOf(textField.getText()), textField_1.getText(), textField_2.getText());
				} else {
					JOptionPane.showMessageDialog(new JFrame(), "Tous les champs ne sont pas completes.", "Dialog",
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
		gbl_panel.rowHeights = new int[] {20, 0, 0};
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
				{"INTITULE", "NOM PROFESSEUR", "DATE", "DEBUT DU COURS", "FIN DU COURS"},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column"
			}
		) {
				private static final long serialVersionUID = 1L;
				Class[] columnTypes = new Class[] {
					Object.class, Object.class, Object.class, Object.class, Object.class
				};
				public Class getColumnClass(int columnIndex) {
					return columnTypes[columnIndex];
				}
				
				boolean[] isCellEditable = new boolean[]{
	                    false, false, false, false, false
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
		
		
		
	}
	
	public void afficherPlanning(int groupe, String dateDebut, String dateFin) {
		PlanningDAO planning = new PlanningDAO();
		
		try {
			((DefaultTableModel) table.getModel()).setRowCount(1);
			planningGroupe = planning.planningGroupe(groupe, dateDebut, dateFin);
			if(planningGroupe != null) {
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
							new Object[]{planningGroupe.get(i).getCoursNom(), planningGroupe.get(i).getProfNom(),
									planningGroupe.get(i).getDate(), heureDebut, finDebut});
				}
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

}
