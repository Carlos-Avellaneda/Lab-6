package test;
import domain.*;
import static org.junit.Assert.*;
import org.junit.Test;
import java.awt.Color;

public class EnergyCellSignificantTest {

    @Test
    public void testCarlosAndDavid() {
        AManufacturing am = new AManufacturing();
        
        EnergyCell carlos = new EnergyCell(am, 2, 2); // Célula activa en (2, 2)
        EnergyCell david = new EnergyCell(am, 3, 3);   // Célula activa en (3, 3)
        
        for (int i = 0; i < 6; i++) { // Simula seis ciclos ticTac para ambos
            carlos.decide();
            david.decide();
            carlos.change();
            david.change();
        }

    
        
        assertEquals(Color.GRAY, carlos.getColor()); // Carlos debe ser gris cuando inactiva
        assertEquals(Color.GRAY, david.getColor());   // David debe ser gris cuando inactiva
        
        assertEquals(6, carlos.getEnergy()); // Carlos debe tener 6 de energía acumulada
        assertEquals(6, david.getEnergy());   // David debe tener 6 de energía acumulada
    }
}