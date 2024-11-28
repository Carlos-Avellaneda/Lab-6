package domain;

import java.awt.Color;
import java.util.Random;

/**
 * Clase que representa una gota de veneno en el sistema.
 * El veneno cambia de color en cada tic-tac siguiendo el orden del arcoíris.
 */
public class Poison implements Thing {
    private Color color; // Color actual del veneno
    private static final Color[] RAINBOW_COLORS = {
        Color.RED, Color.ORANGE, Color.YELLOW, 
        Color.GREEN, Color.BLUE, Color.MAGENTA
    };
    private int currentColorIndex; // Índice del color actual

    /**
     * Crea una nueva gota de veneno con un color inicial aleatorio.
     */
    public Poison() {
        Random rand = new Random();
        currentColorIndex = rand.nextInt(RAINBOW_COLORS.length);
        color = RAINBOW_COLORS[currentColorIndex];
    }

    /**
     * Cambia el color del veneno al siguiente en el arcoíris.
     */
    public void updateColor() {
        currentColorIndex = (currentColorIndex + 1) % RAINBOW_COLORS.length;
        color = RAINBOW_COLORS[currentColorIndex];
    }

    /**
     * Devuelve el color actual del veneno.
     *
     * @return el color actual
     */
    public Color getColor() {
        return color;
    }

    // Implementación de métodos de la interfaz Thing si es necesario
    @Override
    public void decide() {
        // No se necesita lógica para decide en Poison
    }

    @Override
    public void change() {
        // No se necesita lógica para change en Poison
    }
}