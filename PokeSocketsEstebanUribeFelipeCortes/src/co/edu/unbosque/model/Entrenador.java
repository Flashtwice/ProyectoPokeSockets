package co.edu.unbosque.model;
import java.util.ArrayList;

public class Entrenador {
    private EquipoPokemon equipo;
    private CajaPC cajaPC;

    public Entrenador() {
        this.equipo = new EquipoPokemon();
        this.cajaPC = new CajaPC();
    }
    
    public Entrenador(EquipoPokemon equipo) {
        this.equipo = equipo;
        this.cajaPC = new CajaPC();
    }
    
    public EquipoPokemon getEquipo() {
        return equipo;
    }
    
    public CajaPC getCajaPC() {
        return cajaPC;
    }

	public void agregarPokemonAEquipo(Pokemon pokemon) {
        this.equipo.agregarPokemon(pokemon);
    }
    
    public void eliminarPokemonDeEquipo(int pokemon) {
        this.equipo.quitarPokemon(pokemon);
    }
    
    public void agregarPokemonACaja(int numCaja, EquipoPokemon pokemon) {
        this.cajaPC.agregarPokemonACaja(numCaja, pokemon);
    }
    
    public void eliminarPokemonDeCaja(int numCaja, EquipoPokemon pokemon) {
        this.cajaPC.eliminarPokemonDeCaja(numCaja, pokemon);
    }
    
    public ArrayList<EquipoPokemon> obtenerEquiposDeCaja(int numCaja) {
        ArrayList<EquipoPokemon> equipos = new ArrayList<>();
        
        switch(numCaja) {
            case 1:
                equipos = cajaPC.getCaja1();
                break;
            case 2:
                equipos = cajaPC.getCaja2();
                break;
            case 3:
                equipos = cajaPC.getCaja3();
                break;
            default:
                System.out.println("La caja seleccionada no existe.");
        }
        
        return equipos;
    }
    
    public void capturarPokemon(Pokemon pokemon) {
        if (this.equipo.getCantidadPokemon() < 6) {
            this.equipo.agregarPokemon(pokemon);
            System.out.println("¡Felicidades! Has capturado a " + pokemon.getNombre() + ".");
        } else {
            int numCaja = obtenerCajaDisponible();
            if (numCaja == -1) {
                System.out.println("Lo siento, no puedes capturar más Pokémon.");
            } else {
                EquipoPokemon nuevoEquipo = new EquipoPokemon();
                nuevoEquipo.agregarPokemon(pokemon);
                this.cajaPC.agregarPokemonACaja(numCaja, nuevoEquipo);
                System.out.println("¡Felicidades! Has capturado a " + pokemon.getNombre() + ". Se ha enviado a la caja " + numCaja + ".");
            }
        }
    }
    
    public void transferirPokemonAEquipo(int numCaja, int numPokemon) {
        // Obtener el equipo pokemon de la caja correspondiente
        ArrayList<EquipoPokemon> equipos = obtenerEquiposDeCaja(numCaja);
        
        // Verificar si el equipo pokemon de la caja y el equipo del entrenador tienen menos de 6 pokemons
        if (equipos.size() > 0 && equipo.getCantidadPokemon() < 6) {
            // Obtener el pokemon de la caja
            EquipoPokemon equipoPokemon = equipos.get(numPokemon - 1);
            
            // Agregar el pokemon al equipo del entrenador
            this.agregarPokemonAEquipo(equipoPokemon.getEquipo()[numPokemon]);
            
            // Eliminar el pokemon de la caja
            this.eliminarPokemonDeCaja(numCaja, equipoPokemon);
            
            System.out.println("Se ha transferido el pokemon a tu equipo.");
        } else {
            System.out.println("No se ha podido transferir el pokemon a tu equipo.");
        }
    }
    
    public void transferirPokemonAPC(int numCaja, int numPokemon) {
        EquipoPokemon equipo = this.equipo;
        ArrayList<EquipoPokemon> caja = obtenerEquiposDeCaja(numCaja);

        if (numPokemon >= 0 && numPokemon < equipo.getEquipo().length-1) {
            Pokemon pokemon = equipo.getEquipo()[numPokemon];

            if (caja.size() < CajaPC.MAX_EQUIPOS_CAJA) {
                EquipoPokemon nuevoEquipo = new EquipoPokemon();
                
                this.agregarPokemonACaja(numCaja, nuevoEquipo);
                this.eliminarPokemonDeCaja(numCaja, nuevoEquipo);
                System.out.println("¡" + pokemon.getNombre() + " ha sido transferido a la caja " + numCaja + "!");
            } else {
                System.out.println("La caja " + numCaja + " ya tiene el número máximo de equipos (" + CajaPC.MAX_EQUIPOS_CAJA + "). No se puede transferir el pokemon.");
            }
        } else {
            System.out.println("El número de pokemon " + numPokemon + " no es válido.");
        }
    }
    public void liberarPokemon(int numPokemon) {
        // Eliminamos el pokemon del equipo del entrenador
        this.eliminarPokemonDeEquipo(numPokemon);
        int contPokemon = equipo.getEquipo().length;
        // Buscamos en qué caja de PC está el pokemon
        for (int i = 1; i <= 3; i++) {
            ArrayList<EquipoPokemon> equiposCaja = this.obtenerEquiposDeCaja(i);
            for (EquipoPokemon equipo : equiposCaja) {
                for(int j=0; j<equipo.getEquipo().length; j++) {
                    if(contPokemon == numPokemon)
                    this.eliminarPokemonDeCaja(i, equipo);
                    System.out.println(equipo.getEquipo()[numPokemon].getNombre() + " ha sido liberado.");
                    return;
                }
            }
        }
        
        // Si llegamos hasta aquí, es porque el pokemon no estaba en el equipo ni en ninguna caja
        System.out.println(equipo.getEquipo()[numPokemon].getNombre() + " no se ha encontrado en el equipo ni en la PC.");
    }
    public void mostrarEquipoEntrenador() {
    	this.equipo.mostrarEquipo();
    }
    
    public void mostrarCajaPC(int numCaja) {
    	System.out.println(this.obtenerEquiposDeCaja(numCaja));
    }



    private int obtenerCajaDisponible() {
        if (this.cajaPC.getCaja1().size() < CajaPC.MAX_EQUIPOS_CAJA) {
            return 1;
        } else if (this.cajaPC.getCaja2().size() < CajaPC.MAX_EQUIPOS_CAJA) {
            return 2;
        } else if (this.cajaPC.getCaja3().size() < CajaPC.MAX_EQUIPOS_CAJA) {
            return 3;
        } else {
            return -1;
        }
    }

}
