package com.epam.jmp.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Date: 12/7/2014
 * Time: 3:48 PM
 *
 * @author Artur Memekh
 */
public class DepartmentService {

    private EntityManager em;

    private Employee emp;
    private Unit unit;
    private Project pro;

    public DepartmentService(EntityManager em) {
        this.em = em;
    }

    public Employee createEmployee() {
        emp = new Employee();
        em.persist(emp);
        return emp;
    }

    public Unit createUnit() {
        unit = new Unit();
        em.persist(unit);
        return unit;
    }

    public Project createProject() {
        pro = new Project();
        em.persist(pro);
        return pro;
    }

    public Employee findEmployee(Long id) {
        return em.find(Employee.class, id);
    }

    public Unit findUnit(Long id) {
        return em.find(Unit.class, id);
    }

    public Project findProject(Long id) {
        return em.find(Project.class, id);
    }

    public Employee updateEmployee(Long id) {
        emp = em.find(Employee.class, id);
        emp.setFirstName("John");
        em.merge(emp);
        return emp;
    }

    public Unit updateUnit(Long id) {
        unit = em.find(Unit.class, id);
        unit.setName("U9435");
        em.merge(unit);
        return unit;
    }

    public Project updateProject(Long id) {
        pro = em.find(Project.class, id);
        pro.setName("MMG");
        em.merge(pro);
        return pro;
    }

    public Employee deleteEmployee(Long id) {
        emp = em.find(Employee.class, id);
        em.remove(emp);
        return emp;
    }

    public Unit deleteUnit(Long id) {
        unit = em.find(Unit.class, id);
        em.remove(unit);
        return unit;
    }

    public Project deleteProject(Long id) {
        pro = em.find(Project.class, id);
        em.remove(pro);
        return pro;
    }
    
    public void addEmployeeToUnit(Long[] ids) {
        for(Long id: ids) {
            emp = em.find(Employee.class, id);
            unit.getEmployees().add(emp);
            emp.setUnit(unit);
        }
    }

    public void assignEmployeeForProject(Long[] ids) {
        for(Long id: ids) {
            emp = em.find(Employee.class, id);
            pro.getEmployees().add(emp);
            emp.getProjects().add(pro);
        }
    }
}