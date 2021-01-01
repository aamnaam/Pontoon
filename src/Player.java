import java.util.ArrayList;
import java.util.Collections;

public class Player
{
    private String name;
    private ArrayList<Card> hand;

    public Player(String name)
    {
        this.name = name;
        this.hand = new ArrayList<>();
    }

    public String getName() { return name; }

    public void dealToPlayer(Card card) { hand.add(card); }

    public void removeCard(Card card) { hand.remove(card); }

    public ArrayList<Integer> getNumericalHandValue()
    {
        ArrayList<Integer> handVal = new ArrayList<>();
        handVal.add(0);
        for(Card cards : hand)
        {
            for(int i = 0; i < handVal.size(); i++)
            {
                handVal.set(i, handVal.get(i) + cards.getNumericalValue().get(0));
            }
            if(cards.getValue().equals(Card.Value.ACE))
            {
                int size = handVal.size();
                for(int i = 0; i < size; i++)
                {
                    handVal.add(handVal.get(i) + 10);
                }
            }
        }
        Collections.sort(handVal);
        int size = handVal.size();

        for (int i = 0; i < size-1; i++)
        {
            if (handVal.get(i) == handVal.get(i+1))
            {
                handVal.remove(i+1);
                size--;
                i--;
            }
        }
        return handVal;
    }

    public int getBestNumericalHandValue()
    {
        ArrayList<Integer> handVal = getNumericalHandValue();
        int bestVal=0;
        for (int x : handVal)
        {
            if (x > bestVal)
                bestVal = x;
            if(x >= 21)
                break;
        }
        return bestVal;
    }

    public ArrayList<Card> getCards() { return hand; }

    public int getHandSize() { return hand.size(); }
}