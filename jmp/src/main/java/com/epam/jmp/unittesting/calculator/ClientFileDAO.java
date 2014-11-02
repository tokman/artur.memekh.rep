package com.epam.jmp.unittesting.calculator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import org.apache.log4j.Logger;

/**
 * Date: 11/2/2014
 * Time: 1:08 PM
 *
 * @author Artur Memekh
 */
public class ClientFileDAO implements IClientDAO {

    private File expFile;
    private File resFile;

    private long lastExpFileModified = 0;
    private long lastResFileModified = 0;

    public static final Logger logger = Logger.getLogger(ClientFileDAO.class);

    public ClientFileDAO(File expFile, File resFile) {
        this.expFile = expFile;
        this.resFile = resFile;
    }

    @Override
    public void writeExpression(String exp) throws IOException {

        synchronized (expFile) {
            FileWriter fw = new FileWriter(expFile);
            fw.write(exp);
            fw.close();
            lastExpFileModified = expFile.lastModified();
            logger.info("Expression has been written to a file.");
            expFile.notify();
        }
    }

    @Override
    public String getResult() {

        String res = null;
        synchronized (resFile) {
            try {
                if(lastResFileModified == resFile.lastModified() || lastResFileModified == 0) {
                    resFile.wait();
                }
                Scanner sc = new Scanner(resFile);
                while(sc.hasNext()) {
                    res = sc.nextLine();
                }
                sc.close();
                logger.info("Result has been read from a file.");
            } catch (FileNotFoundException e) {
                logger.error(e);
            } catch(InterruptedException e) {
                logger.error(e);
            }
            resFile.notify();
        }
        return res;
    }
}
