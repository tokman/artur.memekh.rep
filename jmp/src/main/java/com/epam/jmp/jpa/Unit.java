package com.epam.jmp.jpa;

import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

/**
 * Date: 12/6/2014
 * Time: 2:17 PM
 *
 * @author Artur Memekh
 */

@Entity
public class Unit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany
    //@JoinColumn(referencedColumnName = "unit_id")
    private Collection<Employee> employees;

    public void setName(String name) {
        this.name = name;
    }

    public Collection<Employee> getEmployees() {
        return employees;
    }
}
