

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import javax.swing.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author victorcarvalho
 */
public class ConnectFour 
{
        
        
        
	public static void main(String[] args) 
	{
                final int LABEL_WIDTH = 120;
                final int LABEL_HEIGHT = 30;
                final int LABEL_YPOS = 15;
                final int BUTTON_WIDTH = 55;
                final int BUTTON_HEIGHT = 20;
                final int BUTTON_YPOS = 60;
                
                ConnectPlayer p1 = new ConnectPlayer();
                ConnectPlayer p2  = new ConnectPlayer();
                ConnectGame game = new ConnectGame();
                
                //Setup frames for player names
                JFrame player1Entry = new JFrame();
                JLabel p1Label = new JLabel("Enter Player 1 name");
                JTextField p1textField = new JTextField(8);
                JButton enterPlayer = new JButton("Submit");
                
                
                player1Entry.setLayout(new FlowLayout());
                player1Entry.add(p1Label);
                player1Entry.add(p1textField);
                player1Entry.add(enterPlayer);
                player1Entry.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                player1Entry.pack();
                player1Entry.setVisible(true);
                
                JFrame player2Entry = new JFrame();
                JLabel p2Label = new JLabel("Enter Player 2 name");
                JTextField p2textField = new JTextField(8);
                JButton enterPlayer2 = new JButton("Submit");

                player2Entry.setLayout(new FlowLayout());
                player2Entry.add(p2Label);
                player2Entry.add(p2textField);
                player2Entry.add(enterPlayer2);
                player2Entry.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                player2Entry.pack(); 
                
                //position all frames in the center of screen
                JFrame f = new JFrame("Connect 4 by Victor Carvalho");
                Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
                int x = (int) ((dimension.getWidth() - f.getWidth()) / 2);
                int y = (int) ((dimension.getHeight() - f.getHeight()) / 2);
                player1Entry.setLocation(x, y);
                player2Entry.setLocation(x, y);
                f.setLocation(x, y);
                
                //Set up menu
                JMenuBar menuBar = new JMenuBar();
                JMenu menu = new JMenu("Menu");
                JMenuItem help = new JMenuItem("Help");
                JMenuItem newGame = new JMenuItem("New Game");
                menuBar.add(menu);
                menu.add(help);
                menu.add(newGame);
                
                //Setup buttons labels and position them
                JLabel label1 = new JLabel();
                JLabel label2 = new JLabel();
                
                label1.setBounds(150, LABEL_YPOS, LABEL_WIDTH, LABEL_HEIGHT);
                label2.setBounds(300, LABEL_YPOS, LABEL_WIDTH, LABEL_HEIGHT);
                
                JButton col1 = new JButton("Drop");
                JButton col2 = new JButton("Drop");
                JButton col3 = new JButton("Drop");
                JButton col4 = new JButton("Drop");
                JButton col5 = new JButton("Drop");
                JButton col6 = new JButton("Drop");
                JButton col7 = new JButton("Drop");
   
                col1.setBounds(100, BUTTON_YPOS, BUTTON_WIDTH, BUTTON_HEIGHT);
                col2.setBounds(190, BUTTON_YPOS, BUTTON_WIDTH, BUTTON_HEIGHT);
                col3.setBounds(280, BUTTON_YPOS, BUTTON_WIDTH, BUTTON_HEIGHT);
                col4.setBounds(370, BUTTON_YPOS, BUTTON_WIDTH, BUTTON_HEIGHT);
                col5.setBounds(460, BUTTON_YPOS, BUTTON_WIDTH, BUTTON_HEIGHT);
                col6.setBounds(550, BUTTON_YPOS, BUTTON_WIDTH, BUTTON_HEIGHT);
                col7.setBounds(640, BUTTON_YPOS, BUTTON_WIDTH, BUTTON_HEIGHT);
                
                
                game.setSize(game.FRAME_WIDTH, game.FRAME_HEIGHT);
                f.setJMenuBar(menuBar);
                f.add(label1);
                f.add(label2);
                f.add(col1);
                f.add(col2);
                f.add(col3);
                f.add(col4);
                f.add(col5);
                f.add(col6);
                f.add(col7);
                f.add(game);
                
            //Listeners    
            enterPlayer.addActionListener(new
            ActionListener()
            {
                    public void actionPerformed(ActionEvent event)
                    {
                            p1.setName(p1textField.getText());
                            player1Entry.setVisible(false);
                            label1.setText(p1.getName() + " Score: " + p1.getScore());
                            player2Entry.setVisible(true);
                    }
            });
            
            enterPlayer2.addActionListener(new
            ActionListener()
            {
                    public void actionPerformed(ActionEvent event)
                    {
                            p2.setName(p2textField.getText());
                            player2Entry.setVisible(false);
                            label2.setText(p2.getName() + " Score: " + p2.getScore());
                            f.setVisible(true);
                    }
            });
                    
            help.addActionListener(new
            ActionListener()
            {
                    public void actionPerformed(ActionEvent event)
                    {
                            JOptionPane.showMessageDialog(f, game.helpMessage);
                            
                    }
            });

            newGame.addActionListener(new
            ActionListener()
            {
                    public void actionPerformed(ActionEvent event)
                    {
                            f.repaint();
                            game.init();
                            
                    }
            }); 
            col1.addActionListener(new
            ActionListener()
            {
                    public void actionPerformed(ActionEvent event)
                    {
                            f.repaint();
                            game.fillCol1();
                            
                    }
            });                
            col2.addActionListener(new
            ActionListener()
            {
                    public void actionPerformed(ActionEvent event)
                    {
                            f.repaint();
                            game.fillCol2();
                            
                    }
            });
            col3.addActionListener(new
            ActionListener()
            {
                    public void actionPerformed(ActionEvent event)
                    {
                            f.repaint();
                            game.fillCol3();
                            
                    }
            });
            col4.addActionListener(new
            ActionListener()
            {
                    public void actionPerformed(ActionEvent event)
                    {
                            f.repaint();
                            game.fillCol4();
                            
                    }
            });
            col5.addActionListener(new
            ActionListener()
            {
                    public void actionPerformed(ActionEvent event)
                    {
                            f.repaint();
                            game.fillCol5();
                            
                    }
            });
            col6.addActionListener(new
            ActionListener()
            {
                    public void actionPerformed(ActionEvent event)
                    {
                            f.repaint();
                            game.fillCol6();
                            
                    }
            });
            col7.addActionListener(new
            ActionListener()
            {
                    public void actionPerformed(ActionEvent event)
                    {
                            f.repaint();
                            game.fillCol7();
                            
                    }
            }); 
            
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                f.addWindowListener(new java.awt.event.WindowAdapter() {
                
                public void windowClosing(java.awt.event.WindowEvent e) {
		try
		{
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Player.dat"));
			out.writeObject(p1);
			out.writeObject(p2);
			out.close();
		}
		catch (SecurityException ex)
		{
			System.out.println("Serialization save error 1");
		}
		catch (IOException ex)
		{
			System.out.println("Serialization save error 2");
		}
                    }
                });

                f.pack();
                Insets insets = f.getInsets();
                f.setSize(game.FRAME_WIDTH + insets.left + insets.right, game.FRAME_HEIGHT + insets.top + insets.bottom);
                game.init();
                f.setVisible(false);
                
  	}
}