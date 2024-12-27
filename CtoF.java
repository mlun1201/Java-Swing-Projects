import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class CtoF extends JFrame
{
   //to reference
   private JPanel panel;
   private JLabel cLabel;
   private JTextField cTextField;
   private JButton convertButton;
   //window dimensions
   private final int WINDOW_WIDTH = 310;
   private final int WINDOW_HEIGHT = 90;

   public void buildPanel(){
      //create label, textfield, button
      cLabel = new JLabel("Celsius: ");
      cTextField = new JTextField(10);
      convertButton = new JButton("Convert");
      //displays conversion when clicked
      convertButton.addActionListener(new ConvertButtonListener());
      //create and add components to panel
      panel = new JPanel();
      panel.add(cLabel);
      panel.add(cTextField);
      panel.add(convertButton);
   }

   public CtoF()
   {
      //setup window and display
      setTitle("Celsius to Fahrenheit");
      setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      buildPanel();
      add(panel);
      setVisible(true);
   }

   private class ConvertButtonListener implements ActionListener{
      public void actionPerformed(ActionEvent e)
      {
         //get from input and initalize new double
         //convert string to double
         double celsius = Double.parseDouble(cTextField.getText());
         //calculate conversion from celsius to fahrenheit
         double fahrenheit = (9.0/5)*celsius+32;
         //display results
         JOptionPane.showMessageDialog(null, "Fahrenheit: " + fahrenheit);
      }
   }
   

   public static void main(String[] args)
   {
      new CtoF();
   }
}