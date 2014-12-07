package com.epam.jmp.unittesting.calculator;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * date: 11/3/2014
 * time: 8:02 AM
 *
 * @author Artur_Memekh
 */
public class ServerFileDAOTest {

    public static final Logger logger = Logger.getLogger(ServerFileDAOTest.class);

    @Test
    public void writeResult() {

        double res = 10, res2 = 0;
        File f = new File("d:/testFile.txt");
        try {
            new ServerFileDAO(f, f).writeResult(res);
            Scanner sc = new Scanner(f);
            while(sc.hasNextLine()) {
                res2 = sc.nextDouble();
            }
        } catch(IOException e) {
            logger.error(e);
        }
        Assert.assertEquals(res2, res, 1e-3);
    }

    @Test
    public void getExpression() {

        String exp = "5+5", exp2="";
        File f = new File("d:/testFile.txt");
        long lastModified = f.lastModified();
        try {
            PrintWriter pw = new PrintWriter(f);
            pw.write(exp);
            pw.close();
        } catch(FileNotFoundException e) {
            logger.error(e);
        }
        ServerFileDAO sfDAO = new ServerFileDAO(f,f);
        sfDAO.setLastExpFileModified(lastModified);
        exp2 = sfDAO.getExpression();
        Assert.assertEquals(exp2, exp);
    }
}
