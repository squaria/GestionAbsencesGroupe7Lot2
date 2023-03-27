package ihm;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GestionProfilProfesseurIHM {
	private JFrame frmMenuPrincipalAdmin;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_3;
	private JTextField textField_4;
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

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestionProfilProfesseurIHM window = new GestionProfilProfesseurIHM();
					window.frmMenuPrincipalAdmin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the application.
	 */
	public GestionProfilProfesseurIHM() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMenuPrincipalAdmin = new JFrame();
		frmMenuPrincipalAdmin.setVisible(true);
		frmMenuPrincipalAdmin.setTitle("Gestion Profil - Etudiant");
		frmMenuPrincipalAdmin.setBounds(100, 100, 1258, 1079);
		frmMenuPrincipalAdmin.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmMenuPrincipalAdmin.getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 128, 255));
		frmMenuPrincipalAdmin.getContentPane().add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 500, 20));
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(0, 128, 255));
		panel.add(panel_6);
		
		JLabel lblNewLabel = new JLabel("Gestion Profil Professeur");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 45));
		panel_6.add(lblNewLabel);
		
		JPanel panel_7_2 = new JPanel();
		panel_7_2.setBackground(new Color(0, 128, 255));
		panel.add(panel_7_2);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Supprimer un profil professeur");
		lblNewLabel_1_1_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel_7_2.add(lblNewLabel_1_1_2);
		
		JPanel panel_2_1_2 = new JPanel();
		panel_2_1_2.setBackground(new Color(0, 128, 255));
		panel.add(panel_2_1_2);
		panel_2_1_2.setLayout(new FlowLayout(FlowLayout.LEFT, 6, 6));
		
		JLabel lblNewLabel_2_5_2 = new JLabel("Nom : ");
		lblNewLabel_2_5_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2_5_2.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel_2_1_2.add(lblNewLabel_2_5_2);
		
		textField_18 = new JTextField();
		textField_18.setColumns(20);
		panel_2_1_2.add(textField_18);
		
		JLabel lblNewLabel_2_1_1_2 = new JLabel("Prenom : ");
		lblNewLabel_2_1_1_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel_2_1_2.add(lblNewLabel_2_1_1_2);
		
		textField_19 = new JTextField();
		textField_19.setColumns(20);
		panel_2_1_2.add(textField_19);
		
		JLabel lblNewLabel_2_3_1_2 = new JLabel("Email : ");
		lblNewLabel_2_3_1_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2_3_1_2.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel_2_1_2.add(lblNewLabel_2_3_1_2);
		
		textField_20 = new JTextField();
		textField_20.setColumns(20);
		panel_2_1_2.add(textField_20);
		
		JButton btnNewButton_2_1_1_2 = new JButton("Supprimer");
		btnNewButton_2_1_1_2.setForeground(Color.BLACK);
		btnNewButton_2_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel_2_1_2.add(btnNewButton_2_1_1_2);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(0, 128, 255));
		frmMenuPrincipalAdmin.getContentPane().add(panel_5);
		panel_5.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 20));
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(new Color(0, 128, 255));
		panel_5.add(panel_8);
		
		JLabel lblNewLabel_1 = new JLabel("Creer nouveau profil professeur");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel_8.add(lblNewLabel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 128, 255));
		panel_5.add(panel_2);
		panel_2.setLayout(new FlowLayout(FlowLayout.LEFT, 6, 6));
		
		JLabel lblNewLabel_2 = new JLabel("Nom : ");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel_2.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setColumns(20);
		panel_2.add(textField);
		
		JLabel lblNewLabel_2_1 = new JLabel("Prenom : ");
		lblNewLabel_2_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel_2.add(lblNewLabel_2_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(20);
		panel_2.add(textField_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Mot de passe : ");
		lblNewLabel_2_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel_2.add(lblNewLabel_2_2);
		
		textField_2 = new JTextField();
		textField_2.setColumns(30);
		panel_2.add(textField_2);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBackground(new Color(0, 128, 255));
		panel_5.add(panel_9);
		
		JLabel lblNewLabel_2_3 = new JLabel("Email : ");
		lblNewLabel_2_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_2_3.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel_9.add(lblNewLabel_2_3);
		
		textField_3 = new JTextField();
		textField_3.setColumns(20);
		panel_9.add(textField_3);
		
		JLabel lblNewLabel_2_4 = new JLabel("Numero de telephone : ");
		lblNewLabel_2_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_2_4.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel_9.add(lblNewLabel_2_4);
		
		textField_4 = new JTextField();
		textField_4.setColumns(20);
		panel_9.add(textField_4);
		
		JButton btnNewButton_2_1 = new JButton("Créer");
		btnNewButton_2_1.setForeground(Color.BLACK);
		btnNewButton_2_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel_9.add(btnNewButton_2_1);
		
		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_1.getLayout();
		flowLayout_1.setVgap(20);
		panel_1.setBackground(new Color(0, 128, 255));
		frmMenuPrincipalAdmin.getContentPane().add(panel_1);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(new Color(0, 128, 255));
		panel_1.add(panel_7);
		
		JLabel lblNewLabel_1_1 = new JLabel("Afficher un profil professeur");
		lblNewLabel_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel_7.add(lblNewLabel_1_1);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBackground(new Color(0, 128, 255));
		panel_1.add(panel_2_1);
		panel_2_1.setLayout(new FlowLayout(FlowLayout.LEFT, 6, 6));
		
		JLabel lblNewLabel_2_5 = new JLabel("Nom : ");
		lblNewLabel_2_5.setForeground(new Color(255, 255, 255));
		lblNewLabel_2_5.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel_2_1.add(lblNewLabel_2_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(20);
		panel_2_1.add(textField_6);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Prenom : ");
		lblNewLabel_2_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel_2_1.add(lblNewLabel_2_1_1);
		
		textField_7 = new JTextField();
		textField_7.setColumns(20);
		panel_2_1.add(textField_7);
		
		JLabel lblNewLabel_2_3_1 = new JLabel("Email : ");
		lblNewLabel_2_3_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_2_3_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel_2_1.add(lblNewLabel_2_3_1);
		
		textField_8 = new JTextField();
		textField_8.setColumns(20);
		panel_2_1.add(textField_8);
		
		JButton btnNewButton_2_1_1 = new JButton("Afficher");
		btnNewButton_2_1_1.setForeground(Color.BLACK);
		btnNewButton_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel_2_1.add(btnNewButton_2_1_1);
		
		JPanel panel_3 = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panel_3.getLayout();
		flowLayout_2.setVgap(10);
		panel_3.setBackground(new Color(0, 128, 255));
		frmMenuPrincipalAdmin.getContentPane().add(panel_3);
		
		JPanel panel_7_1 = new JPanel();
		panel_7_1.setBackground(new Color(0, 128, 255));
		panel_3.add(panel_7_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Modifier un profil professeur");
		lblNewLabel_1_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel_7_1.add(lblNewLabel_1_1_1);
		
		JPanel panel_2_1_1 = new JPanel();
		panel_2_1_1.setBackground(new Color(0, 128, 255));
		panel_3.add(panel_2_1_1);
		panel_2_1_1.setLayout(new FlowLayout(FlowLayout.LEFT, 6, 6));
		
		JLabel lblNewLabel_2_5_1 = new JLabel("Nom : ");
		lblNewLabel_2_5_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_2_5_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel_2_1_1.add(lblNewLabel_2_5_1);
		
		textField_9 = new JTextField();
		textField_9.setColumns(20);
		panel_2_1_1.add(textField_9);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("Prenom : ");
		lblNewLabel_2_1_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_2_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel_2_1_1.add(lblNewLabel_2_1_1_1);
		
		textField_10 = new JTextField();
		textField_10.setColumns(20);
		panel_2_1_1.add(textField_10);
		
		JLabel lblNewLabel_2_3_1_1 = new JLabel("Email : ");
		lblNewLabel_2_3_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_2_3_1_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel_2_1_1.add(lblNewLabel_2_3_1_1);
		
		textField_11 = new JTextField();
		textField_11.setColumns(20);
		panel_2_1_1.add(textField_11);
		
		JButton btnNewButton_2_1_1_1 = new JButton("Selectionner");
		btnNewButton_2_1_1_1.setForeground(Color.BLACK);
		btnNewButton_2_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel_2_1_1.add(btnNewButton_2_1_1_1);
		
		JPanel panel_2_2 = new JPanel();
		panel_2_2.setBackground(new Color(0, 128, 255));
		panel_3.add(panel_2_2);
		panel_2_2.setLayout(new FlowLayout(FlowLayout.LEFT, 6, 6));
		
		JLabel lblNewLabel_2_6 = new JLabel("Nv Nom : ");
		lblNewLabel_2_6.setForeground(Color.WHITE);
		lblNewLabel_2_6.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel_2_2.add(lblNewLabel_2_6);
		
		textField_12 = new JTextField();
		textField_12.setColumns(20);
		panel_2_2.add(textField_12);
		
		JLabel lblNewLabel_2_1_2 = new JLabel("Nv Prenom : ");
		lblNewLabel_2_1_2.setForeground(Color.WHITE);
		lblNewLabel_2_1_2.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel_2_2.add(lblNewLabel_2_1_2);
		
		textField_13 = new JTextField();
		textField_13.setColumns(20);
		panel_2_2.add(textField_13);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("Nv Mot de passe : ");
		lblNewLabel_2_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_2_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel_2_2.add(lblNewLabel_2_2_1);
		
		textField_14 = new JTextField();
		textField_14.setColumns(30);
		panel_2_2.add(textField_14);
		
		JPanel panel_9_1 = new JPanel();
		panel_9_1.setBackground(new Color(0, 128, 255));
		panel_3.add(panel_9_1);
		
		JLabel lblNewLabel_2_3_2 = new JLabel("Nv Email : ");
		lblNewLabel_2_3_2.setForeground(Color.WHITE);
		lblNewLabel_2_3_2.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel_9_1.add(lblNewLabel_2_3_2);
		
		textField_15 = new JTextField();
		textField_15.setColumns(20);
		panel_9_1.add(textField_15);
		
		JLabel lblNewLabel_2_4_2 = new JLabel("Nv Numero de telephone : ");
		lblNewLabel_2_4_2.setForeground(Color.WHITE);
		lblNewLabel_2_4_2.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel_9_1.add(lblNewLabel_2_4_2);
		
		textField_16 = new JTextField();
		textField_16.setColumns(20);
		panel_9_1.add(textField_16);
		
		JButton btnNewButton_2_1_2 = new JButton("Modifier");
		btnNewButton_2_1_2.setForeground(Color.BLACK);
		btnNewButton_2_1_2.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel_9_1.add(btnNewButton_2_1_2);
	}
}
