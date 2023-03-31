package ihm;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JEditorPane;
import java.awt.Color;

public class DeposerJustificatifIHM extends JFrame {

	

	public DeposerJustificatifIHM() {
	
		this.setTitle("JUSTIFICATION");
		this.setSize(730, 427);
		this.setLocation(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		
		JLabel Arriere = new JLabel("");
		Arriere.setIcon(new ImageIcon("C:\\Users\\46426223\\Downloads\\OIP.jfif"));
		Arriere.setBounds(0, 0, 434, 261);
		Arriere.add(Arriere);
		
		JLabel lblNewLabel = new JLabel("Faites glissez votre justificatif");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel.setBounds(113, 93, 212, 20);
		Arriere.add(lblNewLabel);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setBounds(162, 148, 107, 50);
		Arriere.add(editorPane);
		
		JLabel lblNewLabel_1 = new JLabel("Depot de justificatif");
		Arriere.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_1.setBounds(160, 27, 117, 14);
		this.setVisible(true);
	}
}
