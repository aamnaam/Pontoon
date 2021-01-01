import java.util.ArrayList;
import java.util.Collections;
public class Deck
{
    protected ArrayList<Card> deck;

    public Deck()
    {
        deck = getNewDeck();
    }

    public void reset()
    {
        deck = getNewDeck();
    }

    public void shuffle()
    {
        Collections.shuffle(deck);
    }

    public Card getCard(int i)
    {
        return deck.get(i);
    }

    public Card dealRandomCard()
    {
        int index = (int) (Math.random()*deck.size());
        Card dealt = getCard(index);
        Card temp;

        temp = deck.get(deck.size()-1);
        deck.set(deck.size()-1, dealt);
        deck.set(index, temp);

        return deck.remove(deck.size()-1);
    }
    public ArrayList<Card> getNewDeck()
    {
        ArrayList<Card> newDeck = new ArrayList<>();
        for (Card.Suit suits : Card.Suit.values())
        {
            for (Card.Value values : Card.Value.values())
            {
                Card newCard = new Card(suits, values);
                newDeck.add(newCard);
            }
        }
        return newDeck;
    }

    public int size()
    {
        return deck.size();
    }
}