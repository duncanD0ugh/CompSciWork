
class RobotControl
{
	private Robot r;
	public static StringBuilder sb;

	// Examples of constants
//	private final int SOURCE_LOCATION = 10;
//	private final int TARGET_1 = 1;
//	private final int TARGET_2 = 2;
//	private final int FIRST_BAR_POSITION = 3;

	public RobotControl(Robot r)
	{
		this.r = r;
	}

	public void control(int barHeights[], int blockHeights[])
	{
		//sampleControlMechanism(barHeights, blockHeights);
		run(barHeights, blockHeights);
	}
	
	public void run(int barHeights[], int blockHeights[]) 
	{
		//DEFINE the initial position of the robot arm
		int h = 2;
		int w = 1;
		int d = 0;
		
		//DEFINE the fixed amount the arm has to extend to get to the source pillar
		final int EXTEND_AMOUNT = 10;
		
		//DEFINE the initial values of sourceHeight, highestBar and currentBar; to be redefined by the arrays later
		int sourceHeight = 0;
		int highestBar = 0;
		int currentBar = 0;
		
		//DEFINE the amount the arm needs to contract when returning a block of height "3" to its intended column
		int contractAmount = 7;
		
		//CREATE a place holder for contractArm to reduce by one after each block is dropped
		int temp = contractAmount;
		
		//DEFINE the amount the arm needs to contract when returning a block of height "1" to column 1 and 2
		int firstColumn = 9;
		int secondColumn = 8;
		
		//DEFINE the (initial) height of column 1 and 2
		int firstColumnHeight = 0;
		int secondColumnHeight = 0;
		
		//DEFINE which bar to start comparing for the "highest bar"
		int firstBar;
		firstBar = 0;
		
		
		//CALCULATE the sum height of the source column
		for (int i = 0; i < blockHeights.length; i++) 
		{
			sourceHeight += blockHeights[i];
		}
			
		//IDENTIFY the height of the block currently being used
		for (int i = (blockHeights.length - 1); i >= 0; i--) 
		{
			int currentBlockHeight = blockHeights[i];	
			
			//UP arm until it is high enough to clear the source column height
			while (h < sourceHeight + 1)	
			{
				r.up();
				h++;
			}
				
			//UP arm until it is high enough to clear the highest bar
			while (h < highestBar + 1)
			{
				r.up();
				h++;
			}	
			
			//RAISE arm until it, and any extensions down, are high enough to clear the source height
			while (h - d < sourceHeight + 1)
			{
				r.raise();
				d--;
			}
				
			//RAISE arm until it, and any extensions down, are high enough to clear the highest bar
			while (h - d < highestBar + 1)
			{
				r.raise();
				d--;
			}	
				
			//EXTEND arm to be on top of the source pillar
			while (w < EXTEND_AMOUNT)
			{
				r.extend();
				w++;
			}
			
			//LOWER arm to meet the top of the source column
			while (h - d > sourceHeight + 1)
			{
				r.lower();
					d++;
			}
				
			//PICK UP block
			r.pick();
			
			//IF block height is 3
			if (currentBlockHeight == 3)
			{
				//RESET the highest bar to zero to be redefined
				highestBar = 0;
				//FIND the highest bar from the set of bars that the arm needs to move over
				for (int j = firstBar; j < barHeights.length; j++)
				{
					//IF the current highest bar is less than any other bar that the arm needs to move over, define that new "highest bar" to highest bar
					if (highestBar < barHeights[j])
					highestBar = barHeights[j];
				}
				
				//WHILE the arm, any extensions down and the block combined, are not high enough to clear the highest bar, raise the arm
				while ((h - 1) - d - currentBlockHeight < highestBar)
				{
					r.raise();
					d--;
				}
						
				//CONTRACT the arm until it is over the correct column
				while(contractAmount > 0)
				{
					r.contract();
					contractAmount--;
					w--;
				}
				//REDUCE the amount the arm needs to contract by 1
				contractAmount = --temp;	
					
				//LOWER arm to place the block on
				while ((h - 1) - d - currentBlockHeight > barHeights[currentBar])
				{
					r.lower();
					d++;
				}
				//INCREASE the number of the bar that the arm needs to drop the block on by 1
				currentBar++;
				
				//DROP block
				r.drop();
				
				//REDUCE the height of the source column by the value of the block that was just taken off the source column
				sourceHeight = sourceHeight - currentBlockHeight;

				//ADJUST the bar height of the bar by adding the value of the block to it
				barHeights[firstBar] = barHeights[firstBar] + currentBlockHeight;
					
				//ADJUST the first bar which is taken into account when finding the highest bar
				firstBar++;
			}
				
			//ELSE IF block height is 2
			else if (currentBlockHeight == 2)
			{
				//FIND the highest bar from the set of bars that the arm needs to move over
				for (int e = 0; e < barHeights.length; e++)
				{
					//IF the current highest bar is less than any other bar that the arm needs to move over, define that new "highest bar" to highest bar
					if (highestBar < barHeights[e])
					highestBar = barHeights[e];
				}
				
				//WHILE the arm, any extensions down and the block combined are not high enough to clear the highest bar, raise the arm
				while ((h - 1) - d - currentBlockHeight < highestBar)
				{
					r.raise();
					d--;
				}		
					
				//CONTRACT to column 2
				while(secondColumn > 0)
				{
					r.contract();
					secondColumn--;
					w--;
				}
				
				//REDEFINE the amount the arm needs to contract to get to column 2
				secondColumn = 8;
				
				//LOWER arm to place the block
				while ((h - 1) - d - currentBlockHeight > secondColumnHeight)
				{
					r.lower();
					d++;
				}
										
				//DROP block
				r.drop();
				
				//REDUCE the sourceHt by the value of the block it just took off the source column
				sourceHeight = sourceHeight - currentBlockHeight;
				
				//INCREASE the height of the second column by the value of the block just placed
				secondColumnHeight = secondColumnHeight + 2;
			}
			
			//IF the block is not of height 3 or 2 (AKA, height is 1)
			else
			{
				//FIND the highest bar from the set of bars that the arm needs to move over
				for (int e = 0; e < barHeights.length; e++)
				{
					if (highestBar < barHeights[e])
					highestBar = barHeights[e];
				}	
	
				//WHILE the arm, any extensions down and the block combined are not high enough to clear the highest bar, raise the arm
				while ((h - 1) - d - currentBlockHeight < highestBar)
				{
					r.raise();
					d--;
				}
				
				//CONTRACT to column 1
				while(firstColumn > 0)
				{
					r.contract();
					firstColumn--;
					w--;
				}
				
				//REDEFINE the amount the arm needs to contract to get to column 1
				firstColumn = 9;
				
				//LOWER arm to place the block
				while ((h - 1) - d - currentBlockHeight > firstColumnHeight)
				{
					r.lower();
					d++;
				}
						
				//DROP block
				r.drop();
				
				//REDUCE the sourceHt by the value of the block it just took off the source column
				sourceHeight = sourceHeight - currentBlockHeight;
				
				//INCREASE the height of the first column by the value of the block just placed
				firstColumnHeight = firstColumnHeight + 1;					
			}
		}
	}
}

		
	