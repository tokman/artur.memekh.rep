package com.epam.jmp.jpa;

import javax.persistence.Embeddable;
import javax.persistence.Id;

/**
 * Date: 12/6/2014
 * Time: 2:17 PM
 *
 * @author Artur Memekh
 */

@Embeddable
public class Address {

    private String country;

    private String city;

    private String street;
}
