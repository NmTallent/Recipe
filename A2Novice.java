package a2;

import java.util.Scanner;

public class A2Novice {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		//System.out.println("Please enter the number of ingredients");
		int numIngredients = scan.nextInt();
		int numVegetarian = 0;
		int maxPos = 0;
		int minPos = 0;
		boolean [] is_Vegetarian = new boolean [numIngredients];
		double [] Price_Per_Ounce = new double[numIngredients];
		double [] Calories_Per_Ounce = new double [numIngredients];
		double [] Calories_Per_Dollar = new double [numIngredients];
		String [] Ingredient_Names = new String [numIngredients];
		
		for (int i = 0; i<numIngredients; i++)
		{
			//System.out.println("Please enter name of the ingredient.");
			Ingredient_Names[i] = scan.next();
			
			//System.out.println("Please enter the price per ounce");
			Price_Per_Ounce[i] = scan.nextDouble();
			
			//System.out.println("Is this item vegetarian?");
			is_Vegetarian[i] = scan.nextBoolean();
			if(is_Vegetarian[i] == true)
			{
				numVegetarian = numVegetarian + 1;
			}
			
			//System.out.println("How many calories per ounce?");
			Calories_Per_Ounce[i] = scan.nextInt();
			//scan.nextLine();
					
			
		}
		
		for(int i = 0; i<numIngredients; i++)
		{
			Calories_Per_Dollar[i] = Calories_Per_Ounce[i]/Price_Per_Ounce[i];
		}
		
		for(int i = 0; i<numIngredients; i++)
		{
			if(Calories_Per_Dollar[maxPos]<Calories_Per_Dollar[i])
			{
				maxPos = i;
			}
		}
		
		for(int i = 0; i<numIngredients; i++)
		{
			if(Calories_Per_Dollar[minPos]>Calories_Per_Dollar[i])
			{
				minPos = i;
			}
		}
		
		System.out.println("Number of vegetarian ingredients: " + numVegetarian );
		System.out.println("Highest cals/$: " + Ingredient_Names[maxPos] );
		System.out.println("Lowest cals/$: " + Ingredient_Names[minPos] );
	}
	
	// You can define helper methods here if needed.
	
}
