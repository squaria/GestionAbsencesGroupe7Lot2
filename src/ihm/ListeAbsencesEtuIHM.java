package ihm;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JTable;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import dao.ActionsEtudiantDAO;
import model.Absence;

import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListeAbsencesEtuIHM {

	private JFrame frmAbsencesClassiquesEt;
	private JTable table;
	private static int id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListeAbsencesEtuIHM window = new ListeAbsencesEtuIHM(id);
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
	public ListeAbsencesEtuIHM(int id) throws Exception {
		ListeAbsencesEtuIHM.id = id;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws Exception 
	 */
	private void initialize() throws Exception {
		frmAbsencesClassiquesEt = new JFrame();
		frmAbsencesClassiquesEt.setVisible(true);
		frmAbsencesClassiquesEt.setTitle("Absences classiques et physiques");
		frmAbsencesClassiquesEt.setBounds(100, 100, 1405, 899);
		frmAbsencesClassiquesEt.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmAbsencesClassiquesEt.getContentPane().setLayout(new BoxLayout(frmAbsencesClassiquesEt.getContentPane(), BoxLayout.Y_AXIS));
		
		ActionsEtudiantDAO actionEtu = new ActionsEtudiantDAO();
		ArrayList<Absence> listeAbsences = actionEtu.listeAbsences(id);
		
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
		
		for(int i = 0; i<listeAbsences.size(); i++) {
			((DefaultTableModel) table.getModel()).addRow(new Object[]{Boolean.FALSE, listeAbsences.get(i).getDate(), listeAbsences.get(i).getNbHeures(),
									listeAbsences.get(i).getNomCours(),listeAbsences.get(i).getType(),
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
		
		JPanel panel_1 = new JPanel();
		frmAbsencesClassiquesEt.getContentPane().add(panel_1);
		
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
	}
}
