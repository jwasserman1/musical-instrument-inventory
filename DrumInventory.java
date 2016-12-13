/*********************************************
//NAME: Jonathan Wasserman
//DATE: 11/15/2013
//SPECIFICATION: Class DrumInventory maintains an array list of type DrumEquipment and performs certain kinds of analysis on that array list
//FOR: CSE 110 Honors Project
//*******************************************/

//Java.util contains ArrayList class
import java.util.*;

public class DrumInventory
{

	//ArrayList of type DrumEquipment
	private ArrayList <DrumEquipment> inventory;

	//Constructor initializes instance variable
	public DrumInventory()
	{
		inventory = new ArrayList <DrumEquipment>();
	}

	//Allows user to add elements to the ArrayList
	public void addEquipment(String manufacturer, String category, double wholesale, double retail)
	{
		DrumEquipment adding = new DrumEquipment(manufacturer, category, wholesale, retail);
		inventory.add(adding);
	}

	//Standard toString method
	public String toString()
	{
		String returner = "";
		for(int i = 0; i < inventory.size(); i++)
		{
			returner += "\n";
			returner += inventory.get(i).toString();
		}
		return returner;
	}

	//Returns how many items in the ArrayList are made by each of four manufacturers
	public String manufacturerStats()
	{
		String returner = "";
		//Counter for each manufacturer
		int zildjianCount = 0;
		int pearlCount = 0;
		int dwCount = 0;
		int mapexCount = 0;
		
		//ArrayList variable to be filled with manufacturer names
		ArrayList<String> manufacturerList = new ArrayList<String>();

		//Fills manufacturerList with manufacturer names
		for(int i = 0; i<inventory.size(); i++)
		{
			manufacturerList.add(inventory.get(i).manufacturerShow());
		}

		//Examines elements in manufacturer list 
		for(int i = 0; i<manufacturerList.size(); i++)
		{
			//Increments count for each manufacturer if one of their items is examined by the for-loop
			if(manufacturerList.get(i).equals("Zildjian"))
			{
				zildjianCount++;
			}
			else if(manufacturerList.get(i).equals("Pearl"))
			{
				pearlCount++;
			}
			else if(manufacturerList.get(i).equals("Mapex"))
			{
				mapexCount++;
			}
			else if(manufacturerList.get(i).equals("DW"))
			{
				dwCount++;
			}
		}
		returner += "Zildjian products: " + zildjianCount + "\nPearl Products: " + pearlCount + "\nDW Products: " + dwCount + "\nMapex Products: " + mapexCount;
		return returner;
	}

	//Same methodology as manufacturerStats
	public String categoryStats()
	{
		String returner = "";
		int drumCount = 0;
		int cymbalCount = 0;
		int hardwareCount = 0;
		ArrayList<String> categoryList = new ArrayList<String>();

		for(int i = 0; i<inventory.size(); i++)
		{
			categoryList.add(inventory.get(i).categoryShow());
		}

		for(int i = 0; i<categoryList.size(); i++)
		{
			if(categoryList.get(i).equals("Drum"))
			{
				drumCount++;
			}
			else if(categoryList.get(i).equals("Cymbal"))
			{
				cymbalCount++;
			}
			else if(categoryList.get(i).equals("Hardware"))
			{
				hardwareCount++;
			}
		}
		returner += "Drums: " + drumCount + "\nCymbals: " + cymbalCount + "\nPieces of Hardware: " + hardwareCount;
		return returner;
	}

	//Returns how many items in each price range are in the inventory
	public String priceStats()
	{
		String returner = "";
		//Counter for each price range
		int zeroToHundredCount = 0;
		int hundredToTwoCount = 0;
		int twoToThreeCount = 0;
		int threeAndOverCount = 0;
		
		//ArrayList of doubles to hold retail prices
		double[] retailList = new double[inventory.size()];

		//Fills retailList with retail prices
		for(int i = 0; i<inventory.size(); i++)
		{
			retailList[i] = (inventory.get(i).retailShow());
		}

		//Examines elements in retailList
		for(int i = 0; i<retailList.length; i++)
		{
			//Increments count for a price range if an item in that range is examined
			if(retailList[i] < 100)
			{
				zeroToHundredCount++;
			}
			else if(retailList[i] >= 100 && retailList[i] < 200)
			{
				hundredToTwoCount++;
			}
			else if(retailList[i] >= 200 && retailList[i] < 300)
			{
				twoToThreeCount++;
			}
			else if(retailList[i] >= 300)
			{
				threeAndOverCount++;
			}
		}
		returner += "Retail Price Statistics:\n******************************\nUnder $100: " + zeroToHundredCount + "\n$100 to $200: " + hundredToTwoCount + "\n$200 to $300: " + twoToThreeCount +"\n$300 and Over: " + threeAndOverCount;
		return returner;
	}

	//Same methodology as priceStats
	public String profitStats()
	{
		String returner = "";
		int moneyLoser = 0;
		int zeroToForty = 0;
		int fortyToHundred = 0;
		int hundredTo150 = 0;
		int above150 = 0;
		double[] profitList = new double[inventory.size()];

		for(int i = 0; i<inventory.size(); i++)
		{
			profitList[i] = (inventory.get(i).profit());
		}

		for(int i = 0; i<profitList.length; i++)
		{
			if(profitList[i] < 0)
			{
				moneyLoser++;
			}
			else if(profitList[i] >= 0 && profitList[i] < 40)
			{
				zeroToForty++;
			}
			else if(profitList[i] >= 40 && profitList[i] < 100)
			{
				fortyToHundred++;
			}
			else if(profitList[i] >= 100 && profitList[i] < 150)
			{
				hundredTo150++;
			}
			else if(profitList[i] >= 150)
			{
				above150++;
			}
		}
		returner += "Profit Statistics:\n******************************\nNegative profit: " + moneyLoser + "\n$0 to $40: " + zeroToForty + "\n$40 to $100: " + fortyToHundred +"\n$100 to $150: " + hundredTo150 + "\n$150 and over: " + above150;
		return returner;
	}
}