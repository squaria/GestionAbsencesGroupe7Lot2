package ihm;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.BoxLayout;

/**
 * Classe interface utilisateur du menu d'un compte administratif
 * 
 * @author Loic OUASSA, Mael PAROT
 * @version 1.0
 */
public class AdministratifIHM {

	private JFrame frame;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdministratifIHM window = new AdministratifIHM();
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
	public AdministratifIHM() {
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
		frame.setTitle("Menu Principal - Administratif");
		frame.setBounds(100, 100, 1045, 741);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(0, 128, 255));
		frame.getContentPane().add(panel_5);
		panel_5.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(140, 189, 185));
		panel_5.add(panel);
		FlowLayout fl_panel = new FlowLayout(FlowLayout.CENTER, 5, 5);
		panel.setLayout(fl_panel);
		
		JPanel panel_10 = new JPanel();
		panel_10.setBackground(new Color(140, 189, 185));
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
		
		JLabel lblNewLabel = new JLabel("Menu - Administratif");
		lblNewLabel.setBackground(new Color(45, 62, 78));
		lblNewLabel.setForeground(new Color(45, 62, 78));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 45));
		panel.add(lblNewLabel);
		

        JPanel panel_6 = new JPanel();
        panel_6.setBackground(new Color(135, 189, 185));
        panel_5.add(panel_6);
		FlowLayout fl_panel1 = new FlowLayout(FlowLayout.CENTER, 5, 5);
		panel.setLayout(fl_panel1);
		
		ImageIcon imageIcon = new ImageIcon("img/esig.png");
		panel_6.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 30));
		JLabel imageLabel = new JLabel();
        imageLabel.setIcon(imageIcon);
        panel_6.add(imageLabel);
        

        ImageIcon imageIcon1 = new ImageIcon("img/administratif.png");
        Image image = imageIcon1.getImage().getScaledInstance(-1, 150, Image.SCALE_DEFAULT); // Adjust the height (200) as desired
        ImageIcon scaledIcon = new ImageIcon(image);
		JLabel imageLabel1 = new JLabel();
        imageLabel1.setIcon(scaledIcon);
        panel_6.add(imageLabel1);
		
		JPanel panel_2 = new JPanel();
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(140, 189, 185));
		panel_2.add(panel_1);
		
		JButton btnNewButton_2 = new JButton("Traiter les absences");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					/**
					 * Ouvre une nouvelle fenetre et ferme l'ancienne
					 */
					new TraiterAbsencesIHM();
					frame.dispose();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_2.setForeground(new Color(0, 0, 0));
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel_1.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Traiter les absences physiques");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					/**
					 * Ouvre une nouvelle fenetre et ferme l'ancienne
					 */
					new TraiterAbsencesPhysiquesIHM();
					frame.dispose();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_3.setForeground(new Color(0, 0, 0));
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel_1.add(btnNewButton_3);
		
		JPanel panel_31 = new JPanel();
		panel_31.setBackground(new Color(140, 189, 185));
		panel_2.add(panel_31);
		
		JButton btnNewButton = new JButton("Afficher les absences des professeurs");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					/**
					 * Ouvre une nouvelle fenetre et ferme l'ancienne
					 */
					new ListeAbsencesEnsIHM();
					frame.dispose();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel_31.add(btnNewButton);
		
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
		panel_31.add(btnNewButton1);
		
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
		panel_31.add(btnNewButton11);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(140, 189, 185));
		panel_2.add(panel_3);
		
		JButton btnNewButton_1 = new JButton("Gerer les cours");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					/**
					 * Ouvre une nouvelle fenetre et ferme l'ancienne
					 */
					new GestionCoursIHM();
					frame.dispose();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel_3.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Afficher planning de groupe");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					/**
					 * Ouvre une nouvelle fenetre et ferme l'ancienne
					 */
					new PlanningGroupeIHM();
					frame.dispose();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel_3.add(btnNewButton_1_1);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(140, 189, 185));
		panel_2.add(panel_4);
		
		JButton btnGroupe = new JButton("Gerer les plannings de groupe");
		btnGroupe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					/**
					 * Ouvre une nouvelle fenetre et ferme l'ancienne
					 */
					new GestionPlanningIHM();
					frame.dispose();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnGroupe.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel_4.add(btnGroupe);
		
		JButton btnGroupe1 = new JButton("Afficher les absences d'un etudiant");
		btnGroupe1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					/**
					 * Ouvre une nouvelle fenetre et ferme l'ancienne
					 */
					new ListeAbsencesEtuIHM();
					frame.dispose();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnGroupe1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel_4.add(btnGroupe1);

	}

}
