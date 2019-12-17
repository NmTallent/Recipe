package a2;

import java.util.Scanner;

public class A2Jedi {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		// System.out.println("Please enter the number of ingredients");
		int numIngredients = scan.nextInt();
		int numVegetarian = 0;
		int maxPos = 0;
		int minPos = 0;
		int numRecipes;
		boolean[] is_Vegetarian = new boolean[numIngredients];
		double[] Price_Per_Ounce = new double[numIngredients];
		double[] Calories_Per_Ounce = new double[numIngredients];
		double[] Calories_Per_Dollar = new double[numIngredients];
		String[] Ingredient_Names = new String[numIngredients];
		double[] TotalIngredientAmounts = new double[numIngredients];

		for (int i = 0; i < numIngredients; i++) {
			// System.out.println("Please enter name of the ingredient.");
			Ingredient_Names[i] = scan.next();

			// System.out.println("Please enter the price per ounce");
			Price_Per_Ounce[i] = scan.nextDouble();

			// System.out.println("Is this item vegetarian?");
			is_Vegetarian[i] = scan.nextBoolean();
			if (is_Vegetarian[i] == true) {
				numVegetarian = numVegetarian + 1;
			}

			// System.out.println("How many calories per ounce?");
			Calories_Per_Ounce[i] = scan.nextInt();
			// scan.nextLine();

		}
		numRecipes = scan.nextInt();
		String[] Recipe_Names = new String[numRecipes];
		double[][] Ingredient_Amounts = new double[numRecipes][numIngredients];
		String[][] Ingredient_Menu_Names = new String[numRecipes][numIngredients];
		for (int i = 0; i < numRecipes; i++) {
			for (int j = 0; j < numIngredients; j++) {
				Ingredient_Amounts[i][j] = 0.0;
				Ingredient_Menu_Names[i][j] = "";
			}
		}
		for (int i = 0; i < numRecipes; i++) { 
			Recipe_Names[i] = scan.next();
			int numberIngredients = scan.nextInt();
			String[] Recipe_Ingredient_List = new String[numberIngredients];
			for (int o = 0; o < numberIngredients; o++) {
				Recipe_Ingredient_List[o] = "";
			}
			double[] Recipe_Ingredient_Amount = new double[numberIngredients];
			double totalCal = 0;
			double totalPrice = 0;
			boolean isVeg = true;
			boolean keepGoing = true;
			

			for (int j = 0; j < numberIngredients; j++) {
				Recipe_Ingredient_List[j] = scan.next();
				Recipe_Ingredient_Amount[j] = scan.nextDouble();
				for (int k = 0; k < numIngredients; k++) {
					if (Recipe_Ingredient_List[j].equals(Ingredient_Names[k])) {
						// Ingredient_Amounts[k][j] += Recipe_Ingredient_Amount[j];
						totalCal = totalCal + (Calories_Per_Ounce[k] * Recipe_Ingredient_Amount[j]);
						totalPrice = totalPrice + (Price_Per_Ounce[k] * Recipe_Ingredient_Amount[j]);
						if (!is_Vegetarian[k]) {
							isVeg = false;
						}
						Ingredient_Amounts[i][k] = Recipe_Ingredient_Amount[j];
						Ingredient_Menu_Names[i][k] = Recipe_Ingredient_List[j];
					}
				}
				/*
				 * for(int h = 0; h<numberIngredients; h++) { for(int g = 0;
				 * g<numberIngredients;g++) {
				 * if(Recipe_Ingredient_List[h].equals(Ingredient_Names[g])) {
				 * Ingredient_Amounts[g][h] = Recipe_Ingredient_Amount[h]; } } }
				 */
			}

			String totalPriceStr = String.format("%.2f", totalPrice);
			if (isVeg) {
				// System.out.println(Recipe_Names[i]+":");
				// System.out.println(" " + (int)(totalCal+.5) + " calories");
				// System.out.println(" $" + totalPriceStr);
				// System.out.println(" Vegetarian");
			} else {
				// System.out.println(Recipe_Names[i]+":");
				// System.out.println(" " + (int)(totalCal+.5) + " calories");
				// System.out.println(" $" + totalPriceStr);
				// System.out.println(" Non-Vegetarian");
			}
			//double[] TotalIngredientAmounts = new double[numIngredients];
		}
		boolean keepGoing = true;
		System.out.println("The order will require:");
			while (keepGoing) {
				String inputRecipe = scan.next();
				//System.out.println(inputRecipe + " test");
				if (inputRecipe.equals("EndOrder")) {
					keepGoing = false;
				} else {
					for (int p = 0; p < numRecipes; p++) {
						if (inputRecipe.equals(Recipe_Names[p])) {
							for (int k = 0; k < Ingredient_Amounts[p].length; k++) {
								for (int t = 0; t < numIngredients; t++) {
									if (Ingredient_Menu_Names[p][k].equals(Ingredient_Names[t])) {
										TotalIngredientAmounts[t] += Ingredient_Amounts[p][k];
									}
								}
							}
						}
					}
				}
			}
			
			String TotalIngredientAmountsStr[] = new String[numIngredients];
			for (int i = 0; i < numIngredients; i++) {
				TotalIngredientAmountsStr[i] = String.format("%.2f", TotalIngredientAmounts[i]);
			}
			for (int d = 0; d < numIngredients; d++) {
				System.out.println(TotalIngredientAmountsStr[d] + " ounces of " + Ingredient_Names[d]);
			}
		
	}
}
