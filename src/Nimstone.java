/**
 * Created by es on 2017/4/2.
 */
public class Nimstone {
    public static int stonenum= 0;
    public int upperbound=0;

    public Nimstone(int upperbound,int stonenum){
        this.upperbound=upperbound;
        this.stonenum=stonenum;

    }

    public void remove(int stone){

        stonenum=stonenum-stone;
        printNimstoneinfo();
    }

    public boolean empty(){
        if(stonenum==0)return true;
        else {return false ;}


    }
    public int reststone() {
        return stonenum;
    }
    public void printNimstoneinfo(){
        System.out.println();
        System.out.print(stonenum + " stones left:");
        for (int i = 0; i < stonenum; i++) {
            System.out.print(" *");
        }
        System.out.println();
    }
    public int getUpperbound(){
        return upperbound;
    }


}
