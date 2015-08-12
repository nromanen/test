package com.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * For a complete reference see <a href=
 * "http://docs.jboss.org/hibernate/stable/annotations/reference/en/html_single/"
 * > Hibernate Annotations Communit Documentations</a>
 */
@Entity
@Table(name = "PERSON")
public class Person implements Serializable {

	private static final long serialVersionUID = -5527566248002296042L;

	@Id
	@Column(name = "id")
	@GeneratedValue
	private Long id;

	@Column(name = "FIRST_NAME")
	private String firstName;

	@Column(name = "LAST_NAME")
	private String lastName;

	@Column(name = "MONEY")
	private Double money;

	@JsonIgnore
	@ManyToOne(cascade = CascadeType.MERGE)// ALL)
	// @ManyToOne
	@JoinColumn(name="group_id", nullable=true)
	private AcademyGroup group;

	@OneToMany(mappedBy = "primaryKey.person", cascade = CascadeType.ALL)
	Set<Session> sessions = new HashSet<Session>();

	public Set<Session> getSessions() {
		return sessions;
	}

	public void setSessions(Set<Session> sessions) {
		this.sessions = sessions;
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

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Double getMoney() {
		return money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

	public AcademyGroup getGroup() {
		return group;
	}

	public void setGroup(AcademyGroup group) {
		this.group = group;
	}

}
