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
public class MyGrades {
	// Constructors
	public MyGrades()
	{ // initialize the member variables
		finalExam = 0;
		midtermExam = 0;
		numberOfHomeworks = 0;
		hw = new int[DEFAULT_NUM_HW];
	}

	// mutators
	public void setFinalExam(int grade)
	{ // set the finalExam grade
		finalExam = grade;
	}
	public void setMidtermExam(int grade)
	{ // set the midtermExam grade
		midtermExam = grade;
	}
	public void setHomework(int grade)
	{
		if (numberOfHomeworks == hw.length)
		{ // if there is not enough capacity in the array then
			int[] temp = new int[hw.length * 2];
			for (int i = 0; i < numberOfHomeworks; i++)
			{ // copy the current hw grades to the temp array
				temp[i] = hw[i];
			}
			hw = temp; // reposition the new array
		}
		hw[numberOfHomeworks] = grade;
		numberOfHomeworks++;
	}

	// accessors
	public double getFinalGrade()
	{
		double ave;
		int sum = 0;
		for (int i = 0; i < numberOfHomeworks; i++)
		{ // get the homework sum
			sum = sum + hw[i];
		}
		if (numberOfHomeworks != 0)
		{ // if there are hw assignments then no divide by zero issue
			ave = (MIDTERM_EXAM_WEIGHT * midtermExam) + (FINAL_EXAM_WEIGHT * finalExam) + (HW_WEIGHT * (sum / (double)numberOfHomeworks));
		}
		else
		{ // else do not include HW average
			ave = (MIDTERM_EXAM_WEIGHT * midtermExam) + (FINAL_EXAM_WEIGHT * finalExam);
		}
		return ave;
	}
	public boolean equals(MyGrades g)
	{
		boolean rv = true; // default to true
		if ((finalExam != g.finalExam) || (midtermExam != g.midtermExam) || (numberOfHomeworks != g.numberOfHomeworks))
		{ // if exams and array length the same then check the homeworks
			rv = false;
		}
		for (int i = 0; i < numberOfHomeworks; i++)
		{ // check all the homeworks
			if (hw[i] != g.hw[i])
			{ // if any are not the same then not equal and stop
				rv = false;
				break; // once a homewotk is different then end
			}
		}
		return rv;
	}
	@Override
	public String toString()
	{
		return ("Final Exam = " + finalExam + " Midterm Exam = " + midtermExam + " Final Grade = " + getFinalGrade());
	}
	public static double getFinalGrade(int finalTest, int midtermTest, int[] hwGrades)
	{
		double sum = 0;
		for(int i = 0; i < hwGrades.length; i++)
		{ // sum the hw grades
			sum = sum + hwGrades[i];
		}
		double hwAve;
		if (hwGrades.length == 0)
		{ // if no hw grades then average is 0
			hwAve = 0;
		}
		else
		{ // otherwise find the average
			hwAve = sum/hwGrades.length;
		}
		return((finalTest * MyGrades.FINAL_EXAM_WEIGHT) + (midtermTest * MIDTERM_EXAM_WEIGHT) + (hwAve * HW_WEIGHT));
	}

	// member variables
	private final int DEFAULT_NUM_HW = 3;
	private int[] hw;
	private int finalExam;
	private int midtermExam;
	private int numberOfHomeworks;

	// static variables
	public final static double FINAL_EXAM_WEIGHT = .25;
	public final static double MIDTERM_EXAM_WEIGHT = .25;
	public final static double HW_WEIGHT = .5;      
}

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
