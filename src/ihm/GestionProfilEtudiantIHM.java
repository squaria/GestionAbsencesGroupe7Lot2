package ihm;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dao.ActionsGestionnaireDAO;
import model.Etudiant;
import model.Profil;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Classe interface utilisateur de la gestion
 * des profils etudiant (creation, suppression, modification, affichage)
 * 
 * @author Loic OUASSA, Mael PAROT
 * @version 1.0
 */
public class GestionProfilEtudiantIHM {
	private JFrame frmMenuPrincipalEtu;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_18;
	private JTextField textField_19;
	private JTextField textField_20;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_16;
	private JTextField textField_17;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_3_1;
	private JLabel lblNewLabel_13;
	private JLabel lblNewLabel_15;
	private JLabel lblNewLabel_17;
	private JLabel lblNewLabel_19;
	private JLabel lblNewLabel_21;
	private JPanel panel_10;
	private JLabel lblNewLabel_3_2;
	private JLabel lblNewLabel_3_3;
	private JPanel panel_12;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestionProfilEtudiantIHM window = new GestionProfilEtudiantIHM();
					window.frmMenuPrincipalEtu.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the application.
	 */
	public GestionProfilEtudiantIHM() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		/**
		 * Creation de la JFrame
		 */
		frmMenuPrincipalEtu = new JFrame();
		frmMenuPrincipalEtu.setVisible(true);
		frmMenuPrincipalEtu.setTitle("Gestion Profil - Etudiant");
		frmMenuPrincipalEtu.setBounds(100, 100, 1408, 900);
		frmMenuPrincipalEtu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMenuPrincipalEtu.getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		frmMenuPrincipalEtu.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(224, 158, 60));
		frmMenuPrincipalEtu.getContentPane().add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 500, 20));
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(224, 158, 60));
		panel.add(panel_6);
		
		panel_10 = new JPanel();
		panel_10.setBackground(new Color(224, 158, 60));
		panel_6.add(panel_10);
		FlowLayout flowLayout = (FlowLayout) panel_10.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);

		/**
		 * Bouton retour pour la navigation du logiciel
		 */
		JButton btnNewButtonRetour = new JButton("Retour");
		btnNewButtonRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new GestionnaireIHM();
				frmMenuPrincipalEtu.dispose();
			}
		});
		btnNewButtonRetour.setFont(new Font("Tahoma", Font.BOLD, 24));
		panel_10.add(btnNewButtonRetour);
		
		JLabel lblNewLabel = new JLabel("Gestion Profil Etudiant");
		lblNewLabel.setForeground(new Color(45, 62, 78));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 45));
		panel_6.add(lblNewLabel);
		
		JPanel panel_7_2 = new JPanel();
		panel_7_2.setBackground(new Color(224, 158, 60));
		panel.add(panel_7_2);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Supprimer un profil etudiant");
		lblNewLabel_1_1_2.setForeground(new Color(45, 62, 78));
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel_7_2.add(lblNewLabel_1_1_2);
		
		JPanel panel_2_1_2 = new JPanel();
		panel_2_1_2.setBackground(new Color(224, 158, 60));
		panel.add(panel_2_1_2);
		panel_2_1_2.setLayout(new FlowLayout(FlowLayout.LEFT, 6, 6));
		
		JLabel lblNewLabel_2_5_2 = new JLabel("Nom : ");
		lblNewLabel_2_5_2.setForeground(new Color(45, 62, 78));
		lblNewLabel_2_5_2.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel_2_1_2.add(lblNewLabel_2_5_2);
		
		textField_18 = new JTextField();
		textField_18.setColumns(20);
		panel_2_1_2.add(textField_18);
		
		JLabel lblNewLabel_2_1_1_2 = new JLabel("Prenom : ");
		lblNewLabel_2_1_1_2.setForeground(new Color(45, 62, 78));
		lblNewLabel_2_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel_2_1_2.add(lblNewLabel_2_1_1_2);
		
		textField_19 = new JTextField();
		textField_19.setColumns(20);
		panel_2_1_2.add(textField_19);
		
		JLabel lblNewLabel_2_3_1_2 = new JLabel("Email : ");
		lblNewLabel_2_3_1_2.setForeground(new Color(45, 62, 78));
		lblNewLabel_2_3_1_2.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel_2_1_2.add(lblNewLabel_2_3_1_2);
		
		textField_20 = new JTextField();
		textField_20.setColumns(20);
		panel_2_1_2.add(textField_20);
		
		JButton btnNewButton_2_1_1_2 = new JButton("Supprimer");
		btnNewButton_2_1_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**
				 * Verification de textField non vierge 
				 * et des donnees entrees au format correct
				 */
				if (textField_18.getText().length() > 0 && textField_19.getText().length() > 0 
						&& textField_20.getText().length() > 0) {
					supprEtudiant(textField_18.getText(), textField_19.getText(), textField_20.getText());
				} else {
					JOptionPane.showMessageDialog(new JFrame(), "Tous les champs ne sont pas completes.", "Dialog",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton_2_1_1_2.setForeground(Color.BLACK);
		btnNewButton_2_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel_2_1_2.add(btnNewButton_2_1_1_2);
		
		lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setForeground(new Color(255, 0, 0));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_2_1_2.add(lblNewLabel_3);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(224, 158, 60));
		frmMenuPrincipalEtu.getContentPane().add(panel_5);
		panel_5.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 20));
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(new Color(224, 158, 60));
		panel_5.add(panel_8);
		
		JLabel lblNewLabel_1 = new JLabel("Creer nouveau profil etudiant");
		lblNewLabel_1.setForeground(new Color(45, 62, 78));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel_8.add(lblNewLabel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(224, 158, 60));
		panel_5.add(panel_2);
		panel_2.setLayout(new FlowLayout(FlowLayout.LEFT, 6, 6));
		
		JLabel lblNewLabel_2 = new JLabel("Nom : ");
		lblNewLabel_2.setForeground(new Color(45, 62, 78));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel_2.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setColumns(20);
		panel_2.add(textField);
		
		JLabel lblNewLabel_2_1 = new JLabel("Prenom : ");
		lblNewLabel_2_1.setForeground(new Color(45, 62, 78));
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel_2.add(lblNewLabel_2_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(20);
		panel_2.add(textField_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Mot de passe : ");
		lblNewLabel_2_2.setForeground(new Color(45, 62, 78));
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel_2.add(lblNewLabel_2_2);
		
		textField_2 = new JTextField();
		textField_2.setColumns(30);
		panel_2.add(textField_2);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBackground(new Color(224, 158, 60));
		panel_5.add(panel_9);
		
		JLabel lblNewLabel_2_3 = new JLabel("Email : ");
		lblNewLabel_2_3.setForeground(new Color(45, 62, 78));
		lblNewLabel_2_3.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel_9.add(lblNewLabel_2_3);
		
		textField_3 = new JTextField();
		textField_3.setColumns(20);
		panel_9.add(textField_3);
		
		JLabel lblNewLabel_2_4 = new JLabel("Numero groupe : ");
		lblNewLabel_2_4.setForeground(new Color(45, 62, 78));
		lblNewLabel_2_4.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel_9.add(lblNewLabel_2_4);
		
		textField_4 = new JTextField();
		textField_4.setColumns(12);
		panel_9.add(textField_4);
		
		JLabel lblNewLabel_2_4_1 = new JLabel("Filiere (Classique/Apprentissage) : ");
		lblNewLabel_2_4_1.setForeground(new Color(45, 62, 78));
		lblNewLabel_2_4_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel_9.add(lblNewLabel_2_4_1);
		
		textField_5 = new JTextField();
		textField_5.setColumns(12);
		panel_9.add(textField_5);
		
		JButton btnNewButton_2_1 = new JButton("Creer");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**
				 * Verification de textField non vierge 
				 * et des donnees entrees au format correct
				 */
				if (textField.getText().length() > 0 && textField_1.getText().length() > 0 
						&& textField_2.getText().length() > 0 && textField_3.getText().length() > 0
						&& textField_4.getText().length() > 0) {
					creerEtudiant(new Etudiant(textField.getText(), textField_1.getText(), textField_3.getText(),
							textField_5.getText(),Integer.parseInt(textField_4.getText())), textField_2.getText());
				} else {
					JOptionPane.showMessageDialog(new JFrame(), "Tous les champs ne sont pas completes.", "Dialog",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton_2_1.setForeground(Color.BLACK);
		btnNewButton_2_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel_9.add(btnNewButton_2_1);
		
		lblNewLabel_3_1 = new JLabel("");
		lblNewLabel_3_1.setForeground(Color.RED);
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_9.add(lblNewLabel_3_1);
		
		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_1.getLayout();
		flowLayout_1.setVgap(20);
		panel_1.setBackground(new Color(224, 158, 60));
		frmMenuPrincipalEtu.getContentPane().add(panel_1);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(new Color(224, 158, 60));
		panel_1.add(panel_7);
		
		JLabel lblNewLabel_1_1 = new JLabel("Afficher un profil etudiant");
		lblNewLabel_1_1.setForeground(new Color(45, 62, 78));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel_7.add(lblNewLabel_1_1);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBackground(new Color(224, 158, 60));
		panel_1.add(panel_2_1);
		panel_2_1.setLayout(new FlowLayout(FlowLayout.LEFT, 6, 6));
		
		JLabel lblNewLabel_2_5 = new JLabel("Nom : ");
		lblNewLabel_2_5.setForeground(new Color(45, 62, 78));
		lblNewLabel_2_5.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel_2_1.add(lblNewLabel_2_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(20);
		panel_2_1.add(textField_6);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Prenom : ");
		lblNewLabel_2_1_1.setForeground(new Color(45, 62, 78));
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel_2_1.add(lblNewLabel_2_1_1);
		
		textField_7 = new JTextField();
		textField_7.setColumns(20);
		panel_2_1.add(textField_7);
		
		JLabel lblNewLabel_2_3_1 = new JLabel("Email : ");
		lblNewLabel_2_3_1.setForeground(new Color(45, 62, 78));
		lblNewLabel_2_3_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel_2_1.add(lblNewLabel_2_3_1);
		
		textField_8 = new JTextField();
		textField_8.setColumns(20);
		panel_2_1.add(textField_8);
		
		JButton btnNewButton_2_1_1 = new JButton("Afficher");
		btnNewButton_2_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**
				 * Verification de textField non vierge 
				 * et des donnees entrees au format correct
				 */
				if (textField_6.getText().length() > 0 && textField_7.getText().length() > 0 
						&& textField_8.getText().length() > 0) {
					affEtudiant(new Profil(textField_6.getText(), textField_7.getText(), textField_8.getText()));
				} else {
					JOptionPane.showMessageDialog(new JFrame(), "Tous les champs ne sont pas completes.", "Dialog",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton_2_1_1.setForeground(Color.BLACK);
		btnNewButton_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel_2_1.add(btnNewButton_2_1_1);
		
		panel_10 = new JPanel();
		panel_10.setBackground(new Color(224, 158, 60));
		panel_1.add(panel_10);
		panel_10.setVisible(false);
		
		JLabel lblNewLabel_12 = new JLabel("Nom : ");
		lblNewLabel_12.setForeground(new Color(45, 62, 78));
		lblNewLabel_12.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel_10.add(lblNewLabel_12);
		
		lblNewLabel_13 = new JLabel("");
		lblNewLabel_13.setBackground(new Color(255, 255, 255));
		lblNewLabel_13.setForeground(new Color(45, 62, 78));
		lblNewLabel_13.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel_10.add(lblNewLabel_13);
		
		JLabel lblNewLabel_14 = new JLabel("| Prenom : ");
		lblNewLabel_14.setForeground(new Color(45, 62, 78));
		lblNewLabel_14.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel_10.add(lblNewLabel_14);
		
		lblNewLabel_15 = new JLabel("");
		lblNewLabel_15.setBackground(new Color(255, 255, 255));
		lblNewLabel_15.setForeground(new Color(45, 62, 78));
		lblNewLabel_15.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel_10.add(lblNewLabel_15);
		
		JLabel lblNewLabel_16 = new JLabel("| Email : ");
		lblNewLabel_16.setForeground(new Color(45, 62, 78));
		lblNewLabel_16.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel_10.add(lblNewLabel_16);
		
		lblNewLabel_17 = new JLabel("");
		lblNewLabel_17.setBackground(new Color(255, 255, 255));
		lblNewLabel_17.setForeground(new Color(45, 62, 78));
		lblNewLabel_17.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel_10.add(lblNewLabel_17);
		
		JLabel lblNewLabel_18 = new JLabel("| Numero groupe : ");
		lblNewLabel_18.setForeground(new Color(45, 62, 78));
		lblNewLabel_18.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel_10.add(lblNewLabel_18);
		
		lblNewLabel_19 = new JLabel("");
		lblNewLabel_19.setBackground(new Color(255, 255, 255));
		lblNewLabel_19.setForeground(new Color(45, 62, 78));
		lblNewLabel_19.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel_10.add(lblNewLabel_19);
		
		JLabel lblNewLabel_20 = new JLabel("| Filiere : ");
		lblNewLabel_20.setForeground(new Color(45, 62, 78));
		lblNewLabel_20.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel_10.add(lblNewLabel_20);
		
		lblNewLabel_21 = new JLabel("");
		lblNewLabel_21.setBackground(new Color(255, 255, 255));
		lblNewLabel_21.setForeground(new Color(45, 62, 78));
		lblNewLabel_21.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel_10.add(lblNewLabel_21);
		
		panel_12 = new JPanel();
		panel_12.setBackground(new Color(224, 158, 60));
		panel_1.add(panel_12);
		
		lblNewLabel_3_3 = new JLabel("");
		lblNewLabel_3_3.setForeground(Color.RED);
		lblNewLabel_3_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_12.add(lblNewLabel_3_3);
		
		JPanel panel_3 = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panel_3.getLayout();
		flowLayout_2.setVgap(10);
		panel_3.setBackground(new Color(224, 158, 60));
		frmMenuPrincipalEtu.getContentPane().add(panel_3);
		
		JPanel panel_7_1 = new JPanel();
		panel_7_1.setBackground(new Color(224, 158, 60));
		panel_3.add(panel_7_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Modifier un profil etudiant (entrez une ou plusieures modifications)");
		lblNewLabel_1_1_1.setForeground(new Color(45, 62, 78));
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel_7_1.add(lblNewLabel_1_1_1);
		
		JPanel panel_2_1_1 = new JPanel();
		panel_2_1_1.setBackground(new Color(224, 158, 60));
		panel_3.add(panel_2_1_1);
		panel_2_1_1.setLayout(new FlowLayout(FlowLayout.LEFT, 6, 6));
		
		JLabel lblNewLabel_2_5_1 = new JLabel("Nom : ");
		lblNewLabel_2_5_1.setForeground(new Color(45, 62, 78));
		lblNewLabel_2_5_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel_2_1_1.add(lblNewLabel_2_5_1);
		
		textField_9 = new JTextField();
		textField_9.setColumns(20);
		panel_2_1_1.add(textField_9);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("Prenom : ");
		lblNewLabel_2_1_1_1.setForeground(new Color(45, 62, 78));
		lblNewLabel_2_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel_2_1_1.add(lblNewLabel_2_1_1_1);
		
		textField_10 = new JTextField();
		textField_10.setColumns(20);
		panel_2_1_1.add(textField_10);
		
		JLabel lblNewLabel_2_3_1_1 = new JLabel("Email : ");
		lblNewLabel_2_3_1_1.setForeground(new Color(45, 62, 78));
		lblNewLabel_2_3_1_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel_2_1_1.add(lblNewLabel_2_3_1_1);
		
		textField_11 = new JTextField();
		textField_11.setColumns(20);
		panel_2_1_1.add(textField_11);
		
		JPanel panel_2_2 = new JPanel();
		panel_2_2.setBackground(new Color(224, 158, 60));
		panel_3.add(panel_2_2);
		panel_2_2.setLayout(new FlowLayout(FlowLayout.LEFT, 6, 6));
		
		JLabel lblNewLabel_2_6 = new JLabel("Nv Nom : ");
		lblNewLabel_2_6.setForeground(new Color(45, 62, 78));
		lblNewLabel_2_6.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel_2_2.add(lblNewLabel_2_6);
		
		textField_12 = new JTextField();
		textField_12.setColumns(20);
		panel_2_2.add(textField_12);
		
		JLabel lblNewLabel_2_1_2 = new JLabel("Nv Prenom : ");
		lblNewLabel_2_1_2.setForeground(new Color(45, 62, 78));
		lblNewLabel_2_1_2.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel_2_2.add(lblNewLabel_2_1_2);
		
		textField_13 = new JTextField();
		textField_13.setColumns(20);
		panel_2_2.add(textField_13);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("Nv Mot de passe : ");
		lblNewLabel_2_2_1.setForeground(new Color(45, 62, 78));
		lblNewLabel_2_2_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel_2_2.add(lblNewLabel_2_2_1);
		
		textField_14 = new JTextField();
		textField_14.setColumns(30);
		panel_2_2.add(textField_14);
		
		JPanel panel_9_1 = new JPanel();
		panel_9_1.setBackground(new Color(224, 158, 60));
		panel_3.add(panel_9_1);
		
		JLabel lblNewLabel_2_3_2 = new JLabel("Nv Email : ");
		lblNewLabel_2_3_2.setForeground(new Color(45, 62, 78));
		lblNewLabel_2_3_2.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel_9_1.add(lblNewLabel_2_3_2);
		
		textField_15 = new JTextField();
		textField_15.setColumns(20);
		panel_9_1.add(textField_15);
		
		JLabel lblNewLabel_2_4_2 = new JLabel("Nv Numero groupe : ");
		lblNewLabel_2_4_2.setForeground(new Color(45, 62, 78));
		lblNewLabel_2_4_2.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel_9_1.add(lblNewLabel_2_4_2);
		
		textField_16 = new JTextField();
		textField_16.setColumns(4);
		panel_9_1.add(textField_16);
		
		JLabel lblNewLabel_2_4_1_1 = new JLabel("Nv filiere (Classique/Apprentissage) : ");
		lblNewLabel_2_4_1_1.setForeground(new Color(45, 62, 78));
		lblNewLabel_2_4_1_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel_9_1.add(lblNewLabel_2_4_1_1);
		
		textField_17 = new JTextField();
		textField_17.setColumns(15);
		panel_9_1.add(textField_17);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(224, 158, 60));
		panel_3.add(panel_4);
		
		JButton btnNewButton_2_1_2 = new JButton("Modifier");
		btnNewButton_2_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**
				 * Verification de textField non vierge 
				 * et des donnees entrees au format correct
				 */
				if (textField_9.getText().length() > 0 && textField_10.getText().length() > 0 
						&& textField_11.getText().length() > 0) {
					int numGroupe = 0;
					if(!textField_16.getText().equals(""))
						numGroupe = Integer.parseInt(textField_16.getText());
					
					modEtudiant(new Profil(textField_9.getText(), textField_10.getText(), textField_11.getText()), 
							new Etudiant(textField_12.getText(), textField_13.getText(), textField_15.getText(),
							textField_17.getText(), numGroupe), textField_14.getText());
				} else {
					JOptionPane.showMessageDialog(new JFrame(), "Tous les champs de selection de profil ne sont pas completes.", "Dialog",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton_2_1_2.setForeground(Color.BLACK);
		btnNewButton_2_1_2.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel_4.add(btnNewButton_2_1_2);
		
		JPanel panel_11 = new JPanel();
		panel_11.setBackground(new Color(224, 158, 60));
		panel_3.add(panel_11);
		
		lblNewLabel_3_2 = new JLabel("");
		lblNewLabel_3_2.setForeground(Color.RED);
		lblNewLabel_3_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_11.add(lblNewLabel_3_2);
	}
	
	/**
	 * Methode pour la suppression d'un compte etudiant
	 * @param nom
	 * 			nom de l'etudiant
	 * @param prenom
	 * 			prenom de l'etudiant
	 * @param email
	 * 			email de l'etudiant
	 */
	public void supprEtudiant(String nom, String prenom, String email)
	{
		ActionsGestionnaireDAO actionGest = new ActionsGestionnaireDAO();
		try {
			int effectuee = actionGest.suppr(new Profil(nom, prenom, email), 0);
			if (effectuee == 1)
				lblNewLabel_3.setText("Etudiant supprime !");
			else
				lblNewLabel_3.setText("Erreur cet etudiant n'existe pas !");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
	
	/**
	 * Methode pour la creation d'un compte etudiant
	 * @param etudiant
	 * 			compte etudiant
	 * @param pwd
	 * 			mot de passe du compte
	 */
	public void creerEtudiant(Etudiant etudiant, String pwd) {
		ActionsGestionnaireDAO actionGest = new ActionsGestionnaireDAO();
		try {
			int effectuee = actionGest.creerEtudiant(etudiant, pwd);
			if (effectuee == 1)
				lblNewLabel_3_1.setText("Etudiant cree !");
			else
				lblNewLabel_3_1.setText("Erreur cet etudiant n'existe pas !");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Methode pour l'affichage du profil etudiant
	 * @param profil
	 * 			profil d'un compte
	 */
	public void affEtudiant(Profil profil) {
		ActionsGestionnaireDAO actionGest = new ActionsGestionnaireDAO();
		try {
			Etudiant etudiant = actionGest.getEtudiant(profil);
			if (etudiant != null)
			{
				lblNewLabel_13.setText(etudiant.getNom());
				lblNewLabel_15.setText(etudiant.getPrenom());
				lblNewLabel_17.setText(etudiant.getEmail());
				lblNewLabel_19.setText(String.valueOf(etudiant.getGroupe()));
				lblNewLabel_21.setText(etudiant.getFiliere());
				panel_10.setVisible(true);
				panel_12.setVisible(false);
			}
			else {
				panel_10.setVisible(false);
				panel_12.setVisible(true);
				lblNewLabel_3_3.setText("Erreur cet etudiant n'existe pas !");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Methode pour la modification d'un compte etudiant
	 * @param profil
	 * 			profil d'un compte
	 * @param etudiant
	 * 			compte etudiant
	 * @param pwd
	 * 			mot de passe du compte
	 */
	public void modEtudiant(Profil profil, Etudiant etudiant, String pwd) {
		ActionsGestionnaireDAO actionGest = new ActionsGestionnaireDAO();
		try {
			int effectuee = actionGest.modEtudiant(profil, etudiant, pwd);
			if (effectuee == 1)
				lblNewLabel_3_2.setText("Etudiant modifie !");
			else
				lblNewLabel_3_2.setText("Erreur cet etudiant n'existe pas !");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
