package com.epam.jmp.unittesting.calculator;

import org.junit.Assert;
import org.junit.Test;

/**
 * Date: 11/2/2014
 * Time: 3:56 PM
 *
 * @author Artur Memekh
 */
public class CalculatorTest {

    // TODO: write mock to generate various expressions
    @Test
    public void calculate() {

        String exp = "5+5";
        double res = Calculator.calculate(exp);
        Assert.assertEquals(res, 10, 1e-3);
    }
}
