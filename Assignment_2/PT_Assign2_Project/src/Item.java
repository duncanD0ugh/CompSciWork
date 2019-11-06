/*
 * Class:		Item
 * Description:	The class represents a single item that can be hired
 * Author:		[Duncan Do] - [s3718718] 
 */

public abstract class Item 
{
	private String id;
	private String title;
	private String description;
	private String genre;
	private HiringRecord currentlyBorrowed;
	private HiringRecord[] hireHistory = new HiringRecord[10];

	public Item(String id, String title, String genre, String description) throws IdException
	{
		this.id = id;
		this.title = title;
		this.genre = genre;
		this.description = description;	

		String extractedID = id.split("_")[1];

		if(extractedID.length() != 3)
		{
			throw new IdException("Error - the input ID is 3 digits long. Try again");
		}	
	}

	public String getId()
	{
		return id;
	}

	public String getTitle()
	{
		return title;
	}

	public String getGenre()
	{
		return genre;
	}

	public String getDescription()
	{
		return description;
	}

	public HiringRecord getCurrentlyBorrowed()
	{
		return currentlyBorrowed;
	}

	public HiringRecord[] getHireHistory()
	{
		return hireHistory;
	}

	public void setCurrentlyBorrowed()
	{
		if(this.currentlyBorrowed != null)
		{
			this.currentlyBorrowed = null;
		}
	}

	public void setHireHistory(HiringRecord hiringRecord, int i) 
	{
		if(hireHistory != null)
		{
			this.hireHistory[i] = hiringRecord;
		}
	}

	
	public abstract double borrow(String memberId, DateTime borrowDate) throws BorrowException, IdException;

	public double borrow(String memberId, DateTime borrowDate, double fee) throws BorrowException, IdException
	{
		if (currentlyBorrowed == null)
		{
			currentlyBorrowed = new HiringRecord(id, memberId, borrowDate, fee);

			for (int i = 0; i < hireHistory.length; i++)
			{
				if(hireHistory[i] == null)
				{
					hireHistory[i] = getCurrentlyBorrowed();
					return fee;
				}	
			}

			for (int i = 0; i < hireHistory.length - 1; i++)
			{
				hireHistory[i] = hireHistory[i + 1];
			}

			hireHistory[hireHistory.length - 1] = currentlyBorrowed;
			return fee;		
		}

		else
		{
			throw new BorrowException("Error - the item cannot be borrowed");
		}
	}
		/*
		 * BEGIN
		 * 	IF the item is not currently being borrowed
		 * 		CREATE a new hiring record
		 * 		LOOP through the item's hire history array
		 * 			IF a empty slot is found
		 * 				STORE the newly created hiring record into that slot
		 * 				RETURN the fee of the item
		 *		IF this could not be done
		 *		LOOP through the item's hire history except the last slot
		 *			REPLACE each slot of the array with the hiring record in the next slot
		 *		STORE the newly created hiring record in the last slot
		 *		RETURN the fee of the item
		 *	ELSE
		 *		THROW a borrowing exception
		 * END
		 */
	public abstract double returnItem(DateTime returnDate);

	public String getDetails()
	{
		String onLoan = "";

		if(currentlyBorrowed == null)
		{
			onLoan = "NO";
		}

		else
		{
			onLoan = "YES";
		}
		/*Adding the common elements of all Item's details to a 
		*single String*/
		String getDetailsString = String.format("%-30s %s \n", "ID:", id);
		getDetailsString += String.format("%-30s %s \n", "Title:", title);
		getDetailsString += String.format("%-30s %s \n", "Genre:", genre);
		getDetailsString += String.format("%-30s %s \n", "Description:", description);
		getDetailsString += String.format("%-30s %s \n", "On loan:", onLoan);

		getDetailsString += String.format("%-30s %s \n", "", "BORROWING RECORD");
		getDetailsString += String.format("%-30s %s \n", "_______________________________________________________________________________________________________________", "");
		getDetailsString += "\n";

		if(hireHistory[0] != null)
		{
			for(int i = 0; i < hireHistory.length; i++)
			{
				if(hireHistory[i] == null)
				{
					break;
				}
				getDetailsString += hireHistory[i].getDetails();
				getDetailsString += "\n";			
			}
		}

		else
		{
			getDetailsString += String.format("%-30s %s \n", "", "NONE");
		}

		getDetailsString += String.format("%-30s %s \n", "_______________________________________________________________________________________________________________", "");

		return getDetailsString;
	}

	public abstract String toString();
}