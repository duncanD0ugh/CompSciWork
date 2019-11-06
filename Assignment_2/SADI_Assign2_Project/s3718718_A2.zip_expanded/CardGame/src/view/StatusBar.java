package view;

import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

public class StatusBar extends JPanel
{
	private JLabel status1;
	private JLabel status2;
	private JLabel status3;

	public StatusBar()
	{
		Border border = BorderFactory.createRaisedBevelBorder();
		setLayout(new GridLayout(1, 3));

		//Creating components
		status1 = new JLabel("status 1", SwingConstants.LEFT);
		status2 = new JLabel("status 2", SwingConstants.CENTER);
		status3 = new JLabel("status 3", SwingConstants.RIGHT);
		
		//Set the component's(label's) borders
		status1.setBorder(border);
		status2.setBorder(border);
		status3.setBorder(border);

		//Add components(labels) to the status bar
		add(status1);
		add(status2);
		add(status3);
	}
	
	public void setStatusOne(String obj) //Set the status of the first status label
	{
		status1.setText(obj + " is playing");
	}
	
	public void setStatusTwo(String obj) //Set the status of the second status label
	{
		status2.setText(obj + " has Busted!");
	}
	
	public void setStatusThree() //Set the status of the third status label
	{
		status3.setText("GAME OVER");
	}
}