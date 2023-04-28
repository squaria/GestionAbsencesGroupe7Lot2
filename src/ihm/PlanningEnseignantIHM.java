package ihm;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GraphicsConfiguration;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.regex.Pattern;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import dao.PlanningDAO;
import model.Planning;
import model.PlanningEnseignant;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class PlanningEnseignantIHM {

	private JFrame frmCoursNonTraites;
	private JTable table;
	private JTextField textField_1;
	private ArrayList<PlanningEnseignant> planningProf;
	private Planning planning = new Planning();
	private static int profId = 1;
	private float nbHeures;
	private int groupe;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PlanningEnseignantIHM window = new PlanningEnseignantIHM(profId);
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
	public PlanningEnseignantIHM(int profId) {
		PlanningEnseignantIHM.profId = profId;
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
		frmCoursNonTraites.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCoursNonTraites.getContentPane().setLayout(new BoxLayout(frmCoursNonTraites.getContentPane(), BoxLayout.Y_AXIS));
		
		JPanel panel_2 = new JPanel();
		frmCoursNonTraites.getContentPane().add(panel_2);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.Y_AXIS));
		
		JPanel panel_7 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_7.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panel_2.add(panel_7);
		
		JButton btnNewButton = new JButton("Retour");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new EnseignantIHM(profId);
				frmCoursNonTraites.dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 24));
		panel_7.add(btnNewButton);
		
		JPanel panel_4 = new JPanel();
		panel_2.add(panel_4);
		
		JLabel lblEntrezLeGroupe = new JLabel("Selection du planning :  ");
		lblEntrezLeGroupe.setForeground(Color.BLUE);
		lblEntrezLeGroupe.setFont(new Font("Times New Roman", Font.BOLD, 26));
		lblEntrezLeGroupe.setAlignmentX(0.5f);
		panel_4.add(lblEntrezLeGroupe);
		
		JLabel lblNewLabel_1 = new JLabel("Date de debut (JJ/MM/AAAA) : ");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel_4.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_1.setColumns(5);
		panel_4.add(textField_1);
		
		JLabel lblNewLabel_3 = new JLabel("/");
		lblNewLabel_3.setForeground(Color.BLACK);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel_4.add(lblNewLabel_3);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_3.setColumns(5);
		panel_4.add(textField_3);
		
		JLabel lblNewLabel_4 = new JLabel("/");
		lblNewLabel_4.setForeground(Color.BLACK);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel_4.add(lblNewLabel_4);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_4.setColumns(5);
		panel_4.add(textField_4);
		
		JPanel panel_3 = new JPanel();
		panel_2.add(panel_3);
		
		JLabel lblNewLabel_2 = new JLabel("Date de fin (JJ/MM/AAAA) : ");
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel_3.add(lblNewLabel_2);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_5.setColumns(5);
		panel_3.add(textField_5);
		
		JLabel lblNewLabel_5 = new JLabel("/");
		lblNewLabel_5.setForeground(Color.BLACK);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel_3.add(lblNewLabel_5);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_6.setColumns(5);
		panel_3.add(textField_6);
		
		JLabel lblNewLabel_6 = new JLabel("/");
		lblNewLabel_6.setForeground(Color.BLACK);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel_3.add(lblNewLabel_6);
		
		textField_7 = new JTextField();
		textField_7.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_7.setColumns(5);
		panel_3.add(textField_7);
		
		JButton btnNewButton_1 = new JButton("Afficher planning");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField_1.getText().length() > 0 && textField_3.getText().length() > 0 &&
						textField_4.getText().length() > 0 && textField_5.getText().length() > 0 &&
						textField_6.getText().length() > 0 && textField_7.getText().length() > 0 &&
						planning.isIntDay(textField_1.getText(), textField_3.getText(), textField_4.getText()) && 
						planning.intMonth(textField_3.getText()) != 0 && planning.intYear(textField_4.getText()) != 0 && 
						planning.isIntDay(textField_5.getText(), textField_5.getText(), textField_6.getText()) &&
						planning.intMonth(textField_6.getText()) != 0 && planning.intYear(textField_7.getText()) != 0 ) {
					String dateDebut = textField_1.getText() + "/" + textField_3.getText() + "/" + textField_4.getText();
					String dateFin = textField_5.getText() + "/" + textField_6.getText() + "/" + textField_7.getText();
					afficherPlanning(dateDebut, dateFin);
				} else {
					JOptionPane.showMessageDialog(new JFrame(), "Tous les champs ne sont pas completes ou ne sont pas des entiers.", "Dialog",
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
				{Boolean.FALSE, "INTITULE", "GROUPE", "DATE", "DEBUT DU COURS", "FIN DU COURS"},
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
		
		JPanel panel_1 = new JPanel();
		frmCoursNonTraites.getContentPane().add(panel_1);
		
		JButton btnNewButton_1_1 = new JButton("Declarer une absence pour ce cours");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int ligneNum = -1;
				for(int i = 0; i < table.getRowCount(); i++) {
					Boolean CaseCochee = Boolean.valueOf(table.getValueAt(i, 0).toString());
					if(CaseCochee) {
						ligneNum = i;
						nbHeures = (float) table.getValueAt(i, 5) - (float) table.getValueAt(i, 4);
						groupe =  (int) table.getValueAt(i, 2);
					}
				}
				if(ligneNum != -1)
					new DeclarerAbsenceIHM(ligneNum, nbHeures, groupe);
				else {
					JOptionPane.showMessageDialog(new JFrame(), "Vous n'avez pas coche d'absence.", "Dialog",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel_1.add(btnNewButton_1_1);
		
		
		
	}
	
	public void afficherPlanning(String dateDebut, String dateFin) {
		PlanningDAO planning = new PlanningDAO();
		
		try {
			((DefaultTableModel) table.getModel()).setRowCount(1);
			planningProf = planning.planningProf(profId, dateDebut, dateFin);
			if(planningProf != null) {
				for(int i = 0; i<planningProf.size(); i++) {
					((DefaultTableModel) table.getModel()).addRow(
							new Object[]{Boolean.FALSE, planningProf.get(i).getCoursNom(), planningProf.get(i).getGrpId(),
									planningProf.get(i).getDate(), planningProf.get(i).getHeureDebut(), planningProf.get(i).getHeureFin()});
				}
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
}
