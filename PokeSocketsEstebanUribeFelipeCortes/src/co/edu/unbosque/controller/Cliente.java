package co.edu.unbosque.controller;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import co.edu.unbosque.model.CajaPC;
import co.edu.unbosque.model.Entrenador;
import co.edu.unbosque.model.EquipoPokemon;
import co.edu.unbosque.model.Pokemon;
import co.edu.unbosque.view.ConsoleUtil;

public class Cliente {
    private static final int PUERTO = 12345;
    private static final String IP = "localhost";

    private static Socket socket;
    private static ObjectInputStream entrada;
    private static ObjectOutputStream salida;
    
    static ArrayList<EquipoPokemon> equipos;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Conectar al servidor
            socket = new Socket(IP, PUERTO);
            entrada = new ObjectInputStream(socket.getInputStream());
            salida = new ObjectOutputStream(socket.getOutputStream());

            // Solicitar el nombre del entrenador
            System.out.println("Ingrese su nombre de entrenador:");
            String nombreEntrenador = scanner.nextLine();

            // Crear un objeto Entrenador con el nombre ingresado
            // Agregar un Pokémon al equipo del entrenador
            EquipoPokemon equipo = new EquipoPokemon();
            int[] estadisticaBase = {23, 42,34,54};
            String[] ataque = {"Hola", "bola", "hed"};
            Pokemon p = new Pokemon("Pikachu", 12, estadisticaBase, ataque );
            equipo.agregarPokemon(p);
            Entrenador entrenador = new Entrenador(equipo);

            // Enviar el entrenador al servidor
            salida.writeObject(entrenador);

            // Recibir los equipos de la caja 1 del PC del entrenador
            equipos = (ArrayList<EquipoPokemon>) entrada.readObject();
            System.out.println("Equipos de la caja 1:");
            for (EquipoPokemon eq : equipos) {
                System.out.println(eq);

            // Mostrar el menú principal
            while (true) {
                mostrarMenuPrincipal(entrenador);
                int opcion = scanner.nextInt();

                switch (opcion) {
                    case 1:
                        // Capturar un Pokemon
                        entrenador.capturarPokemon(p);;
                        break;

                    case 2:
                        // Transferir un Pokemon del equipo a una caja en la PC
                        transferirPokemonAEquipo(entrenador);
                        break;

                    case 3:
                        // Transferir un Pokemon de una caja en la PC al equipo
                        transferirPokemonAPC(entrenador);
                        break;

                    case 4:
                        // Liberar un Pokemon del equipo o una caja en la PC
                        liberarPokemon(entrenador);
                        break;

                    case 5:
                        // Mostrar el equipo del entrenador
                        mostrarEquipo(entrenador);
                        break;

                    case 6:
                        // Mostrar una caja de la PC
                        mostrarCajaPC(entrenador);
                        break;

                    case 7:
                        // Salir del programa
                        System.out.println("Adios!");
                        System.exit(0);

                    default:
                        System.out.println("Opcion no valida, intente de nuevo.");
                        break;
                }
            }

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            // Cerrar los recursos
            try {
                socket.close();
                entrada.close();
                salida.close();
                scanner.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void mostrarMenuPrincipal(Entrenador entrenador) {
        System.out.println("\n=== MENU PRINCIPAL ===");
        System.out.println("Entrenador: "  /*entrenador.getNombreEntrenador()*/);
        System.out.println("1. Capturar Pokemon");
        System.out.println("2. Transferir Pokemon del equipo a la PC");
        System.out.println("3. Transferir Pokemon de la PC al equipo");
        System.out.println("4. Liberar Pokemon");
        System.out.println("5. Mostrar equipo");
        System.out.println("6. Mostrar caja de la PC");
        System.out.println("7. Salir");
        System.out.println("=======================");
        System.out.println("Seleccione una opcion:");
    
    }
}
