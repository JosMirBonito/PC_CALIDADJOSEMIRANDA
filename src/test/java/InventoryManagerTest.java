import com.mycompany.pagoconsola.InventoryManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class InventoryManagerTest {

    @BeforeAll
    public static void IniciarPrueba() {
        System.out.println("\n[INICIO DE PRUEBAS UNITARIAS JOSEMIRANDA InventoryManager]\n");
    }

    @AfterAll
    public static void endAll() {
        System.out.println("\n[FIN DE PRUEBAS UNITARIAS JOSEMIRANDA InventoryManager]\n");
    }

   @Test
    void testFuncionamientoCorrecto() {
        InventoryManager m = new InventoryManager();
        
        m.AddItem("CocaCola", 10);
        assertEquals(10, m.getInventory().get("CocaCola"));
        
        m.AddItem("CocaCola", 5);
        assertEquals(15, m.getInventory().get("CocaCola"));
    }

    @Test
    void testNombresInvalidos() {
        InventoryManager m = new InventoryManager();

        assertThrows(IllegalArgumentException.class, () -> m.AddItem(null, 50));
        
        assertThrows(IllegalArgumentException.class, () -> m.AddItem("", 50));
        
        assertThrows(IllegalArgumentException.class, () -> m.AddItem("A", 50));
        
        String nombreLargo = "A".repeat(51); 
        assertThrows(IllegalArgumentException.class, () -> m.AddItem(nombreLargo, 50));
    }

    @Test
    void testCantidadesInvalidas() {
        InventoryManager m = new InventoryManager();

        assertThrows(IllegalArgumentException.class, () -> m.AddItem("Pera", 0));
        
        assertThrows(IllegalArgumentException.class, () -> m.AddItem("Pera", 1001));
    }
}