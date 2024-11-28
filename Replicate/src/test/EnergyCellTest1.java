package test;
import domain.*;
import java.awt.Color;
import static org.junit.Assert.*;
import org.junit.Test;

public class EnergyCellTest1 {

    @Test
    public void testInitialState() {
        AManufacturing am = new AManufacturing();
        EnergyCell cell = new EnergyCell(am, 1, 1); // Célula activa en (1, 1)

        assertTrue(cell.isActive()); // Debe ser activa inicialmente
        assertEquals(0, cell.getEnergy()); // Debe tener 0 de energía acumulada
        assertEquals(Color.CYAN, cell.getColor()); // Debe ser cyan inicialmente
    }
}
