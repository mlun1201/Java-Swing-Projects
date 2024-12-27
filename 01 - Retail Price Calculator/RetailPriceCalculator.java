import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class RetailPriceCalculator extends JFrame
{
   //to reference
   private JPanel panel;
   private JLabel priceLabel;
   private JLabel markupLabel;
   private JTextField priceTextField;
   private JTextField markupTextField;
   private JButton calcButton;
   //window dimensions
   private final int WINDOW_WIDTH = 310;
   private final int WINDOW_HEIGHT = 150;

   public RetailPriceCalculator()
   {
      //set title
      setTitle("Retail Price Calculator");
      //set size
      setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
      //close upon clicking close button
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      //build and add panel to frame and content pane
      buildPanel();
      add(panel);
      setVisible(true);
   }

   private void buildPanel(){
      //create labels, textfields, and button
      priceLabel = new JLabel("Wholesale cost: $");
      priceTextField = new JTextField(10);
      markupLabel = new JLabel("Markup Percentage: ");
      markupTextField = new JTextField(10);
      calcButton = new JButton("Calculate");
      //displays retail price when clicked
      calcButton.addActionListener(new CalcButtonListener());
      //create panel and add components to it
      panel = new JPanel();
      panel.add(priceLabel);
      panel.add(priceTextField);
      panel.add(markupLabel);
      panel.add(markupTextField);
      panel.add(calcButton);
   }

   private class CalcButtonListener implements ActionListener{
      public void actionPerformed(ActionEvent e)
      {
         //initalize new doubles with inputs
         //must convert string to double
         double price = Double.parseDouble(priceTextField.getText());
         //percentage to decimal equivalent
         double markup = Double.parseDouble(markupTextField.getText()) * 0.01;
         //calculate retail price
         double retail = price + (price*markup);
         //display results
         JOptionPane.showMessageDialog(null, "Retail price is $" + retail);
      }
   }
   

   public static void main(String[] args)
   {
      new RetailPriceCalculator();
   }
}