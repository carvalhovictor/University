/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.managedb;

/**
 *
 * @author victorcarvalho
 */
public class EmployeeDB {
 	// Member variables
	private int age;
	private String name;
	private double salary;

	// Constructors
	public EmployeeDB()
	{
		age = -1;
		name = "";
		salary = -1.0;
	}

	// Mutators
	public void setName(String n)
	{
		name = n;
	}
	public void setAge(int a)
	{
		age = a;
	}
	public void setSalary(double s)
	{
		salary = s;
	}

	// Accessors
	public String getName()
	{
		return name;
	}
	public int getAge()
	{
		return age;
	}
	public double getSalary()
	{
		return salary;
	}   
}
