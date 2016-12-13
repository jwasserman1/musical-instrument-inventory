/*********************************************
//NAME: Jonathan Wasserman
//DATE: 11/15/2013
//SPECIFICATION: Class DrumEquipment maintains four variables of an element of a retailer's inventory
//FOR: CSE 110 Honors Project
//*******************************************/

public class DrumEquipment
{
	//Four traits of each DrumEquipment
	private String manufacturer;
	private String category;
	private double wholesale;
	private double retail;

	//Constructor assigns each instance variable to an input
	public DrumEquipment(String manufacturerInput, String categoryInput, double wholesaleInput, double retailInput)
	{
		manufacturer = manufacturerInput;
		category = categoryInput;
		wholesale = wholesaleInput;
		retail = retailInput;
	}

	//Standard toString method
	public String toString()
	{
		String result = "Manufacturer: " + manufacturer + "Category: " + category + "Wholesale price: " + wholesale + "Retail price: " + retail;
		return result;
	}

	//Calculates profit based on retail and wholesale prices
	public double profit()
	{
		double result = retail - wholesale;
		return result;
	}

	//Accessor methods for all instance variables 
	public String manufacturerShow()
	{
		return manufacturer;
	}

	public String categoryShow()
	{
		return category;
	}

	public double wholesaleShow()
	{
		return wholesale;
	}

	public double retailShow()
	{
		return retail;
	}

}

