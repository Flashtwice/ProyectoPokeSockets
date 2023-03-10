package co.edu.unbosque.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PcPokemon {
	private List<Pokemon> box1;
    private List<Pokemon> box2;
    private List<Pokemon> box3;

    public PcPokemon() {
        this.box1 = new ArrayList<>();
        this.box2 = new ArrayList<>();
        this.box3 = new ArrayList<>();
    }

    public List<Pokemon> getBox(int boxNumber) {
        switch (boxNumber) {
            case 1:
                return box1;
            case 2:
                return box2;
            case 3:
                return box3;
            default:
                throw new IllegalArgumentException("Box number must be between 1 and 3");
        }
    }

    public void addPokemonToBox(Pokemon pokemon, int boxNumber) {
        getBox(boxNumber).add(pokemon);
    }

    public void removePokemonFromBox(Pokemon pokemon, int boxNumber) {
        getBox(boxNumber).remove(pokemon);
    }

    public boolean isBoxFull(int boxNumber) {
        return getBox(boxNumber).size() >= Integer.MAX_VALUE;
    }

    public boolean isPokemonInBox(Pokemon pokemon, int boxNumber) {
        return getBox(boxNumber).contains(pokemon);
    }
}

