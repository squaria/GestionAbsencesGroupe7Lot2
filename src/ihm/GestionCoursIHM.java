package ihm;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.Color;
import dao.ActionsGestionnaireDAO;
import model.Cours;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GestionCoursIHM {

	private JFrame frmModificationDunCours;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_13;
	private JTextField textField_6;
	private JLabel lblNewLabel_3_2;
	private JLabel lblNewLabel_3_4;
	private JLabel lblNewLabel_3_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestionCoursIHM window = new GestionCoursIHM();
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
	public GestionCoursIHM() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmModificationDunCours = new JFrame();
		frmModificationDunCours.setTitle("Gestion des Cours");
		frmModificationDunCours.setBounds(100, 100, 1127, 731);
		frmModificationDunCours.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmModificationDunCours.getContentPane().setLayout(new BoxLayout(frmModificationDunCours.getContentPane(), BoxLayout.Y_AXIS));
		frmModificationDunCours.setVisible(true);
		JPanel panel_4 = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panel_4.getLayout();
		flowLayout_2.setHgap(500);
		frmModificationDunCours.getContentPane().add(panel_4);
		
		JPanel panel_2 = new JPanel();
		panel_4.add(panel_2);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Gestion des cours");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 45));
		panel_2.add(lblNewLabel_1_1_1);
		
		JPanel panel_5 = new JPanel();
		frmModificationDunCours.getContentPane().add(panel_5);
		panel_5.setLayout(new FlowLayout(FlowLayout.LEADING, 5, 5));
		
		JPanel panel_13 = new JPanel();
		panel_5.add(panel_13);
		
		JLabel lblNewLabel_1_1 = new JLabel("Supprimer un cours");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel_13.add(lblNewLabel_1_1);
		
		JPanel panel_15 = new JPanel();
		panel_5.add(panel_15);
		
		JLabel lblNewLabel_2_1 = new JLabel("Nom :");
		lblNewLabel_2_1.setForeground(new Color(255, 128, 0));
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_15.add(lblNewLabel_2_1);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_6.setColumns(10);
		panel_15.add(textField_6);
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField_6.getText().length() > 0) {
					supprCours(textField_6.getText());
				} else {
					JOptionPane.showMessageDialog(new JFrame(), "Tous les champs ne sont pas completes.", "Dialog",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnSupprimer.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel_15.add(btnSupprimer);
		
		lblNewLabel_3_2 = new JLabel("");
		lblNewLabel_3_2.setForeground(Color.RED);
		lblNewLabel_3_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_15.add(lblNewLabel_3_2);
		
		JPanel panel_6 = new JPanel();
		FlowLayout flowLayout_4 = (FlowLayout) panel_6.getLayout();
		flowLayout_4.setHgap(20);
		flowLayout_4.setAlignment(FlowLayout.LEFT);
		frmModificationDunCours.getContentPane().add(panel_6);
		
		JPanel panel_10_1 = new JPanel();
		panel_6.add(panel_10_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Creer un cours");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel_10_1.add(lblNewLabel_1_2);
		
		JPanel panel_11_1 = new JPanel();
		panel_6.add(panel_11_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Nv Nom :");
		lblNewLabel_2_2.setForeground(new Color(255, 128, 0));
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_11_1.add(lblNewLabel_2_2);
		
		textField_7 = new JTextField();
		textField_7.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_7.setColumns(10);
		panel_11_1.add(textField_7);
		
		JLabel lblNewLabel_3_1 = new JLabel("Nv Enseignant :");
		lblNewLabel_3_1.setForeground(new Color(255, 128, 0));
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_11_1.add(lblNewLabel_3_1);
		
		textField_8 = new JTextField();
		textField_8.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_8.setColumns(10);
		panel_11_1.add(textField_8);
		
		JLabel lblNewLabel_4_1 = new JLabel("Nv Reference du planning :");
		lblNewLabel_4_1.setForeground(new Color(255, 128, 0));
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_11_1.add(lblNewLabel_4_1);
		
		textField_9 = new JTextField();
		textField_9.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_9.setColumns(10);
		panel_11_1.add(textField_9);
		
		JPanel panel_7 = new JPanel();
		FlowLayout flowLayout_5 = (FlowLayout) panel_7.getLayout();
		flowLayout_5.setHgap(20);
		flowLayout_5.setAlignment(FlowLayout.LEFT);
		frmModificationDunCours.getContentPane().add(panel_7);
		
		JPanel panel_12 = new JPanel();
		panel_7.add(panel_12);
		
		JLabel lblNewLabel_5_1 = new JLabel("Nv Numero du groupe :");
		lblNewLabel_5_1.setForeground(new Color(255, 128, 0));
		lblNewLabel_5_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_12.add(lblNewLabel_5_1);
		
		textField_10 = new JTextField();
		textField_10.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_10.setColumns(10);
		panel_12.add(textField_10);
		
		JLabel lblNewLabel_6_1 = new JLabel("Nv Heures Amphi/ Examen :");
		lblNewLabel_6_1.setForeground(new Color(255, 128, 0));
		lblNewLabel_6_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_12.add(lblNewLabel_6_1);
		
		textField_11 = new JTextField();
		textField_11.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_11.setColumns(10);
		panel_12.add(textField_11);
		
		JLabel lblNewLabel_7_1 = new JLabel("Nv Heures Td/Tp :");
		lblNewLabel_7_1.setForeground(new Color(255, 128, 0));
		lblNewLabel_7_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_12.add(lblNewLabel_7_1);
		
		textField_12 = new JTextField();
		textField_12.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_12.setColumns(10);
		panel_12.add(textField_12);
		
		JPanel panel_9_1 = new JPanel();
		panel_7.add(panel_9_1);
		
		JButton btnGroupe_1 = new JButton("Creer");
		btnGroupe_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				float[] tab = new float[] {0, 0, 0, 0};
				
				String[] tabTxt = new String[] {textField_9.getText(), 
						textField_10.getText(), textField_11.getText(), 
						textField_12.getText()};
				for(int i = 0; i < 4; i++) {
					if(!tabTxt[i].equals(""))
						tab[i] = Float.parseFloat(tabTxt[i]);
				}
				
				if (textField_7.getText().length() > 0 && textField_8.getText().length() > 0) {
					creerCours(new Cours(textField_7.getText(), Integer.parseInt(textField_8.getText()), tab[0], tab[1],
							tab[2], tab[3]));
				} else {
					JOptionPane.showMessageDialog(new JFrame(), "Tous les champs ne sont pas completes.", "Dialog",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnGroupe_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel_9_1.add(btnGroupe_1);
		
		lblNewLabel_3_4 = new JLabel("");
		lblNewLabel_3_4.setForeground(Color.RED);
		lblNewLabel_3_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_9_1.add(lblNewLabel_3_4);
		
		JPanel panel_1 = new JPanel();
		panel_1.setAlignmentY(Component.TOP_ALIGNMENT);
		FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
		flowLayout.setHgap(20);
		flowLayout.setAlignment(FlowLayout.LEFT);
		frmModificationDunCours.getContentPane().add(panel_1);
		
		JPanel panel_10 = new JPanel();
		panel_1.add(panel_10);
		
		JLabel lblNewLabel_1 = new JLabel("Modifier un cours");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel_10.add(lblNewLabel_1);
		
		JPanel panel_11 = new JPanel();
		panel_1.add(panel_11);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Nom :");
		lblNewLabel_2_1_1.setForeground(new Color(255, 128, 0));
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_11.add(lblNewLabel_2_1_1);
		
		textField_13 = new JTextField();
		textField_13.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_13.setColumns(10);
		panel_11.add(textField_13);
		
		JPanel panel_14 = new JPanel();
		panel_1.add(panel_14);
		
		JLabel lblNewLabel_2 = new JLabel("Nv Nom :");
		lblNewLabel_2.setForeground(new Color(255, 128, 0));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_14.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField.setColumns(10);
		panel_14.add(textField);
		
		JLabel lblNewLabel_3 = new JLabel("Nv Enseignant :");
		lblNewLabel_3.setForeground(new Color(255, 128, 0));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_14.add(lblNewLabel_3);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_1.setColumns(10);
		panel_14.add(textField_1);
		
		JLabel lblNewLabel_4 = new JLabel("Nv Reference du planning :");
		lblNewLabel_4.setForeground(new Color(255, 128, 0));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_14.add(lblNewLabel_4);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_2.setColumns(10);
		panel_14.add(textField_2);
		
		JPanel panel_3 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_3.getLayout();
		flowLayout_1.setHgap(20);
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		frmModificationDunCours.getContentPane().add(panel_3);
		
		JPanel panel = new JPanel();
		panel_3.add(panel);
		
		JLabel lblNewLabel_5 = new JLabel("Nv Numero du groupe :");
		lblNewLabel_5.setForeground(new Color(255, 128, 0));
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel.add(lblNewLabel_5);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_3.setColumns(10);
		panel.add(textField_3);
		
		JLabel lblNewLabel_6 = new JLabel("Nv Heures Amphi/ Examen :");
		lblNewLabel_6.setForeground(new Color(255, 128, 0));
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel.add(lblNewLabel_6);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_4.setColumns(10);
		panel.add(textField_4);
		
		JLabel lblNewLabel_7 = new JLabel("Nv Heures Td/Tp :");
		lblNewLabel_7.setForeground(new Color(255, 128, 0));
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel.add(lblNewLabel_7);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_5.setColumns(10);
		panel.add(textField_5);
		
		JPanel panel_9 = new JPanel();
		panel_3.add(panel_9);
		
		JButton btnGroupe = new JButton("Modifier");
		btnGroupe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				float[] tab = new float[] {0, 0, 0, 0};
				int profId = 0;
				if(!textField_1.getText().equals(""))
					profId = Integer.parseInt(textField_1.getText());
				String[] tabTxt = new String[] {textField_2.getText(), 
						textField_3.getText(), textField_4.getText(), 
						textField_5.getText()};
				for(int i = 0; i < 4; i++) {
					if(!tabTxt[i].equals(""))
						tab[i] = Float.parseFloat(tabTxt[i]);
				}
				
				if (textField_13.getText().length() > 0) {
					modCours(new Cours(textField.getText(), profId, tab[0], tab[1],
							tab[2], tab[3]), textField_13.getText());
				} else {
					JOptionPane.showMessageDialog(new JFrame(), "Tous les champs ne sont pas completes.", "Dialog",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnGroupe.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel_9.add(btnGroupe);
		
		lblNewLabel_3_5 = new JLabel("");
		lblNewLabel_3_5.setForeground(Color.RED);
		lblNewLabel_3_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_9.add(lblNewLabel_3_5);
	}
	
	public void supprCours(String nomCours)
	{
		ActionsGestionnaireDAO actionGest = new ActionsGestionnaireDAO();
		try {
			int effectuee = actionGest.supprCours(nomCours);
			if (effectuee == 1)
				lblNewLabel_3_2.setText("Cours supprime !");
			else
				lblNewLabel_3_2.setText("Erreur ce cours n'existe pas !");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
	
	public void creerCours(Cours cours) {
		ActionsGestionnaireDAO actionGest = new ActionsGestionnaireDAO();
		try {
			int effectuee = actionGest.creerCours(cours);
			if (effectuee == 1)
				lblNewLabel_3_4.setText("Cours cree !");
			else
				lblNewLabel_3_4.setText("Erreur ce cours n'existe pas !");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void modCours(Cours cours, String nomCours) {
		ActionsGestionnaireDAO actionGest = new ActionsGestionnaireDAO();
		try {
			int effectuee = actionGest.modCours(cours, nomCours);
			if (effectuee == 1)
				lblNewLabel_3_2.setText("Cours modifie !");
			else
				lblNewLabel_3_2.setText("Erreur ce cours n'existe pas !");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
