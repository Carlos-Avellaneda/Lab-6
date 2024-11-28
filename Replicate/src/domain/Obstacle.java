package domain;

import java.awt.Color;

/**
 * Clase que representa un obstáculo en el sistema.
 * Los obstáculos pueden afectar el movimiento de las células.
 */
public class Obstacle implements Thing {
    private Color color; // Color del obstáculo
    private int row;     // Fila del obstáculo
    private int column;  // Columna del obstáculo

    /**
     * Crea un nuevo obstáculo en la cuadrícula.
     *
     * @param row fila en la que se ubicará el obstáculo
     * @param column columna en la que se ubicará el obstáculo
     * @param color color del obstáculo
     */
    public Obstacle(int row, int column, Color color) {
        this.row = row;
        this.column = column;
        this.color = color;
    }

    public Color getColor() {
        return color; // Devuelve el color del obstáculo
    }

    public int getRow() {
        return row; // Devuelve la fila del obstáculo
    }

    public int getColumn() {
        return column; // Devuelve la columna del obstáculo
    }

    @Override
    public boolean isActive() {
        return true; // Un obstáculo siempre está "activo"
    }

    @Override
    public void decide() {
    }
}