/*********************************************
//NAME: Jonathan Wasserman
//DATE: 11/29/13
//SPECIFICATION: Class HomeScreen contains a GUI for the main menu of the inventory system
//FOR: CSE 110 Honors Project
//*******************************************/

//javax.swing contains interface elements
import javax.swing.*;
import javax.swing.border.*;

//java.awt contains event listener elements
import java.awt.*;
import java.awt.event.*;

public class HomeScreen
{
	
	JFrame frame;
	//Buttons for user to pick which operation he/she wants
	JButton stats;
	JButton inventory;
	//Panels for formatting
	JPanel panel;
	JPanel panel2;
	JLabel greeting;
	//ActionListeners for buttons
	StatsScreenButton listener;
	InventoryScreenButton listener2;
	//Creates instance of class DrumInventory
	DrumInventory newOne;

	public HomeScreen()
	{

		//Initializes variables
		newOne = new DrumInventory();
		listener = new StatsScreenButton();
		listener2 = new InventoryScreenButton();

		//Frame anchors GUI
		frame = new JFrame();
		frame.setSize(600,400);
		frame.setTitle("Welcome to The Drum Rack");
		frame.setVisible(true);
		//Terminates program when frame is closed
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//Panel to hold greeting
		panel = new JPanel();
		panel.setSize(new Dimension(600,400));
		panel.setOpaque(true);
   		//Establishes blue/white color scheme
		panel.setBorder(new LineBorder(Color.blue, 10));
   		//Inserts panel into frame, placed at top of frame using BorderLayout
   		frame.getContentPane().add(panel, BorderLayout.PAGE_START);

   		//Panel to hold buttons
   		panel2 = new JPanel();
   		panel2.setSize(new Dimension(600,400));
   		panel2.setOpaque(true);
   		panel2.setBorder(new LineBorder(Color.blue, 10));
   		//Inserts panel into frame, placed at bottom of frame using BorderLayout
   		frame.getContentPane().add(panel2, BorderLayout.PAGE_END );

		//Greeting for user
   		greeting = new JLabel("Welcome to the Drum Rack!");
		greeting.setSize(new Dimension(400,500));
		greeting.setOpaque(true);
		greeting.setBackground(Color.WHITE);
		greeting.setForeground(Color.BLUE);
		//Formats greeting to unique font
		greeting.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
		//Inserts greeting into panel, placed at top of panel using BorderLayout
		panel.add(greeting, BorderLayout.PAGE_START);

		//Labels button for ease of use
		stats = new JButton("Get Statistics");
		stats.setVisible(true);
		stats.setPreferredSize(new Dimension(200,40));
		stats.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		stats.setBackground(Color.WHITE);
		stats.setForeground(Color.BLUE);
		//Adds ActionListener to make button functional
		stats.addActionListener(listener);
		//Inserts into panel2, placed at right side of page using BorderLayout
		panel2.add(stats, BorderLayout.LINE_END);

		//Labels button for ease of use
		inventory = new JButton("Modify Inventory");
		inventory.setVisible(true);
		inventory.setPreferredSize(new Dimension(200,40));
		inventory.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		inventory.setBackground(Color.WHITE);
		inventory.setForeground(Color.BLUE);
		//Adds ActionListener to make button functional
		inventory.addActionListener(listener2);
		//Inserts into panel2, placed at left side of page using BorderLayout
		panel2.add(inventory, BorderLayout.LINE_START);

		//Compresses elements for visual appeal
		frame.pack();
	}

	//ActionListener for inventory button
	private class InventoryScreenButton implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			/*Creates new object of type InventoryScreen using newOne (type DrumInventory) as an argument
			so that the entire program will only operate on one instance of DrumInventory*/
			InventoryScreen test = new InventoryScreen(newOne);
		}
	}

	//ActionListener for stats button
	private class StatsScreenButton implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			/*Creates new object of type StatsScreen using newOne (type DrumInventory) as an argument
			so that the entire program will only operate on one instance of DrumInventory*/
			StatsScreen test = new StatsScreen(newOne);
		}
	}

	//Main method
	public static void main(String[] args)
	{
		//Creates new object of type HomeScreen; launches GUI
		HomeScreen test = new HomeScreen();
	}

}
