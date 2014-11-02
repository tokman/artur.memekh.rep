package com.epam.jmp.unittesting.calculator;

/**
 * Date: 11/2/2014
 * Time: 9:07 AM
 *
 * @author Artur Memekh
 */
public interface IServerDAO {

    void writeResult(double res) throws Exception;

    String getExpression();
}
