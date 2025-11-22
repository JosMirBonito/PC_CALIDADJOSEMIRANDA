/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import com.mycompany.pagoconsola.TextProcessor;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
/**
 *
 * @author rodri
 */
public class TextProcessorTest {

    @BeforeAll
    public static void IniciarPrueba() {
        System.out.println("\n[INICIO DE PRUEBAS UNITARIAS JOSEMIRANDA TextProcessor]\n");
    }

    @AfterAll
    public static void endAll() {
        System.out.println("\n[FIN DE PRUEBAS UNITARIAS JOSEMIRANDA TextProcessor]\n");
    }

    @Test
    public void testReverseAndCapitalize_Null() {
        TextProcessor processor = new TextProcessor();
        
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            processor.reverseAndCapitalize(null);
        });
        
        assertEquals("El texto no puede ser nulo", exception.getMessage());
    }

    @Test
    public void testReverseAndCapitalize_EmptyOrSpaces() {
        TextProcessor processor = new TextProcessor();
        String expectedMsg = "El texto no puede estar vacío o contener solo espacios";

        Exception e1 = assertThrows(IllegalArgumentException.class, () -> {
            processor.reverseAndCapitalize("");
        });
        assertEquals(expectedMsg, e1.getMessage());

        Exception e2 = assertThrows(IllegalArgumentException.class, () -> {
            processor.reverseAndCapitalize("     ");
        });
        assertEquals(expectedMsg, e2.getMessage());
    }

    @Test
    public void testReverseAndCapitalize_LengthExceeded() {
        TextProcessor processor = new TextProcessor();
        
        String longText = "a".repeat(1001);
        
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            processor.reverseAndCapitalize(longText);
        });
        
        assertEquals("El texto excede el límite de 1000 caracteres", exception.getMessage());
    }

    @Test
    public void testReverseAndCapitalize_Success() {
        TextProcessor processor = new TextProcessor();

        String result1 = processor.reverseAndCapitalize("Hola mundo");
        assertEquals("ODNUM ALOH", result1);

        String result2 = processor.reverseAndCapitalize(" hola ");
        assertEquals("ALOH", result2);
    }
}