/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.fau.COT4930;

/**
 *
 * @author victorcarvalho
 */
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JTextArea;

public class MyGradesUI {
	public static void main(String[] args) 
	{
            final int FIELD_WIDTH = 8;
          
           
            JFrame frame = new JFrame("Howmework 6"); // a frame object is created
		// A textfiled object is created with initial text
            JTextField textField = new JTextField(FIELD_WIDTH);
            textField.setText("Enter grade");
            
            JTextArea textArea = new JTextArea();
            textArea.setText("Victor Carvalho");
            
            MyGrades m = new MyGrades();
            
            // A JButton is created with a text label
            JButton finalButton = new JButton("Final Exam");
            JButton midtermButton = new JButton("Midterm Exam");
            JButton homeworkButton = new JButton("Home Work");
            JButton enterfinalGrade = new JButton("Enter Grade");
            JButton entermidGrade = new JButton("Enter Grade");
            JButton enterhwGrade = new JButton("Enter Grade");
            JButton getGradesButton = new JButton("Get averaged grade");
            // An ActionListener object is added to the button using an anonymous class
            finalButton.addActionListener(new
            ActionListener()
            {
                    public void actionPerformed(ActionEvent event)
                    {
                            frame.add(textField);
                            frame.add(enterfinalGrade);
                            frame.pack();
                            
                            
                            //frame.validate();
                            //int grade = Integer.parseInt(textField.getText());
                            //m.setFinalExam(grade);
                    }
            });
            
            midtermButton.addActionListener(new
            ActionListener()
            {
                    public void actionPerformed(ActionEvent event)
                    {
                            frame.add(textField);
                            frame.add(entermidGrade);
                            frame.pack();
                            //frame.validate();
                            //int grade = Integer.parseInt(textField.getText());
                            //m.setFinalExam(grade);
                    }
            });
           
            homeworkButton.addActionListener(new
            ActionListener()
            {
                    public void actionPerformed(ActionEvent event)
                    {
                            frame.add(textField);
                            frame.add(enterhwGrade);
                            frame.pack();
                            //frame.validate();
                            //int grade = Integer.parseInt(textField.getText());
                            //m.setFinalExam(grade);
                    }
            });  
          
            enterfinalGrade.addActionListener(new
            ActionListener()
            {
                    public void actionPerformed(ActionEvent event)
                    {
                            int grade = Integer.parseInt(textField.getText());
                            m.setFinalExam(grade);
                            frame.remove(textField);
                            frame.remove(enterfinalGrade);
                            textArea.append("\n" + "Final grade " + Integer.toString(grade) + " entered");
                            textField.setText("Enter grade");
                            frame.pack();
                            
                    }
            });
            
            entermidGrade.addActionListener(new
            ActionListener()
            {
                    public void actionPerformed(ActionEvent event)
                    {
                            int grade = Integer.parseInt(textField.getText());
                            m.setMidtermExam(grade);
                            frame.remove(textField);
                            frame.remove(entermidGrade);
                            textArea.append("\n" + "Midterm grade " + Integer.toString(grade) + " entered");
                            textField.setText("");
                            frame.pack();
                            
                    }
            });
            
            enterhwGrade.addActionListener(new
            ActionListener()
            {
                    public void actionPerformed(ActionEvent event)
                    {
                            int grade = Integer.parseInt(textField.getText());
                            m.setHomework(grade);
                            frame.remove(textField);
                            frame.remove(enterhwGrade);
                            textArea.append("\n" + "Homework grade " + Integer.toString(grade) + " entered");
                            textField.setText("");
                            frame.pack();
                            
                    }
            });
            
            
            
            getGradesButton.addActionListener(new
            ActionListener()
            {
                    public void actionPerformed(ActionEvent event)
                    {
                            textArea.append("\n" + "Averaged grade = " + Double.toString(m.getFinalGrade()));
                            frame.pack();
                    }
            }); 
            
            textField.addFocusListener(new 
            FocusAdapter( ) 
            { // called when focus is obtained
                    public void focusGained(FocusEvent e) 
                    { // this will clear the field
                            textField.setText("");
                    }
            });

            
		// a layout for the frame object is selected
                frame.setLayout(new FlowLayout());

		// the button components and the textfield component is added to the frame
                frame.add(finalButton);
                frame.add(midtermButton);
                frame.add(homeworkButton);
                frame.add(getGradesButton);
                frame.add(textArea);

                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();  // sizes the frames for the components contained
                frame.setVisible(true);
   
        }
}
