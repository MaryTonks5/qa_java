package com.example;

import org.junit.Test;
import static org.junit.Assert.*;

public class AnimalTest {

    @Test
    public void testGetFamilyContainsSeveralFamilies() {
        com.example.Animal animal = new com.example.Animal();  // Полное имя
        String family = animal.getFamily();
        assertTrue("Описание семейства должно содержать 'несколько семейств'",
                family.contains("несколько семейств"));
    }

    @Test
    public void testGetFamilyContainsFeline() {
        com.example.Animal animal = new com.example.Animal();
        String family = animal.getFamily();
        assertTrue("Описание должно содержать 'кошачьи'",
                family.contains("кошачьи"));
    }

    @Test
    public void testGetFamilyContainsCanine() {
        com.example.Animal animal = new com.example.Animal();
        String family = animal.getFamily();
        assertTrue("Описание должно содержать 'псовые'",
                family.contains("псовые"));
    }
}