package view;

import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

import model.interfaces.Player;

class ComboBoxRenderer extends JLabel implements ListCellRenderer<Player>
{
	@Override
	public Component getListCellRendererComponent(JList<? extends Player> list, Player player, int index, 
			boolean isSelected, boolean cellHasFocus) //Set the visable thing in the comboBox to the player's name rather than the whole player
	{
		this.setText(player.getPlayerName());
		return this;
	}
}