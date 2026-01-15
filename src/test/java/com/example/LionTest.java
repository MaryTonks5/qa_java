package com.example;

import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class LionTest {

    @Test
    public void testLionConstructorInvalidSex() {
        try {
            new Lion("Неизвестный", Mockito.mock(Feline.class));
            fail("Должно быть выброшено исключение для невалидного пола");
        } catch (Exception e) {
            assertTrue("Сообщение об ошибке должно содержать 'Используйте допустимые значения'",
                    e.getMessage().contains("Используйте допустимые значения"));
        }
    }

    @Test
    public void testLionConstructorEmptySex() {
        try {
            new Lion("", Mockito.mock(Feline.class));
            fail("Должно быть выброшено исключение для пустого пола");
        } catch (Exception e) {
            assertTrue("Сообщение об ошибке должно содержать 'Используйте допустимые значения'",
                    e.getMessage().contains("Используйте допустимые значения"));
        }
    }

    @Test
    public void testLionConstructorNullSex() {
        try {
            new Lion(null, Mockito.mock(Feline.class));
            fail("Должно быть выброшено исключение для null пола");
        } catch (Exception e) {
            assertTrue("Сообщение об ошибке должно содержать 'Используйте допустимые значения'",
                    e.getMessage().contains("Используйте допустимые значения"));
        }
    }

    @Test
    public void testMaleLionHasMane() throws Exception {
        Lion lion = new Lion("Самец", Mockito.mock(Feline.class));
        assertTrue("Самец льва должен иметь гриву", lion.doesHaveMane());
    }

    @Test
    public void testFemaleLionHasNoMane() throws Exception {
        Lion lion = new Lion("Самка", Mockito.mock(Feline.class));
        assertFalse("Самка льва не должна иметь гриву", lion.doesHaveMane());
    }

    @Test
    public void testGetKittens() throws Exception {
        Feline felineMock = Mockito.mock(Feline.class);
        Mockito.when(felineMock.getKittens()).thenReturn(1);

        Lion lion = new Lion("Самец", felineMock);
        assertEquals("Должен возвращаться 1 котенок", 1, lion.getKittens());
    }

    @Test
    public void testGetFood() throws Exception {
        Feline felineMock = Mockito.mock(Feline.class);
        Mockito.when(felineMock.eatMeat()).thenReturn(java.util.List.of("Животные", "Птицы", "Рыба"));

        Lion lion = new Lion("Самка", felineMock);
        java.util.List<String> food = lion.getFood();
        assertNotNull("Еда не должна быть null", food);
        assertEquals("Должно быть 3 вида еды", 3, food.size());
    }
}