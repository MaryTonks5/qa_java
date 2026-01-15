package com.example;

import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class FelineParameterizedTest {

    private final int kittensCount;

    public FelineParameterizedTest(int kittensCount) {
        this.kittensCount = kittensCount;
    }

    @Parameterized.Parameters(name = "Количество котят: {0}")
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
    public void testGetKittensWithParameter() {
        Feline feline = new Feline();
        assertEquals("С параметром должен возвращаться переданное количество",
                kittensCount, feline.getKittens(kittensCount));
    }
}