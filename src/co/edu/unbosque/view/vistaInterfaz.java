package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import co.edu.unbosque.model.PcDTO;
import co.edu.unbosque.model.PcPokemon;
import co.edu.unbosque.model.Pokedex;
import co.edu.unbosque.model.Pokemon;

public class vistaInterfaz extends JFrame implements ActionListener{
	
	public JPanel panel1;
	public JLabel label1;
	public JLabel labelP;
	public TextArea txtarea1;
	public TextArea txtarea2;
	public TextArea txtarea3;
	public TextArea txtarea4;
	public TextArea txtarea5;
	public TextArea txtarea6;
	public JButton buttonAdd;
	public JButton buttonVen;
	private PcPokemon pc;
	private PcDTO pcdto;
	private Pokedex poke;


	public vistaInterfaz() throws HeadlessException {
		poke = new Pokedex();
//		pcdto =new PcDTO();
		pc = new PcPokemon();

	}


	public void iniciarComponentes() {
		

		
		
		JFrame fMain = new JFrame ("PC POKEMON");
		fMain.setSize(1200,750);
		
		fMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fMain.setResizable(false);
		fMain.setLocation(400,120);
		fMain.getContentPane().setBackground(Color.WHITE);
		fMain.setVisible(true);
		
		JPanel panel1 = new JPanel();
		panel1.setLayout(null);
		fMain.add(panel1);
		panel1.setBackground(Color.BLACK);
		
		label1 = new JLabel("Equipo Pokemon");
		label1.setBounds(100, 0, 400, 100);
		label1.setForeground(Color.WHITE);
		label1.setFont(new java.awt.Font("Tahoma", 3, 40));
		panel1.add(label1);
		
		txtarea1 = new TextArea("");
		txtarea1.setBounds(100,100,300,500);
		txtarea1.setEditable(false);
		panel1.add(txtarea1);
		
//		txtarea2 = new TextArea("");
//		txtarea2.setBounds(100, 150, 300, 80);
//		txtarea2.setEditable(false);
//		panel1.add(txtarea2);
//		
//		txtarea3 = new TextArea("");
//		txtarea3.setBounds(100, 250, 300, 80);
//		txtarea3.setEditable(false);
//		panel1.add(txtarea3);
//		
//		txtarea4 = new TextArea("");
//		txtarea4.setBounds(100, 350, 300, 80);
//		txtarea4.setEditable(false);
//		panel1.add(txtarea4);
//		
//		txtarea5 = new TextArea("");
//		txtarea5.setBounds(100, 450, 300, 80);
//		txtarea5.setEditable(false);
//		panel1.add(txtarea5);
//		
//		txtarea6 = new TextArea("");
//		txtarea6.setBounds(100, 550, 300, 80);
//		txtarea6.setEditable(false);
//		panel1.add(txtarea6);

		buttonAdd = new JButton("Agregar Pokemon");
		buttonAdd.setBounds(600, 380, 190, 30);
		//buttonAdd.addActionListener(this);
		panel1.add(buttonAdd);
		//buttonAdd.addActionListener(this);
		
		buttonVen = new JButton("Ver Cajas PC");
		buttonVen.setBounds(600, 280, 190, 30);
		panel1.add(buttonVen);
		
		labelP = new JLabel();
		labelP.setBounds(30, 60, 50, 50);
		ImageIcon imagen = new ImageIcon("images//pokeball.png");
		Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(labelP.getWidth(), labelP.getWidth(), Image.SCALE_DEFAULT));
		labelP.setIcon(icono);
		panel1.add(labelP);
		
		labelP = new JLabel();
		labelP.setBounds(30, 160, 50, 50);
		labelP.setIcon(icono);
		panel1.add(labelP);
		
		labelP = new JLabel();
		labelP.setBounds(30, 260, 50, 50);
		labelP.setIcon(icono);
		panel1.add(labelP);
		
		labelP = new JLabel();
		labelP.setBounds(30, 360, 50, 50);
		labelP.setIcon(icono);
		panel1.add(labelP);
		
		labelP = new JLabel();
		labelP.setBounds(30, 460, 50, 50);
		labelP.setIcon(icono);
		panel1.add(labelP);
		
		labelP = new JLabel();
		labelP.setBounds(30, 560, 50, 50);
		labelP.setIcon(icono);
		panel1.add(labelP);
		
		txtarea1.append("");
	}


	public JButton getButtonVen() {
		return buttonVen;
	}


	public void setButtonVen(JButton buttonVen) {
		this.buttonVen = buttonVen;
	}


	public JButton getButtonAdd() {
		return buttonAdd;
	}


	public void setButtonAdd(JButton buttonAdd) {
		this.buttonAdd = buttonAdd;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
	
	
//	@Override
//	public void actionPerformed(ActionEvent e) {
//	    boolean agregarMas = true;
//	    while (agregarMas) {
//	        String name = null;
//	        int level = 0;
//	        String nickname = null;
//	        String statsStr = null;
//	        String movesStr = null;
//	        int[] stats = null;
//	        String[] moves = null;
//	        try {
//	            name = JOptionPane.showInputDialog("Ingrese el nombre del pokemon");
//	            if (name == null) break;
//	            level = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el nivel del pokemon"));
//	            nickname = JOptionPane.showInputDialog("Ingrese el Nickname del pokemon");
//	            statsStr = JOptionPane.showInputDialog("Ingrese las estadisticas del pokemon (separadas por comas o espacios)");
//	            String[] statsArr = statsStr.split("[,\\s]+");
//	            stats = new int[statsArr.length];
//	            for (int i = 0; i < statsArr.length; i++) {
//	                stats[i] = Integer.parseInt(statsArr[i]);
//	            }
//	            movesStr = JOptionPane.showInputDialog("Ingrese los movimientos del pokemon (separados por comas o espacios)");
//	            String[] movesArr = movesStr.split("[,\\s]+");
//	            moves = new String[movesArr.length];
//	            for (int i = 0; i < movesArr.length; i++) {
//	                moves[i] = movesArr[i];
//	            }
//	        } catch (NumberFormatException ex) {
//	            // Si se produce una excepción al convertir una cadena de texto en un número, simplemente ignórela y continúe
//	            continue;
//	        } catch (NullPointerException ex) {
//	            // Si el usuario presiona "Cancelar", simplemente ignórelo y continúe
//	            break;
//	        }
//	        Pokemon nuevoPokemon = poke.agregarPokemon(name, level, nickname, stats, moves);
//	        pc.addPokemonToBox(nuevoPokemon, 1);
//	        System.out.println(pc.getBox(1));
//
//	        // Agrega la información del nuevo Pokemon al JTextArea
//	        txtarea1.append(name+"\n"+level+"\n"+nickname+"\n"+Arrays.toString(stats)+"\n"+Arrays.toString(moves)+"\n\n");
//
//	        int opcion = JOptionPane.showConfirmDialog(null, "¿Desea agregar otro Pokemon?", "Agregar Pokemon", JOptionPane.YES_NO_OPTION);
//	        if (opcion == JOptionPane.NO_OPTION) {
//	            agregarMas = false;
//	        }
//	    }
//	}
}
