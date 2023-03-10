package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class vistaCajas extends JFrame implements ActionListener{
	public JPanel panel1;
	public JLabel label1;
	public JLabel labelP;
	public TextArea txtarea1;
	public TextArea txtarea2;
	public TextArea txtarea3;
	
	
	
	public void iniciarCompontes2() {
		JFrame fMain = new JFrame ("PC POKEMON");
		fMain.setSize(1200,750);
		
		fMain.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		fMain.setResizable(false);
		fMain.setLocation(400,120);
		fMain.getContentPane().setBackground(Color.WHITE);
		fMain.setVisible(true);
		
		JPanel panel1 = new JPanel();
		panel1.setLayout(null);
		fMain.add(panel1);
		panel1.setBackground(Color.BLACK);
		
		label1 = new JLabel("CAJA 1");
		label1.setBounds(100, 10, 190, 30);
		label1.setForeground(Color.white);
		label1.setFont(new java.awt.Font("Tahoma", 3, 40));
		panel1.add(label1);
		
		label1 = new JLabel("CAJA 2");
		label1.setBounds(455, 10, 190, 30);
		label1.setForeground(Color.white);
		label1.setFont(new java.awt.Font("Tahoma", 3, 40));
		panel1.add(label1);
		
		label1 = new JLabel("CAJA 3");
		label1.setBounds(800, 10, 190, 30);
		label1.setForeground(Color.white);
		label1.setFont(new java.awt.Font("Tahoma", 3, 40));
		panel1.add(label1);
		
		txtarea1 = new TextArea("");
		txtarea1.setBounds(100, 80, 300, 400);
		txtarea1.setEditable(false);
		panel1.add(txtarea1);
		
		txtarea2 = new TextArea("");
		txtarea2.setBounds(455, 80, 300, 400);
		txtarea2.setEditable(false);
		panel1.add(txtarea2);
		
		txtarea3 = new TextArea("");
		txtarea3.setBounds(800, 80, 300, 400);
		txtarea3.setEditable(false);
		panel1.add(txtarea3);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
