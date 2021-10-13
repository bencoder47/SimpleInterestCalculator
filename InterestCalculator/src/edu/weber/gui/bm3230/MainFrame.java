package edu.weber.gui.bm3230;


//Written by Benjamin Medrano CS 3230
// Use Double value with out comma separator for savings
// Use Double for percentage, code will turn into % ex: 2.5 will be converted to 0.025
// Use int for years which will be ran through a for loop
//
import javax.swing.*;
import javax.swing.border.Border;
import javax.xml.soap.Text;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                GUIFrame frame = new GUIFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.getContentPane().setBackground(Color.GRAY);
                frame.setVisible(true);
            }
        });
    }

}

class GUIFrame extends JFrame
{
 public static final int DEFAULT_HEIGHT = 400;
 public static final int DEFAULT_WIDTH = 400;

 public GUIFrame() {
     setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
     setLocationByPlatform(true);
     setTitle("Long Term Interest Calculator");

     final JTextField savingsTextField = new JTextField();
     final JTextField interestTextField = new JTextField();
     final JTextField yearsTextField = new JTextField();
     final TextArea textArea = new TextArea();



     JPanel northPanel = new JPanel();
     JPanel southPanel = new JPanel();
     JPanel eastPanel = new JPanel();
     northPanel.setLayout(new GridLayout(5,4));
     northPanel.add(new JLabel("Initial Savings:", SwingConstants.LEFT));
     northPanel.add(savingsTextField);
     northPanel.add(new JLabel("Interest Rate:", SwingConstants.LEFT));
     northPanel.add(interestTextField);
     JButton calculateButton = new JButton("Calculate");

     northPanel.add(new JLabel("Years: ", SwingConstants.LEFT));
     northPanel.add(yearsTextField);

     eastPanel.add(calculateButton);
     calculateButton.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
             int yearsEntered = Integer.parseInt(yearsTextField.getText());
             double interestEntered = Double.parseDouble(interestTextField.getText());
             double savingsEntered = Double.parseDouble(savingsTextField.getText());

             for(int i = 0; i < yearsEntered; i++) {
                 if(i != 0) {
                     double current = savingsEntered * (interestEntered / 100);
                     savingsEntered += current;
                 }
                 textArea.append("Savings in year " + (i+1) + ": $" + savingsEntered +  "\n");
             }
         }
     });




     northPanel.add(new JLabel("Yearly Savings: ", SwingConstants.LEFT));
     //Calculate Button


     southPanel.setLayout(new GridLayout(1,1));
     southPanel.add(textArea);


     add(northPanel, BorderLayout.NORTH);
     add(eastPanel, BorderLayout.AFTER_LINE_ENDS);
     add(southPanel);
 }


}




