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
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.File;

public class ManageDB {

    private EmployeeDB[] emp;
  
    //Constructor
    public ManageDB(int number, String fileName) {
        File f = new File(fileName);
        long fileLength;
        String fileString = "No information was read";
        BufferedReader in = null;
        emp = new EmployeeDB[number];
        try {

            if (f.exists() == true) // throws SecurityException checked exception
            {
                fileLength = f.length();  // throws SecurityException checked exception
                char[] ch = new char[(int) fileLength];
                in = new BufferedReader(new FileReader(fileName)); // throws FileNotFoundException checked exception
                in.read(ch, 0, (int)fileLength);  // throws IOException checked exception

                fileString = String.valueOf(ch, 0, (int) fileLength);

                //Array to store employees data
                String[] data = fileString.split("\\^");

                //Create array of EmployeeDB objects
                for (int i = 0; i < number; i++) {
                    emp[i] = new EmployeeDB();
                }

                //Loop that iterates through all data
                for (int i = 1; i < data.length; i++) {
                    //Substring to store index
                    String index = data[i].substring(0, 4);
                    //Substring to store the last number of the index
                    int iValue = Integer.parseInt(index.substring(3));
                    //Substring to store the field name
                    String fieldName = data[i].substring(4, data[i].indexOf("="));
                    //Substring to store the field value
                    String fieldValue = data[i].substring(data[i].indexOf("=") + 1);
                    if (index.equals("0000") || index.equals("0001") || index.equals("0002") || index.equals("0003") || index.equals("0004")) {
                        if (fieldName.equals("age")) {
                            try {
                                // checking valid integer using parseInt() method 
                                int age = Integer.parseInt(fieldValue);
                                emp[iValue].setAge(age);
                            } catch (NumberFormatException e) {
                                System.out.println(fieldValue + " is not a valid integer number");
                            }

                        }
                        if(fieldName.equals("name")){
                            emp[iValue].setName(fieldValue);
                        }
                        if(fieldName.equals("salary")){
                            try {
                                // checking valid double using double() method 
                                double salary = Double.parseDouble(fieldValue);
                                emp[iValue].setSalary(salary);
                            } catch (NumberFormatException e) {
                                System.out.println(fieldValue + " is not a valid double number");
                            }                            
                            
                        }                       
                    }

                    //System.out.println(ages[i].substring(0,4));
                }

            } else {
                System.out.println("File does not exist");
            }
        } catch (SecurityException e) {
            System.out.println("SecurityException when reading the file " + e);
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException when reading the file " + e);
        } catch (IOException e) {
            System.out.println("IOException when reading the file " + e);
        } finally {
            closeReadFile(in);
        }
    }

    //Acessors
    public String getName(int i) {
        return emp[i].getName();
    }

    public int getAge(int i) {

        return emp[i].getAge();
    }

    public double getSalary(int i) {
        return emp[i].getSalary();
    }

    public static void closeReadFile(BufferedReader in) {
        try {
            if (in != null) {
                in.close();
            }
        } catch (IOException e) {
            System.out.println("IOException when closing the read file " + e);
        }
    }
}
