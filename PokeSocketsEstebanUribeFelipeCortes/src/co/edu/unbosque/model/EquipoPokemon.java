package co.edu.unbosque.model;
public class EquipoPokemon {

    private Pokemon[] equipo;
    private int cantidadPokemon;
    
    public EquipoPokemon() {
        equipo = new Pokemon[6];
        cantidadPokemon = 0;
    }
    
    public void agregarPokemon(Pokemon pokemon) {
        if (cantidadPokemon < 6) {
            equipo[cantidadPokemon] = pokemon;
            cantidadPokemon++;
        } else {
            System.out.println("No se puede agregar el pokemon. Equipo lleno.");
        }
    }
    
    public void quitarPokemon(int indice) {
        if (indice >= 0 && indice < cantidadPokemon) {
            for (int i = indice; i < cantidadPokemon-1; i++) {
                equipo[i] = equipo[i+1];
            }
            equipo[cantidadPokemon-1] = null;
            cantidadPokemon--;
        } else {
            System.out.println("No se puede quitar el pokemon. Indice fuera de rango.");
        }
    }
    
    public void intercambiarPokemon(int indiceOrigen, int indiceDestino) {
        if (indiceOrigen >= 0 && indiceOrigen < cantidadPokemon && indiceDestino >= 0 && indiceDestino < 6) {
            Pokemon temp = equipo[indiceOrigen];
            equipo[indiceOrigen] = equipo[indiceDestino];
            equipo[indiceDestino] = temp;
        } else {
            System.out.println("No se puede intercambiar el pokemon. Indices fuera de rango.");
        }
    }
    
    public Pokemon[] getEquipo() {
        return equipo;
    }
    
    public void setEquipo(Pokemon[] equipo) {
        this.equipo = equipo;
    }
    
    public int getCantidadPokemon() {
        return cantidadPokemon;
    }
    
    public void mostrarEquipo() {
        System.out.println("Equipo Pokemon:");
        for (int i = 0; i < cantidadPokemon; i++) {
            System.out.println("Pokemon #" + (i+1) + ":");
            equipo[i].mostrarDatos();
        }
    }
    
}

