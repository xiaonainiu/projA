/**
 * Created by Shen YI(844373) on 2017/3/20.
 */
public class NimPlayer {

    //To record the player's name
//    String Player1;
    //String Player2;
    String name;
    public NimPlayer(String name){
        this.name=name;
    }
    public static void removeStone(Nimstone s, int r) {
        s.remove(r);

    }
    public String getname(){
        return name;
    }

}
