package test;
import domain.*;

import static org.junit.Assert.*;
import org.junit.Test;
import java.awt.Color;

public class ObstacleTest {

    @Test
    public void testObstacleActiveState() {
        Obstacle obstacle = new Obstacle(1, 1, Color.GREEN); // Crear un obstáculo en (1, 1)

        assertTrue(obstacle.isActive()); // Verifica que el obstáculo esté activo
        assertEquals(Color.GREEN, obstacle.getColor()); // Verifica el color
    }
}