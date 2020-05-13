/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mygrades;

/**
 *
 * @author victorcarvalho
 */
public class MyGrades {
    
    private final int DEFAULT_NUM_HW = 3;
    private int [] hw;
    private int finalExam;
    private int midtermExam;
    private int numberOfHomeworks;
    
    public static final double FINAL_EXAM_WEIGHT = 0.25;
    public static final double MIDTERM_EXAM_WEIGHT = 0.25;
    public static final double HW_WEIGHT = 0.5;
    
    //Default Constructor
    public MyGrades(){
        finalExam = 0;
        midtermExam = 0;
        numberOfHomeworks = 0;
        hw = new int[DEFAULT_NUM_HW];
    }
    
    //Mutators
    public void setFinalExam(int grade){
        finalExam = grade;
    }
    
    public void setMidtermExam(int grade){
        midtermExam = grade;
    }
    
    public void setHomework(int grade){
        if(numberOfHomeworks>=hw.length){
            int hwtemp[] = new int [numberOfHomeworks+1];
            for (int i = 0; i < hw.length; i++) {
                hwtemp[i] = hw[i];
            }
            hw = hwtemp;
            hw[numberOfHomeworks] = grade;
            numberOfHomeworks++;
        }else{
            hw[numberOfHomeworks] = grade;
            numberOfHomeworks++;
        }
    }
    
    //Returns true if the objects are equal and false if not equal.
    public boolean equals(MyGrades g){
        boolean rv = true;
        if ((midtermExam != g.midtermExam) || (numberOfHomeworks != g.numberOfHomeworks) || (finalExam != g.finalExam)){
            rv = false;
        }else{
            for (int i = 0; i < g.hw.length; i++) {
                if(hw[i]!=g.hw[i]){
                    rv = false; 
                }
            }
        }

        
        return rv;
    }

    @Override
    public String toString(){
        return "Final exam = " +finalExam+ " Midterm Exam = "+midtermExam+ " Finalgrade = "+getFinalGrade();
    }
    
    //Returns final grade based on weights
    public double getFinalGrade(){
        double totalhw = 0;
        if(numberOfHomeworks!=0){
            for (int i = 0; i < hw.length; i++) {
                totalhw += hw[i];
            }
            totalhw = totalhw/numberOfHomeworks;
        }
        return ((finalExam * FINAL_EXAM_WEIGHT) + (midtermExam * MIDTERM_EXAM_WEIGHT) + (totalhw * HW_WEIGHT));
    }
    
    //Returns final grade based on weights
    public static double getFinalGrade(int finalTest, int midtermTest, int[] hwGrades){
        double totalhw = 0;
            for (int i = 0; i < hwGrades.length; i++) {
                totalhw += hwGrades[i];
            }
            totalhw = totalhw/hwGrades.length;

        return ((finalTest * FINAL_EXAM_WEIGHT) + (midtermTest * MIDTERM_EXAM_WEIGHT) + (totalhw * HW_WEIGHT));
    }
    
}
