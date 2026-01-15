package com.example;

import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

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

    @Parameterized.Parameters(name = "Пол: {0}, Ожидается грива: {1}")
    public static Object[][] getSexData() {
        return new Object[][] {
                {"Самец", true},
                {"Самка", false}
        };
    }

    @Test
    public void testLionConstructorAndHasMane() throws Exception {
        Lion lion = new Lion(sex, Mockito.mock(Feline.class));
        assertEquals("Для пола " + sex + " наличие гривы должно быть " + expectedHasMane,
                expectedHasMane, lion.doesHaveMane());
    }

    @Test
    public void testGetKittens() throws Exception {
        Feline felineMock = Mockito.mock(Feline.class);
        Mockito.when(felineMock.getKittens()).thenReturn(1);

        Lion lion = new Lion(sex, felineMock);
        assertEquals("Лев должен возвращать 1 котенка",
                1, lion.getKittens());
    }

    @Test
    public void testGetFood() throws Exception {
        Feline felineMock = Mockito.mock(Feline.class);
        List<String> expectedFood = Arrays.asList("Животные", "Птицы", "Рыба");
        Mockito.when(felineMock.eatMeat()).thenReturn(expectedFood);

        Lion lion = new Lion(sex, felineMock);
        assertEquals("Еда льва должна совпадать с едой хищника",
                expectedFood, lion.getFood());
    }
}