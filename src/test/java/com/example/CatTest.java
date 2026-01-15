package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Mock
    private Predator predatorMock;

    private Cat cat;

    @Before
    public void setUp() {
        cat = new Cat(predatorMock);
    }

    @Test
    public void testGetSound() {
        assertEquals("Кот должен мяукать", "Мяу", cat.getSound());
    }

    @Test
    public void testGetFoodReturnsCorrectList() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        when(predatorMock.eatMeat()).thenReturn(expectedFood);

        List<String> actualFood = cat.getFood();
        assertEquals("Еда кота должна совпадать с едой хищника",
                expectedFood, actualFood);
    }

    @Test
    public void testGetFoodCallsEatMeatOnce() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        when(predatorMock.eatMeat()).thenReturn(expectedFood);

        cat.getFood();
        Mockito.verify(predatorMock, Mockito.times(1)).eatMeat();
    }

    @Test(expected = Exception.class)
    public void testGetFoodThrowsException() throws Exception {
        when(predatorMock.eatMeat()).thenThrow(new Exception("Ошибка при получении еды"));
        cat.getFood();
    }

    @Test
    public void testMultipleGetFoodCalls() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        when(predatorMock.eatMeat()).thenReturn(expectedFood);

        cat.getFood();
        cat.getFood();

        Mockito.verify(predatorMock, Mockito.times(2)).eatMeat();
    }
}