/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import com.mycompany.pagoconsola.PasswordValidator;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PasswordValidatorTest {

    @BeforeAll
    public static void IniciarPrueba() {
        System.out.println("\n[INICIO DE PRUEBAS UNITARIAS PasswordValidator]\n");
    }



    @Test
    public void testIsValid_Exceptions_NullOrEmpty() {
        String errorMsg = "La contraseña no puede ser nula o vacía";

        Exception e1 = assertThrows(IllegalArgumentException.class, () -> {
            PasswordValidator.isValid(null);
        });
        assertEquals(errorMsg, e1.getMessage());

        Exception e2 = assertThrows(IllegalArgumentException.class, () -> {
            PasswordValidator.isValid("");
        });
        assertEquals(errorMsg, e2.getMessage());
    }

    @Test
    public void testIsValid_BasicValidations() {
        assertFalse(PasswordValidator.isValid("Pass1!"));

        assertFalse(PasswordValidator.isValid("Pass 1!_"));
    }

    @Test
    public void testIsValid_CharacterRequirements() {
        assertFalse(PasswordValidator.isValid("password123!"));

        assertFalse(PasswordValidator.isValid("PASSWORD123!"));

        assertFalse(PasswordValidator.isValid("Password!!"));

        assertFalse(PasswordValidator.isValid("Password123"));
    }

    @Test
    public void testIsValid_Success() {
        assertTrue(PasswordValidator.isValid("Password1!"));
        
        assertTrue(PasswordValidator.isValid("Secure#99"));
    }
}
