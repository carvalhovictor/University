/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.fau.COT4930;

import java.awt.Image;

/**
 *
 * @author victorcarvalho
 */
public class Card {
        
    private final int cardSuit, cardValue;
    private final Image cardImage;
    
        
        //Constructor
        public Card(int s, int v, Image im){
            cardSuit = s;
            cardValue = v;
            cardImage = im;
        }
        
        //Accessors 
        public Image getImage(){
            return cardImage;
        }
        
        public int getValue(){
            return cardValue;
        }
        
        public int getSuit(){
            return cardSuit;
        }
         
}
