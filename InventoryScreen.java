/*********************************************
//NAME: Jonathan Wasserman
//DATE: 11/29/2013
//SPECIFICATION: Class Inventory contains a GUI that allows users to add elements to an object of type DrumInventory
//FOR: CSE 110 Honors Project
//*******************************************/

import javax.swing.*;
import javax.swing.border.*;

import java.awt.*;
import java.awt.event.*;

public class InventoryScreen
{
	//Creates object of type DrumInventory to contain argument
	DrumInventory inventory;
	//Strings to store user input
	String manuName;
	String catName;
	//GUI components
	JFrame frame;
	JLabel greeting;
	JLabel manufacturer;
	JLabel category;
	JLabel wholesale;
	JLabel retail;
	JPanel inputFields;
	JPanel panelGreeting;
	JPanel panelSubmit;
	//User submission button
	JButton submit;
	//Button groups for manufacturer and category radio buttons
	ButtonGroup manuGroup;
	ButtonGroup catGroup;
	JRadioButton pearl;
	JRadioButton zildjian;
	JRadioButton dw;
	JRadioButton mapex;
	JRadioButton drum;
	JRadioButton hardware;
	JRadioButton cymbal;
	//Text fields for wholesale and retail price user input 
	JTextField wholesaleInput;
	JTextField retailInput;
	//ActionListener for submission
	InventorySubmissionListener submitListener;
	//ActionListeners for radio buttons
	PearlActionListener listener1;
	DWActionListener listener2;
	ZildjianActionListener listener3;
	MapexActionListener listener4;
	DrumActionListener listener5;
	CymbalActionListener listener6;
	HardwareActionListener listener7;

	public InventoryScreen(DrumInventory input)
	{
		//Passes argument of type DrumInventory from HomeScreen, stores as variable input
		inventory = input;
		
		//Initializes frame, anchor for screen
		frame = new JFrame();
		frame.setSize(600,400);
		frame.setTitle("Adding Product to Inventory");
		frame.setVisible(true);
		frame.setBackground(new Color(53, 56, 64));

		//JPanel to contain greeting
		panelGreeting = new JPanel();
		panelGreeting.setSize(new Dimension(600,400));
		panelGreeting.setOpaque(true);
		panelGreeting.setBorder(new LineBorder(Color.blue, 10));
		//Adds panelGreeting to frame, places at top of frame using BorderLayout
		frame.getContentPane().add(panelGreeting, BorderLayout.PAGE_START);

		//Initializes greeting and instructions for user
		greeting = new JLabel("Please enter the product information:");
		greeting.setSize(new Dimension(400,500));
		greeting.setOpaque(true);
		greeting.setBackground(Color.WHITE);
		greeting.setForeground(Color.BLUE);
		greeting.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
		//Adds greeting to panelGreeting, places at top of panel 
		panelGreeting.add(greeting, BorderLayout.PAGE_START);

		//Panel for user input fields and radio buttons
		inputFields = new JPanel();
		inputFields.setSize(new Dimension(600,400));
		inputFields.setOpaque(true);
		inputFields.setVisible(true);
		inputFields.setBorder(new LineBorder(Color.blue, 10));
		//Adds inputFields to frame, places in middle of frame
		frame.getContentPane().add(inputFields, BorderLayout.LINE_START);

		//Label instructs user what to enter in the accompanying text field
		wholesale = new JLabel(" Wholesale price: ");
		wholesale.setSize(new Dimension(400,500));
		wholesale.setOpaque(true);
		wholesale.setBackground(Color.WHITE);
		wholesale.setForeground(Color.BLUE);
		wholesale.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		//Adds label to inputFields, places it leftmost on the panel using default FlowLayout
		inputFields.add(wholesale);

		//Initializes text field for wholesale price user input
		wholesaleInput = new JTextField(7);
		wholesaleInput.setVisible(true);
		//Adds wholesaleInput to inputFields panel
		inputFields.add(wholesaleInput);

		//Label instructs user what to enter
		retail = new JLabel(" Retail price: ");
		retail.setSize(new Dimension(400,500));
		retail.setOpaque(true);
		retail.setBackground(Color.WHITE);
		retail.setForeground(Color.BLUE);
		retail.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		//Adds label to inputFields
		inputFields.add(retail);

		//Initializes text field for retail price user input
		retailInput = new JTextField(7);
		retailInput.setVisible(true);
		//Adds retailInput to inputFields
		inputFields.add(retailInput);

		//Label instructs user of what the accompanying radio buttons represent
		manufacturer = new JLabel(" Manufacturer name: ");
		manufacturer.setSize(new Dimension(400,500));
		manufacturer.setOpaque(true);
		manufacturer.setBackground(Color.WHITE);
		manufacturer.setForeground(Color.BLUE);
		manufacturer.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		//Adds manufacturer to inputFields
		inputFields.add(manufacturer);

		//Initializes button group for manufacturer choices
		manuGroup = new ButtonGroup();

		//Initializes Action Listener for each radio button
		listener1 = new PearlActionListener();
		listener2 = new DWActionListener();
		listener3 = new ZildjianActionListener();
		listener4 = new MapexActionListener();
		listener5 = new DrumActionListener();
		listener6 = new CymbalActionListener();
		listener7 = new HardwareActionListener();

		//Initializes each radio button
		pearl = new JRadioButton("Pearl");
		//Adds each radio button to manuGroup
		manuGroup.add(pearl);
		//Adds the appropriate Action Listener to each radio button
		pearl.addActionListener(listener1);
		//Adds each radio button to inputFields panel
		inputFields.add(pearl);

		zildjian = new JRadioButton("Zildjian");
		manuGroup.add(zildjian);
		zildjian.addActionListener(listener3);
		inputFields.add(zildjian);

		mapex = new JRadioButton("Mapex");
		manuGroup.add(mapex);
		mapex.addActionListener(listener4);
		inputFields.add(mapex);

		dw = new JRadioButton("DW");
		manuGroup.add(dw);
		dw.addActionListener(listener2);
		inputFields.add(dw);

		//Label instructs user as to what accompanying radio buttons represent
		category = new JLabel(" Category: ");
		category.setSize(new Dimension(400,500));
		category.setOpaque(true);
		category.setBackground(Color.WHITE);
		category.setForeground(Color.BLUE);
		category.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		//Adds category to inputFields
		inputFields.add(category);

		//Initializes button group for category radio buttons
		catGroup = new ButtonGroup();

		//Initializes each radio button
		drum = new JRadioButton("Drum");
		//Adds eaach radio button to catGroup
		catGroup.add(drum);
		//Adds the appropriate Action Listener to each radio button
		drum.addActionListener(listener5);
		//Adds each radio button to the inputFields panel
		inputFields.add(drum);

		cymbal = new JRadioButton("Cymbal");
		catGroup.add(cymbal);
		cymbal.addActionListener(listener6);
		inputFields.add(cymbal);

		hardware = new JRadioButton("Hardware");
		catGroup.add(hardware);
		hardware.addActionListener(listener7);
		inputFields.add(hardware);

   		//Initializes panel for submit button
		panelSubmit = new JPanel();
		panelSubmit.setSize(new Dimension(600,400));
		panelSubmit.setOpaque(true);
		panelSubmit.setBorder(new LineBorder(Color.blue, 10));
   		//Adds panelSubmit to frame, places at bottom of frame
		frame.getContentPane().add(panelSubmit, BorderLayout.PAGE_END );

		//Initializes ActionListener for submit button 
		submitListener = new InventorySubmissionListener();

		//Initializes submit button
		submit = new JButton("Submit");
		submit.setVisible(true);
		submit.setPreferredSize(new Dimension(200,40));
		submit.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		submit.setBackground(Color.WHITE);
		submit.setForeground(Color.BLUE);
		//Adds Action Listener to submit button
		submit.addActionListener(submitListener);
		//Adds submit button to panelSubmit
		panelSubmit.add(submit);

		//Compresses GUI components for visual appeal
		frame.pack();
	}	
	
	//Action Listener class for each category radio button
	private class CymbalActionListener extends DrumInventory implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			//Assigns relevant category name to catName, registers user input
			catName = "Cymbal";
		}
	}
	
	private class DrumActionListener extends DrumInventory implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			catName = "Drum";
		}
	}

	private class HardwareActionListener extends DrumInventory implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			catName = "Hardware";
		}
	}

	//Action Listener class for each manufacturer radio button
	private class DWActionListener extends DrumInventory implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			//Assigns relevant manufacturer name to manuName, registers user input
			manuName = "DW";
		}
	}
	
	private class PearlActionListener extends DrumInventory implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			manuName = "Pearl";
		}
	}
	
	private class ZildjianActionListener extends DrumInventory implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			manuName = "Zildjian";
		}
	}
	
	private class MapexActionListener extends DrumInventory implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			manuName = "Mapex";
		}
	}
	
	//Action Listener class for submit button
	private class InventorySubmissionListener implements ActionListener
	{
		//Declares variables to store input for retail and wholesale prices
		double wholesaleNum;
		double retailNum;

		public void actionPerformed(ActionEvent e)
		{
			//Stores text from text field
			String wholesaleText = wholesaleInput.getText();
			//Converts text into double
			wholesaleNum = Double.parseDouble(wholesaleText);
			String retailText = retailInput.getText();
			retailNum = Double.parseDouble(retailText);
			//Informs user that their input has been submitted
			JOptionPane.showMessageDialog(frame, "Submitted. Please submit another item or return to the main menu.");
			//Adds element to inventory using input
			inventory.addEquipment(manuName, catName, wholesaleNum, retailNum);
		}
	}

}