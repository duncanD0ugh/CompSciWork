/*
 * Class:		HiringRecord
 * Description:	The class represents a single hiring record for any type of item that can be hired
 * Author:		[Duncan Do] - [s3718718] 
 */

public class HiringRecord 
{
	private String id;
	private double rentalFee;
	private double lateFee;
	private DateTime borrowDate;
	private DateTime returnDate;

	HiringRecord(String id, String memberId, DateTime borrowDate, double rentalFee) throws IdException //CONSTRUCTOR for a hiring record for each movie
	{
		this.id = id + "_" + memberId + "_" + borrowDate.getEightDigitDate();
		this.borrowDate = borrowDate;
		this.rentalFee = rentalFee;

		if(memberId.length() != 3)
		{
			throw new IdException("Error - the member ID is invalid. Try again");
		}	
	}
	
	public String getId()
	{
		return id;
	}
	
	public double getRentalFee()
	{	
		return rentalFee;
	}

	public DateTime getBorrowDate()
	{
		return this.borrowDate;
	}

	public DateTime getReturnDate()
	{
		return returnDate;
	}

	public void returnItem(DateTime returnDate, double lateFee) //METHOD to update variables after an item is returned
	{	
		this.returnDate = returnDate;
		this.lateFee = lateFee;
	}

	public String getDetails() //METHOD to return the details of a hiring record
	{
		String getDetailsString = "";
		/*Creating the string for all the details 
		*associated with hiring records*/
		if (returnDate == null)
		{
			getDetailsString = String.format("%-30s %-30s %s \n", "", "Hire ID:", id);
			getDetailsString += String.format("%-30s %-30s %s \n", "", "Borrow Date:", borrowDate);
		}

		else
		{
			getDetailsString = String.format("%-30s %-30s %s \n", "", "Hire ID:", id);
			getDetailsString += String.format("%-30s %-30s %s \n", "", "Borrow Date:", borrowDate);
			getDetailsString += String.format("%-30s %-30s %s \n", "", "Return Date:", returnDate);
			getDetailsString += String.format("%-30s %-30s %s \n", "", "Fee:", "$" + rentalFee);
			getDetailsString += String.format("%-30s %-30s %s \n", "", "Late Fee:", "$" + lateFee);
			getDetailsString += String.format("%-30s %-30s %s \n", "", "Total Fees: ", "$" + (rentalFee + lateFee));
		}

		return getDetailsString;
		/*
		 * BEGIN
		 * 	DECLARE/INITIALISE a String to store the details in
		 * 	IF the Item has not been returned yet
		 * 		ADD the Hire ID to the string
		 * 		ADD the borrow date to the string
		 * 	ELSE
		 * 		ADD the Hire ID to the string
		 * 		ADD the borrow date to the string
		 * 		ADD the return date to the string
		 * 		ADD the fee to the string
		 * 		ADD the late fee to the string
		 * 		ADD the total fee to the string (fee + late fee)
		 * 	RETRUN the completed string
		 * END
		 */
	}

	public String toString() //METHOD to return the object in the method in the form of a string
	{
		if (returnDate == null)
		{
			return id + ":" + borrowDate.getEightDigitDate() + ":none:none:none";
		}

		else
		{
			return id + ":" + borrowDate.getEightDigitDate() + ":" + returnDate.getEightDigitDate() + ":" + rentalFee + ":" + lateFee; 
		}
	}
}
