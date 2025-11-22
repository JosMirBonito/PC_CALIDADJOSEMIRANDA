/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import com.mycompany.pagoconsola.Email;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EmailTest {

    @BeforeAll
    public static void IniciarPrueba() {
        System.out.println("\n[INICIO DE PRUEBAS UNITARIASJoseMiranda Email]\n");
    }

    @AfterAll
    public static void endAll() {
        System.out.println("\n[FIN DE PRUEBAS UNITARIASJoseMiranda Email]\n");
    }

    @Test
    public void testIsValidEmail_Exceptions_NullOrEmpty() {
        Email validator = new Email();
        String errorMsg = "El correo no puede ser nulo o vacío";

        Exception e1 = assertThrows(IllegalArgumentException.class, () -> validator.isValidEmail(null));
        assertEquals(errorMsg, e1.getMessage());

        Exception e2 = assertThrows(IllegalArgumentException.class, () -> validator.isValidEmail(""));
        assertEquals(errorMsg, e2.getMessage());

        Exception e3 = assertThrows(IllegalArgumentException.class, () -> validator.isValidEmail("   "));
        assertEquals(errorMsg, e3.getMessage());
    }

 
    @Test
    public void testIsValidEmail_LengthAndSpaces() {
        Email validator = new Email();

        assertFalse(validator.isValidEmail("a@b.c"));

        String longEmail = "a".repeat(250) + "@b.co"; 
        assertFalse(validator.isValidEmail(longEmail));

        assertFalse(validator.isValidEmail("j ose@test.com"));
    }

    @Test
    public void testIsValidEmail_AtSignStructure() {
        Email validator = new Email();

        assertFalse(validator.isValidEmail("Jose.com"));

        assertFalse(validator.isValidEmail("@test.com"));

        assertFalse(validator.isValidEmail("jose@"));

        assertFalse(validator.isValidEmail("jose@test@com"));
    }

    @Test
    public void testIsValidEmail_LocalPartValidation() {
        Email validator = new Email();

        assertFalse(validator.isValidEmail(".jose@test.com"));

        assertFalse(validator.isValidEmail("jose.@test.com"));

        assertFalse(validator.isValidEmail("jo..se@test.com"));

        assertFalse(validator.isValidEmail("jo!se@test.com"));
    }

    @Test
    public void testIsValidEmail_DomainPartValidation() {
        Email validator = new Email();

        assertFalse(validator.isValidEmail("Jose@com"));

        assertFalse(validator.isValidEmail("Jose@x.com"));

        assertFalse(validator.isValidEmail("Jose@test."));
    }

    @Test
    public void testIsValidEmail_Success() {
        Email validator = new Email();

        assertTrue(validator.isValidEmail("Jose123@tienda.com"));

        assertTrue(validator.isValidEmail("Jose.ventas@mi-tienda.pe"));
    }
}