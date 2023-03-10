package co.edu.unbosque.model;

import java.util.ArrayList;

public class Pokedex {
    private ArrayList<Pokemon> listaPokemon;

    public Pokedex() {
        listaPokemon = new ArrayList<Pokemon>();
        
    }

    public Pokemon agregarPokemon(String name, int level, String nickname, int[] stats, String[] moves) {
        Pokemon nuevoPokemon = new Pokemon(name, level, nickname, stats,moves);
        listaPokemon.add(nuevoPokemon);
        System.out.println("¡" + name + " ha sido agregado a la Pokedex!");
		return nuevoPokemon;
    }
}
