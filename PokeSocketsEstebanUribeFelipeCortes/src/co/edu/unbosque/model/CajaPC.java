package co.edu.unbosque.model;
import java.util.ArrayList;

public class CajaPC {
    public static final int MAX_EQUIPOS_CAJA = 20;
	private ArrayList<EquipoPokemon> caja1;
    private ArrayList<EquipoPokemon> caja2;
    private ArrayList<EquipoPokemon> caja3;
    
    public CajaPC() {
        this.caja1 = new ArrayList<>();
        this.caja2 = new ArrayList<>();
        this.caja3 = new ArrayList<>();
    }

    public ArrayList<EquipoPokemon> getCaja1() {
        return caja1;
    }

    public ArrayList<EquipoPokemon> getCaja2() {
        return caja2;
    }

    public ArrayList<EquipoPokemon> getCaja3() {
        return caja3;
    }
    
    public void agregarPokemonACaja(int numCaja, EquipoPokemon pokemon) {
        switch(numCaja) {
            case 1:
                caja1.add(pokemon);
                break;
            case 2:
                caja2.add(pokemon);
                break;
            case 3:
                caja3.add(pokemon);
                break;
            default:
                System.out.println("La caja seleccionada no existe.");
        }
    }
    
    public void eliminarPokemonDeCaja(int numCaja, EquipoPokemon pokemon) {
        switch(numCaja) {
            case 1:
                caja1.remove(pokemon);
                break;
            case 2:
                caja2.remove(pokemon);
                break;
            case 3:
                caja3.remove(pokemon);
                break;
            default:
                System.out.println("La caja seleccionada no existe.");
        }
    }
}
