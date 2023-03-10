package co.edu.unbosque.controller;


import java.awt.Color;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import co.edu.unbosque.model.AlmacenamientoPokemon;
import co.edu.unbosque.model.PcPokemon;
import co.edu.unbosque.model.Pokedex;
import co.edu.unbosque.model.Pokemon;
import co.edu.unbosque.view.vistaCajas;
import co.edu.unbosque.view.vistaInterfaz;
public class Controller implements ActionListener {
	private vistaInterfaz vista;
	private vistaCajas vistac;
	private AlmacenamientoPokemon pk;
	private Pokemon pokemon;
	private Pokedex poke;
	private PcPokemon pc;
	public Controller() {
		vista = new vistaInterfaz();
		vistac = new vistaCajas();
		vista.iniciarComponentes();
		vistac.iniciarCompontes2();
		poke = new Pokedex();
		pc = new PcPokemon();
		funcionar();
	}


	private void funcionar() {


		vista.getButtonAdd().addActionListener(this);
		vista.getButtonVen().addActionListener(new OtroActionListener());

	}

	private class OtroActionListener implements ActionListener {
		public void actionPerformed1(ActionEvent e) {
			abrirNuevaVista();
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			abrirNuevaVista();

		}

	}

	private void abrirNuevaVista() {
		vistac.setVisible(true);
		vistac.iniciarCompontes2();

	}






























	@Override
	public void actionPerformed(ActionEvent e) {
		boolean agregarMas = true;
		while (agregarMas) {
			String name = null;
			int level = 0;
			String nickname = null;
			String statsStr = null;
			String movesStr = null;
			int[] stats = null;
			String[] moves = null;
			try {
				name = JOptionPane.showInputDialog("Ingrese el nombre del pokemon");
				if (name == null) break;
				level = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el nivel del pokemon"));
				nickname = JOptionPane.showInputDialog("Ingrese el Nickname del pokemon");
				statsStr = JOptionPane.showInputDialog("Ingrese las estadisticas del pokemon (separadas por comas o espacios)");
				String[] statsArr = statsStr.split("[,\\s]+");
				stats = new int[statsArr.length];
				for (int i = 0; i < statsArr.length; i++) {
					stats[i] = Integer.parseInt(statsArr[i]);
				}
				movesStr = JOptionPane.showInputDialog("Ingrese los movimientos del pokemon (separados por comas o espacios)");
				String[] movesArr = movesStr.split("[,\\s]+");
				moves = new String[movesArr.length];
				for (int i = 0; i < movesArr.length; i++) {
					moves[i] = movesArr[i];
				}
			} catch (NumberFormatException ex) {
				// Si se produce una excepción al convertir una cadena de texto en un número, simplemente ignórela y continúe
				continue;
			} catch (NullPointerException ex) {
				// Si el usuario presiona "Cancelar", simplemente ignórelo y continúe
				break;
			}
			Pokemon nuevoPokemon = poke.agregarPokemon(name, level, nickname, stats, moves);
			pc.addPokemonToBox(nuevoPokemon, 1);
			System.out.println(pc.getBox(1));

			// Agrega la información del nuevo Pokemon al JTextArea
			vista.txtarea1.append(name+"\n"+level+"\n"+nickname+"\n"+Arrays.toString(stats)+"\n"+Arrays.toString(moves)+"\n\n");

			int opcion = JOptionPane.showConfirmDialog(null, "¿Desea agregar otro Pokemon?", "Agregar Pokemon", JOptionPane.YES_NO_OPTION);
			if (opcion == JOptionPane.NO_OPTION) {
				agregarMas = false;
			}
		}
	}

}