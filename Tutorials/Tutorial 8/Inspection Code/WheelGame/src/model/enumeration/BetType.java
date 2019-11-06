package model.enumeration;

import model.interfaces.Player;
import model.interfaces.Slot;

public enum BetType {
	RED {
		@Override
		public void applyWinLoss(Player player, Slot winSlot) {
			if (winSlot.getColor() == Color.RED) {
				player.setPoints(player.getPoints()+(player.getBet() * 2));
			}
			player.setPoints(player.getPoints()+(player.getBet() - (player.getBet() * 2)));
		}
	},
	BLACK {
		@Override
		public void applyWinLoss(Player player, Slot winSlot) {
			if (winSlot.getColor() == Color.BLACK) {
				player.setPoints(player.getPoints()+(player.getBet() * 2));
			}
			player.setPoints(player.getPoints()+(player.getBet() - (player.getBet() * 2)));
		}
	},
	ZEROS {
		@Override
		public void applyWinLoss(Player player, Slot winSlot) {
			if ((winSlot.getColor() == Color.GREEN0) || (winSlot.getColor() == Color.GREEN00)) {
				player.setPoints(player.getPoints()+(player.getBet() * 17));
			}
			player.setPoints(player.getPoints()+(player.getBet() - (player.getBet() * 2)));
		}
	};

	public abstract void applyWinLoss(Player player, Slot winSlot);
}