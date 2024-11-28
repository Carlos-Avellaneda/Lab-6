package domain;

import java.awt.Color;

/**
 * Clase que representa una célula de energía en el sistema.
 * Acumula energía en cada ciclo y cambia su estado basado en la energía acumulada.
 */
public class EnergyCell extends Cell {
    private int energy; // Energía acumulada
    private static final int ENERGY_THRESHOLD = 5; // Umbral para cambiar a inactiva

    /**
     * Crea una nueva célula de energía en el sistema de manufactura.
     *
     * @param am referencia al objeto AManufacturing que gestiona las celdas
     * @param row fila en la que se ubicará la celda
     * @param column columna en la que se ubicará la celda
     */
    public EnergyCell(AManufacturing am, int row, int column) {
        super(am, row, column, true); // Inicia como activa
        this.energy = 0; // Inicializa la energía acumulada
        this.color = Color.CYAN; // Color inicial de la célula
    }

    @Override
    public void decide() {
        if (isActive()) {
            energy++; // Acumula energía si está activa
            
            // Cambia a inactiva si alcanza el umbral de energía
            if (energy >= ENERGY_THRESHOLD) {
                state = Artefact.INACTIVE; // Cambia el estado a inactivo
                color = Color.GRAY; // Cambia el color al llegar al umbral
            }
        }
    }


    @Override
    public void change() {
        super.change(); 
    }

    public int getEnergy() {
        return energy; // Método para obtener la energía acumulada
    }

    @Override
    public Color getColor() {
        return color; // Método para obtener el color actual
    }

}