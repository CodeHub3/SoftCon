import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Fleet {
    public ArrayList<Ship> aFleet = new ArrayList<>(10);

    //translator
    public boolean validatePositions(String pShipType, Position pFirstPosition, Position pSecondPosition) {
        if (pFirstPosition == pSecondPosition) {
            System.out.println("You can not enter the same position twice!");
            return false;
        }
        return true;
    }

    public void createUserFleet() {
        String[] shipTypes = {"Carrier", "Battleship", "Battleship", "Submarine", "Submarine", "Submarine",
                "Patrolboat", "Patrolboat", "Patrolboat", "Patrolboat", };

        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 10; i++) {
            System.out.println("Please enter " + shipTypes[i] + " position...");
            Position firstPosition = new Position(sc.next());
            Position secondPosition = new Position(sc.next());

            if (validatePositions(shipTypes[i], firstPosition,secondPosition)) {
                System.out.println("Congrats!");
            }


            /*
            Ship newShip = new Ship();
            aFleet.add(newShip); */

        }

    }
}
