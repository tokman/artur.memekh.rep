package com.epam.jmp.unittesting.calculator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import org.apache.log4j.Logger;

/**
 * Date: 11/2/2014
 * Time: 8:58 AM
 *
 * @author Artur Memekh
 */
public class ServerFileDAO implements IServerDAO {

    private File expFile;
    private File resFile;

    private long lastExpFileModified = 0;
    private long lastResFileModified = 0;

    public static final Logger logger = Logger.getLogger(ServerFileDAO.class);

    public ServerFileDAO(File expFile, File resFile) {
        this.expFile = expFile;
        this.resFile = resFile;
    }

    public void setLastExpFileModified(long lastExpFileModified) {
        this.lastExpFileModified = lastExpFileModified;
    }

    @Override
    public void writeResult(double res) throws IOException {

        synchronized (resFile) {
            PrintWriter pw = new PrintWriter(resFile);
            pw.write(String.valueOf(res));
            pw.close();
            lastResFileModified = resFile.lastModified();
            logger.info("Result has been written to a file.");
            resFile.notify();
        }
    }

    @Override
    public String getExpression() {

        String exp = null;

        synchronized (expFile) {
            try {
                if(lastExpFileModified == expFile.lastModified() || lastExpFileModified == 0) {
                    expFile.wait();
                }

                Scanner sc = new Scanner(expFile);
                while(sc.hasNextLine()) {
                    exp = sc.nextLine();
                }
                sc.close();
                logger.info("Expression has been read from a file.");
            } catch(FileNotFoundException e) {
                logger.error(e);
            } catch(InterruptedException e) {
                logger.error(e);
            }
        }
        return exp;
    }
}
