package view;

import javax.swing.JMenu;

public class Menu extends JMenu
{
	public Menu(String menuName)
	{
		//Set the visible name of the menu
		super(String.format(menuName));
	}
}