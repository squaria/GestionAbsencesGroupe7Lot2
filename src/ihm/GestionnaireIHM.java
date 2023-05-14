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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Classe interface utilisateur du menu d'un compte gestionnaire
 * 
 * @author Loic OUASSA, Mael PAROT
 * @version 1.0
 */
public class GestionnaireIHM {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestionnaireIHM window = new GestionnaireIHM();
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
	public GestionnaireIHM() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		/**
		 * Creation de la JFrame
		 */
		frame = new JFrame();
		frame.setVisible(true);
		frame.setTitle("Menu Principal - Etudiant");
		frame.setBounds(100, 100, 1045, 741);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 128, 255));
		frame.getContentPane().add(panel);
		FlowLayout fl_panel = new FlowLayout(FlowLayout.CENTER, 5, 5);
		panel.setLayout(fl_panel);
		
		JPanel panel_10 = new JPanel();
		panel_10.setBackground(new Color(0, 128, 255));
		panel.add(panel_10);
		FlowLayout flowLayout = (FlowLayout) panel_10.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);

		/**
		 * Bouton retour pour la navigation du logiciel
		 */
		JButton btnNewButtonRetour = new JButton("Retour");
		btnNewButtonRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ConnexionIHM();
				frame.dispose();
			}
		});
		btnNewButtonRetour.setFont(new Font("Tahoma", Font.BOLD, 24));
		panel_10.add(btnNewButtonRetour);
		
		JLabel lblNewLabel = new JLabel("Menu - Gestionnaire");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 45));
		panel.add(lblNewLabel);
		
		JPanel panel_2 = new JPanel();
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 128, 255));
		panel_2.add(panel_1);
		
		JButton btnNewButton_2 = new JButton("Gestion profil etudiant");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**
				 * Ouvre une nouvelle fenetre et ferme l'ancienne
				 */
				new GestionProfilEtudiantIHM();
				frame.dispose();
			}
		});
		btnNewButton_2.setForeground(new Color(0, 0, 0));
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel_1.add(btnNewButton_2);
		
		JButton btnNewButton_2_1 = new JButton("Gestion profil professeur");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**
				 * Ouvre une nouvelle fenetre et ferme l'ancienne
				 */
				new GestionProfilProfesseurIHM();
				frame.dispose();
			}
		});
		btnNewButton_2_1.setForeground(Color.BLACK);
		btnNewButton_2_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel_1.add(btnNewButton_2_1);
		
		JButton btnNewButton_2_2 = new JButton("Gestion profil administratif");
		btnNewButton_2_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**
				 * Ouvre une nouvelle fenetre et ferme l'ancienne
				 */
				new GestionProfilAdministratifIHM();
				frame.dispose();
			}
		});
		
		btnNewButton_2_2.setForeground(Color.BLACK);
		btnNewButton_2_2.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel_1.add(btnNewButton_2_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(0, 128, 255));
		panel_2.add(panel_3);
		
		JButton btnNewButton_2_2_1 = new JButton("Gestion cours");
		btnNewButton_2_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**
				 * Ouvre une nouvelle fenetre et ferme l'ancienne
				 */
				new GestionCoursIHM();
				frame.dispose();
			}
		});
		btnNewButton_2_2_1.setForeground(Color.BLACK);
		btnNewButton_2_2_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel_3.add(btnNewButton_2_2_1);
		
		JButton btnNewButton1 = new JButton("Remplacer les professeurs absents");
		btnNewButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					/**
					 * Ouvre une nouvelle fenetre et ferme l'ancienne
					 */
					new RemplacerProfAbsentIHM();
					frame.dispose();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel_3.add(btnNewButton1);
		
		JButton btnNewButton11 = new JButton("Declarer une absence d'un professeur");
		btnNewButton11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					/**
					 * Ouvre une nouvelle fenetre et ferme l'ancienne
					 */
					new PlanningEnseignantIHM();
					frame.dispose();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton11.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel_3.add(btnNewButton11);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(0, 128, 255));
		panel_2.add(panel_4);
		
		JButton btnGroupe = new JButton("Gestion planning de Groupe");
		btnGroupe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**
				 * Ouvre une nouvelle fenetre et ferme l'ancienne
				 */
				new GestionPlanningIHM();
				frame.dispose();
			}
		});
		btnGroupe.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel_4.add(btnGroupe);
		
		JButton btnNewButton_21 = new JButton("Traiter les absences");
		btnNewButton_21.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**
				 * Ouvre une nouvelle fenetre et ferme l'ancienne
				 */
				try {
					new TraiterAbsencesIHM();
					frame.dispose();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_21.setForeground(new Color(0, 0, 0));
		btnNewButton_21.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel_4.add(btnNewButton_21);
		
		JButton btnNewButton_3 = new JButton("Traiter les absences physiques");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**
				 * Ouvre une nouvelle fenetre et ferme l'ancienne
				 */
				try {
					new TraiterAbsencesPhysiquesIHM();
					frame.dispose();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_3.setForeground(new Color(0, 0, 0));
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel_4.add(btnNewButton_3);
	}

}
