package org.example;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class NumberToWordTester
{
    /**
     * Rigorous Test :-)
     */
    NumberToWord obj = new NumberToWord();
    @Test
    public void shouldAnswerWithEquals()
    {
        assertEquals("one", obj.convert(1));
        assertEquals("twenty one", obj.convert(21));
        assertEquals("one hundred and five", obj.convert(105));
        assertEquals("fifty six million nine hundred and forty five thousand seven hundred and eighty one", obj.convert(56945781));
        assertEquals("nine hundred and ninety nine million nine hundred and ninety nine thousand nine hundred and ninety nine", obj.convert(999999999));

    }

    @Test(expected = RuntimeException.class)
    public void exceptionRange() {
        obj.convert(1000000000);
    }

    @Test(expected = RuntimeException.class)
    public void exceptionInvalidNumber() {
        obj.convert(-1000000000);
    }
}
