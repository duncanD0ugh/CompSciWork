import java.util.Scanner;
public class Test 
{
	static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) 
	{
		System.out.println("*** Movie Master System Menu ***");
		System.out.println(String.format("%-15s %s", "Add Item", "A"));
		System.out.println(String.format("%-15s %s", "Borrow Item", "B"));
		System.out.println(String.format("%-15s %s", "Return Item", "C"));
		System.out.println(String.format("%-15s %s", "Display details", "D"));
		System.out.println(String.format("%-15s %s", "Seed Data", "E"));
		System.out.println(String.format("%-15s %s", "Exit Program", "X"));
		System.out.println("Enter Selection:");
		test();
	}
	
	public static void test() 
	{
		String input;
		input = scanner.nextLine();
		input = input.toUpperCase();
		
		switch(input)
		{
			case ("A"):
				//System.out.println("input.addItem()");
				Scanner scannerA = new Scanner(System.in);
				System.out.println("Please enter movie ID:");
				input = scannerA.nextLine();
				
				if(input.length() != 3)
				{
					System.out.println("Please enter a valid movie ID.");
					System.out.println("Enter Selection:");
					input = scanner.nextLine();
				}
				
				else
				{
					
				}
					
				break;
				
			case ("B"):
				System.out.println("input.borrowItem()");
				break;
			case ("C"):
				System.out.println("input.returnItem()");
				break;
			case ("D"):
				System.out.println("input.displayDetails()");
				break;
			case ("E"):
				System.out.println("input.seedData()");
				break;
			case ("X"):
				System.out.println("input.exitProgram()");
				break;
			default:
				System.out.println("Please enter a valid input.");
				break;
		}
	}
}
