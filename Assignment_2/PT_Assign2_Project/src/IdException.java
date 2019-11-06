/*
 * Class:		IDException
 * Description:	The class represents the errors/exceptions that can occur with ID
 * Author:		[Duncan Do] - [s3718718] 
 */

public class IdException extends Exception
{
	public IdException(String inputID) 
	{
		/*Passing the String to the super 
		*class' constructor*/
		super(inputID);
		/*
		 * BEGIN
		 * 	CALL on the super class' constructor
		 * END
		 */
	}
}