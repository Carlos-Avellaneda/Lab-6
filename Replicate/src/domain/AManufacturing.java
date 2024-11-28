package domain;
import java.io.File;
import java.util.*;
import  java.lang.Class;
import java.lang.reflect.Constructor;

/*No olviden adicionar la documentacion*/
public class AManufacturing{
    public static final int SIZE=50;
    private Thing[][] lattice;
    
    public AManufacturing() {
        lattice=new Thing[SIZE][SIZE];
        for (int r=0;r<SIZE;r++){
            for (int c=0;c<SIZE;c++){
                lattice[r][c]=null;
            }
        }
        someThings();
    }

    public int  getSize(){
        return SIZE;
    }

    public Thing getThing(int r,int c){
        return lattice[r][c];
    }

    public void setThing(int r, int c, Thing e){
        lattice[r][c]=e;
    }

    public void someThings() {
        TouristCell move = new TouristCell(this, 0, 0); // Célula turista activa en (10, 10)
        EnergyCell walk = new EnergyCell(this, 5, 0); // Célula turista activa en (15, 15)
        
        // Añadiendo gotas de veneno
        Poison mercury = new Poison(); // Gota de veneno en la esquina superior izquierda
        Poison arsenic = new Poison(); // Gota de veneno en la esquina superior derecha
        
        setThing(0, 1, mercury);
        setThing(0, 5, arsenic);
    }

    public int neighborsActive(int r, int c){
        int num=0;
        for(int dr=-1; dr<2;dr++){
            for (int dc=-1; dc<2;dc++){
                if ((dr!=0 || dc!=0) && inLatice(r+dr,c+dc) && 
                    (lattice[r+dr][c+dc]!=null) &&  (lattice[r+dr][c+dc].isActive())) num++;
            }
        }
        return (inLatice(r,c) ? num : 0);
    }

    public boolean isEmpty(int r, int c){
        return (inLatice(r,c) && lattice[r][c]==null);
    }    
        
    private boolean inLatice(int r, int c){
        return ((0<=r) && (r<SIZE) && (0<=c) && (c<SIZE));
    }

    public void ticTac() {
        // Primera pasada: decidir el próximo estado
        for (int r = 0; r < SIZE; r++) {
            for (int c = 0; c < SIZE; c++) {
                Thing thing = lattice[r][c];
                if (thing instanceof Cell) {
                    ((Cell) thing).decide(); // Llama al método decide() para cada celda
                }
            }
        }
    
        // Actualiza el color del veneno
        for (int r = 0; r < SIZE; r++) {
            for (int c = 0; c < SIZE; c++) {
                Thing thing = lattice[r][c];
                if (thing instanceof Poison) {
                    ((Poison) thing).updateColor(); // Llama al método para actualizar el color del veneno
                }
            }
        }
    
        // Segunda pasada: cambiar el estado actual
        for (int r = 0; r < SIZE; r++) {
            for (int c = 0; c < SIZE; c++) {
                Thing thing = lattice[r][c];
                if (thing instanceof Cell) {
                    ((Cell) thing).change(); // Llama al método change() para cada celda
                }
            }
        }
    }

    /**
     * Abre un archivo para ser procesado en el sistema.
     *
     * @param archivo el archivo a ser abierto.
     * @return una instancia de {@code AManufacturing} representando los datos del archivo abierto.
     * @throws AManufacturingException si la operación aún no está implementada.
     */
    public static AManufacturing open (File archivo) throws AManufacturingException {
        throw new AManufacturingException("Opción open en construcción. Archilvo " + archivo.getName());
    }
    /**
     * Guarda los datos actuales en el archivo especificado.
     *
     * @param archivo el archivo donde los datos serán guardados.
     * @throws AManufacturingException si la operación aún no está implementada.
     */
    public void save (File archivo) throws AManufacturingException {
        throw new AManufacturingException("Opción save en construcción. Archilvo " + archivo.getName());
    }
    /**
     * Importa datos desde el archivo especificado.
     *
     * @param archivo el archivo desde el cual se importarán los datos.
     * @return el archivo importado.
     * @throws AManufacturingException si la operación aún no está implementada.
     */
    public static AManufacturing importFile (File archivo) throws AManufacturingException {
        throw new AManufacturingException("Opción import en construcción. Archilvo " + archivo.getName());
    }
    /**
     * Exporta los datos actuales al archivo especificado.
     *
     * @param archivo el archivo al cual se exportarán los datos.
     * @throws AManufacturingException si la operación aún no está implementada.
     */
    public void export (File archivo) throws AManufacturingException {
        throw new AManufacturingException("Opción export en construcción. Archilvo " + archivo.getName());
    }
}
