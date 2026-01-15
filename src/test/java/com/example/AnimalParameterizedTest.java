package com.example;

import com.example.Animal;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class AnimalParameterizedTest {
    private final String animalKind;
    private final List<String> expectedFood;
    private final boolean shouldThrowException;

    public AnimalParameterizedTest(String animalKind, List<String> expectedFood, boolean shouldThrowException) {
        this.animalKind = animalKind;
        this.expectedFood = expectedFood;
        this.shouldThrowException = shouldThrowException;
    }

    @Parameterized.Parameters(name = "Вид: {0}")
    public static Object[][] getAnimalKindData() {
        return new Object[][] {
                {"Травоядное", Arrays.asList("Трава", "Различные растения"), false},
                {"Хищник", Arrays.asList("Животные", "Птицы", "Рыба"), false},
                {"Всеядное", null, true},
                {"Неизвестный", null, true},
                {"", null, true},
                {null, null, true}
        };
    }

    @Test
    public void testGetFood() throws Exception {
        Animal animal = new Animal();

        if (shouldThrowException) {
            try {
                animal.getFood(animalKind);
                fail("Должно быть выброшено исключение для вида: " + animalKind);
            } catch (Exception e) {
                assertTrue("Сообщение об ошибке должно содержать 'Неизвестный вид животного'",
                        e.getMessage().contains("Неизвестный вид животного"));
            }
        } else {
            List<String> actualFood = animal.getFood(animalKind);
            assertEquals("Еда для вида " + animalKind + " должна соответствовать ожидаемой",
                    expectedFood, actualFood);
        }
    }
}