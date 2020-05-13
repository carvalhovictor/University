/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.fau.COT4930;

import java.awt.Component;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.CropImageFilter;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageFilter;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import javax.imageio.ImageIO;

/**
 *
 * @author victorarvalho
 */
public class Deck {
    
    private int cardsLeft;
    private ArrayList<Card> deckCards;
    private Image cardImage;
    private final int CARD_WIDTH = 71;
    private final int CARD_HEIGHT = 96; 
    
    public Deck(Component comp, String fileCards){
        BufferedImage im = null;
        deckCards = new ArrayList<>();
        ImageFilter crop; 
        cardsLeft = 52;        
        try{
            File f = new File(fileCards);
            // get the image from the file
            im = ImageIO.read(f);
            
            //Loops trhough 52 cards
            for(int i = 0; i<=3; i++){
                for(int j=0; j<=12; j++){
                   //crop card from the image and add to the deck
                   crop = new CropImageFilter(j*CARD_WIDTH, i*CARD_HEIGHT, CARD_WIDTH, CARD_HEIGHT);
                   cardImage = comp.createImage(new FilteredImageSource(im.getSource(), crop));
                   Card c = new Card(i,j,cardImage);
                   deckCards.add(c);  
                }   
            }

        }catch(IOException e){
            System.out.println("Cannot find the image file");
        }
        
    }
    
    //Shuffles the deck of cards
    public void shuffle(){
        cardsLeft = 52;
        Collections.shuffle(deckCards);
    }
    
    //Get the next card on the deck and decrement the number of cards left
    public Card getNextCardInDeck(){
         if(cardsLeft>0){
             cardsLeft--;
         }
         return deckCards.get((50-cardsLeft)+1);
    }
    
    //Acessor
    public int getNumberLeftInDeck(){
        return cardsLeft;
    }
}
