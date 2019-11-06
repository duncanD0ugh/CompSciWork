/*
 * Class:		Movie
 * Description:	The class represents a single movie type item that can be hired
 * Author:		[Duncan Do] - [s3718718] 
 */

public class Movie extends Item
{
	private boolean isNewRelease;

	private final double NEW_RELEASE_SURCHARGE = 5;
	private final double WEEKLY_SURCHARGE = 3;
	private final double LATE_FEE_RATE = 0.5;
	private final int NEW_RELEASE_HIRE_DAYS = 2; 
	private final int WEEKLY_HIRE_DAYS = 7; 

	Movie(String id, String title, String genre, String description, boolean isNewRelease) throws IdException
	{
		super("M_" + id, title, genre, description);
		this.isNewRelease = isNewRelease;
	}

	public boolean getIsNewRelease()
	{
		return isNewRelease;
	}

	public double borrow(String memberId, DateTime borrowDate) throws BorrowException
	, IdException
	{
		double fee;

		if(isNewRelease == true)
		{
			fee = NEW_RELEASE_SURCHARGE;
		}

		else
		{
			fee = WEEKLY_SURCHARGE;
		}

		super.borrow(memberId, borrowDate, fee);

		return fee;
	}

	public double returnItem(DateTime returnDate)
	{
		DateTime borrowDate = getCurrentlyBorrowed().getBorrowDate();
		int dateDifference = DateTime.diffDays(returnDate, borrowDate);

		if (dateDifference > 0)
		{	
			double lateFee;
			double fee;
			if(isNewRelease == true)
			{
				lateFee = (((dateDifference)) - NEW_RELEASE_HIRE_DAYS) * LATE_FEE_RATE * NEW_RELEASE_SURCHARGE;
				fee = NEW_RELEASE_SURCHARGE;
			}

			else			
			{
				lateFee = (((dateDifference)) - WEEKLY_HIRE_DAYS) * LATE_FEE_RATE * WEEKLY_SURCHARGE;
				fee = WEEKLY_SURCHARGE;
			}

			if(lateFee < 0)
			{
				lateFee = 0;
			}

			getCurrentlyBorrowed().returnItem(returnDate, lateFee);
			super.setCurrentlyBorrowed();
			return fee + lateFee;
		}

		else 
		{
			return Double.NaN;
		}
	}

	public String getDetails()
	{
		String standardFee = "";
		String movieType = "";
		String rentalPeriod = "";

		if(isNewRelease == true)
		{
			standardFee = "$5";
			movieType = "New Release";
			rentalPeriod = "2 days";
		}

		else
		{
			standardFee = "$3";	
			movieType = "Weekly";
			rentalPeriod = "7 days";
		}

		String getDetailsString = super.getDetails();
		/*Adding the movie specific elements to the details 
		*String on top of all the common elements from the Item class*/
		String moviesDetails = String.format("%-30s %s \n", "Standard Fee:", standardFee);
		moviesDetails += String.format("%-30s %s \n", "Movie Type:", movieType);
		moviesDetails += String.format("%-30s %s \n", "Rental Period:", rentalPeriod);		
		moviesDetails += "\n";
		int index = getDetailsString.indexOf("BORROWING RECORD");

		moviesDetails = getDetailsString.substring(0, index - 31) + moviesDetails + getDetailsString.substring(index - 31, getDetailsString.length() - 1);
		return moviesDetails;
	}

	public String toString()
	{
		String typeOfHire = "";
		String loanStatus = "";
		double price = 0;
		if(isNewRelease == true)
		{
			typeOfHire = "NR";
			price = NEW_RELEASE_SURCHARGE;
		}

		else
		{
			typeOfHire = "WK";
			price = WEEKLY_SURCHARGE;
		}

		if(getCurrentlyBorrowed() != null)
		{
			loanStatus = "Y";
		}

		else
		{
			loanStatus = "N";
		}
		
		if(super.getCurrentlyBorrowed() == null)
		{
			return this.getId() + ":" + super.getTitle() + ":" + super.getGenre() + ":" + super.getDescription() + ":" + price + ":" + typeOfHire + ":" + loanStatus;
		}
		
		else
		{
			return this.getId() + ":" + super.getTitle() + ":" + super.getGenre() + ":" + super.getDescription() + ":" + getCurrentlyBorrowed().getRentalFee() + ":" + typeOfHire + ":" + loanStatus;
		}
	}
}