import java.util.ArrayList;
import java.util.Scanner;

public class BattleShip {
    public static void main(String[] args ) {
        System.out.println("Welcome to Battle Ship!\n");

        Player player = new Player();
        Com com = new Com();

        TargetGrid target = com.createComTarget();
        //OceanGrid ocean = new OceanGrid();

        //Grids grids = new Grids(target,ocean);

        //grids.printGrids();


        boolean won = false;

        while (!won) {
            Scanner sc = new Scanner(System.in);
            Position newUserBomb = null;
            boolean inputCheck = false;
            while (!inputCheck) {
                System.out.println("\nEnter position of bomb");
                try {
                    newUserBomb = new Position(sc.next());
                    inputCheck = true;
                }
                catch (Exception e) {
                    System.out.println("Not a valid position, try again!");
                }
            }

            target.bombard(newUserBomb);
            target.printTargetGrid();



            //grids.printGrids();
        }
        
    }
}
