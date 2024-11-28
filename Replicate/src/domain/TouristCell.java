package domain;

import java.awt.Color;

/**
 * Clase que representa una celda turística en un sistema de manufactura.
 * Esta celda tiene un comportamiento específico: se mueve hacia el centro
 * del sistema cuando está activa y hacia los bordes cuando está inactiva.
 */
public class TouristCell extends Cell {
    private int targetRow;    // Fila objetivo a la que se dirige la celda
    private int targetColumn; // Columna objetivo a la que se dirige la celda

    /**
     * Crea una nueva celda turística en el sistema de manufactura.
     *
     * @param am referencia al objeto AManufacturing que gestiona las celdas
     * @param row fila en la que se ubicará la celda
     * @param column columna en la que se ubicará la celda
     */
    public TouristCell(AManufacturing am, int row, int column) {
        super(am, row, column, true); // Inicia como activa
        this.color = Color.ORANGE; // Color inicial de la celda
    }

    /**
     * Decide el siguiente estado de la celda turística basado en su estado actual.
     * - Si está activa, se mueve hacia el centro del sistema.
     * - Si está inactiva, se mueve hacia los bordes del sistema.
     */
    @Override
    public void decide() {
        if (isActive()) {
            // Lógica para moverse hacia el centro
            targetRow = AManufacturing.SIZE / 2;
            targetColumn = AManufacturing.SIZE / 2;
    
            // Mueve la celda hacia el centro
            if (row < targetRow) {
                row++; // Mueve hacia abajo
            } else if (row > targetRow) {
                row--; // Mueve hacia arriba
            }
    
            if (column < targetColumn) {
                column++; // Mueve a la derecha
            } else if (column > targetColumn) {
                column--; // Mueve a la izquierda
            }
    
            // Cambia a inactiva si llega al centro
            if (row == targetRow && column == targetColumn) {
                color = Color.YELLOW; // Cambia el color al llegar al centro
                state = Artefact.INACTIVE;
            }
        } else {
            // Lógica para moverse hacia los bordes
            int edgeRow = (row == 0) ? 0 : (row == AManufacturing.SIZE - 1) ? AManufacturing.SIZE - 1 : (row < AManufacturing.SIZE / 2) ? 0 : AManufacturing.SIZE - 1;
            int edgeColumn = (column == 0) ? 0 : (column == AManufacturing.SIZE - 1) ? AManufacturing.SIZE - 1 : (column < AManufacturing.SIZE / 2) ? 0 : AManufacturing.SIZE - 1;
    
            // Mueve la celda hacia los bordes
            if (row < edgeRow) {
                row++; // Mueve hacia abajo
            } else if (row > edgeRow) {
                row--; // Mueve hacia arriba
            }
    
            if (column < edgeColumn) {
                column++; // Mueve a la derecha
            } else if (column > edgeColumn) {
                column--; // Mueve a la izquierda
            }
    
            // Cambia a activa si llega al borde
            if (row == edgeRow && column == edgeColumn) {
                color = Color.ORANGE; // Cambia el color al llegar al borde
                state = Artefact.ACTIVE;
            }
        }
    }

    /**
     * Cambia el estado actual de la celda turística y aumenta el contador de pasos.
     */
    @Override
    public void change() {
        super.change(); 
    }
}