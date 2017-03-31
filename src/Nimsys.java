import java.util.Scanner;

/**
 * Created by Shen YI(844373) on 2017/3/26.
 */
public class Nimsys {

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);

        System.out.println("Welcome to Nim");
        System.out.println();
        //Use Class NimPlayer
        NimPlayer Player = new NimPlayer();
        System.out.println("Please enter Player 1's name:");
        //Use variable Player1 in Class NimPlayer to record Player 1's name
        Player.Player1 = keyboard.next();
        System.out.println();
        System.out.println("Please enter Player 2's name:");
        //Use variable Player2 in Class NimPlayer to record Player 1's name
        Player.Player2 = keyboard.next();
        //Initialize, if variable Restart == "Y", the game will be play again. Otherwise, if Restart != "Y", game over.
        String Restart = "Y";

        while (Restart.equals("Y")) {
            System.out.println();
            System.out.println("Please enter upper bound of stone removal:");
            //Use variable UpperBound to record the upper bound of stone removal
            int UpperBound = keyboard.nextInt();
            System.out.println();
            System.out.println("Please enter initial number of stones:");
            //Use variable StoneNum to record the number of stones
            int StoneNum = keyboard.nextInt();
            System.out.println();
            //To display the number of stones and use "*" to represent stones
            System.out.print(StoneNum + " stones left:");

            for (int i = 0; i < StoneNum; i++) {
                System.out.print(" *");
            }
            System.out.println();
            //Initialize the variable Turn, which use to count which player is going to remove stones, and which player wins.
            //Once a player finished the movement, Turn changes.
            int Turn = 0;
            //Use variable Active to record the player who is making his/her movement
            String Active = Player.Player1;

            while (StoneNum > 0) {
                System.out.println(Active + "'s turn - remove how many?");
                //Use variable RemoveNum to record the number of stones will be remove
                int RemoveNum = keyboard.nextInt();
                //To decide whether the RemoveNum entered by player is acceptable, if not, print "WRONG INPUT"
                if (RemoveNum > UpperBound || RemoveNum < 1 || RemoveNum > StoneNum) {
                    System.out.println("WRONG INPUT");
                } else {
                    //Use method removeStone from Class NimPlayer to make the removal, return the number of stones which left
                    StoneNum = NimPlayer.removeStone(StoneNum, RemoveNum);
                    Turn++;
                    if (Turn % 2 == 0) {
                        Active = Player.Player1;
                    } else {
                        Active = Player.Player2;
                    }
                }
            }

            System.out.println();
            System.out.println("Game Over");
            System.out.println(Active + " wins!");
            System.out.println();
            System.out.print("Do you want to play again (Y/N):");
            Restart = keyboard.next();
        }
    }
}
