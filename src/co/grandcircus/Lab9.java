package co.grandcircus;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

//(.gitignore added)
//List 8 goods for sale, include names and prices
//Ask user to enter an item name
//If that item exists, display the item and price, then add the price to your cart
//If that item does not exist, validation. Reprompt.
//Ask if they want to add another. Repeat if they do. 
//When user prompts to exit shopping, display all items purchased and their prices in columns
//Display the average price of items

//BUILD SPECIFICATIONS
//Use a map to keep track of the goods, with String key for names and Double for prices
//Use parallel arrays of String and Double to keep track of items purchased and their prices
//Write methods to find: 1. The average price of ordered items. 2. The most expensive goods. 3. The least expensive.

//EXTENDED CHALLENGE:
//Display most expensive and least expensive item (easy?)
public class Lab9 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		Map<String, Double> items = new HashMap<>();

		items.put("Chirpus Live on Tour",14.99);
		items.put("Voodoo Doll",29.99);
		items.put("Oysters",17.99);
		items.put("Abstract Art 3MWE",27.99);
		items.put("Hugs",0.01);
		items.put("Steak",10.99);
		items.put("Custom Print Toaster",47.99);
		items.put("Cheese of Cheese",999.99);
		items.put("How to Greenshift",9.99);
		String contin = "yes";
		String userInput;
		double userTotal = 0;
		double userAverage = 0;
		int i = 0;

		List<String> itemsPurchased = new ArrayList<String>(); // These are your parallel arrays
		List<Double> pricesOfPurchased = new ArrayList<Double>(); // These are your parallel arrays

		do {
			System.out.println(
					"Welcome to Phil's emporium of wonderous and mystical goods. If you see something you like, type its name to add to cart!\n" + "Inputs are case sensitive!\n");
			for (String key : items.keySet()) { // for (String(this is the key type) key: items(this is the variable
												// being
												// searched).keySet (method to search)
				System.out.println(key + ": $ " + items.get(key));

			}

			userInput = scan.nextLine();

			if (items.containsKey(userInput)) {
				System.out.println("You have selected: " + userInput + " which cost $" + items.get(userInput));
				itemsPurchased.add(userInput);
				pricesOfPurchased.add(items.get(userInput));

				System.out.println("Would you like to add another item? yes to continue, any other input to exit: ");

				contin = scan.next();
				scan.nextLine();

			} else if (!items.containsKey(userInput)) {
				System.out.println("You have entered an invalid item name.");
				// scan.nextLine();
			}
		} while (contin.equals("yes"));

		scan.close();// Good practice

		for (i = 0; i < pricesOfPurchased.size(); i++) {
			
			System.out.printf("%-30s %-30f\n", itemsPurchased.get(i), pricesOfPurchased.get(i));
			userTotal = userTotal + pricesOfPurchased.get(i);
		}

		System.out.println("\n" + "Your average price per item is: $" + listAverage(userTotal, pricesOfPurchased.size()));
		System.out.println("\n" + "Your total today is: $" + userTotal +". We don't charge tax. Please don't tell.");
		System.out.println("Your most expensive item cost: " + Collections.max(pricesOfPurchased));
		System.out.print("Your least expensive item cost: " + Collections.min(pricesOfPurchased));
	

		
	}

	public static double listAverage(Double userTotal, int numItems) { //Method to calculate average price of items
		return userTotal / numItems;
	}
	
		
		
	           
	        
	    
	}