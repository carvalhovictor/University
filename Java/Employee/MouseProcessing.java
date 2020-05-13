/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.employee;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;

/**
 *
 * @author victorcarvalho
 */
public class MouseProcessing implements MouseListener {
    
    private int insideClick = 0;
    private int outsideClick = 0;
    private int xCoord;
    private int yCoord;
    private int width;
    private int height;
    
    //Constructor defining the region
    public MouseProcessing(int x, int y, int w, int h){
        xCoord = x;
        yCoord = y;
        width = w;
        height = h;
        
    }
    
    //Getters
    public int getClicksInRegion(){
        return insideClick;
    }
    public double getTotalClicks(){
        return outsideClick;
    }

    @Override
    public void mouseClicked(MouseEvent e){
        //If clicked in region increment counter
       if((e.getX() >= xCoord && (e.getX() < (xCoord+width) && e.getY() >= yCoord)  && e.getY()< (yCoord+height))){
           insideClick++;
       }
       
       outsideClick++;
    }
    
    @Override
    public void mousePressed(MouseEvent e){
        
    }  
    
    @Override
    public void mouseReleased(MouseEvent e){
        
    }
    
    @Override
    public void mouseEntered(MouseEvent e){
        
    }
    
    @Override
    public void mouseExited(MouseEvent e){
        
    }
}
