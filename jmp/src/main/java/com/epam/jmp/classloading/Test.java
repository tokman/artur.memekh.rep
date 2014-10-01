package com.epam.jmp.classloading;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Scanner;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * date: 9/30/2014
 * time: 3:15 PM
 *
 * @author Artur_Memekh
 */
public class Test {

    static final Logger logger = Logger.getLogger(Test.class);
    private static final String PATH_TO_JAR = "d:/personal work/idea projects/jmp-add/ClassesToLoad.jar";

    public static void main(String[] args) {

        while(true) {
            logger.info("Please, enter a number of an action you want...");
            logger.info("1. Load class name");
            logger.info("2. Load class fields");
            logger.info("3. Exit from the program");
            Scanner sc = new Scanner(System.in);
            if (sc.hasNextInt()) {
                int num = sc.nextInt();
                switch (num) {
                    case 1:
                        loadClassName();
                        break;
                    case 2:
                        loadClassFields();
                        break;
                    case 3:
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

    private static void loadClassFields() {

        ArrayList<Class> classes = getClassesLoaded();
        for(Class clazz: classes) {
            logger.info("class fields are = " + clazz.getFields());
        }
    }

    private static void loadClassName() {

        ArrayList<Class> classes = getClassesLoaded();
        for(Class clazz: classes) {
            logger.info("class name is = " + clazz.getName());
        }
    }

    private static ArrayList<Class> getClassesLoaded() {

        ArrayList<Class> classes = new ArrayList<Class>();
        try {
            JarFile jarFile = new JarFile(PATH_TO_JAR);
            Enumeration e = jarFile.entries();
            URL[] urls = {new URL("jar:file:" + PATH_TO_JAR + "!/")};
            URLClassLoader cl = URLClassLoader.newInstance(urls);

            while (e.hasMoreElements()) {
                JarEntry je = (JarEntry) e.nextElement();
                if (je.isDirectory() || !je.getName().endsWith(".class")) {
                    continue;
                }
                // -6 because of .class
                String className = je.getName().substring(0, je.getName().length() - 6);
                className = className.replace('/', '.');
                classes.add(cl.loadClass(className));
            }
            jarFile.close();
            cl.close();
        } catch(MalformedURLException e) {
            logger.error("URL initialization error.");
        } catch(IOException e) {
            logger.error("Jar file initialization error.");
        } catch(ClassNotFoundException e) {
            logger.error("Class has not been found.");
        }

        return classes;
    }
}