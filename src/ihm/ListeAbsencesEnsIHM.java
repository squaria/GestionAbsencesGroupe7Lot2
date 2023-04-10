package ihm;

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

import dao.ActionsProfesseurDAO;
import model.Absence;

import java.awt.Color;

public class ListeAbsencesEnsIHM {
	private JFrame frmAbsencesClassiquesEnseignant;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListeAbsencesEnsIHM window = new ListeAbsencesEnsIHM();
					window.frmAbsencesClassiquesEnseignant.setVisible(true);
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
	public ListeAbsencesEnsIHM() throws Exception {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws Exception 
	 */
	private void initialize() throws Exception {
		frmAbsencesClassiquesEnseignant = new JFrame();
		frmAbsencesClassiquesEnseignant.setVisible(true);
		frmAbsencesClassiquesEnseignant.setTitle("Absences classiques et physiques");
		frmAbsencesClassiquesEnseignant.setBounds(100, 100, 1405, 899);
		frmAbsencesClassiquesEnseignant.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmAbsencesClassiquesEnseignant.getContentPane().setLayout(new BoxLayout(frmAbsencesClassiquesEnseignant.getContentPane(), BoxLayout.Y_AXIS));
		
		ActionsProfesseurDAO actionProf = new ActionsProfesseurDAO();
		ArrayList<Absence> listeAbsencesP = actionProf.listeAbsencesProf();
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLUE);
		frmAbsencesClassiquesEnseignant.getContentPane().add(panel);
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
				{"DATE", "NBHEURES", "NOM COURS", "TYPE"},
			},
			new String[] {
				"New column", "New column", "New column", "New column"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(40);
		table.getColumnModel().getColumn(1).setPreferredWidth(60);
		table.getColumnModel().getColumn(2).setPreferredWidth(50);
		
		
		for(int i = 0; i<listeAbsencesP.size(); i++) {
			((DefaultTableModel) table.getModel()).addRow(new Object[]{Boolean.FALSE, listeAbsencesP.get(i).getDate(), listeAbsencesP.get(i).getNbHeures(),
									listeAbsencesP.get(i).getNomCours(),listeAbsencesP.get(i).getType()});
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
		
		JPanel panel_1 = new JPanel();
		frmAbsencesClassiquesEnseignant.getContentPane().add(panel_1);
		
		
		
		

	}
}

	
