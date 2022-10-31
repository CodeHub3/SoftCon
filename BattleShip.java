import java.util.Scanner;

public class BattleShip {


    public static void main(String[] args ) {
        System.out.println("Welcome to Battle Ship!\n");

        OceanGrid ocean = new OceanGrid();
        TargetGrid target = new TargetGrid();
        Grids grids = new Grids(target, ocean);

        


        Player player = new Player();
        Fleet userFleet = player.createUserFleet();
        ocean.addFleet(userFleet);

        System.out.println("\nNow let the game begin!\n");

        grids.printGrids();

        // now I create a ship (carrier) for test purposes
        Position startPosition = new Position(1, 2);
        Position endPosition = new Position(6, 2);
        Ship testShip = new Ship(startPosition, endPosition, "Carrier");

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

            newUserBomb.printPosition();
            target.addHit(newUserBomb);
            won = true;
        
        }

        grids.printGrids();





    }
}
