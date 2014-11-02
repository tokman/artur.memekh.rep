package com.epam.jmp.multithreading;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import org.apache.log4j.Logger;

/**
 * Date: 10/25/2014
 * Time: 1:03 PM
 *
 * @author Artur Memekh
 */
public class Test {

    private static final Logger logger = Logger.getLogger(Test.class);
    private static final String PATH_TO_FILE = "d:/work/idea projects/jmp/file.txt";

    public static void main(String[] args) {

        writeFile();

        while(true) {
            logger.info("Please, enter a number of an action you wanna do...");
            logger.info("1. Read file");
            logger.info("2. Exit from the program");
            Scanner sc = new Scanner(System.in);
            if (sc.hasNextInt()) {
                int num = sc.nextInt();
                switch (num) {
                    case 1:
                        readFile();
                        break;
                    case 2:
                        System.exit(0);
                    default:
                        logger.error("Please enter a correct number.");
                        break;
                }
            } else {
                logger.error("Your input is wrong or empty. Please enter only digits.");
            }
        }
    }

    private static void writeFile() {

        new Thread(new Runnable() {
            @Override
            public void run() {

                int k = 1;
                while(true) {
                    try {
                        FileWriter fw = new FileWriter(PATH_TO_FILE, true);
                        fw.write("Some string " + k++ + "\n");
                        fw.close();
                        Thread.sleep(500);
                    } catch (IOException e) {
                        logger.error(e.getMessage());
                    } catch(InterruptedException e) {
                        logger.error(e.getMessage());
                    }
                }
            }
        }).start();
    }

    private static void readFile() {

        new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    Scanner sc = new Scanner(new File(PATH_TO_FILE));
                    StringBuilder sb = new StringBuilder();
                    while (sc.hasNextLine()) {
                        sb.append(sc.nextLine());
                    }
                    System.out.println(sb);
                    logger.info(sb);
                } catch(FileNotFoundException e) {
                    logger.error(e.getMessage());
                }
            }
        }).start();
    }
}
