import java.util.ArrayList;
import java.util.Scanner;

public class PontoonMain
{
    public static void main(String[] args)
    {
        int points1 = 0, points2 = 0;
        ArrayList<String> names = new ArrayList<>(2);
        Scanner sc = new Scanner(System.in);

        Interactive.printWelcomeMessage();

        System.out.println("Enter name of Player 1: ");
        names.add(sc.nextLine());

        System.out.println("Enter name of Player 2: ");
        names.add(sc.nextLine());

        Pontoon game = new Pontoon(2, names);

        System.out.println("\nDealing cards... ");
        Interactive.printCardSumRule();

        game.dealInitialCards();
        Deck deck = new Deck();

        while (true)
        {
            boolean[] bust = {false, false};
            Interactive.printStartMessage();

            System.out.print(names.get(0));
            Interactive.printCheckMessage();

            while (true) {
                System.out.println("\nYour cards are: ");
                System.out.println(game.getPlayer(0).getCards().toString());
                int handVal1 = game.getPlayer(0).getBestNumericalHandValue();

                if (handVal1 < 16)
                {
                    System.out.println(names.get(0) + " must twist, dealing another card");
                    game.Players.get(0).dealToPlayer(deck.dealRandomCard());
                }
                else if (handVal1 >= 16 && handVal1 <= 21)
                {
                    System.out.println(names.get(0) + ", do you want to stick(S) or twist(T) ?");
                    String choice = sc.next();

                    if (choice.equalsIgnoreCase("S"))
                    {
                        System.out.println("\n" + names.get(0) + " chose to stick... continuing");
                        break;
                    }
                    else if (choice.equalsIgnoreCase("T"))
                    {
                        System.out.println("\n" + names.get(0) + " chose to twist... dealing another card");
                        game.Players.get(0).dealToPlayer(deck.dealRandomCard());
                        break;
                    }
                    break;
                }
                else {
                    System.out.println("Bust!");
                    bust[0] = true;
                    break;
                }

            }

            System.out.print(names.get(1));
            Interactive.printCheckMessage();

            while (true) {
                System.out.println("\nYour cards are: ");
                System.out.println(game.getPlayer(1).getCards().toString());
                int handVal2 = game.getPlayer(1).getBestNumericalHandValue();

                if (handVal2 < 16)
                {
                    System.out.println(names.get(1) + " must twist, dealing another card");
                    game.Players.get(1).dealToPlayer(deck.dealRandomCard());
                }
                else if (handVal2 >= 16 && handVal2 <= 21)
                {
                    System.out.println(names.get(1) + ", do you want to stick(S) or twist(T) ?");
                    String choice = sc.next();

                    if (choice.equalsIgnoreCase("S"))
                    {
                        System.out.println("\n" + names.get(1) + " chose to stick... continuing");
                        break;
                    }
                    else if (choice.equalsIgnoreCase("T"))
                    {
                        System.out.println("\n" + names.get(1) + " chose to twist... dealing another card");
                        game.Players.get(1).dealToPlayer(deck.dealRandomCard());
                        break;
                    }

                    break;
                }
                else {
                    System.out.println("Bust!");
                    bust[1] = true;
                    break;
                }
            }

            if (bust[0] || game.compareHands(game.getPlayer(0), game.getPlayer(1)) == 1) {
                System.out.println(names.get(1) + "wins this round");
                points2 ++;
            }

            else if (bust[1] || game.compareHands(game.getPlayer(0), game.getPlayer(1)) == -1) {
                System.out.println(names.get(0) + "wins this round");
                points1 ++;
            }
            else
                System.out.println("Nobody won this round");

            System.out.println(names.get(0) + "  " + points1 + " : " + points2 + "  " + names.get(1));
            System.out.println("\nPress Q to quit, or anything else to play another round.");
            String input = sc.next();

            if (input.equalsIgnoreCase("Q")) {
                Interactive.printEndMessage();
                break;
            }

            else if (input.equalsIgnoreCase("bruh"))
                Interactive.bruh();

            else
                Interactive.printNextRoundMessage();
        }
    }
}