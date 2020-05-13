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
public class TechnicalStaff extends Employee {
    
    //Default constructor
    public TechnicalStaff(){
        
    }
    
    //Constructor calling super class with name and base salary parameters
    public TechnicalStaff(String n, double base){
        super(n,base);
    }
    
    @Override
    public boolean checkPassword(String s){
        String pattern = "(?=.*[0-9])(?=.*[a-zA-Z]).{8,}";  //Pattern to match 1 number 1 letter and minimum 8 chars
        String format = "^[a-zA-Z0-9]+$"; //Format to match only letters and numbers password
        boolean rv = false;
        if(s.matches(pattern) && s.matches(format)){
            rv = true;
        }
        
        return rv;
    }
    
    @Override
    public double getSalary(){
        return getBaseSalary();
    }
    
}
