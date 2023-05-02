package ihm;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
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
import model.Note;

import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;

public class NotesEtRatrapagesEtuIHM {

	private JFrame frmAbsencesClassiquesEt;
	private JTable table;
	private JLabel lblNewLabel;
	private ActionsEtudiantDAO actionEtu = new ActionsEtudiantDAO();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NotesEtRatrapagesEtuIHM window = new NotesEtRatrapagesEtuIHM();
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
	public NotesEtRatrapagesEtuIHM() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws Exception 
	 */
	private void initialize() {
		frmAbsencesClassiquesEt = new JFrame();
		frmAbsencesClassiquesEt.setVisible(true);
		frmAbsencesClassiquesEt.setTitle("Notes et rattrapages");
		frmAbsencesClassiquesEt.setBounds(100, 100, 1400, 700);
		frmAbsencesClassiquesEt.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAbsencesClassiquesEt.getContentPane().setLayout(new BoxLayout(frmAbsencesClassiquesEt.getContentPane(), BoxLayout.Y_AXIS));
		frmAbsencesClassiquesEt.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		
		ArrayList<Note> listeNotes = null;
		try {
			listeNotes = actionEtu.listeNotes(IdEtTypeCompte.id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		

		JPanel panel_3 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		frmAbsencesClassiquesEt.getContentPane().add(panel_3);
		
		JButton btnNewButtonRetour = new JButton("Retour");
		btnNewButtonRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new EtudiantIHM();
				frmAbsencesClassiquesEt.dispose();
			}
		});
		btnNewButtonRetour.setFont(new Font("Tahoma", Font.BOLD, 24));
		panel_3.add(btnNewButtonRetour);
		
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
				{"DATE", "COURS", "VALEUR", "RATTRAPAGE DECLANCHE"}
			},
			new String[] {
				"New column", "New column", "New column", "New column"
			}
		) {
			private static final long serialVersionUID = 1L;
			Class[] columnTypes = new Class[] {
				Object.class, Object.class, Object.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			
			boolean[] isCellEditable = new boolean[]{
                    false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return isCellEditable[columnIndex];
            }
		});
		
		for(int i = 0; i<listeNotes.size(); i++) {
			((DefaultTableModel) table.getModel()).addRow(new Object[]{listeNotes.get(i).getDate(),
					listeNotes.get(i).getCoursNom(), listeNotes.get(i).getValeur(), listeNotes.get(i).getRattrapage()});
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
		
		JPanel panel_2 = new JPanel();
		frmAbsencesClassiquesEt.getContentPane().add(panel_2);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_2.add(lblNewLabel);
		
		
	}
}
