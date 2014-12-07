package com.epam.jmp.jpa;

import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import org.hibernate.annotations.AccessType;

/**
 * Date: 12/6/2014
 * Time: 2:16 PM
 *
 * @author Artur Memekh
 */

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Embedded
    private Address address;

    //@OneToOne(mappedBy="employee_id", cascade = CascadeType.ALL)
    @OneToOne(mappedBy="employee", cascade = CascadeType.ALL)
    private EmployeePersonalInfo empPersonalInfo;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name="employee_project",
            joinColumns=@JoinColumn(name="employee_id"),
            inverseJoinColumns=@JoinColumn(name="project_id"))
    private Collection<Project> projects;

    @Enumerated(EnumType.ORDINAL)
    private EmployeeStatus status;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "unit_id", referencedColumnName = "id")
    private Unit unit;

    public Employee() {

        /*
        firstName = "first name";
        lastName = "last name";
        address = new Address();
        empPersonalInfo = new EmployeePersonalInfo();
        projects
        status
        */
    }

    public Collection<Project> getProjects() {
        return projects;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }
}