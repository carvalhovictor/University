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
public class Manager extends Employee {
    
    private double bonus;
    
    //Default constructor
    public Manager(){
        bonus = 0;        
    }
    
    //Constructor calling super class with name and base salary parameters
    public Manager(double b, String n, double base){
        super(n, base);
        bonus = b;
    }
    
    @Override
    public boolean checkPassword(String s){
        String pattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{10,}"; //Pattern to match 1 number 1 lowercaseletter 1 uppercase lettrer and minimum 10 chars
        String format = "^[a-zA-Z0-9]+$"; //Format to match only letters and numbers password
        boolean rv = false;
        if(s.matches(pattern) && s.matches(format)){
            rv = true;
        }
        
        return rv;
    }
    
    @Override
    public double getSalary(){
        return getBaseSalary()+bonus;
    }
    
}
