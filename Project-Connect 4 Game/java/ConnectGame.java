/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author victorcarvalho
 */
public class ConnectGame extends JPanel
{
	final int FRAME_WIDTH = 800;
	final int FRAME_HEIGHT = 600;
        final String helpMessage = "The objective of the game is to be the first to form a horizontal, vertical, or diagonal line of four discs. "
                + "\nPlayer 1 color is red. "
                + "\nPlayer 2 color is yellow";
	private Image offscrImg;
	private Graphics offscrGC;
        private int col1counter;
        private int col2counter;
        private int col3counter;
        private int col4counter;
        private int col5counter;
        private int col6counter;
        private int col7counter;
        private int turn;
        /**
		Method to initialize the game.
	*/   
    public void init()
	{
		BufferedImage backgroundImage = null;
		try
		{

			File f = new File("Connect4Board.png");
                         
			// get the image from the file
			backgroundImage = ImageIO.read(f);


		}
		catch(IOException e)
		{
			System.out.println("Cannot find the image file");
		}
		this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
                
                turn = 0;
                
                col1counter = 0;
                col2counter = 0;
                col3counter = 0;
                col4counter = 0;
                col5counter = 0;
                col6counter = 0;
                col7counter = 0;

                offscrImg = this.createImage(FRAME_WIDTH, FRAME_HEIGHT);
                offscrGC = offscrImg.getGraphics();
                
                offscrGC.setColor(Color.red);
                offscrGC.drawString("Player 1 turn", 15, 35);
                offscrGC.drawImage(backgroundImage, 80, 90, this);

	}
    
    	/**
		Method to fill the first column
	*/
        public void fillCol1(){
            if(col1counter == 6){
                return;
            }
            if(turn == 0){
                offscrGC.drawString("Player 2 turn", 15, 35);
                offscrGC.setColor(Color.red);
                turn = 1;
            }else{
                offscrGC.drawString("Player 1 turn", 15, 35);
                offscrGC.setColor(Color.yellow);
                turn = 0;
            }
            
            offscrGC.fillOval(92, 495-(col1counter*80), 73, 73);
            col1counter++;

        }
        
     	/**
		Method to fill the second column
	*/       
        public void fillCol2(){
            if(col2counter == 6){
                return;
            }
            if(turn == 0){
                offscrGC.drawString("Player 2 turn", 15, 35);
                offscrGC.setColor(Color.red);
                turn = 1;
            }else{
                offscrGC.drawString("Player 1 turn", 15, 35);
                offscrGC.setColor(Color.yellow);
                turn = 0;
            }

            offscrGC.fillOval(182, 495-(col2counter*80), 73, 73);
            col2counter++;

        }
        
    	/**
		Method to fill the third column
	*/        
        public void fillCol3(){
            if(col3counter == 6){
                return;
            }
            if(turn == 0){
                offscrGC.drawString("Player 2 turn", 15, 35);
                offscrGC.setColor(Color.red);
                turn = 1;
            }else{
                offscrGC.drawString("Player 1 turn", 15, 35);
                offscrGC.setColor(Color.yellow);
                turn = 0;
            }

            offscrGC.fillOval(272, 495-(col3counter*80), 73, 73);
            col3counter++;

        }
    	/**
		Method to fill the forth column
	*/
        public void fillCol4(){
            if(col4counter == 6){
                return;
            }
            if(turn == 0){
                offscrGC.drawString("Player 2 turn", 15, 35);
                offscrGC.setColor(Color.red);
                turn = 1;
            }else{
                offscrGC.drawString("Player 1 turn", 15, 35);
                offscrGC.setColor(Color.yellow);
                turn = 0;
            }

            offscrGC.fillOval(362, 495-(col4counter*80), 73, 73);
            col4counter++;

        }
    	/**
		Method to fill the fifth column
	*/
        public void fillCol5(){
            if(col5counter == 6){
                return;
            }
            if(turn == 0){
                offscrGC.drawString("Player 2 turn", 15, 35);
                offscrGC.setColor(Color.red);
                turn = 1;
            }else{
                offscrGC.drawString("Player 1 turn", 15, 35);
                offscrGC.setColor(Color.yellow);
                turn = 0;
            }

            offscrGC.fillOval(452, 495-(col5counter*80), 73, 73);
            col5counter++;

        }
        
    	/**
		Method to fill the sixth column
	*/
        public void fillCol6(){
            if(col6counter == 6){
                return;
            }
            if(turn == 0){
                offscrGC.drawString("Player 2 turn", 15, 35);
                offscrGC.setColor(Color.red);
                turn = 1;
            }else{
                offscrGC.drawString("Player 1 turn", 15, 35);
                offscrGC.setColor(Color.yellow);
                turn = 0;
            }

            offscrGC.fillOval(542, 495-(col6counter*80), 73, 73);
            col6counter++;

        }
        
    	/**
		Method to fill the seventh column
	*/
        public void fillCol7(){
            if(col7counter == 6){
                return;
            }
            if(turn == 0){
                offscrGC.drawString("Player 2 turn", 15, 35);
                offscrGC.setColor(Color.red);
                turn = 1;
            }else{
                offscrGC.drawString("Player 1 turn", 15, 35);
                offscrGC.setColor(Color.yellow);
                turn = 0;
            }

            offscrGC.fillOval(632, 495-(col7counter*80), 73, 73);
            col7counter++;

        }
	@Override
  	public void paint(Graphics g)
   	{
                
		g.setColor(Color.white);
		g.fillRect(0, 0, FRAME_WIDTH, FRAME_HEIGHT);
		g.drawImage(offscrImg, 0, 0, this);
    	}
	@Override
	public void update(Graphics g)
	{
		paint(g);
	}
}