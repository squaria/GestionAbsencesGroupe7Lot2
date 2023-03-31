package ihm;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class PlanningProfIHM {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PlanningProfIHM window = new PlanningProfIHM();
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
	public PlanningProfIHM() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 739, 489);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Planning Enseignant");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel.setBounds(303, 26, 150, 30);
		frame.getContentPane().add(lblNewLabel);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi", "Horaires", "Groupe"},
				{null, null, null, null, null, "08h-08h30", null},
				{null, null, null, null, null, "08h30-09h", null},
				{null, null, null, null, null, "09h-09h30", null},
				{null, null, null, null, null, "09h30-10h", null},
				{null, null, null, null, null, "10h-10h30", null},
				{null, null, null, null, null, "10h30-11h", null},
				{null, null, null, null, null, "11h-11h30", null},
				{null, null, null, null, null, "11h30-12h", null},
				{null, null, null, null, null, "12h-12h30", null},
				{null, null, null, null, null, "12h30-13h", null},
				{null, null, null, null, null, "13h-13h30", null},
				{null, null, null, null, null, "13h30-14h", null},
				{null, null, null, null, null, "14h-14h30", null},
				{null, null, null, null, null, "14h30-15h", null},
				{null, null, null, null, null, "15h-15h30", null},
				{null, null, null, null, null, "15h30-16h", null},
				{null, null, null, null, null, "16h-16h30", null},
				{null, null, null, null, null, "16h30-17h", null},
				{null, null, null, null, null, "17h-17h30", null},
				{null, null, null, null, null, "17h30-18h", null},
				{null, null, null, null, null, "18h30-19h", null},
				{null, null, null, null, null, "19h-19h30", null},
			},
			new String[] {
				"Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi", "Horaires", "New column"
			}
		));
		table.setBounds(46, 67, 634, 372);
		frame.getContentPane().add(table);
	}
}
