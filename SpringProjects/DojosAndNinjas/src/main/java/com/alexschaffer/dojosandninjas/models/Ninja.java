package com.alexschaffer.dojosandninjas.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity 
@Table(name="ninjas")
public class Ninja {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
    @NotNull
    @Size(min = 3, message="First name must be longer than 3 characters.")
    private String firstname;
    
    @NotNull
    @Size(min = 3, message="Last name must be longer than 3 characters.")
    private String lastname;
    
    @NotNull
    @Size(min = 18, message="Must be older than 18 to join the Dojo.")
    private Integer age;
	
    //constructor
	public Ninja() {}

	//getters and setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
	
	
	
}




