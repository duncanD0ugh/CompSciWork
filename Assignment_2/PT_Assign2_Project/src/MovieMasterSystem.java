/*
 * Class:		MovieMasterSystem
 * Description:	The class represents the functions of the program when run
 * Author:		[Duncan Do] - [s3718718] 
 */

import java.util.*;

public class MovieMasterSystem 
{
	Scanner scanner = new Scanner(System.in);
	Item[] itemList = new Item[100];
	
	boolean endSwitch = true;
	
	public void menu()
	{
		ReadTextFiles();
		while(endSwitch)
		{			
			System.out.println();
			System.out.println("*** Movie Master System Menu ***");
			System.out.println(String.format("%-30s %s", "Add Item", "A"));
			System.out.println(String.format("%-30s %s", "Borrow Item", "B"));
			System.out.println(String.format("%-30s %s", "Return Item", "C"));
			System.out.println(String.format("%-30s %s", "Display Details", "D"));
			System.out.println(String.format("%-30s %s", "Seed Data", "E"));
			System.out.println(String.format("%-30s %s", "Exit Program", "X"));
			System.out.println("Enter Selection:");
		
			String input;
			input = scanner.nextLine();
			/*Assigning each function of the menu to a different switch case 
			*for the user to input*/
			switch(input.toUpperCase())
			{
				case ("A"):
				
					addItem();
					break;
					
				case ("B"):
					
					borrowItem();
					break;
					
				case ("C"):
					
					returnItem();
					break;
					
				case ("D"):
					
					displayDetails();
					break;
					
				case ("E"):
					
					if(itemList[0] == null)
					{
						seedData();
					}
				
					else
					{
						System.out.println("Error - The movie list already contains movie records.");
					}
					break;
					
				case ("X"):
					
					SaveTextFileItems();
					SaveTextFileHiriingRecords();
					System.out.println("Exited Program.");
					System.exit(0);
					break;
				
				default:
					
					System.out.println("Please enter a valid input.");
					input = scanner.nextLine();
					break;
			}	
		}
	}
	
	private void addItem()
	{
		String validID = null;
		
		while (validID == null)
		{
			validID = addValidID();
		}
	
		System.out.println("Enter Title:");
		String inputTitle = scanner.nextLine();
		
		System.out.println("Enter Genre:");
		String inputGenre = scanner.nextLine();
		
		System.out.println("Enter Description:");
		String inputDescription = scanner.nextLine();
		
		System.out.println("Movie or Game (M/G)?");
		String inputItemType = scanner.nextLine();
		inputItemType = inputItemType.toUpperCase();
		
		if(inputItemType.equals("M"))
		{
			System.out.println("Enter New Release, (Y/N):");
			String inputNewRelease;
			inputNewRelease = scanner.nextLine();
			inputNewRelease = inputNewRelease.toUpperCase();
			String inputNewReleaseString = "";
			boolean isNewRelease = true;
			
			if(inputNewRelease.equals("Y"))
			{
				isNewRelease = true;
			}
			
			else if(inputNewRelease.equals("N"))
			{
				isNewRelease = false;
			}
			
			else 
			{
				System.out.println("Error - please enter Y or N");
				inputNewRelease = scanner.nextLine();
			}
			
			Item movie1 = null;
			
			try 
			{
				movie1 = new Movie(validID, inputTitle, inputGenre, inputDescription, isNewRelease);
			} 
			
			catch (IdException e) 
			{
				System.out.println(e.getMessage());
				menu();
			}
			
			for (int i = 0; i < itemList.length; i++)
			{
				if(itemList[i] == null)
				{
					itemList[i] = movie1;
					break;
				}	
			}
			
			System.out.println(String.format("%-100s %s", "", ""));
			System.out.println(String.format("%-30s %s", "ID:", validID));
			System.out.println(String.format("%-30s %s", "Title:", inputTitle));
			System.out.println(String.format("%-30s %s", "Genre:", inputGenre));
			System.out.println(String.format("%-30s %s", "Description:", inputDescription));
			System.out.println(String.format("%-30s %s", "New Release:", inputNewReleaseString));
			
		}
		
		else if(inputItemType.equals("G"))
		{
			System.out.println("Enter Game Platforms (seperated by commas):");
			String inputPlatforms = scanner.nextLine();
			
			String[] platforms = inputPlatforms.split(",");
			
			for(int i = 0; i < platforms.length; i++)
			{
				platforms[i] = platforms[i].trim();
			}
			
			String allPlatforms = "";
			
			for(int i = 0; i < platforms.length; i++)
			{
				if(platforms[i] != null)
				{
					allPlatforms += platforms[i] + ", ";
				}				
			}
			
			allPlatforms = allPlatforms.substring(0, allPlatforms.lastIndexOf(","));
			
			Item game1 = null;
			try 
			{
				game1 = new Game(validID, inputTitle, inputGenre, inputDescription, platforms);
			} 
			catch (IdException e) 
			{
				System.out.println(e.getMessage());
				menu();
			}
									
			for (int i = 0; i < itemList.length; i++)
			{
				if(itemList[i] == null)
				{
					itemList[i] = game1;
					break;
				}	
			}
			
			System.out.println(String.format("%-100s %s", "", ""));
			System.out.println(String.format("%-30s %s", "ID:", validID));
			System.out.println(String.format("%-30s %s", "Title:", inputTitle));
			System.out.println(String.format("%-30s %s", "Genre:", inputGenre));
			System.out.println(String.format("%-30s %s", "Description:", inputDescription));
			System.out.println(String.format("%-30s %s", "Platforms:", allPlatforms));
		}
		
		else
		{
			System.out.println("Error - please enter M or G");
			inputItemType = scanner.nextLine();
		}	
		
		scanner.nextLine();
	}
	
	private void borrowItem()
	{
		Item correctItem = null;
		
		while(correctItem == null)
		{
			correctItem = borrowCorrectItem();
		}
		
		String extractedID = correctItem.getId().split("_")[1];
		
		System.out.println("Enter Member ID:");
		String inputMemberID = scanner.nextLine();
		
		while(inputMemberID.length() != 3)
		{
			System.out.println("Error - The Member ID '" + inputMemberID + "' is invalid. Please enter a 3 charatcer long Member ID." );
			inputMemberID = scanner.nextLine();
		}
		
		System.out.println("Enter Advance Borrow Days:");
		int inputABD = scanner.nextInt();
		scanner.nextLine();
		
		DateTime advanceBorrowDays = new DateTime(inputABD);
		DateTime dueDate = null;
		String extend = "";		

		if(correctItem instanceof Movie)
		{
			if(((Movie) correctItem).getIsNewRelease() == true)
			{
				dueDate = new DateTime(inputABD + 2);
			}
			
			else
			{
				dueDate = new DateTime(inputABD + 7);
			}
			
			System.out.println(String.format("%-100s %s", "", ""));
			System.out.println(String.format("%-30s %s", "ID:", extractedID.toUpperCase()));
			System.out.println(String.format("%-30s %s", "Member ID:", inputMemberID.toUpperCase()));
			System.out.println(String.format("%-30s %s", "Advnace Borrow (Days):", inputABD));	
			
			try 
			{
				System.out.println("The item " + correctItem.getTitle() + " costs $" + correctItem.borrow(inputMemberID, advanceBorrowDays) + " and is due on: " + dueDate);
			} 
			
			catch (BorrowException e) 
			{
				System.out.println(e.getMessage());
				menu();
			} 
			
			catch (IdException e) 
			{
				System.out.println(e.getMessage());
				menu();
			}

		}
		
		else if(correctItem instanceof Game)
		{
			dueDate = new DateTime(inputABD + 30);
			
			System.out.println("Enter Extended (Y/N):");
			String extended = scanner.nextLine();
			extended = extended.toUpperCase();
			
			if(extended.equals("Y")) 
			{
				((Game) correctItem).setExtended(true);
				extend = "YES";
			}
			
			else if(extended.equals("N"))
			{
				((Game) correctItem).setExtended(false);
				extend = "NO";
			}
			
			else 
			{
				System.out.println("Error - Please enter Y or N");
				extended = scanner.nextLine();
			}
			
			System.out.println(String.format("%-100s %s", "", ""));
			System.out.println(String.format("%-30s %s", "ID:", extractedID.toUpperCase()));
			System.out.println(String.format("%-30s %s", "Member ID:", inputMemberID.toUpperCase()));
			System.out.println(String.format("%-30s %s", "Advnace Borrow (Days):", inputABD));
			System.out.println(String.format("%-30s %s", "Extended:", extend));
			try 
			{
				System.out.println("The item " + correctItem.getTitle() + " costs $" + correctItem.borrow(inputMemberID, advanceBorrowDays) + " and is due on: " + dueDate);
			} 
			
			catch (BorrowException e) 
			{
				System.out.println(e.getMessage());
				menu();
			} 
			
			catch (IdException e) 
			{
				System.out.println(e.getMessage());
				menu();
			}
		}
	}
	
	private void returnItem() 
	{
		Item correctItem = null;
		
		while (correctItem == null)
		{
			correctItem = returnCorrectItem();
		}
		
		String extractedID = correctItem.getId().split("_")[1];

		System.out.println("Enter Member ID:");
		String inputMemberID = scanner.nextLine();
		
		while(inputMemberID.length() != 3)
		{
			System.out.println("Error - The Member ID '" + inputMemberID + "' is invalid. Please enter a 3 charatcer long Member ID." );
			inputMemberID = scanner.nextLine();
		}
		
		System.out.println("Enter Advance Returned Date:");
		int inputARD = scanner.nextInt();
		
		DateTime returnDate = new DateTime(inputARD);
		double payableFee = 0;
		payableFee = correctItem.returnItem(returnDate);
		
		System.out.println(String.format("%-100s %s", "", ""));
		System.out.println(String.format("%-30s %s", "ID:", extractedID));
		System.out.println(String.format("%-30s %s", "Number of Days on Loan:", inputARD));
		System.out.println("The total fee payable is $" + payableFee);

		scanner.nextLine();
	}
	
	private void displayDetails()
	{
		for (int i = 0; i < itemList.length; i++)
		{
			if(itemList[i] == null)
			{
				break;
			}
			
			else
			{
				System.out.println(itemList[i].getDetails());
			}
		}
		
		/*
		 * BEGIN
		 * 	LOOP through the itemList array
		 * 		IF one of the array slots is empty
		 * 			STOP the loop
		 * 		ELSE
		 * 			PRINT the details of that Item to the console 
		 * END
		 */
	}
	
	private void seedData()
	{
		try
		{
			itemList[0] = new Movie("MOS", "Man of Steel", "Action", 
					"An alien crash lands on Earth and is raised as a human", false);
					
			itemList[1] = new Movie("TYS", "Toy Story", "Adventure", 
					"The secret life of a child's toys when they are not looking", false);	
			DateTime borrowDateOne = new DateTime();
			itemList[1].borrow("BUZ", borrowDateOne);
	
			itemList[2] = new Movie("LCY", "Like Crazy", "Romance", 
					"The story of the struggles of a long-distance relationship", false);
			DateTime borrowDateTwo = new DateTime();
			itemList[2].borrow("FLJ", borrowDateTwo);
			DateTime returnDateTwo = new DateTime(5);
			itemList[2].returnItem(returnDateTwo);
			
			itemList[3] = new Movie("BRD", "Buried", "Thriller", 
					"A man wakes up in a coffin with limited air, a lighter, a cell phone and only his wits to save his life", false);
			DateTime borrowDateThree = new DateTime();
			itemList[3].borrow("RRN", borrowDateThree);
			DateTime returnDateThree = new DateTime(10);
			itemList[3].returnItem(returnDateThree);
			
			itemList[4] = new Movie("IRM", "Iron Man", "Action", 
					"A man is determined to right the wrongs of his company's war profiteering", false);
			DateTime borrowDateFour = new DateTime();
			itemList[4].borrow("RDJ", borrowDateFour);
			DateTime returnDateFour = new DateTime(10);
			itemList[4].returnItem(returnDateFour);
			DateTime borrowDateFourOne = new DateTime(11);
			itemList[4].borrow("STR", borrowDateFourOne);
			
			itemList[5] = new Movie("AIW", "Avengers: Infinity War", "Action", 
					"The heroes of the Marvel cinematic universe team up to face Thanos", true);
			
			itemList[6] = new Movie("AQP", "A Quiet Place", "Horror", 
					"A family stays silent to hide from aliens who hunt based on noise", true);
			DateTime borrowDateSix = new DateTime();
			itemList[6].borrow("DUN", borrowDateSix);
			
			itemList[7] = new Movie("TEM", "The Emoji Movie", "Comedy apparently", 
					"The longest app commercial in existence", true);
			DateTime borrowDateSeven = new DateTime();
			itemList[7].borrow("ASS", borrowDateSeven);
			DateTime returnDateSeven = new DateTime(1);
			itemList[7].returnItem(returnDateSeven);
			
			itemList[8] = new Movie("TFA", "Star Wars: The Force Awakens", "Sci-Fi", 
					"A new generation of heroes rise to take down the First Order", true);		
			DateTime borrowDateEight = new DateTime(0);
			itemList[8].borrow("OBI", borrowDateEight);
			DateTime returnDateEight = new DateTime(3);
			itemList[8].returnItem(returnDateEight);
			
			itemList[9] = new Movie("ITS", "Interstellar", "Sci-Fi", 
					"Astronauts go find a suitable replacement for their dying Earth", true);
			DateTime borrowDateNine = new DateTime(0);
			itemList[9].borrow("WEZ", borrowDateNine);
			DateTime returnDateNine = new DateTime(3);
			itemList[9].returnItem(returnDateNine);
			DateTime borrowDateNineOne = new DateTime(0);
			itemList[9].borrow("DUC", borrowDateNineOne);	
			
			String[] game10 = new String[2];
			game10[0] = "Switch";
			game10[1] = "Wii U";
			itemList[10] = new Game("LOZ", "Legend of Zelda", "Open World", "A hero wakes up after 100 years to find his home ravaged by the evil Ganondorf", game10);
		
			String[] game11 = new String[1];
			game11[0] = "PC";
			itemList[11] = new Game("OVW", "Overwatch", "FPS", "The world could use more heroes", game11);
			DateTime borrowDateEleven = new DateTime(0);
			itemList[11].borrow("DVA", borrowDateEleven);
			
			String[] game12 = new String[2];
			game12[0] = "3DS";
			game12[1] = "2DS";
			itemList[12] = new Game("PKX", "Pokemon X", "Turn-Based Stratergy", "Catch them all!", game12);
			DateTime borrowDateTwelve = new DateTime(0);
			itemList[12].borrow("ASH", borrowDateTwelve);
			DateTime returnDateTwelve = new DateTime(19);
			itemList[12].returnItem(returnDateTwelve);
			
			String[] game13 = new String[2];
			game13[0] = "PS4";
			game13[1] = "XBOX One";
			itemList[13] = new Game("IGA", "Injustice Gods Amoung Us", "2D Fighting", "Superman goes mad in an alternate universe", game13);
			DateTime borrowDateThirteen = new DateTime(0);
			itemList[13].borrow("CLK", borrowDateThirteen);
			DateTime returnDateThirteen = new DateTime(32);
			itemList[13].returnItem(returnDateThirteen);
		}
		
		catch(IdException e)
		{
			System.out.println(e.getMessage());
			menu();
		} 
		
		catch (BorrowException e) 
		{
			System.out.println(e.getMessage());
			menu();
		}
	}
	
	
	private String addValidID()
	{
		System.out.println("Enter ID:");
		String inputID = scanner.nextLine();
		inputID = inputID.toUpperCase();
		
		while(inputID.length() != 3)
		{
			System.out.println("Error - The ID '" + inputID + "' is invalid. Please enter a 3 digit ID." );
			inputID = scanner.nextLine();
		}
		
		String validID = null;
		
		while(validID == null)
		{
			if(itemList[0] != null)
			{
				for (int i = 0; i < itemList.length; i++)
				{
					if(itemList[i] == null)
					{
						continue;
					}	
					
					String extractedID = itemList[i].getId().split("_")[1];
					
					if(extractedID.equals(inputID))
					{
						System.out.println("Error - The item with the ID: '" + inputID + "' is already in the system.");
						inputID = scanner.nextLine();
						break;
					}
					
					else
					{
						validID = inputID;
					}
				}
			}
			
			else
			{
				return inputID;
			}
		}
		
		return validID;
	}
	
	private Item borrowCorrectItem()
	{
		System.out.println("Enter ID:");
		String inputID = scanner.nextLine();
		inputID = inputID.toUpperCase();
		
		while(inputID.length() != 3)
		{
			System.out.println("Error - The ID '" + inputID + "' is invalid. Please enter a 3 digit ID." );
			inputID = scanner.nextLine();
		}
		
		Item correctItem = null;
		
		for (int i = 0; i < itemList.length; i++)
		{
			if(itemList[i] == null)
			{
				continue;
			}	
			
			String extractedID = itemList[i].getId().split("_")[1];
			
			if(extractedID.equals(inputID))
			{
				correctItem = itemList[i];
				break;
			}	
		}
		
		if(correctItem != null)
		{
			if(correctItem.getCurrentlyBorrowed() != null)
			{
				System.out.println("Error - The item with the ID: '" + inputID + "' is currently on loan.");
				correctItem = null;
			}
		}
		
		else
		{
			System.out.println("Error - The item with the ID: '" + inputID + "', not found." );
		}
		
		return correctItem;
	}

	private Item returnCorrectItem()
	{
		System.out.println("Enter ID:");
		String inputID = scanner.nextLine();
		inputID = inputID.toUpperCase();
		
		while(inputID.length() != 3)
		{
			System.out.println("Error - The ID '" + inputID + "' is invalid. Please enter a 3 digit ID." );
			inputID = scanner.nextLine();
		}
		
		Item correctItem = null;
		
		for (int i = 0; i < itemList.length; i++)
		{
			if(itemList[i] == null)
			{
				continue;
			}	
			
			String extractedID = itemList[i].getId().split("_")[1];
			
			if(extractedID.equals(inputID))
			{
				correctItem = itemList[i];
				break;
			}	
		}
		
		if(correctItem != null)
		{
			if(correctItem.getCurrentlyBorrowed() == null)
			{
				System.out.println("Error - The item with the ID: '" + inputID + "' is not currently on loan.");
				correctItem = null;
			}
		}
		
		else
		{
			System.out.println("Error - The item with the ID: '" + inputID + "', not found." );
		}
		
		return correctItem;
	}

	private void SaveTextFileItems()
	{
		ItemSaver saver = new ItemSaver();
		saver.saveItems(itemList);
	}
	
	private void SaveTextFileHiriingRecords() 
	{
		ItemSaver saver = new ItemSaver();
		saver.saveHireHistory(itemList);
	}
	
	private void ReadTextFiles()
	{
		ItemReader reader = new ItemReader();
		itemList = reader.LoadItems();
	}
}