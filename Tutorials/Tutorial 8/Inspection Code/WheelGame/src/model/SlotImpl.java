package model;

import java.util.Objects;

import model.enumeration.Color;
import model.interfaces.Slot;

public class SlotImpl implements Slot {
	private int position;
	private int number;
	private Color color;
	
	public SlotImpl(int position, Color color, int number) {
		this.position = position;
		this.number = number;
		this.color = color;
	}

	@Override
	public int getPosition() {
		return this.position;
	}

	@Override
	public int getNumber() {
		return this.number;
	}

	@Override
	public Color getColor() {
		return this.color;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		return sb.append("Position: ").append(position)
				.append(", Color: ").append(color)
				.append(", Number: ").append(number)
				.toString();
	}

	@Override
	public boolean equals(Slot slot) {
		if (slot instanceof Slot && this.number == slot.getNumber() && this.color == slot.getColor()) {
			return true;
		}
		return false;
	}

	@Override
	public int hashCode() {
		return Objects.hash(color, position, number);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof Slot)) {
			return false;
		}
		Slot slot = (Slot) obj;
		return equals(slot);
	}
}
