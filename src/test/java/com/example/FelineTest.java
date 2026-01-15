package com.example;

import com.example.Feline;
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.*;

public class FelineTest {

    @Test
    public void testEatMeat() throws Exception {
        Feline feline = new Feline();
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
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