package ihm;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import dao.ConnexionUtilisateurDAO;
import java.awt.Color;
import javax.swing.JPasswordField;

public class ConnexionIHM extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frmConnexion;
	private JTextField textField;
	private JLabel lblNewLabel_3;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConnexionIHM window = new ConnexionIHM();
					window.frmConnexion.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ConnexionIHM() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmConnexion = new JFrame();
		frmConnexion.setTitle("Connexion");
		frmConnexion.setBounds(100, 100, 1045, 741);
		frmConnexion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmConnexion.getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 128, 255));
		frmConnexion.getContentPane().add(panel);
		FlowLayout fl_panel = new FlowLayout(FlowLayout.CENTER, 5, 5);
		panel.setLayout(fl_panel);
		
		JLabel lblNewLabel = new JLabel("Connexion");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 45));
		panel.add(lblNewLabel);
		
		JPanel panel_2 = new JPanel();
		frmConnexion.getContentPane().add(panel_2);
		panel_2.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 128, 255));
		panel_2.add(panel_1);
		
		JLabel lblNewLabel_1 = new JLabel("Email : ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		panel_1.add(lblNewLabel_1);
		
		textField = new JTextField();
		panel_1.add(textField);
		textField.setColumns(20);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(0, 128, 255));
		panel_2.add(panel_3);
		
		JLabel lblNewLabel_2 = new JLabel("Mot de passe : ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		panel_3.add(lblNewLabel_2);
		
		passwordField = new JPasswordField();
		passwordField.setColumns(20);
		panel_3.add(passwordField);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(0, 128, 255));
		panel_2.add(panel_4);
		
		JButton btnProfil = new JButton("Connexion");
		btnProfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField.getText().length() > 0 && passwordField.getPassword().length > 0) {
					connexion(textField.getText(), String.valueOf(passwordField.getPassword()));
				} else {
					JOptionPane.showMessageDialog(new JFrame(), "Vous devez entrer un email et un mot de passe.", "Dialog",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnProfil.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel_4.add(btnProfil);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(0, 128, 255));
		panel_2.add(panel_5);
		
		lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel_5.add(lblNewLabel_3);
	}
	
	public void connexion(String email, String pwd)
	{
		ConnexionUtilisateurDAO connDAO = new ConnexionUtilisateurDAO();
		int[] res = {-1,-1};
		try {
			res = connDAO.checkConnexion(email, pwd);
		} catch (Exception e) {
			e.printStackTrace();
		}
		switch(res[0]) {
		case -1:
			lblNewLabel_3.setText("Mauvais mot de passe ou email !");
			break;
		case 0:
			lblNewLabel_3.setText("Connecté en tant qu'etudiant !");
			frmConnexion.dispose();
			new EtudiantIHM(res[1]);
			break;
		case 1:
			lblNewLabel_3.setText("Connecté en tant que professeur !");
			frmConnexion.dispose();
			new EnseignantIHM(res[1]);
			break;
		case 2:
			lblNewLabel_3.setText("Connecté en tant qu'administratif !");
			frmConnexion.dispose();
			new AdministratifIHM(res[1]);
			break;
		case 3:
			lblNewLabel_3.setText("Connecté en tant que gestionnaire !");
			frmConnexion.dispose();
			new GestionnaireIHM(res[1]);
			break;
		}
	}

}


