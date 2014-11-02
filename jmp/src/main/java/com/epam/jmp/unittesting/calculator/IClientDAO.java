package com.epam.jmp.unittesting.calculator;

/**
 * Date: 11/2/2014
 * Time: 1:09 PM
 *
 * @author Artur Memekh
 */
public interface IClientDAO {

    void writeExpression(String exp) throws Exception;

    String getResult();
}
