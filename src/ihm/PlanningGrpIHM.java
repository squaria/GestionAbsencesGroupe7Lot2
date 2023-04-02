package ihm;

import java.awt.EventQueue;
import java.awt.Font;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.PlanningDAO;
import model.PlanningGroupe;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;

public class PlanningGrpIHM {

	private JFrame frame;
	private JTable table;
	private static int idEtu;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PlanningGrpIHM window = new PlanningGrpIHM(idEtu);
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
	public PlanningGrpIHM(int idEtu) {
		PlanningGrpIHM.idEtu = idEtu;
		initialize();
	}

	public PlanningGrpIHM() {
		idEtu = 0;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 768, 503);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);

		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel = new JLabel("Planning Groupe");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 14));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi", "Horaires"},
				{null, null, null, null, null, "08h-08h30"},
				{null, null, null, null, null, "08h30-09h"},
				{null, null, null, null, null, "09h-09h30"},
				{null, null, null, null, null, "09h30-10h"},
				{null, null, null, null, null, "10h-10h30"},
				{null, null, null, null, null, "10h30-11h"},
				{null, null, null, null, null, "11h-11h30"},
				{null, null, null, null, null, "11h30-12h"},
				{null, null, null, null, null, "12h-12h30"},
				{null, null, null, null, null, "12h30-13h"},
				{null, null, null, null, null, "13h-13h30"},
				{null, null, null, null, null, "13h30-14h"},
				{null, null, null, null, null, "14h-14h30"},
				{null, null, null, null, null, "14h30-15h"},
				{null, null, null, null, null, "15h-15h30"},
				{null, null, null, null, null, "15h30-16h"},
				{null, null, null, null, null, "16h-16h30"},
				{null, null, null, null, null, "16h30-17h"},
				{null, null, null, null, null, "17h-17h30"},
				{null, null, null, null, null, "17h30-18h"},
				{null, null, null, null, null, "18h30-19h"},
				{null, null, null, null, null, "19h-19h30"},
			},
			new String[] {
				"Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi", "Horaires"
			})
			{
				private static final long serialVersionUID = 1L;
				Class[] columnTypes = new Class[] {
					Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class
				};
				public Class getColumnClass(int columnIndex) {
					return columnTypes[columnIndex];
				}
				
				boolean[] isCellEditable = new boolean[]{
	                    false, false, false, false, false, false
	            };

	            public boolean isCellEditable(int rowIndex, int columnIndex) {
	                return isCellEditable[columnIndex];
	            }
			});
		
		PlanningDAO planDAO = new PlanningDAO();
		ArrayList<PlanningGroupe> listeCours = null;
		try {
			if(idEtu != 0)
				listeCours = planDAO.listeCoursGroupe(planDAO.getGroupeEtudiant(idEtu));
		} catch (Exception e) {
			e.printStackTrace();
		}
		for(int i = 0; i<listeCours.size(); i++) {
			for(int j = 0; j < 5; j++) {
				for(int k = 0; k < 22; k++) {
					if(listeCours.get(i).getJour() == j && Math.floor(listeCours.get(i).getHeureDebut()) == k)
						((DefaultTableModel) table.getModel()).setValueAt(listeCours.get(i).getCoursNom(), k, j);
				}
			}
			
		}
		
		table.setBounds(46, 67, 634, 372);
		frame.getContentPane().add(table);
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
		panel_1.add(table);
	}
}
