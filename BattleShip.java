import java.util.Scanner;

public class BattleShip {

    //hi there

    public static void main(String[] args ) {
        System.out.println("Welcome to Battle Ship");

        OceanGrid ocean = new OceanGrid();
        TargetGrid target = new TargetGrid();
        Grids grids = new Grids(target, ocean);

        grids.printGrids();


        //Fleet fleet = new Fleet();
        //fleet.createUserFleet();

        //System.out.println(fleet.aFleet.get(0));

        // now I create a ship (carrier) for test purposes
        Position startPosition = new Position(1, 2);
        Position endPosition = new Position(6, 2);
        Ship testShip = new Ship(startPosition, endPosition, "Carrier");

        boolean won = false;

        while (!won) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter position of bomb");
            Position newUserBomb = new Position(sc.next());
            newUserBomb.printPosition();
            target.bombard(newUserBomb);
            won = true;
        }

        grids.printGrids();





    }
}
