package model;

import model.interfaces.PlayingCard;

public class PlayingCardImpl implements PlayingCard
{
	private Suit suit;
	private Value value;
	private int score;
	
	public PlayingCardImpl(Suit suit, Value value)
	{
		this.value = value;
		this.suit = suit;
	}
	
	@Override
	public Suit getSuit() 
	{
		return suit;
	}

	@Override
	public Value getValue() 
	{
		return value;
	}

	@Override
	public int getScore() 
	{
		switch(value)
		{
			//assigning the correct score to the corresponding card, based on the value
			case ACE:
				this.score = 1;
				break;
			case TWO:
				this.score = 2;
				break;
			case THREE:
				this.score = 3;
				break;
			case FOUR:
				this.score = 4;
				break;
			case FIVE:
				this.score = 5;
				break;
			case SIX:
				this.score = 6;
				break;
			case SEVEN:
				this.score = 7;
				break;
			case EIGHT:
				this.score = 8;
				break;
			case NINE:
				this.score = 9;
				break;
			case TEN: case JACK: case QUEEN: case KING:
				this.score = 10;
				break;
		}
		return score;
	}

	@Override
	public boolean equals(PlayingCard card) 
	{
		//check if the suit AND value of the card match
		if((card.getSuit().equals(this.suit)) && (card.getValue().equals(this.value)))
		{
			return true;
		}
		
		else
		{
			return false;
		}
	}

	@Override
	public boolean equals(Object obj) 
	{
		if (this == obj)
		{
			return true;
		}
		
		if (obj == null)
		{
			return false;
		}
		
		//if the object is a playing card, it can be compared with the playing card equals method
		if(obj instanceof PlayingCard)
		{
			return equals((PlayingCard) obj);
		}	
		return false;
	}

	@Override
	public int hashCode() 
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + score;
		result = prime * result + ((suit == null) ? 0 : suit.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}
	
	@Override
	public String toString()
	{
		return String.format("Suit: %s, Value: %s, Score: %s", getSuit(), getValue(), getScore());
	}
}