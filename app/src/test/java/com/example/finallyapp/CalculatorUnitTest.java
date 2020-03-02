package com.example.finallyapp;

import android.view.View;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class CalculatorUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void tipOutShouldWork(){
        Calculator c = new Calculator();
        double value = c.calculateTipOut(4, 100);
        assertEquals(4, value, 0);
        double finalAmount = c.calculateFinal(true, value, 53);
        assertEquals(57, finalAmount, 0);

    }
}