/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.matrix;
/**
 *
 * @author victorcarvalho
 */
public class Matrix {
    private final int numberRows;
    private final int numberColumns;
    private final double[][] data;
   
    /*
    Default constructor
    Pre-condition: Object does not exist
    Pos-condition: Object created with parameters
    */
    
    public Matrix(int row, int column, double x[]){
        //Check for correct matrix format
         if(row < 0 || column < 0 || x.length != row*column){
             throw new MatrixFormatException("Invalid matrix format");
            }else{
                int count = 0;
                this.numberRows = row;
                this.numberColumns = column;
                this.data = new double[row][column];
                
            //Populate the two dimensional array with data from the x array
            for (int i = 0; i < row; i++){
                for (int j = 0; j < column; j++){
                     this.data[i][j] = x[count]; 
                     count++;
                } 

            }

         }
    }
    
    //Accessors 
    public int getNumberRows(){
        return numberRows;
    }
    
    public int getNumberColumns(){
        return numberColumns;
    }
    
    /*
    getTranspose()
    Pre-condition: A filled matrix objects exists with a defined number of columns and number of rows
    Pos-condition: Creates and returns a new matrix with swapped columns and rows
    */
    public Matrix getTranspose() throws MatrixFormatException{
        double d[]= new double[numberColumns*numberRows];
        int count = 0;
        
        //Iterate trough the original matrix array and assign swapped values to new array d
        for (int i = 0; i < numberColumns; i++){
                for (int j = 0; j < numberRows; j++){
                    d[count]=data[j][i];
                    count++;
                } 
        }
        
        Matrix transpose = new Matrix(numberColumns, numberRows, d);     
        return transpose;
    }
    
    //Compare two different obects to see if they are equal
    public boolean equals(Matrix m){
        boolean rv = true;
        if ((this.numberRows != m.numberRows) || (this.numberColumns != m.numberColumns)){
            rv = false;
        }else{
            //Check each value of the compared matrix to see if they are the same
            for (int i = 0; i < numberRows; i++){
                for (int j = 0; j < numberColumns; j++){
                     if(this.data[i][j] != m.data[i][j]){
                         rv = false;
                     }
                }
            } 
        }

        return rv;
    }
}
