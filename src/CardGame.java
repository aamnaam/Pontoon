import java.util.ArrayList;

public abstract class CardGame
{
    protected ArrayList<Player> Players;
    protected Deck deck;

    public void setPlayers(ArrayList<Player> players) { Players = players; }

    public ArrayList<Player> getPlayers() { return Players; }

    public void setDeck(Deck deck) { this.deck = deck; }

    public CardGame(int numPlayers, ArrayList<String> names)
    {
        String name;
        Players = new ArrayList<>(numPlayers);

        for (int i = 0; i < numPlayers; i++)
        {
            name = names.get(i);
            Player newPlayer = new Player(name);
            Players.add(newPlayer);
        }
        deck = new Deck();
    }

    public abstract void dealInitialCards();

    public abstract int compareHands(Player hand1, Player hand2);

    public Deck getDeck() { return deck; }

    public Player getPlayer(int i) { return Players.get(i); }

    public int getNumPlayers() { return Players.size(); }
}