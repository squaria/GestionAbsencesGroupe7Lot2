package ihm;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import dao.ActionsEtudiantDAO;
import model.Planning;

import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DeposerJustificatifAbsPhysiqueIHM {

	private JFrame frame;
	private JTextField textField;
	private Planning plan = new Planning();
	private JLabel lblNewLabel_3_4;
	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeposerJustificatifAbsPhysiqueIHM window = new DeposerJustificatifAbsPhysiqueIHM();
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
	public DeposerJustificatifAbsPhysiqueIHM() {
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
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
		
		JPanel panel_3 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		frame.getContentPane().add(panel_3);
		
		JButton btnNewButtonRetour = new JButton("Retour");
		btnNewButtonRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new EtudiantIHM();
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
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		
		JLabel lblNewLabel_1 = new JLabel("Date de debut (JJ/MM/AAAA) : ");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel_2.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_1.setColumns(5);
		panel_2.add(textField_1);
		
		JLabel lblNewLabel_3 = new JLabel("/");
		lblNewLabel_3.setForeground(Color.BLACK);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel_2.add(lblNewLabel_3);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_3.setColumns(5);
		panel_2.add(textField_3);
		
		JLabel lblNewLabel_4 = new JLabel("/");
		lblNewLabel_4.setForeground(Color.BLACK);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel_2.add(lblNewLabel_4);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_4.setColumns(5);
		panel_2.add(textField_4);
		
		JPanel panel_4 = new JPanel();
		panel.add(panel_4);
		
		JLabel lblNewLabel_2 = new JLabel("Date de fin (JJ/MM/AAAA) : ");
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel_4.add(lblNewLabel_2);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_5.setColumns(5);
		panel_4.add(textField_5);
		
		JLabel lblNewLabel_5 = new JLabel("/");
		lblNewLabel_5.setForeground(Color.BLACK);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel_4.add(lblNewLabel_5);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_6.setColumns(5);
		panel_4.add(textField_6);
		
		JLabel lblNewLabel_6 = new JLabel("/");
		lblNewLabel_6.setForeground(Color.BLACK);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel_4.add(lblNewLabel_6);
		
		textField_7 = new JTextField();
		textField_7.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_7.setColumns(5);
		panel_4.add(textField_7);
		
		JLabel lblNewLabel = new JLabel("Entrez l'url de telechargement de votre justificatif : ");
		lblNewLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblNewLabel.setBounds(113, 93, 212, 20);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_7 = new JLabel("Depot de justificatif");
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_7.setBounds(160, 27, 117, 14);
		
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
				if (textField.getText().length() > 0 && textField.getText().length() > 0 && 
						textField_1.getText().length() > 0 && textField_3.getText().length() > 0 && 
						textField_4.getText().length() > 0 && textField_5.getText().length() > 0 && 
						textField_6.getText().length() > 0 && textField_7.getText().length() > 0 && 
						plan.isIntDay(textField_1.getText(), textField_3.getText(), textField_4.getText()) && 
						plan.intMonth(textField_3.getText()) != 0 && plan.intYear(textField_4.getText()) != 0 && 
						plan.isIntDay(textField_5.getText(), textField_6.getText(), textField_7.getText()) &&
						plan.intMonth(textField_6.getText()) != 0 && plan.intYear(textField_7.getText()) != 0 ) {
					String dateDebut = textField_1.getText() + "/" + textField_3.getText() + "/" + textField_4.getText();
					String dateFin = textField_5.getText() + "/" + textField_6.getText() + "/" + textField_7.getText();
					deposerJustificatif(textField.getText(), dateDebut, dateFin);
				} else {
					JOptionPane.showMessageDialog(new JFrame(), "Le justificatif n'est pas entre ou les dates ne sont pas correctes.", "Dialog",
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

	public void deposerJustificatif(String justificatif, String dateDebut, String dateFin) {
		ActionsEtudiantDAO actionEtu = new ActionsEtudiantDAO();
		try {
			int effectuee = actionEtu.deposerJustificatifAbsPhysique(justificatif, dateDebut, dateFin);
			if (effectuee == 1)
				lblNewLabel_3_4.setText("Justificatif envoye !");
			else
				lblNewLabel_3_4.setText("Erreur !");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
