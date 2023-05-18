package ihm;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Classe interface utilisateur du menu d'un compte enseignant
 * 
 * @author Loic OUASSA, Mael PAROT
 * @version 1.0
 */
public class EnseignantIHM {

	private JFrame frmMenuPrincipal;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EnseignantIHM window = new EnseignantIHM();
					window.frmMenuPrincipal.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the application.
	 */
	public EnseignantIHM() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		/**
		 * Creation de la JFrame
		 */
		frmMenuPrincipal = new JFrame();
		frmMenuPrincipal.setVisible(true);
		frmMenuPrincipal.setTitle("Menu Principal - Enseignant");
		frmMenuPrincipal.setBounds(100, 100, 1045, 741);
		frmMenuPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMenuPrincipal.getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		frmMenuPrincipal.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(0, 128, 255));
		frmMenuPrincipal.getContentPane().add(panel_5);
		panel_5.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(232, 236, 235));
		panel_5.add(panel);
		FlowLayout fl_panel = new FlowLayout(FlowLayout.CENTER, 5, 5);
		panel.setLayout(fl_panel);
		
		JPanel panel_10 = new JPanel();
		panel_10.setBackground(new Color(232, 236, 235));
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
				frmMenuPrincipal.dispose();
			}
		});
		btnNewButtonRetour.setFont(new Font("Tahoma", Font.BOLD, 24));
		panel_10.add(btnNewButtonRetour);
		
		JLabel lblNewLabel = new JLabel("Enseignant");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 45));
		panel.add(lblNewLabel);
		
		JPanel panel_6 = new JPanel();
        panel_6.setBackground(new Color(232, 236, 235));
        panel_5.add(panel_6);
		FlowLayout fl_panel1 = new FlowLayout(FlowLayout.CENTER, 5, 5);
		panel.setLayout(fl_panel1);
		
		ImageIcon imageIcon = new ImageIcon("img/esig.png");
		panel_6.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 30));
		JLabel imageLabel = new JLabel();
        imageLabel.setIcon(imageIcon);
        panel_6.add(imageLabel);
        

        ImageIcon imageIcon1 = new ImageIcon("img/prof.png");
        Image image = imageIcon1.getImage().getScaledInstance(-1, 150, Image.SCALE_DEFAULT); // Adjust the height (200) as desired
        ImageIcon scaledIcon = new ImageIcon(image);
		JLabel imageLabel1 = new JLabel();
        imageLabel1.setIcon(scaledIcon);
        panel_6.add(imageLabel1);
        
		JPanel panel_2 = new JPanel();
		frmMenuPrincipal.getContentPane().add(panel_2);
		panel_2.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(232, 236, 235));
		panel_2.add(panel_1);
		
		JButton btnNewButton_2 = new JButton("Planning et declarer absence etudiant");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				/**
				 * Ouvre une nouvelle fenetre et ferme l'ancienne
				 */
				new PlanningEnseignantIHM();
				frmMenuPrincipal.dispose();
			}
		});
		btnNewButton_2.setForeground(new Color(0, 0, 0));
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel_1.add(btnNewButton_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(232, 236, 235));
		panel_2.add(panel_3);
		
		JButton btnNewButton_1 = new JButton("Absences");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					/**
					 * Ouvre une nouvelle fenetre et ferme l'ancienne
					 */
					new ListeAbsencesEnsIHM();
					frmMenuPrincipal.dispose();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel_3.add(btnNewButton_1);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(232, 236, 235));
		panel_2.add(panel_4);
		
		JButton btnNewButton_3 = new JButton("Liste de mes cours");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					/**
					 * Ouvre une nouvelle fenetre et ferme l'ancienne
					 */
					new ListeCoursEnsIHM();
					frmMenuPrincipal.dispose();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel_4.add(btnNewButton_3);
		
		JButton btnNewButton_31 = new JButton("Synthese absence d'un etudiant");
		btnNewButton_31.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					/**
					 * Ouvre une nouvelle fenetre et ferme l'ancienne
					 */
					new ListeAbsencesEtuIHM();
					frmMenuPrincipal.dispose();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_31.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel_4.add(btnNewButton_31);
	}

}
