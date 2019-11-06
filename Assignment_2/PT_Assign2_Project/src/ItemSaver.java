/*
 * Class:		ItemSaver
 * Description:	The class is responsible for the functions necessary to write data into text files
 * Author:		[Duncan Do] - [s3718718] 
 */

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class ItemSaver 
{
	public void saveItems(Item[] itemsToSave) 
	{
		String saveString = "";
		PrintWriter outputStream = null;

		for(int i = 0; i < itemsToSave.length; i++)
		{
			if (itemsToSave[i] == null)
			{
				continue;
			}
			
			String itemData = itemsToSave[i].toString();

			itemData += "\n";
			saveString += itemData;
			
			String fileName = "items.txt";
			
			try
			{
				outputStream = new PrintWriter(new FileOutputStream(fileName));
				outputStream.write(saveString);
			}
			
			catch (FileNotFoundException e)
			{
				System.out.println("Error - ItemSaver, writing text file");
			}
		}
		
		outputStream.close();
		/*
		 * BEGIN
		 * 	DECLARE/INITIALISE an empty String to save the item data to
		 * 	DECLARE/INITIALISE a print writer object to write the item data to a text file
		 * 	LOOP through the items array to write to a text file
		 * 		IF a slot in the array is empty, stop ("continue")
		 * 		SAVE the item's data in toString format to a String variable
		 * 		ADD an empty line to the item data
		 * 		ADD the item data to the empty string
		 * 		DECLARE/INITIALISE a String name for the text file
		 * 	TRY
		 * 		CREATE a print writer variable for the text file
		 * 		WRITE the String into the text file
		 * 	CATCH the error if a file was not found
		 * 		PRINT error message
		 * 	CLOSE
		 * END
		 */	
	}
	
	public void saveHireHistory(Item[] itemsToSave) 
	{
		String saveString = "";
		PrintWriter outputStream = null;
		
		for(int i = 0; i < itemsToSave.length; i++)
		{
			if (itemsToSave[i] == null)
			{
				continue;
			}
			/*Looping through all movie's hiring records to 
			*add them to the movie's hire history*/
			for(int a = 0; a < itemsToSave[i].getHireHistory().length; a++)
			{
				if (itemsToSave[i].getHireHistory()[a] == null)
				{
					continue;
				}
				
				String HiringRecordData = itemsToSave[i].getHireHistory()[a].toString();
				
				HiringRecordData += "\n";
				saveString += HiringRecordData;
				
				String fileName = "hireHistory.txt";
				
				try
				{
					outputStream = new PrintWriter(new FileOutputStream(fileName));
					outputStream.write(saveString);
				}
				
				catch (FileNotFoundException e)
				{
					System.out.println("Error - ItemSaver, writing text file");
				}
			}
		}
		outputStream.close();
	}
}