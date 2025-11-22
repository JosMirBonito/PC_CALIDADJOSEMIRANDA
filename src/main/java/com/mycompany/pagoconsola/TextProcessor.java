/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pagoconsola;

/**
 *
 * @author rodri
 */
public class TextProcessor {

    public String reverseAndCapitalize(String input) {
        if (input == null) {
            throw new IllegalArgumentException("El texto no puede ser nulo");
        }

        if (input.trim().isEmpty()) {
            throw new IllegalArgumentException("El texto no puede estar vacío o contener solo espacios");
        }

        if (input.length() > 1000) {
            throw new IllegalArgumentException("El texto excede el límite de 1000 caracteres");
        }

      
        String trimmed = input.trim();
        StringBuilder reversed = new StringBuilder(trimmed).reverse();
        
        return reversed.toString().toUpperCase();
    }
}
