/*
 * Class:		ItemReader
 * Description:	The class is responsible for the functions necessary to read data from text files to load them back into the arrays
 * Author:		[Duncan Do] - [s3718718] 
 */

import java.awt.event.ItemListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ItemReader
{	
	public Item CreateItem(String string)
	{
		String[] readItems = string.split(":");
		
		String[] itemKey = string.split("_");
		Item item = null;

		if(itemKey[0].equals("M"))
		{
			boolean isNewRelease = false;

			if(readItems[5].equals("NR"))
			{
				isNewRelease = true;
			}
			
			else if(readItems[5].equals("WK"))
			{
				isNewRelease = false;
			}
			
			try 
			{
				item = new Movie(itemKey[1].substring(0, 3), readItems[1], readItems[2], readItems[3], isNewRelease);
			} 
			
			catch (IdException e) 
			{
				System.out.println("Error - ItemReader, Movie object");
			}
		}
		
		else if(itemKey[0].equals("G"))
		{
			String[] platforms = readItems[4].split(",");
			
			try 
			{
				item = new Game(itemKey[1].substring(0, 3), readItems[1], readItems[2], readItems[3], platforms);
			} 
			
			catch (IdException e) 
			{
				System.out.println("error - ItemReader, Game object");
			}
		}
		return item;
	}

	public HiringRecord CreateHiringRecord(String line) 
	{
		String[] readHiringRecord = line.split(":");
		
		String[] HiringRecordKey = line.split("_");
		HiringRecord hiringRecord = null;
		
		if(readHiringRecord[3].equals("none"))
		{
			readHiringRecord[3] = "0.0";
		}
		
		double rentalFee = Double.parseDouble(readHiringRecord[3]);
		int borrowDay = Integer.parseInt(readHiringRecord[1].substring(0, 2));
		int borrowMonth = Integer.parseInt(readHiringRecord[1].substring(2, 4));
		int borrowYear = Integer.parseInt(readHiringRecord[1].substring(4, 8));
		
		try 
		{
			hiringRecord = new HiringRecord(readHiringRecord[0], HiringRecordKey[2], new DateTime(borrowDay, borrowMonth, borrowYear), rentalFee);
		} 
		
		catch (IdException e) {
			System.out.println(e.getMessage());
		}
		return hiringRecord;
	}
	
	public Item[] ReadItem(String path)
	{
		Item[] itemList = new Item[100];
		
		File file = new File(path);
		int i = 0;
		try(BufferedReader reader = new BufferedReader(new FileReader(file)))
		{
			String line = reader.readLine();
			while(line != null)
			{
				itemList[i] = CreateItem(line);
				line = reader.readLine();
				i++;
			}
		
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return itemList;
	}
	
	public HiringRecord[] ReadHiringRecord(String path)
	{
		HiringRecord[] hireHistory = new HiringRecord[100];
		
		File file = new File(path);
		int i = 0;
		try(BufferedReader reader = new BufferedReader(new FileReader(file)))
		{
			String line = reader.readLine();
			while(line != null)
			{	
				hireHistory[i] = CreateHiringRecord(line);
				line = reader.readLine();
				i++;
			}
		
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return hireHistory;
	}
	
	public Item[] LoadItems() 
	{
		/* creating temporary holding zones for the Items and 
		 * Hiring Records to be loaded back into the actual arrays 
		 * of the program + creating the integers to use as counters*/
		Item[] tempItems = ReadItem("items.txt");
		HiringRecord[] tempHiringRecords = ReadHiringRecord("hireHistory.txt");
		int i = 0;
		int a = 0;
		int e = 0;
		
		for(; a < tempItems.length; a++)
		{
			if(tempItems[a] == null)
			{
				continue;
			}
			for(;i < tempHiringRecords.length; i++)
			{
				if(tempHiringRecords[i] == null)
				{
					continue;
				}
				
				String extractedHiringRecordID = tempHiringRecords[i].getId().split("_")[1];
				String extractedItemRecordID = tempItems[a].getId().split("_")[1];
				
				if(extractedItemRecordID.equals(extractedHiringRecordID))
				{
					tempItems[a].setHireHistory(tempHiringRecords[i], e);
					e++;
				}
			}
		}
		return tempItems;
	}
}
