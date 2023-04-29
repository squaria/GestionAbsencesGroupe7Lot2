package ihm;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import dao.ActionsEtudiantDAO;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DeposerJustificatifIHM {

	private JFrame frame;
	
	private static int ligneNum;
	private JTextField textField;

	private JLabel lblNewLabel_3_4;
	private static int id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeposerJustificatifIHM window = new DeposerJustificatifIHM(id, ligneNum);
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
	public DeposerJustificatifIHM(int id, int ligneNum) {
		DeposerJustificatifIHM.id = id;
		DeposerJustificatifIHM.ligneNum = ligneNum;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setVisible(true);
		frame.setTitle("JUSTIFICATION");
		frame.setBounds(100, 100, 1156, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_3 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		frame.getContentPane().add(panel_3);
		
		JButton btnNewButtonRetour = new JButton("Retour");
		btnNewButtonRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new ListeAbsencesEtuIHM(id, 1);
					frame.dispose();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButtonRetour.setFont(new Font("Tahoma", Font.BOLD, 24));
		panel_3.add(btnNewButtonRetour);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		frame.getContentPane().add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		JLabel lblNewLabel = new JLabel("Entrez l'url de telechargement de votre justificatif : ");
		lblNewLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblNewLabel.setBounds(113, 93, 212, 20);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Depot de justificatif");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_1.setBounds(160, 27, 117, 14);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel.add(textField);
		textField.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout1 = (FlowLayout) panel_1.getLayout();
		flowLayout1.setVgap(20);
		panel.add(panel_1);
		
		JButton btnDeposer = new JButton("Deposer");
		btnDeposer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField.getText().length() > 0) {
					deposerJustificatif(textField.getText());
				} else {
					JOptionPane.showMessageDialog(new JFrame(), "Le justificatif n'est pas entre.", "Dialog",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnDeposer.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel_1.add(btnDeposer);
		
		lblNewLabel_3_4 = new JLabel("");
		lblNewLabel_3_4.setForeground(Color.RED);
		lblNewLabel_3_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_1.add(lblNewLabel_3_4);

	}

	public void deposerJustificatif(String justificatif) {
		ActionsEtudiantDAO actionEtu = new ActionsEtudiantDAO();
		try {
			int effectuee = actionEtu.deposerJustificatif(ligneNum, justificatif);
			if (effectuee == 1)
				lblNewLabel_3_4.setText("Justificatif envoye !");
			else
				lblNewLabel_3_4.setText("Erreur l'absence selectionnee n'existe pas !");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
