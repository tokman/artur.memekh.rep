package com.epam.jmp.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.apache.log4j.Logger;

/**
 * Date: 12/6/2014
 * Time: 3:04 PM
 *
 * @author Artur Memekh
 */
public class Test {

    private static final Logger logger = Logger.getLogger(Test.class);

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jmp-jpa");
        EntityManager em = emf.createEntityManager();

        DepartmentService ds = new DepartmentService(em);
        Employee emp;
        Unit unit;
        Project pro;

        //create
        emp = ds.createEmployee();
        logger.info(emp + " employee has been found");
        unit = ds.createUnit();
        logger.info(unit + " employee has been found");
        pro = ds.createProject();
        logger.info(pro + " employee has been found");

        //find
        emp = ds.findEmployee(Long.valueOf(1));
        logger.info(emp + " employee has been found");
        unit = ds.findUnit(Long.valueOf(2));
        logger.info(unit + " unit has been found");
        pro = ds.findProject(Long.valueOf(3));
        logger.info(pro + " project has been found");

        //update
        emp = ds.updateEmployee(Long.valueOf(2));
        logger.info(emp + " employee has been updated");
        unit = ds.updateUnit(Long.valueOf(3));
        logger.info(unit + " unit has been updated");
        pro = ds.updateProject(Long.valueOf(1));
        logger.info(pro + " project has been updated");

        //add employee to unit
        Long[] ids = {Long.valueOf(1),Long.valueOf(2)};
        ds.addEmployeeToUnit(ids);

        //assign employees for project
        ds.assignEmployeeForProject(ids);

        //remove
        emp = ds.deleteEmployee(Long.valueOf(3));
        logger.info(emp + " employee has been removed");
        unit = ds.deleteUnit(Long.valueOf(1));
        logger.info(unit + " unit has been removed");
        pro = ds.deleteProject(Long.valueOf(1));
        logger.info(pro + " project has been removed");

        em.close();
        emf.close();
    }
}