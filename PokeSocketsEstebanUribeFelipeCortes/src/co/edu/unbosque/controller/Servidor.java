package co.edu.unbosque.controller;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import co.edu.unbosque.model.Entrenador;
import co.edu.unbosque.model.EquipoPokemon;

public class Servidor {
    public static void main(String[] args) {
        int puertoServidor = 5000; // número de puerto del servidor
        ServerSocket servidor;
        Socket socket;
        ObjectInputStream entrada;
        ObjectOutputStream salida;

        try {
            servidor = new ServerSocket(puertoServidor);
            System.out.println("Servidor iniciado. Esperando conexiones...");

            while (true) {
                socket = servidor.accept();
                entrada = new ObjectInputStream(socket.getInputStream());
                salida = new ObjectOutputStream(socket.getOutputStream());

                // Recibir el entrenador del cliente
                Entrenador entrenador = (Entrenador) entrada.readObject();

                // Obtener los equipos de la caja 1 del PC del entrenador
                ArrayList<EquipoPokemon> equiposCaja1 = entrenador.getCajaPC().getCaja1();

                // Enviar los equipos de la caja 1 al cliente
                salida.writeObject(equiposCaja1);

                socket.close();
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

