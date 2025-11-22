/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pagoconsola;

import java.util.HashMap;
import java.util.Map;

public class InventoryManager {
//a
    private Map<String, Integer> inventory = new HashMap<>();

    public void AddItem(String name, int quantity) {

        if (name == null || name.trim().isEmpty() || name.length() < 2 || name.length() > 50) {
            throw new IllegalArgumentException("El nombre del producto no puede estar vacío");
        }

        if (quantity < 1 || quantity > 1000) {
            throw new IllegalArgumentException("El nombre del producto no puede estar vacío");
        }

        inventory.put(name, inventory.getOrDefault(name, 0) + quantity);
    }

    public Map<String, Integer> getInventory() {
        return inventory;
    }
}
