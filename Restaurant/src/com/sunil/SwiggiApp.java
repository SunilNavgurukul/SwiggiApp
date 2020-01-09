package com.sunil;

import java.util.Scanner;


// This is Swiggi in this application we will store the Restaurant's detail in our 
// Array (Restaurant[]) First we will store all the details and then we can find Restaurant
// by Id and we can get profitable Restaurant.
// This is commond line game.

//I used array, overloading, oops, Condition and loop, Custom datatype and Array, modal class, getter and setter

public class SwiggiApp {
	
//	In this method we setting the data in array.
//	restaurants array is storing restaurants details and items 
//	and item array is storing restaurants.
	
	
	public Restaurant[] restaurantDetails(int n) {
		Scanner sc = new Scanner(System.in);
		Restaurant[] restaurants = new Restaurant[n];
		Restaurant restaurant = new Restaurant();
		Item item = new Item();
		for (int i = 0; i < n; i++) {
			System.out.println("Enter " + (i + 1) + " Restaurant details: ");
			
			System.out.println("Enter id: ");
			restaurant.setId(sc.nextInt());
			System.out.println("Enter no of items: ");
			int ni = sc.nextInt();
			Item[] items = new Item[ni];
//			for storing food item
			for (int j = 0; j < items.length; j++) {
				System.out.println("Enter " + (j + 1) + " Item details: ");
				
				System.out.println("Enter id of item: ");
				item.setId(sc.nextInt());
				System.out.println("Enter name of item: ");
				item.setName(sc.next());
				System.out.println("Enter price of item: ");
				item.setPrice(sc.nextDouble());
				System.out.println("Enter type of item: ");
				item.setType(sc.next());
				
				items[j]=item;
			}
//			System.out.println(items[0].getPrice());
			restaurant.setItems(items);
			

			System.out.println("Enter Name of Restaurant: ");
			sc.nextLine();
			restaurant.setName(sc.nextLine());
			System.out.println("Enter Revenue of Restaurant: ");
			restaurant.setRevenue(sc.nextDouble());
			System.out.println("Enter Expense Of Restaurant: ");
			restaurant.setExpense(sc.nextDouble());
			restaurants[i]= restaurant;
		}

		return restaurants;
	}

	
//	It is use for print data in good format from restaurants[]
	public void printRestaurantDetails(Restaurant restaurants[]) {

		for (Restaurant res : restaurants) {
//			System.out.println(res);
			System.out.println("************Restaurant Details***********");
			System.out.println("id" + "\t" + "name" + "\t" + "expense" + "\t" + "revenue");
			System.out.println(res.getId() + "\t" + res.getName() + "\t" + res.getExpense() + "\t" + res.getRevenue());
			System.out.println("------------------------------");
			System.out.println("Item Details");
			System.out.println("id" + "\t" + "name" + "\t" + "type" + "\t" + "price");

			for (Item item : res.getItems()) {
				System.out.println(item.getId() + "\t" + item.getName() + "\t" + item.getType() + "\t" + item.getPrice());
			}
		}

	}
	
//	It is use for print data in good format from res
	public void printRestaurantDetails(Restaurant res) {

		System.out.println("************Restaurant Details***********");
		System.out.println("id" + "\t" + "name" + "\t\t" + "expense" + "\t\t" + "revenue");
		System.out.println(res.getId() + "\t" + res.getName() + "\t\t" + res.getExpense() + "\t\t" + res.getRevenue());
		System.out.println("------------------------------");
		System.out.println("Item Details");
		System.out.println("id" + "\t" + "name" + "\t\t" + "type" + "\t\t" + "price");
		for (Item item : res.getItems()) {
			System.out.println(item.getId() + "\t" + item.getName() + "\t\t" + item.getType() + "\t\t" + item.getPrice());
		}

	
	}

//	it will give a array by id detailsBasedOnId
	public Restaurant detailsBasedOnId(Restaurant[] res, int Id) {

		Restaurant restaurant = new Restaurant();
		for (int i = 0; i < res.length; i++) {
			if (res[i].getId() == Id) {
				restaurant = res[i];
			}
		}
		return restaurant;
	}
	
//	it will give a array by Profitable Restaurant

	public Restaurant getProfitableRestaurant(Restaurant[] res) {

		Restaurant profitableRestaurant = new Restaurant();
		double profit = res[0].getRevenue() - res[0].getExpense();
		profitableRestaurant = res[0];
		for (int i = 0; i < res.length; i++) {
			if (profit < res[i].getRevenue() - res[i].getExpense()) {
				profitableRestaurant = res[i];
			}
			
		}
		return profitableRestaurant;
	}

//	it will give a array by costly item.
	public Restaurant costliestItem(Restaurant[] res) {

		Restaurant restaurant = new Restaurant();
		double highestcost = 0;
		for (int i = 0; i < res.length; i++) {
			for (int j = 0; j < res[i].getItems().length; j++) {
				{
					if (highestcost < res[i].getItems()[j].getPrice()) {
						highestcost = res[i].getItems()[j].getPrice();
						restaurant = res[i];
					}
				}
			}
		}
		return restaurant;
	}
	

//	this is main class our code will run start from here because of JVM because JVM
//	is the one that actually calls the main method present in a java code
	
	
	public static void main(String[] args) {
		
//		Scanner class for taking input from user.
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter no of restaurants: ");
		
//		n is a var in this variable i am storing data(how much restaurants's data you want to store. )
		
		int n = sc.nextInt();
		
//		I am making object of my class because Main is static method and it  access only static methods.
		
		
		SwiggiApp ka = new SwiggiApp();
		
//		In rest I am storing data from restaurantDetails() method.
//		this method is giving use data in Array.
//		Restaurant[] this is 
		Restaurant[] rest = ka.restaurantDetails(n);

		System.out.println("*************************************************");

		ka.printRestaurantDetails(rest);

		int a = 1;
		do {
			System.out.println(
					"Enter 1 to get details of Restaurant by ID:\nEnter 2 to get details of Most Profitable Restaurant:\nEnter 3 to get details of Restaurant which have costliest item: ");
			int choice = sc.nextInt();
//			user will give us input for get output.
//			if the user input will be 1 it will find data by Id.
//			if the user input will be 2 it will give us profitable Restaurant
//			if the user input will be 3 it will costliest Item
			

			switch (choice) {
			case 1:
				System.out.println("Enter Id of the Restaurant to be find: ");
				int Id = sc.nextInt();
//				detailsBasedOnId(rest, Id) method is giving us data by id.
				ka.printRestaurantDetails(ka.detailsBasedOnId(rest, Id));
				break;
			case 2:
//				getProfitableRestaurant method is giving us profitable restaurant
				ka.printRestaurantDetails(ka.getProfitableRestaurant(rest));
				break;
			case 3:
//				costliestItem method is giving us costliest Item 
				ka.printRestaurantDetails(ka.costliestItem(rest));
				break;
			default:
				break;
			}
			
//			this input help us restart loop 
			System.out.println("\n\nEnter 1 to continue, 0 to exit");
			a = sc.nextInt();
		} while (a == 1);
		sc.close();

	}
}
