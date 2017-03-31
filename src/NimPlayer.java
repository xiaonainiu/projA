/**
 * Created by Shen YI(844373) on 2017/3/20.
 */
public class NimPlayer {

    //To record the player's name
    String Player1;
    String Player2;

    //The method to remove the stones, int s represents the number of stones, int r represents the number of stones the player want to remove.
    public static int removeStone(int s, int r) {
        s = s - r;
        if (s == 0) {
            return 0;
        } else {
            System.out.println();
            System.out.print(s + " stones left:");
            for (int i = 0; i < s; i++) {
                System.out.print(" *");
            }
            System.out.println();
            //Return the number of stones after removal
            return s;
        }
    }
}
