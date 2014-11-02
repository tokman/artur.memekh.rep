package com.epam.jmp.unittesting.calculator;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import org.apache.log4j.Logger;

/**
 * Date: 11/2/2014
 * Time: 12:59 PM
 *
 * @author Artur Memekh
 */
public class Run {

    public static final Logger logger = Logger.getLogger(Run.class);

    public static void main(final String[] args) {

        final File expFile = new File(args[0]);
        final File resFile = new File(args[1]);

        // Client
        new Thread(new Runnable() {
            @Override
            public void run() {

                Scanner sc = new Scanner(System.in);
                ClientFileDAO cfDAO = new ClientFileDAO(expFile, resFile);

                while(true) {
                    logger.info("Enter an expression to calculate or \'0\' to exit:");
                    String exp = sc.nextLine();
                    if("0".equals(exp)) {
                        System.exit(0);
                    }
                    logger.info("Expression is \'" + exp + "\'.");
                    try {
                        cfDAO.writeExpression(exp);
                    } catch (IOException e) {
                        logger.error(e);
                    }
                    String result = cfDAO.getResult();
                    logger.info("The result is \'" + result + "\'");
                }
            }
        }).start();

        // server
        new Thread(new Runnable() {
            @Override
            public void run() {

                ServerFileDAO sfDAO = new ServerFileDAO(expFile, resFile);

                while(true) {
                    try {
                        String exp = sfDAO.getExpression();
                        double res = Calculator.calculate(exp);
                        sfDAO.writeResult(res);
                    } catch (IOException e) {
                        logger.error(e);
                    }
                }
            }
        }).start();
    }
}
