package ihm;

import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JButton;

import java.awt.Color;
import dao.ActionsGestionnaireDAO;
import model.Cours;
import model.Groupe;
import net.miginfocom.swing.MigLayout;

public class CreerGroupeEtuIHM {

	private JFrame frmModificationDunCours;
	
	private ActionsGestionnaireDAO actionGest = new ActionsGestionnaireDAO();

	private JLabel lblNewLabel_3_4;

	private JTextField textField;

	private JTextField textField_1;
	private static int id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreerGroupeEtuIHM window = new CreerGroupeEtuIHM(id);
					window.frmModificationDunCours.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CreerGroupeEtuIHM(int id) {
		CreerGroupeEtuIHM.id = id;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmModificationDunCours = new JFrame();
		frmModificationDunCours.setTitle("Creer groupe etudiant");
		frmModificationDunCours.setBounds(100, 100, 600, 300);
		frmModificationDunCours.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmModificationDunCours.getContentPane().setLayout(new BoxLayout(frmModificationDunCours.getContentPane(), BoxLayout.Y_AXIS));
		frmModificationDunCours.setVisible(true);
		
		JPanel panel_3 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		frmModificationDunCours.getContentPane().add(panel_3);
		
		JButton btnNewButtonRetour = new JButton("Retour");
		btnNewButtonRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new GestionnaireIHM(id);
				frmModificationDunCours.dispose();
			}
		});
		btnNewButtonRetour.setFont(new Font("Tahoma", Font.BOLD, 24));
		panel_3.add(btnNewButtonRetour);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		frmModificationDunCours.getContentPane().add(panel);
		panel.setLayout(new MigLayout("", "[228px][5px][53px][5px][10px][5px][3px][5px][154px]", "[29px][28px][28px][][][]"));
		
		JLabel lblNewLabel_2 = new JLabel("Creer un groupe d'etudiant");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel.add(lblNewLabel_2, "cell 0 0 3 1,alignx left,aligny top");
		
		JLabel lblNewLabel = new JLabel("Numero du groupe :");
		lblNewLabel.setForeground(new Color(255, 128, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel.add(lblNewLabel, "flowx,cell 0 1 3 1,alignx left,aligny center");
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField.setColumns(10);
		panel.add(textField, "cell 8 1,alignx right,aligny top");
		
		
		JLabel lblNewLabel_1 = new JLabel("Capacite max du groupe :");
		lblNewLabel_1.setForeground(new Color(255, 128, 0));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel.add(lblNewLabel_1, "cell 0 3,alignx left,aligny center");
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_1.setColumns(10);
		panel.add(textField_1, "cell 8 3,alignx right,aligny top");
		
		JButton btnGroupe_1 = new JButton("Creer");
		btnGroupe_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField.getText().length() > 0 && textField_1.getText().length() > 0 &&
						isIntNumGrp(textField.getText())) {
					try {
						if(!actionGest.isGrpDejaCree(Integer.parseInt(textField.getText())))
							creerGroupe(new Groupe(Integer.parseInt(textField.getText()),
										Integer.parseInt(textField_1.getText())));
						else
							lblNewLabel_3_4.setText("Ce groupe existe deja !");
					}
					catch (Exception e1) {
						e1.printStackTrace();
					}
				} else {
					JOptionPane.showMessageDialog(new JFrame(), "Tous les champs ne sont pas completes ou ne sont pas des entiers.", "Dialog",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnGroupe_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel.add(btnGroupe_1, "cell 2 4");
		
		lblNewLabel_3_4 = new JLabel("");
		lblNewLabel_3_4.setForeground(Color.RED);
		lblNewLabel_3_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel.add(lblNewLabel_3_4, "cell 8 5,alignx left,aligny center");
		
	}
	
	public void creerGroupe(Groupe groupe) {
		try {
			int effectuee = actionGest.creerGroupe(groupe);
			if (effectuee == 1)
				lblNewLabel_3_4.setText("Groupe cree !");
			else
				lblNewLabel_3_4.setText("Erreur ce cours n'existe pas !");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean isIntNumGrp(String text) {
		boolean isNum = true;
		try {
			Integer.parseInt(text);
		}
		catch (NumberFormatException e) {
			isNum = false;
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return isNum;
	}
	
}
