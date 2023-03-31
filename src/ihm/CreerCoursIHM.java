package ihm;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.SwingConstants;

public class CreerCoursIHM extends JFrame {
	private JTextField txtBmww;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField;
	
	
	public CreerCoursIHM() {
		initialize();
	}
	
	private void initialize() {
		this.setTitle("CREATION");
		this.setSize(730, 427);
		this.setLocation(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		
		JLabel ArrierePlan = new JLabel("");
		ArrierePlan.setIcon(new ImageIcon("C:\\Users\\46426223\\Downloads\\profile-17.jpg"));
		ArrierePlan.setBounds(0, 0, 704, 388);
		getContentPane().add(ArrierePlan);
		
		JLabel lblNewLabel = new JLabel("Cr\u00E9ation d'dun nouveau cours");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel.setBounds(117, 11, 226, 20);
		ArrierePlan.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Informations");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(177, 51, 77, 14);
		ArrierePlan.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Nom");
		lblNewLabel_2.setForeground(Color.ORANGE);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(32, 79, 46, 14);
		ArrierePlan.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Enseignant");
		lblNewLabel_3.setForeground(Color.ORANGE);
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(32, 110, 67, 14);
		ArrierePlan.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("R\u00E9f\u00E9rence du planning");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_4.setForeground(Color.ORANGE);
		lblNewLabel_4.setBounds(32, 141, 136, 14);
		ArrierePlan.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Num\u00E9ro du groupe");
		lblNewLabel_5.setForeground(Color.ORANGE);
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(32, 173, 110, 14);
		ArrierePlan.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Nombre d'heures Amphi/ EXamen");
		lblNewLabel_6.setForeground(Color.ORANGE);
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_6.setBounds(32, 204, 172, 14);
		ArrierePlan.add(lblNewLabel_6);
		
		textField_5 = new JTextField();
		textField_5.setBackground(Color.WHITE);
		textField_5.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_5.setBounds(234, 105, 214, 20);
		ArrierePlan.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Nombre d'heures Td/ Tp");
		lblNewLabel_7.setForeground(Color.ORANGE);
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_7.setBounds(32, 235, 158, 14);
		ArrierePlan.add(lblNewLabel_7);
		
		txtBmww = new JTextField();
		ArrierePlan.add(txtBmww);
		txtBmww.setBackground(Color.WHITE);
		txtBmww.setHorizontalAlignment(SwingConstants.RIGHT);
		txtBmww.setBounds(234, 80, 214, 20);
		txtBmww.setColumns(10);
		
		textField_1 = new JTextField();
		ArrierePlan.add(textField_1);
		textField_1.setBackground(Color.WHITE);
		textField_1.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_1.setBounds(234, 141, 214, 20);
		textField_1.setColumns(10);
		
		textField_3 = new JTextField();
		ArrierePlan.add(textField_3);
		textField_3.setBackground(Color.WHITE);
		textField_3.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_3.setBounds(234, 172, 214, 20);
		textField_3.setColumns(10);
		
		textField_2 = new JTextField();
		ArrierePlan.add(textField_2);
		textField_2.setBackground(Color.WHITE);
		textField_2.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_2.setBounds(234, 203, 214, 20);
		textField_2.setColumns(10);
		
		textField_4 = new JTextField();
		ArrierePlan.add(textField_4);
		textField_4.setBackground(Color.WHITE);
		textField_4.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_4.setBounds(234, 234, 214, 20);
		textField_4.setColumns(10);
		
		textField = new JTextField();
		textField.setBounds(234, 141, 214, 20);
		ArrierePlan.add(textField);
		textField.setColumns(10);
		
		this.setVisible(true);
	}
}
