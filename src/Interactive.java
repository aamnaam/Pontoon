public class Interactive
{
    private final static String[] randomStartMessages = {
            "\nLet the game begin!",
            "\nEpic showdown time!",
            "\nHave fun!",

    };
    private final static String[] randomCheckMessages = {
            "'s turn to check their cards",
            ", it's time to check your cards!",
            ", check your cards and choose wisely!",
            ", what will it be?"
    };

    private final static String cardSumRule = "If the value of the two cards sums to less than 16, you will receive " +
            "another card. This is called ‘twist’.\nIf it is between 16 and 21 (inclusive) you may" +
            "choose to ‘stick’.";

    private final static String welcomeMessage = "Welcome to the game of Pontoon! \nThe main attribute of " +
            "this game is that the players are trying to get a hand of cards with the value 21 or less, but as close to 21 " +
            "as possible if less than 21.\n\nThis game is played by two Players. Please enter your names one by one: \n";

    public static void printStartMessage() {
        System.out.println(randomStartMessages[(int)Math.random()*randomStartMessages.length]);
    }

    public static void printCheckMessage() {
        System.out.println(randomCheckMessages[(int) Math.random() * randomCheckMessages.length]);
    }

    public static void bruh() {
        System.out.println("\nHmmm... I see you're a man of culture\n\nContinuing to next round");
    }

    public static void printEndMessage() {
        System.out.println("\nQuitting game... Hope it was fun!");
    }

    public static void printNextRoundMessage() {
        System.out.println("\nStarting next round...");
    }

    public static void printCardSumRule() {
        System.out.println(cardSumRule);
    }

    public static void printWelcomeMessage() {
        System.out.println(welcomeMessage);
    }
}
