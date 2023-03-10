package co.edu.unbosque.model;
import java.util.Arrays;

public class Pokemon {
    
    private String nombre;
    private int nivel;
    private int[] estadisticasBase;
    private String[] ataques;
    
    public Pokemon(String nombre, int nivel, int[] estadisticasBase, String[] ataques) {
        this.nombre = nombre;
        this.nivel = nivel;
        this.estadisticasBase = estadisticasBase;
        this.ataques = ataques;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public int getNivel() {
        return nivel;
    }
    
    public int[] getEstadisticasBase() {
        return estadisticasBase;
    }
    
    public String[] getAtaques() {
        return ataques;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
    
    public void setEstadisticasBase(int[] estadisticasBase) {
        this.estadisticasBase = estadisticasBase;
    }
    
    public void setAtaques(String[] ataques) {
        this.ataques = ataques;
    }
    
    public void mostrarDatos() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Nivel: " + nivel);
        System.out.println("Estadisticas base: " + Arrays.toString(estadisticasBase));
        System.out.println("Ataques: " + Arrays.toString(ataques));
    }
    
}
