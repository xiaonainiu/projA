import java.util.Scanner;

/**
 * Created by Shen YI(844373) on 2017/3/26.
 */
public class Nimsys {
    static Scanner keyboard;
    public static void main(String[] args) {

        keyboard = new Scanner(System.in);

        System.out.println("Welcome to Nim");
        System.out.println();
        //Use Class NimPlayer
       // NimPlayer Player = new NimPlayer();
        System.out.println("Please enter Player 1's name:");
        //Use variable Player1 in Class NimPlayer to record Player 1's name
        NimPlayer player1 = new NimPlayer(keyboard.next());

        System.out.println();
        System.out.println("Please enter Player 2's name:");
        //Use variable Player2 in Class NimPlayer to record Player 1's name
        NimPlayer player2 = new NimPlayer(keyboard.next());
        //Initialize, if variable Restart == "Y", the game will be play again. Otherwise, if Restart != "Y", game over.

        String Restart = "Y";
        while (Restart.equals("Y")) {
            System.out.println();
            System.out.println("Please enter upper bound of stone removal:");
            //Use variable UpperBound to record the upper bound of stone removal
            int upperbound = keyboard.nextInt();
            System.out.println();
            System.out.println("Please enter initial number of stones:");
            //Use variable StoneNum to record the number of stones
            int stonenum = keyboard.nextInt();

            Nimstone nimstone=new Nimstone(upperbound,stonenum);

            //To display the number of stones and use "*" to represent stones
            nimstone.printNimstoneinfo();
            //Initialize the variable Turn, which use to count which player is going to remove stones, and which player wins.
            //Once a player finished the movement, Turn changes.
            int turn = 0;
            //Use variable Active to record the player who is making his/her movement
            NimPlayer activeplayer=null;
            while (!nimstone.empty()) {

                if (turn % 2 == 0) {
                    while(!pickStone(player1,nimstone));
                    activeplayer=player2;
                } else {
                    while(!pickStone(player2,nimstone));
                    activeplayer=player1;
                }
                turn++;
            }

            System.out.println();
            System.out.println("Game Over");
            System.out.println(activeplayer.getname() + " wins!");
            System.out.println();
            System.out.print("Do you want to play again (Y/N):");
            Restart = keyboard.next();
        }
    }
    public static boolean pickStone(NimPlayer player,Nimstone nimstone){
        System.out.println(player.getname()  + "'s turn - remove how many?");
        //Use variable RemoveNum to record the number of stones will be remove
        int removenum = keyboard.nextInt();
        //To decide whether the RemoveNum entered by player is acceptable, if not, print "WRONG INPUT"
        if (removenum > nimstone.getUpperbound() || removenum < 1 || removenum > nimstone.reststone()) {
            System.out.println("WRONG INPUT");
            return false;
        } else {
            //Use method removeStone from Class NimPlayer to make the removal, return the number of stones which left
            player.removeStone(nimstone,removenum);
            return true;
        }

    }
}
