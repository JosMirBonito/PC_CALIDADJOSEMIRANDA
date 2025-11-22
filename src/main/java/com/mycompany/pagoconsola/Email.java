/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pagoconsola;

/**
 *
 * @author rodri
 */
public class Email {

    public boolean isValidEmail(String email) {
        
        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("El correo no puede ser nulo o vacío");
        }

        if (email.length() < 6 || email.length() > 254) {
            return false;
        }

        if (email.contains(" ")) {
            return false;
        }

        int atIndex = email.indexOf('@');
        if (atIndex == -1 || atIndex != email.lastIndexOf('@') || atIndex == 0 || atIndex == email.length() - 1) {
            return false;
        }

        String localPart = email.substring(0, atIndex);
        String domainPart = email.substring(atIndex + 1);

        if (localPart.startsWith(".") || localPart.endsWith(".")) {
            return false;
        }
        if (localPart.contains("..")) {
            return false;
        }
        if (!localPart.matches("[a-zA-Z0-9._-]+")) {
            return false;
        }

        int dotIndex = domainPart.indexOf('.');
        
        if (dotIndex == -1) {
            return false; 
        }

        String domainName = domainPart.substring(0, dotIndex);
        if (domainName.length() < 2) {
            return false;
        }

        String extension = domainPart.substring(dotIndex + 1);
        if (extension.isEmpty()) {
            return false;
        }

        return true;
    }
}