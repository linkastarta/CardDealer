import java.util.Scanner;
public class Dealer {
    public static void main(String[]args){
        Deck deck = new Deck();
        deck.DeckMaker();
        Scanner scn = new Scanner(System.in);
        System.out.print(">");


        while (scn.hasNextLine()){
            String action = scn.nextLine();

            if(action == null || action.equals("")){
                System.out.print(">");
                continue;
            }

            else if(action.equalsIgnoreCase("RESTORE")){
                System.out.print("Enter how many cards: ");
                String str = scn.nextLine();
                if (str.equalsIgnoreCase("")){
                    deck.Restore(52);
                }
                else {
                    Scanner nscn = new Scanner(str);
                    deck.Restore(nscn.nextInt());
                }
            }


            else if(action.equalsIgnoreCase("SHUFFLE")){
                deck.Shuffle();
            }

            else if(action.equalsIgnoreCase("DRAW")){
                System.out.print("Enter how many cards: ");
                String str = scn.nextLine();
                if (str.equalsIgnoreCase("")){
                    deck.drawCards(52);
                }
                else {
                    Scanner nscn = new Scanner(str);
                    deck.drawCards(nscn.nextInt());
                }
            }

            else if (action.equalsIgnoreCase("SHOW")){
                System.out.println(deck);
            }


            System.out.print("\n>");
        }



    }
}
