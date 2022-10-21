import java.util.Scanner;

public class BattleShip {

    public static void main(String[] args ) {

        //create ocean
        //create target

        //System.out.println("Welcome to Battle Ship");

        //Fleet fleet = new Fleet();
        //fleet.createUserFleet();

        //System.out.println(fleet.aFleet.get(0));

        boolean won = false;

        while (!won) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter position of bomb");
            Bomb newUserBomb = new Bomb(sc.next());
            System.out.println(newUserBomb);
            //target.addBomb(newUserBomb);

            won = true;
        }



    }
}
