/*********************************************
//NAME: Jonathan Wasserman
//DATE: 11/29/2013
//SPECIFICATION: Class StatsScreen contains a GUI that allows users to view statistics on an object of type DrumInventory
//FOR: CSE 110 Honors Project
//*******************************************/

//Imports swing package to create frames, panels, buttons, labels, borders
import javax.swing.*;
import javax.swing.border.*;
//Imports awt package to create ActionListeners
import java.awt.*;
import java.awt.event.*;

public class StatsScreen
{
	//GUI components
	JFrame frame;
	JLabel greeting;
	JPanel panel;
	JPanel panel2;
	JPanel mainReturn;
	JButton manufacturer;
	JButton category;
	JButton priceRange;
	JButton profitRange;
	//Creates object of type DrumInventory to contain argument
	DrumInventory inventory;
	//Creates Action Listener for each button
	ManuListener listener1;
	CatListener listener2;
	PriceListener listener3;
	ProfitListener listener4;


	public StatsScreen(DrumInventory input)
	{

		//Assigns argument input to inventory, passes object of type DrumInventory from HomeScreen
		inventory = input;
		
		//Initializes Action Listener for each button
		listener1 = new ManuListener();
		listener2 = new CatListener();
		listener3 = new PriceListener();
		listener4 = new ProfitListener();

		//Initializes frame to anchor components
		frame = new JFrame();
		frame.setSize(600,400);
		frame.setTitle("What kind of statistics would you like?");
		frame.setVisible(true);
		frame.setBackground(new Color(53, 56, 64));

		//Initializes panel to hold greeting
		panel = new JPanel();
		panel.setSize(new Dimension(600,400));
		panel.setOpaque(true);
		panel.setBorder(new LineBorder(Color.blue, 10));
		//Adds panel to frame, places at top of frame using BorderLayout
		frame.getContentPane().add(panel, BorderLayout.PAGE_START);

		//Initializes panel2 to hold buttons
		panel2 = new JPanel();
		panel2.setSize(new Dimension(600,400));
		panel2.setOpaque(true);
		panel2.setBorder(new LineBorder(Color.blue, 10));
		//Adds panel2 to frame, places at bottom of frame
   		frame.getContentPane().add(panel2, BorderLayout.PAGE_END );

		//Greeting prompts user to select a button
   		greeting = new JLabel("What kind of statistics would you like?");
		greeting.setSize(new Dimension(400,500));
		greeting.setOpaque(true);
		greeting.setBackground(Color.WHITE);
		greeting.setForeground(Color.BLUE);
		greeting.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
		//Adds greeting to panel, places at top of panel
		panel.add(greeting, BorderLayout.PAGE_START);

		//Initializes button for each type of statistic
		manufacturer = new JButton("Manufacturer");
		manufacturer.setVisible(true);
		manufacturer.setPreferredSize(new Dimension(200,40));
		manufacturer.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		manufacturer.setBackground(Color.WHITE);
		manufacturer.setForeground(Color.BLUE);
		//Adds Action Listener to each button
		manufacturer.addActionListener(listener1);
		//Adds each button to panel2, places left to right across the panel according to chronological order using default FlowLayout
		panel2.add(manufacturer);

		category = new JButton("Category");
		category.setVisible(true);
		category.setPreferredSize(new Dimension(200,40));
		category.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		category.setBackground(Color.WHITE);
		category.setForeground(Color.BLUE);
		category.addActionListener(listener2);
		panel2.add(category);

		priceRange = new JButton("Price Range");
		priceRange.setVisible(true);
		priceRange.setPreferredSize(new Dimension(200,40));
		priceRange.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		priceRange.setBackground(Color.WHITE);
		priceRange.setForeground(Color.BLUE);
		priceRange.addActionListener(listener3);
		panel2.add(priceRange);

		profitRange = new JButton("Profit Range");
		profitRange.setVisible(true);
		profitRange.setPreferredSize(new Dimension(200,40));
		profitRange.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		profitRange.setBackground(Color.WHITE);
		profitRange.setForeground(Color.BLUE);
		profitRange.addActionListener(listener4);
		panel2.add(profitRange);

		//Compresses GUI components for visual appeal
		frame.pack();
	}

	//Action Listener class for each button
	private class ManuListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			//Launches dialog box containing the relevant statistics based on DrumEquipment inventory
			JOptionPane.showMessageDialog(frame, inventory.manufacturerStats());
		}
	}

	private class CatListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			JOptionPane.showMessageDialog(frame, inventory.categoryStats());
		}
	}

	private class PriceListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			JOptionPane.showMessageDialog(frame, inventory.priceStats());
		}
	}

	private class ProfitListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			JOptionPane.showMessageDialog(frame, inventory.profitStats());
		}
	}

}