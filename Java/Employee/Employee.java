/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.employee;

/**
 *
 * @author victorcarvalho
 */
public abstract class Employee {
    
    private String name;
    private double baseSalary;
    private String password;
    
    //Default constructor 
    public Employee(){
        name = "";
        baseSalary = 0;
    } 
    
    //Constructor to set name and base salary
    public Employee(String n, Double s){
        name = n;
        baseSalary = s;
    }
    
    //Getters
    public String getName(){
        return name;
    }
    
    public double getBaseSalary(){
        return baseSalary;
    } 
    
    //Set password if matches the criteria, if not throws exception
    protected void setPW(String p) throws IllegalArgumentException{
        if(checkPassword(p) == true){
            password = p;
        }else{
            throw new IllegalArgumentException();
        }
    }
    
    public boolean isPasswordMatch(String s){
        boolean rv = false;
            if(s.equals(password)){
                rv = true;
            }
        return rv;
    }
   
    public abstract boolean checkPassword(String s);
    
    public abstract double getSalary();

}
