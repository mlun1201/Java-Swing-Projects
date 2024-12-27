import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class PropertyTax extends JFrame
{
   //to reference
   private JPanel panel;
   private JLabel valueLabel;
   private JTextField valueTextField;
   private JButton calcButton;
   //window dimensions
   private final int WINDOW_WIDTH = 310;
   private final int WINDOW_HEIGHT = 100;

   private void buildPanel(){
      //create label, textfield, button
      valueLabel = new JLabel("Value of property: $");
      valueTextField = new JTextField(10);
      calcButton = new JButton("Calculate");
      //displays assessment price and property tax when clicked
      calcButton.addActionListener(new CalcButtonListener());
      //create and add components to panel
      panel = new JPanel();
      panel.add(valueLabel);
      panel.add(valueTextField);
      panel.add(calcButton);
   }

   public PropertyTax()
   {
      //setup window
      setTitle("Property Tax Calculator");
      setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      buildPanel();
      add(panel);
      setVisible(true);
   }

   private class CalcButtonListener implements ActionListener{
      public void actionPerformed(ActionEvent e)
      {
         //get and intialize variable from input
         //convert string to double
         double propertyValue = Double.parseDouble(valueTextField.getText());
         //calculate assessment value
         double assessmentValue = propertyValue*0.6;
         //calculate property tax
         //for every $100, $0.64 so round down with (int)
         double propertyTax = (int)(assessmentValue/100)*(0.64);
         //display results
         JOptionPane.showMessageDialog(null, "Assessment Value: $"  + assessmentValue + "\n" + "Property Tax: $" + propertyTax);
      }
   } 
   

   public static void main(String[] args)
   {
      new PropertyTax();
   }
}