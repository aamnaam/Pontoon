import java.util.ArrayList;

public class Card
{
    public enum Suit {CLUBS, HEARTS, DIAMONDS, SPADES;}
    public enum Value {ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING}

    private Suit suit;
    private Value value;

    public Card(Suit suit, Value value)
    {
        this.suit = suit;
        this.value = value;
    }

    public Suit getSuit() {
        return this.suit;
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    public Value getValue() {
        return this.value;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    public ArrayList<Integer> getNumericalValue()
    {
        ArrayList<Integer> result = new ArrayList<>();

        if (value.equals(Value.ACE))
        {
            result.add(1);
            result.add(11);
        }
        else if (value.equals(Value.JACK) || value.equals(Value.QUEEN) || value.equals(Value.KING))
            result.add(10);
        else
            result.add(value.ordinal() + 1);

        return result;
    }

    public String toString() {
        return value + " of " + suit;
    }
}