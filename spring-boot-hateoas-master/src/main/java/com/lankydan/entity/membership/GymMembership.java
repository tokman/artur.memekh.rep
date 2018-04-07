package com.lankydan.entity.membership;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lankydan.entity.person.Person;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "memberships")
public class GymMembership {

	@Id
	@GeneratedValue
	private Long id;

	@JsonIgnore
	@ManyToOne
	private Person owner;

	private String name;

	private long cost;

	public GymMembership(final Person owner, final String name, final long cost) {
		this.owner = owner;
		this.name = name;
		this.cost = cost;
	}

	public GymMembership(Long id, Person owner, String name, long cost) {
		super();
		this.id = id;
		this.owner = owner;
		this.name = name;
		this.cost = cost;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Person getOwner() {
		return owner;
	}

	public void setOwner(Person owner) {
		this.owner = owner;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getCost() {
		return cost;
	}

	public void setCost(long cost) {
		this.cost = cost;
	}

}
