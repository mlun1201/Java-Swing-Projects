import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class MPGCalculator extends JFrame
{
   //to reference
   private JPanel panel;
   private JLabel gasLabel;
   private JLabel milesLabel;
   private JTextField gasTextField;
   private JTextField milesTextField;
   private JButton calcButton;
   //window dimensions
   private final int WINDOW_WIDTH = 350;
   private final int WINDOW_HEIGHT = 150;

   public void buildPanel(){
      //create labels, textfields, button
      gasLabel = new JLabel("# of gallons car holds: ");
      gasTextField = new JTextField(10);
      milesLabel = new JLabel("# of miles it can drive on full tank: ");
      milesTextField = new JTextField(10);
      calcButton = new JButton("Calculate MPG");
      //displays mpg when clicked
      calcButton.addActionListener(new CalcButtonListener());
      //create and add componenets to panel
      panel = new JPanel();
      panel.add(gasLabel);
      panel.add(gasTextField);
      panel.add(milesLabel);
      panel.add(milesTextField);
      panel.add(calcButton);
   }

   public MPGCalculator()
   {
      //setup window
      setTitle("MPG Calculator");
      setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      buildPanel();
      add(panel);
      setVisible(true);
   }

   private class CalcButtonListener implements ActionListener{
      public void actionPerformed(ActionEvent e)
      {
         //get and intialize variables from input
         //convert from string to double
         double gallons = Double.parseDouble(gasTextField.getText());
         double miles = Double.parseDouble(milesTextField.getText());
         //calculate mileage
         double mpg = miles/gallons;
         //display results
         JOptionPane.showMessageDialog(null, "Mileage: " + mpg + " MPG");
      }
   }
   

   public static void main(String[] args)
   {
      new MPGCalculator();
   }
}