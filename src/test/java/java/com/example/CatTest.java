package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Mock
    Feline feline;

    @Test
    public void testGetSound() {
        Cat cat = new Cat(feline);
        assertEquals("Кот должен мяукать", "Мяу", cat.getSound());
    }

    @Test
    public void testGetFood() throws Exception {
        Cat cat = new Cat(feline);
        List<String> expectedFood = Arrays.asList("Животные", "Птицы", "Рыба");

        when(feline.eatMeat()).thenReturn(expectedFood);

        List<String> actualFood = cat.getFood();

        assertEquals("Еда кота должна совпадать с едой хищника",
                expectedFood, actualFood);
        Mockito.verify(feline, Mockito.times(1)).eatMeat();
    }

    @Test
    public void testGetFoodWithException() throws Exception {
        Cat cat = new Cat(feline);
        when(feline.eatMeat()).thenThrow(new Exception("Ошибка при получении еды"));

        try {
            cat.getFood();
            fail("Должно было быть выброшено исключение");
        } catch (Exception e) {
            assertEquals("Ошибка при получении еды", e.getMessage());
        }

        Mockito.verify(feline, Mockito.times(1)).eatMeat();
    }

    @Test
    public void testMultipleGetFoodCalls() throws Exception {
        Cat cat = new Cat(feline);
        List<String> expectedFood = Arrays.asList("Мясо", "Рыба");

        when(feline.eatMeat()).thenReturn(expectedFood);

        cat.getFood();
        cat.getFood();

        Mockito.verify(feline, Mockito.times(2)).eatMeat();
    }
}