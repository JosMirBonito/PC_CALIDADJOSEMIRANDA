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
    public static void FinalizarPrueba() {
        System.out.println("\n[FIN DE PRUEBAS UNITARIASJoseMiranda Email]\n");
    }

    @Test
    public void testValidarEmail_Excepciones_NuloOVacio() {
        Email validador = new Email();
        String mensajeError = "El correo no puede ser nulo o vacío";

        // Caso Nulo
        Exception e1 = assertThrows(IllegalArgumentException.class, () -> validador.isValidEmail(null));
        assertEquals(mensajeError, e1.getMessage());

        // Caso Vacío
        Exception e2 = assertThrows(IllegalArgumentException.class, () -> validador.isValidEmail(""));
        assertEquals(mensajeError, e2.getMessage());

        // Caso Solo Espacios
        Exception e3 = assertThrows(IllegalArgumentException.class, () -> validador.isValidEmail("   "));
        assertEquals(mensajeError, e3.getMessage());
    }

    @Test
    public void testValidarEmail_LongitudYEspacios() {
        Email validador = new Email();

        // Muy corto
        assertFalse(validador.isValidEmail("a@b.c"));

        // Muy largo
        String emailLargo = "a".repeat(250) + "@b.co"; 
        assertFalse(validador.isValidEmail(emailLargo));

        // Con espacios intermedios
        assertFalse(validador.isValidEmail("j ose@test.com"));
    }

    @Test
    public void testValidarEmail_EstructuraArroba() {
        Email validador = new Email();

        // Sin arroba
        assertFalse(validador.isValidEmail("Jose.com"));

        // Empieza con arroba
        assertFalse(validador.isValidEmail("@test.com"));

        // Termina con arroba
        assertFalse(validador.isValidEmail("jose@"));

        // Doble arroba separada
        assertFalse(validador.isValidEmail("jose@test@com"));
    }

    @Test
    public void testValidarEmail_ValidacionParteLocal() {
        Email validador = new Email();

        // Empieza con punto
        assertFalse(validador.isValidEmail(".jose@test.com"));

        // Termina con punto (antes de la arroba)
        assertFalse(validador.isValidEmail("jose.@test.com"));

        // Puntos consecutivos
        assertFalse(validador.isValidEmail("jo..se@test.com"));

        // Caracter no permitido (!)
        assertFalse(validador.isValidEmail("jo!se@test.com"));
    }

    @Test
    public void testValidarEmail_ValidacionDominio() {
        Email validador = new Email();

        // Sin punto en dominio
        assertFalse(validador.isValidEmail("Jose@com"));

        // Dominio muy corto
        assertFalse(validador.isValidEmail("Jose@x.com"));

        // Termina en punto
        assertFalse(validador.isValidEmail("Jose@test."));
    }

   // lo que agregue para completar el 100%
       @Test
    public void testValidarEmail_CasoExitoso() {
        Email validador = new Email();

        assertTrue(validador.isValidEmail("Jose123@tienda.com"));

        assertTrue(validador.isValidEmail("Jose.ventas@mi-tienda.pe"));
    }

    @Test
    public void testValidarEmail_MultiplesArrobas() {
        Email validador = new Email();
        assertFalse(validador.isValidEmail("user@@gmail.com"));
    }

    @Test
    public void testValidarEmail_EmpiezaConArroba() {
        Email validador = new Email();
        assertFalse(validador.isValidEmail("@gmail.com"));
    }

    @Test
    public void testValidarEmail_TerminaConArroba() {
        Email validador = new Email();
        assertFalse(validador.isValidEmail("user@"));
    }

}