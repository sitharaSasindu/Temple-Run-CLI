package CourseWork;

import java.util.Scanner;

public class TempleRun {

	public static Scanner input = new Scanner(System.in); // to use scanner in
															// every class

	// I create arrays here to use them in every classes and methods
	public static int[] arrayOfcompNo = new int[20], arrayOfAge = new int[20], arrayOfCoin = new int[20],
			arrayOfScore = new int[20], arrayOfDistance = new int[20];
	public static String[] arrayOfName = new String[20];

	public static void main(String[] args) {

		boolean repeat = true; // this will repeat the menu
		while (repeat) {

			TempleRun.viewMenu(); // here I use a method to show the menu and name of the game

			int menuChoice = input.nextInt();
			switch (menuChoice) {
			case 1:
				TempleRun.inputs(); // get inputs by calling a method
				break;

			case 2:
				TempleRun.Case2(); // case 2 is about the winners of the game
				break;

			case 3:
				TempleRun.AllPlayerDetails(); // to view details of all players
				break;

			case 4:
				TempleRun.Case4(); // to view details of a selected player
				break;

			case 5:
				return; // to exit the program

			}
		}
	}

	// Display the menu and the name of the game
	public static void viewMenu() {

		System.out.println("\t\t\t\t\t******************\n" + "\t\t\t\t\t****Temple Run****\n"
				+ "\t\t\t\t\t******************\n\n"); // Display the name of
														// the game

		System.out
				.print("    -----------------------------------------------------------------------------------------\n"
						+ "	 			 ______________________________________\n"
						+ "		 		|                 Menu                 |"
						+ "\n			        |______________________________________|\n"

						+ "				|1.| Input Competitor Details          |\n"
						+ " 				----------------------------------------\n"
						+ "				|2.| View the 3 Winners                |\n"
						+ " 				----------------------------------------\n"
						+ "				|3.| View All competitors Details      |\n"
						+ " 				----------------------------------------\n"
						+ "				|4.| View details of a competitor      |\n"
						+ " 				----------------------------------------\n"
						+ "				|5.| Exit                              |\n"
						+ " 				________________________________________\n"

						+ "\n\n >> Refer the menu and Enter a number  : ");
	}

	/*
	 * here I get inputs for the program and validate those inputs through
	 * validation method
	 */
	public static void inputs() {

		System.out.println("\nPlease Input Your Details  \n");

		for (int i = 0; i < 20; i++) {
			
			System.out.println(" Player  " + (i+1));

			System.out.print(" 1. Enter Player No          : ");
			arrayOfcompNo[i] = integerValidation();

			System.out.print(" 2. Name                     : ");
			arrayOfName[i] = input.next();

			System.out.print(" 3. Age			     : ");
			arrayOfAge[i] = integerValidation();

			System.out.print(" 4. Number of Coins Collected: ");
			arrayOfCoin[i] = integerValidation();

			System.out.print(" 5. Score		     : ");
			arrayOfScore[i] = integerValidation();

			System.out.print(" 6. Distance(m)		     : ");
			arrayOfDistance[i] = integerValidation();

			System.out.println("");// this blank print line is for the clear
									// view
		}

	}

	// validate inputs
	public static int integerValidation() {

		Scanner inputCheck = new Scanner(System.in);

		int number;
		do {

			while (!inputCheck.hasNextInt()) {
				String input = inputCheck.next();
				System.out.printf("  \'%s\' is not a valid number.Enter again:\n", input);
			}

			number = inputCheck.nextInt();
			if (number < 0)
				System.out.println("   Please enter a positive Value : ");
		} while (number < 0);

		return number;
	}

	// selection procedure of the max scored player
	public static int MaxScoreIndex(int[] arrayOfScore) {
		int maxScore = arrayOfScore[0];
		int indexOfScore = 0;
		for (int i = 0; i < arrayOfScore.length; i++) {
			if (arrayOfScore[i] > maxScore) {
				maxScore = arrayOfScore[i];
				indexOfScore = i;
			}
		}
		return indexOfScore;
	}

	// selection procedure of player who ran maximum distance
	public static int MaxDistanceIndex(int[] arrayOfDistance) {
		int maxDist = arrayOfDistance[0];
		int indexOfDist = 0;
		for (int i = 0; i < arrayOfDistance.length; i++) {
			if (arrayOfDistance[i] > maxDist) {
				maxDist = arrayOfDistance[i];
				indexOfDist = i;
			}
		}
		return indexOfDist;
	}

	// selection procedure of maximum coins collector
	public static int MaxCoinIndex(int[] arrayOfCoin) {
		int maxCoin = arrayOfCoin[0];
		int indexOfCoin = 0;
		for (int i = 0; i < arrayOfCoin.length; i++) {
			if (arrayOfCoin[i] > maxCoin) {
				maxCoin = arrayOfCoin[i];
				indexOfCoin = i;
			}
		}
		return indexOfCoin;
	}

	public static void Case2() {

		// here I import these details to use as follows
		int maxScore = MaxScoreIndex(arrayOfScore);
		int maxDist = MaxDistanceIndex(arrayOfDistance);
		int maxCoin = MaxCoinIndex(arrayOfCoin);
		
		System.out.println("\n\t\t The Winners who won the 3 Titles \n");
		
		//show the winners
		System.out.println("	 Max Scored Player : " + arrayOfName[maxScore]);
		System.out.println("			Score : " + arrayOfScore[maxScore] + "\n");

		System.out.println(" 	 Player who ran maximum distance : " + arrayOfName[maxDist]);
		System.out.println("			Max Distance : " + arrayOfDistance[maxDist] + "\n");

		System.out.println("	 Maximum coins collector : " + arrayOfName[maxCoin]);
		System.out.println("			Coins collected : " + arrayOfCoin[maxCoin] + "\n");
		
		boolean repeat2 = true;
		while (repeat2) { // this is a sub menu within case2

			System.out.println("\nPlease select an option: \n");
			System.out.println(" 1. View details of the 3 winners\n" + " 2. Details of a winner\n" + " 3. Exit");

			int menuChoice2 = input.nextInt();

			switch (menuChoice2) {
			case 1: // show the details of the 3 winners
				System.out.println("Highest Scored Competitor :- " + "\n" + "\t Name            : "
						+ arrayOfcompNo[maxScore] + "." + arrayOfName[maxScore] + "\n" + "\t Age             : "
						+ arrayOfAge[maxScore] + "\n" + "\t Coins Collected : " + arrayOfCoin[maxScore] + "\n"
						+ " \t Score           : " + arrayOfScore[maxScore] + "\n" + " \t Distance        : "
						+ arrayOfDistance[maxScore] + "\n");

				
				System.out.println("\nThe competitor who ran the maximum distance ; " + "\n"
						+ "\t Name            : " + arrayOfcompNo[maxDist] + "." + arrayOfName[maxDist] + "\n"
						+ "\t Age             : " + arrayOfAge[maxDist] + "\n" + "\t Coins Collected : "
						+ arrayOfCoin[maxDist] + "\n" + " \t Score           : " + arrayOfScore[maxDist] + "\n"
						+ " \t Distance        : " + arrayOfDistance[maxDist] + "\n");
				
				System.out.println("\nMaximum Gold Collector : " + "\n" + "\t Name            : "
						+ arrayOfcompNo[maxCoin] + "." + arrayOfName[maxCoin] + "\n" + "\t Age             : "
						+ arrayOfAge[maxCoin] + "\n" + "\t Coins Collected : " + arrayOfCoin[maxCoin] + "\n"
						+ " \t Score           : " + arrayOfScore[maxCoin] + "\n" + " \t Distance        : "
						+ arrayOfDistance[maxCoin] + "\n");

				break;

			case 2:// here you can individually view the details of the 3
					// winners

				System.out.println("\n >> Plese select which player you want to view : \n");
				System.out.println("		a. Max Scored Player" + "\n" + "		b. The player who ran maximum Distance"
						+ "\n" + "		c. Maximum Coins collected Player");

				char menu2 = 0;
				menu2 = input.next().charAt(0);

				switch (menu2) {
				case 'a':
				case 'A':// Highest Scored Competitor

					System.out.println("Highest Scored Competitor :- " + "\n" + "\t Name            : "
							+ arrayOfcompNo[maxScore] + "." + arrayOfName[maxScore] + "\n" + "\t Age             : "
							+ arrayOfAge[maxScore] + "\n" + "\t Coins Collected : " + arrayOfCoin[maxScore] + "\n"
							+ " \t Score           : " + arrayOfScore[maxScore] + "\n" + " \t Distance        : "
							+ arrayOfDistance[maxScore] + "\n");
					break;

				case 'b':
				case 'B': // The competitor who ran the maximum distance

					System.out.println("\nThe competitor who ran the maximum distance ; " + "\n"
							+ "\t Name            : " + arrayOfcompNo[maxDist] + "." + arrayOfName[maxDist] + "\n"
							+ "\t Age             : " + arrayOfAge[maxDist] + "\n" + "\t Coins Collected : "
							+ arrayOfCoin[maxDist] + "\n" + " \t Score           : " + arrayOfScore[maxDist] + "\n"
							+ " \t Distance        : " + arrayOfDistance[maxDist] + "\n");
					break;

				case 'c':
				case 'C': // Maximum Coins Collector
					System.out.println("\nMaximum Coins Collector : " + "\n" + "\t Name            : "
							+ arrayOfcompNo[maxCoin] + "." + arrayOfName[maxCoin] + "\n" + "\t Age             : "
							+ arrayOfAge[maxCoin] + "\n" + "\t Coins Collected : " + arrayOfCoin[maxCoin] + "\n"
							+ " \t Score           : " + arrayOfScore[maxCoin] + "\n" + " \t Distance        : "
							+ arrayOfDistance[maxCoin] + "\n");
				}

			case 3: // to exit this sub menu
				return;

			}
		}
	}

	public static void AllPlayerDetails() { // to show details of all
											// competitors
		for (int j = 0; j < 20; j++) {

			System.out.println("\n\t Competitor No.  : " +  arrayOfcompNo[j] + "\n\t Name            : "
							+  arrayOfName[j] + "\n" + "\t Age             : "
							+ arrayOfAge[j] + "\n" + "\t Coins Collected : " + arrayOfCoin[j] + "\n"
							+ " \t Score           : " + arrayOfScore[j] + "\n" + " \t Distance        : "
							+ arrayOfDistance[j] + "\n");
		}
	}

	public static void Case4() { // to show details of any competitor
		System.out.println("\nPlease input the competetor number to view details : \n");
		int inputNo = input.nextInt();
		if (inputNo <= 20 && inputNo > 0) {
			int num = (inputNo - 1);

			System.out.println(" Name 			 : " + arrayOfName[num]);
			System.out.println(" Age 			 : " + arrayOfAge[num]);
			System.out.println(" Coins Collected 	 : " + arrayOfCoin[num]);
			System.out.println(" Score 			 : " + arrayOfScore[num]);
			System.out.println(" Distance 		 : " + arrayOfDistance[num]);
		} else {
			System.out.println("Please input a valid competitor number !! ");
		}
	}

}
