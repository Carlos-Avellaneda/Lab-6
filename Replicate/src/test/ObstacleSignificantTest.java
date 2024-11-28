package test;
import domain.*;

import static org.junit.Assert.*;
import org.junit.Test;
import java.awt.Color;

public class ObstacleSignificantTest {

    @Test
    public void testCarlosAndDavidObstacles() {
        Obstacle carlos = new Obstacle(0, 0, Color.BLUE); // Crear un obstáculo llamado Carlos
        Obstacle david = new Obstacle(1, 1, Color.YELLOW); // Crear un obstáculo llamado David

        assertEquals(0, carlos.getRow()); // Verifica la fila de Carlos
        assertEquals(0, carlos.getColumn()); // Verifica la columna de Carlos
        assertEquals(Color.BLUE, carlos.getColor()); // Verifica el color de Carlos

        assertEquals(1, david.getRow()); // Verifica la fila de David
        assertEquals(1, david.getColumn()); // Verifica la columna de David
        assertEquals(Color.YELLOW, david.getColor()); // Verifica el color de David
    }
}