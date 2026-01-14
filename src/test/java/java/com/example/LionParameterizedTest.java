package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class LionParameterizedTest {

    private final String sex;
    private final boolean expectedHasMane;

    public LionParameterizedTest(String sex, boolean expectedHasMane) {
        this.sex = sex;
        this.expectedHasMane = expectedHasMane;
    }

    @Parameters(name = "Пол: {0}, Ожидается грива: {1}")
    public static Object[][] getSexData() {
        return new Object[][] {
                {"Самец", true},
                {"Самка", false}
        };
    }

    @Test
    public void testLionConstructorAndHasMane() throws Exception {
        Lion lion = new Lion(sex);
        assertEquals("Для пола " + sex + " наличие гривы должно быть " + expectedHasMane,
                expectedHasMane, lion.doesHaveMane());
    }

    @Test
    public void testGetFood() throws Exception {
        Lion lion = new Lion(sex);
        List<String> expectedFood = Arrays.asList("Животные", "Птицы", "Рыба");
        assertEquals("Еда льва должна совпадать с едой хищника",
                expectedFood, lion.getFood());
    }

    @Test
    public void testGetKittens() throws Exception {
        Lion lion = new Lion(sex);
        assertEquals("Лев должен возвращать 1 котенка по умолчанию",
                1, lion.getKittens());
    }
}