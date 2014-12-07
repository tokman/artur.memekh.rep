package com.epam.jmp.jpa;

import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

/**
 * Date: 12/6/2014
 * Time: 2:17 PM
 *
 * @author Artur Memekh
 */

@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany
    @JoinTable(
            name="employee_project",
            joinColumns=@JoinColumn(name="employee_id"),
            inverseJoinColumns=@JoinColumn(name="project_id"))
    private Collection<Employee> employees;

    public Collection<Employee> getEmployees() {
        return employees;
    }

    public void setName(String name) {
        this.name = name;
    }
}
