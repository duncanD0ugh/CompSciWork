package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExitActionListener implements ActionListener 
{
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		//Exit the program
		System.exit(0);
	}
}