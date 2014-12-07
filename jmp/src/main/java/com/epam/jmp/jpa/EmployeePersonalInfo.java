package com.epam.jmp.jpa;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Date: 12/6/2014
 * Time: 2:17 PM
 *
 * @author Artur Memekh
 */

@Entity
@Table(name = "employee_personal_info")
public class EmployeePersonalInfo implements Serializable{

    @Id
    @OneToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "driver_license")
    private String driverLicense;
}
