import java.util.ArrayList;

public class Pontoon extends CardGame
{
    public Pontoon(int numPlayers, ArrayList<String> names)
    {
        super(numPlayers, names);
    }

    @Override
    public void dealInitialCards()
    {
        for (Player person : Players)
        {
            person.dealToPlayer(deck.dealRandomCard());
            person.dealToPlayer(deck.dealRandomCard());
        }
    }

    @Override
    public int compareHands(Player hand1, Player hand2)
    {
        int points1 = 0;
        int points2 = 0;

        if (isPontoon(hand1))
            points1 += 100;
        if (isFCT(hand1))
            points1 += 50;
        if (isPontoon(hand2))
            points2 += 100;
        if (isFCT(hand2))
            points2 += 50;

        if (points1 > points2 || hand1.getBestNumericalHandValue() > hand2.getBestNumericalHandValue())
            return -1;
        else if (points1 < points2 || hand1.getBestNumericalHandValue() < hand2.getBestNumericalHandValue())
            return 1;

        return 0;
    }

    private boolean isPontoon(Player hand)
    {
        for (int i = 0; i < 1; i++)
        {
            if (hand.getHandSize() == 2 && hand.getCards().get(i).getValue().equals(Card.Value.ACE))
            {
                if (hand.getCards().get((i+1)%2).getNumericalValue().get(0) == 10)
                {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isFCT(Player hand)
    {
        if (hand.getHandSize() == 5 && hand.getBestNumericalHandValue() <= 21)
        {
            return true;
        }
        return false;
    }
}