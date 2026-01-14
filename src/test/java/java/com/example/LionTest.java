package com.example;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class LionTest {

    @Test
    public void testLionConstructorInvalidSex() {
        try {
            new Lion("Неизвестный");
            fail("Должно быть выброшено исключение для невалидного пола");
        } catch (Exception e) {
            assertTrue("Сообщение об ошибке должно содержать 'Используйте допустимые значения'",
                    e.getMessage().contains("Используйте допустимые значения"));
            assertTrue("Сообщение об ошибке должно содержать 'самей или самка'",
                    e.getMessage().contains("самей или самка"));
        }
    }

    @Test
    public void testLionConstructorEmptySex() {
        try {
            new Lion("");
            fail("Должно быть выброшено исключение для пустого пола");
        } catch (Exception e) {
            assertTrue("Сообщение об ошибке должно содержать 'Используйте допустимые значения'",
                    e.getMessage().contains("Используйте допустимые значения"));
        }
    }

    @Test
    public void testLionConstructorNullSex() {
        try {
            new Lion(null);
            fail("Должно быть выброшено исключение для null пола");
        } catch (Exception e) {
            assertTrue("Сообщение об ошибке должно содержать 'Используйте допустимые значения'",
                    e.getMessage().contains("Используйте допустимые значения"));
        }
    }

    @Test
    public void testMaleLionHasMane() throws Exception {
        Lion lion = new Lion("Самец");
        assertTrue("Самец льва должен иметь гриву", lion.doesHaveMane());
    }

    @Test
    public void testFemaleLionHasNoMane() throws Exception {
        Lion lion = new Lion("Самка");
        assertFalse("Самка льва не должна иметь гриву", lion.doesHaveMane());
    }

    @Test
    public void testGetFoodConsistency() throws Exception {
        Lion lion = new Lion("Самец");
        List<String> food = lion.getFood();
        assertNotNull("Еда не должна быть null", food);
        assertFalse("Список еды не должен быть пустым", food.isEmpty());
        assertEquals("Должно быть 3 вида еды", 3, food.size());
        assertTrue("Должны содержаться 'Животные'", food.contains("Животные"));
        assertTrue("Должны содержаться 'Птицы'", food.contains("Птицы"));
        assertTrue("Должны содержаться 'Рыба'", food.contains("Рыба"));
    }

    @Test
    public void testGetKittensConsistency() throws Exception {
        Lion lion = new Lion("Самка");
        assertEquals("Должен возвращаться 1 котенок", 1, lion.getKittens());

        // Проверяем несколько вызовов
        assertEquals("Повторный вызов должен возвращать 1", 1, lion.getKittens());
        assertEquals("Третий вызов должен возвращать 1", 1, lion.getKittens());
    }

    @Test
    public void testMultipleLionInstances() throws Exception {
        Lion maleLion = new Lion("Самец");
        Lion femaleLion = new Lion("Самка");

        assertTrue("Первый лев (самец) должен иметь гриву", maleLion.doesHaveMane());
        assertFalse("Второй лев (самка) не должен иметь гриву", femaleLion.doesHaveMane());
        assertEquals("Оба льва должны возвращать одинаковое количество котят",
                maleLion.getKittens(), femaleLion.getKittens());

        List<String> maleFood = maleLion.getFood();
        List<String> femaleFood = femaleLion.getFood();
        assertEquals("Еда у львов разного пола должна быть одинаковой",
                maleFood, femaleFood);
    }
}