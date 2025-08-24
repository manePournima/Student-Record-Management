package com.example.demo.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.*;
import jakarta.persistence.GenerationType;


@Entity
@Table(name="Student Records")


public class Student {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;

	    @NotBlank(message = "Name is required")
	    @Size(min = 3, message = "Name must be at least 3 characters long")
	    private String name;

	    @Min(value = 5, message = "Age must be at least 5")
	    @Max(value = 25, message = "Age must not exceed 25")
	    private int age;

	    @Min(value = 0, message = "Mark1 must be >= 0")
	    @Max(value = 100, message = "Mark1 must be <= 100")
	    private int mark1;

	    @Min(value = 0, message = "Mark2 must be >= 0")
	    @Max(value = 100, message = "Mark2 must be <= 100")
	    private int mark2;

	    @Min(value = 0, message = "Mark3 must be >= 0")
	    @Max(value = 100, message = "Mark3 must be <= 100")
	    private int mark3;

	    @Min(value = 0, message = "Mark4 must be >= 0")
	    @Max(value = 100, message = "Mark4 must be <= 100")
	    private int mark4;

	    @Min(value = 0, message = "Mark5 must be >= 0")
	    @Max(value = 100, message = "Mark5 must be <= 100")
	    private int mark5;

	    private float percentage;
	    private String division;

	    public Student() {}
	
	
	public Student(int id, String name, int mark1, int mark2, int mark3, int mark4, int mark5, float percentage,
			String division) {
		super();
		this.id = id;
		this.name = name;
		this.mark1 = mark1;
		this.mark2 = mark2;
		this.mark3 = mark3;
		this.mark4 = mark4;
		this.mark5 = mark5;
		this.percentage = percentage;
		this.division = division;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public int getMark1() {
		return mark1;
	}


	public void setMark1(int mark1) {
		this.mark1 = mark1;
	}


	public int getMark2() {
		return mark2;
	}


	public void setMark2(int mark2) {
		this.mark2 = mark2;
	}


	public int getMark3() {
		return mark3;
	}


	public void setMark3(int mark3) {
		this.mark3 = mark3;
	}


	public int getMark4() {
		return mark4;
	}


	public void setMark4(int mark4) {
		this.mark4 = mark4;
	}


	public int getMark5() {
		return mark5;
	}


	public void setMark5(int mark5) {
		this.mark5 = mark5;
	}


	public float getPercentage() {
		return percentage;
	}


	public void setPercentage(float percentage) {
		this.percentage = percentage;
	}


	public String getDivision() {
		return division;
	}


	public void setDivision(String division) {
		this.division = division;
	}


	
	

}
