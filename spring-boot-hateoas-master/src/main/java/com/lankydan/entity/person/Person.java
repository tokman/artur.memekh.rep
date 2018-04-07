package com.lankydan.entity.person;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lankydan.entity.membership.GymMembership;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "people")
@NoArgsConstructor
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String firstName;

	private String secondName;

	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDateTime dateOfBirth;

	private String profession;

	private int salary;

	@JsonIgnore
	@OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
	private List<GymMembership> memberships;
	
	public Person() {
		super();
	}

	public Person(final Person person) {
		this.firstName = person.getFirstName();
		this.secondName = person.getSecondName();
		this.dateOfBirth = person.getDateOfBirth();
		this.profession = person.getProfession();
		this.salary = person.getSalary();
		this.memberships = person.getMemberships();
	}

	public Person(final Person person, final long id) {
		this.id = id;
		this.firstName = person.getFirstName();
		this.secondName = person.getSecondName();
		this.dateOfBirth = person.getDateOfBirth();
		this.profession = person.getProfession();
		this.salary = person.getSalary();
		this.memberships = person.getMemberships();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public LocalDateTime getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDateTime dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public List<GymMembership> getMemberships() {
		return memberships;
	}

	public void setMemberships(List<GymMembership> memberships) {
		this.memberships = memberships;
	}

}
