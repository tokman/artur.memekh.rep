package com.epam.jmp.unittesting.calculator;

import junit.framework.Assert;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PipedWriter;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * date: 11/3/2014
 * time: 7:30 AM
 *
 * @author Artur_Memekh
 */
public class ClientFileDAOTest {

    public static final Logger logger = Logger.getLogger(ClientFileDAOTest.class);

    @Test
    public void writeExpression() {

        String exp = "5+5", exp2="";
        File f = new File("d:/testFile.txt");
        try {
            new ClientFileDAO(f, f).writeExpression(exp);
            Scanner sc = new Scanner(f);
            while(sc.hasNextLine()) {
                exp2 = sc.nextLine();
            }
        } catch(IOException e) {
            logger.error(e);
        }
        Assert.assertEquals(exp2, exp);
    }

    @Test
    public void getResult() {

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
        ClientFileDAO cfDAO = new ClientFileDAO(f,f);
        cfDAO.setLastResFileModified(lastModified);
        exp2 = cfDAO.getResult();
        Assert.assertEquals(exp2, exp);
    }
}
