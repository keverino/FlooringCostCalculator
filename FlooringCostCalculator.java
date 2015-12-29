/*
 * PROJECT: Find cost to cover W x H Floor
 * DESCRIPTION: Calculate the total cost of tile it would take to cover a floor plan of width and length
 */

import java.util.Scanner;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class FlooringCostCalculator implements ActionListener
{
	private JFrame jfrm;
	private JLabel statusLabel;
	private JTextArea textArea;
	private JTextField widthField;
	private JTextField lengthField;
	private JTextField costField;
	private JComboBox currencyComboBox;
	private JComboBox unitComboBox;
   private String versionString = "0.1";
//----------------------------------------------------------------------------------------------------
	public static void main(String[] args){ new FlooringCostCalculator(); }
//----------------------------------------------------------------------------------------------------
	public FlooringCostCalculator()
	{
		String[] currencyStrings = { "$", "€", "₩", "¥" };
		String[] unitStrings = { "inches", "centimeters", "feet", "meters", "yards" };

		// Create a new JFrame container with specified settings.
      jfrm = new JFrame("Flooring Cost Calculator");
      jfrm.setLayout(new BorderLayout());
      jfrm.setSize(600, 400);
      jfrm.setLocationRelativeTo(null);
      jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      jfrm.setResizable(false);

		// Create banner
      ImageIcon banner = new ImageIcon(getClass().getResource("images/flooringCost.jpg"));
      JLabel imgLabel = new JLabel();
      imgLabel.setIcon(banner);

		// Create width/length/cost labels and fields
		JLabel widthLabel = new JLabel("Width:");
		widthField = new JTextField(12);
		JLabel lengthLabel = new JLabel("Length:");
		lengthField = new JTextField(12);
		JLabel costLabel = new JLabel("Cost / unit\u00B2:");
		costField = new JTextField(32);

      // Create buttons and actionListeners
      JButton calcButton = new JButton("Calculate");
      JButton helpButton = new JButton("Help");
      calcButton.addActionListener(this);
      helpButton.addActionListener(this);

		// Create the combo box (dropdown menu) for currency, select item at index 0;
		currencyComboBox = new JComboBox(currencyStrings);
		currencyComboBox.setSelectedIndex(0);
		currencyComboBox.addActionListener(this);

		// Create the combo box (dropdown menu) for units, select item at index 0;
		unitComboBox = new JComboBox(unitStrings);
		unitComboBox.setSelectedIndex(0);
		unitComboBox.addActionListener(this);

		// Create a text area within a scrollpane, output goes here
   	textArea = new JTextArea(5, 35);
      JScrollPane scrollPane = new JScrollPane(textArea);
      textArea.setEditable(false);
		Font font = new Font("Verdana", Font.PLAIN, 16);
		textArea.setFont(font);

		// Add status bar
      statusLabel = new JLabel();

		// Create a new panel
      JPanel panel = new JPanel(new FlowLayout());
      panel.add(imgLabel);
		panel.add(widthLabel);
		panel.add(widthField);
		panel.add(lengthLabel);
		panel.add(lengthField);
		panel.add(unitComboBox);
		panel.add(costLabel);
		panel.add(currencyComboBox);
		panel.add(costField);
		panel.add(calcButton);
		panel.add(helpButton);
		panel.add(scrollPane);

      // Add objects to the content pane.
      jfrm.add(panel, BorderLayout.CENTER);
      jfrm.add(statusLabel, BorderLayout.SOUTH);

      //Display the frame.
      jfrm.setVisible(true);
	}
//----------------------------------------------------------------------------------------------------
	public void actionPerformed(ActionEvent ae)
   {
		try
      {
         if(ae.getActionCommand().equals("Calculate"))
         {
				double tempCostDouble = Double.parseDouble(costField.getText());
				double tempWidthDouble = Double.parseDouble(widthField.getText());
				double tempLengthDouble = Double.parseDouble(lengthField.getText());
				double tempResultDouble = tempWidthDouble * tempLengthDouble;
				String currencyValue = currencyComboBox.getSelectedItem().toString();
				String unitValue = unitComboBox.getSelectedItem().toString();

				textArea.setText("Your area of " + tempResultDouble + " " + unitValue + "\u00B2 will cost "
										+ currencyValue + tempCostDouble * tempResultDouble);

				clearFields();
         }
         else if (ae.getActionCommand().equals("Help"))
         {
           textArea.setText("");
           statusLabel.setText("");
           jfrm.setTitle("Flooring Cost Calculator");
           JOptionPane.showMessageDialog(jfrm,
            "Version: " + versionString + "\n\n"
            + "Description: \n"
            + "This program is designed to calculate the cost for flooring an area.\n",
            "Help / About", JOptionPane.PLAIN_MESSAGE);
         }
      }//end try
   catch (Exception e){}
	}
//----------------------------------------------------------------------------------------------------
	public void clearFields()
	{
		widthField.setText("");
		lengthField.setText("");
		costField.setText("");
	}
//----------------------------------------------------------------------------------------------------
}
