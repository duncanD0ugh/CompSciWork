/*
 * Class:		Game
 * Description:	The class represents a single game type item that can be hired
 * Author:		[Duncan Do] - [s3718718] 
 */

public class Game extends Item
{
	private String platforms[];
	private boolean extended = false;
	private final double RENTAL_DAYS = 30;
	private double GAME_PRICE = 20;
	private final double SUR_CHARGE = 5;
	private final double EXTENDED_DISCOUNT_RATE = 0.5;

	private final int DAYS_IN_A_WEEK = 7; 

	Game(String id, String title, String genre, String description, String[] inputPlatforms) throws IdException 
	{
		super("G_" + id, title, genre, description);
		this.platforms = inputPlatforms;

	}

	public void setExtended(boolean extend) 
	{
		if(extend)
		{
			extended = true;
		}
		
		else
		{
			extend = false;
		}
	}

	public double borrow(String memberId, DateTime borrowDate) throws BorrowException, IdException
	{	
		double fee = GAME_PRICE;

		super.borrow(memberId, borrowDate, fee);

		return fee;
		/*
		 * BEGIN
		 * 	DECLARE/INITIALISE the fee to the price of a game
		 * 	CALL upon the super class' borrow method, passing it a member ID, borrow date and fee
		 * 	RETURN the fee
		 * END
		 */
	}

	public double returnItem(DateTime returnDate)
	{
		DateTime borrowDate = super.getCurrentlyBorrowed().getBorrowDate();
		int dateDifference = DateTime.diffDays(returnDate, borrowDate);

		if (dateDifference > 0)
		{	
			double lateFee = (dateDifference - RENTAL_DAYS) * GAME_PRICE;

			if(dateDifference + RENTAL_DAYS > DAYS_IN_A_WEEK)
			{
				int weeksLate = dateDifference / 7 - dateDifference % 7;

				lateFee += weeksLate * SUR_CHARGE;
			}

			if(extended = true)
			{
				lateFee = lateFee * EXTENDED_DISCOUNT_RATE;
			}

			if(lateFee < 0)
			{
				lateFee = 0;
			}

			super.getCurrentlyBorrowed().returnItem(returnDate, lateFee);
			super.setCurrentlyBorrowed();
			return GAME_PRICE + lateFee;
		}

		else
		{
			return Double.NaN;
		}
	}

	public String getDetails() 
	{
		String onLoan;

		if(this.extended = true)
		{
			onLoan = "EXTENDED";
		}

		else
		{
			onLoan = "NOT EXTEMDED";
		}

		String getDetailsString = super.getDetails();

		String gamesDetails = String.format("%-30s %s \n", "Rental Fee:", "$" + GAME_PRICE);

		String allPlatforms = "";

		for(int i = 0; i < platforms.length; i++)
		{
			if(platforms[i] != null)
			{
				allPlatforms += platforms[i] + ", ";
			}				
		}

		allPlatforms = allPlatforms.substring(0, allPlatforms.lastIndexOf(","));
		/*Adding the game specific elements to the details 
		*String on top of all the common elements from the Item class*/
		gamesDetails += String.format("%-30s %s \n", "Platforms:", allPlatforms);
		gamesDetails += String.format("%-30s %s \n", "Rental Period:", onLoan);
		gamesDetails += "\n";

		int index = getDetailsString.indexOf("BORROWING RECORD");

		getDetailsString = getDetailsString.substring(0, index - 31) + gamesDetails + getDetailsString.substring(index - 31, getDetailsString.length() - 1);

		return getDetailsString;
	}

	public String toString()
	{
		String loanStatus;

		if((getCurrentlyBorrowed() != null) && (extended = false))
		{
			loanStatus = "Y";
		}

		else if((getCurrentlyBorrowed() != null) && (extended = true))
		{
			loanStatus = "E";
		}
		else
		{
			loanStatus = "N";
		}

		String allPlatforms = "";

		for(int i = 0; i < platforms.length; i++)
		{
			if(platforms[i] != null)
			{
				allPlatforms += platforms[i] + ",";
			}				
		}

		allPlatforms = allPlatforms.substring(0, allPlatforms.lastIndexOf(","));
		
		return this.getId() + ":" + super.getTitle() + ":" + super.getGenre() + ":" + super.getDescription() + ":" + allPlatforms + ":" + GAME_PRICE + ":" + loanStatus;	
	}
}