package view;

import javax.swing.JTextArea;

public class DialogueBox extends JTextArea
{
	public DialogueBox()
	{
		//Do not allow users to edit the dialogue box
		setEditable(false);
	}
}