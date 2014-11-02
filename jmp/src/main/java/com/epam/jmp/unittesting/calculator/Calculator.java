package com.epam.jmp.unittesting.calculator;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Date: 11/2/2014
 * Time: 9:16 AM
 *
 * @author Artur Memekh
 */
public class Calculator {

    private static final String PLUS_SIGN =     "+";
    private static final String SUB_SIGN =      "-";
    private static final String MULTI_SIGN =    "*";
    private static final String DIV_SIGN =      "/";

    public static final double calculate(String exp) {

        exp = exp.replaceAll("\\s","");
        //Scanner sc = new Scanner(exp).useDelimiter(PLUS_SIGN + SUB_SIGN + MULTI_SIGN + DIV_SIGN);
        Scanner sc = new Scanner(exp).useDelimiter(Pattern.compile("-|\\+|\\*|/"));

        // get all numbers
        ArrayList<Double> numbers = new ArrayList();
        while(sc.hasNext()) {
            numbers.add(Double.parseDouble(sc.next()));
        }

        ArrayList tokens = new ArrayList(numbers.size() * 2 - 1); // numbers and signs
        int i = 0;
        tokens.add(numbers.get(i++));

        // get all signs and put it into the tokens collection
        // with all numbers alternately
        sc = new Scanner(exp).useDelimiter(Pattern.compile("[0-9]+|\\."));
        while(sc.hasNext()) {
            tokens.add(sc.next());
            tokens.add(numbers.get(i++));
        }

        // eliminate any multiplication and division,
        // substitute subtraction by addition
        for(int k = 1; k < tokens.size(); k += 2) {
            String sign = (String)tokens.get(k);
            double res = 0;
            if (PLUS_SIGN.equals(sign)) {
                continue;
            } else if(SUB_SIGN.equals(sign)) {
                double el = (Double)tokens.remove(k+1);
                tokens.add(k+1, -el);
                continue;
            } else if(MULTI_SIGN.equals(sign)) {
                res = (Double)tokens.get(k-1) * (Double)tokens.get(k+1);
            } else if(DIV_SIGN.equals(sign)) {
                res = (Double)tokens.get(k-1) / (Double)tokens.get(k+1);
            }
            tokens.remove(k+1);
            tokens.remove(k);
            tokens.remove(k-1);
            tokens.add(k-1, res);
        }

        // calculate sum
        double res = 0;
        for(int k = 0; k < tokens.size(); k += 2) {
            res += (Double)tokens.get(k);
        }
        return res;
    }
}