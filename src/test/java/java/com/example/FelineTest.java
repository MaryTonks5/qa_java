package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class FelineTest {

    private final int kittensCount;

    public FelineTest(int kittensCount) {
        this.kittensCount = kittensCount;
    }

    @Parameters(name = "Количество котят: {0}")
    public static Object[][] getKittensData() {
        return new Object[][] {
                {1},
                {0},
                {3},
                {5},
                {10}
        };
    }

    @Test
    public void testEatMeat() throws Exception {
        Feline feline = new Feline();
        List<String> expectedFood = Arrays.asList("Животные", "Птицы", "Рыба");
        assertEquals("Еда для хищника должна соответствовать списку",
                expectedFood, feline.eatMeat());
    }

    @Test
    public void testGetFamily() {
        Feline feline = new Feline();
        assertEquals("Семейство должно быть 'Кошачьи'",
                "Кошачьи", feline.getFamily());
    }

    @Test
    public void testGetKittensWithoutParameter() {
        Feline feline = new Feline();
        assertEquals("Без параметра должен возвращаться 1 котенок",
                1, feline.getKittens());
    }

    @Test
    public void testGetKittensWithParameter() {
        Feline feline = new Feline();
        assertEquals("С параметром должен возвращаться переданное количество",
                kittensCount, feline.getKittens(kittensCount));
    }

    @Test
    public void testGetKittensMultipleCalls() {
        Feline feline = new Feline();
        assertEquals("Первый вызов getKittens() должен вернуть 1",
                1, feline.getKittens());
        assertEquals("Второй вызов getKittens() должен вернуть 1",
                1, feline.getKittens());
        assertEquals("Вызов getKittens(5) должен вернуть 5",
                5, feline.getKittens(5));
    }
}