import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Player {

    public ArrayList<Position> occupiedFields = new ArrayList<>();
    //translator
    public boolean validatePositions(String pShipType, Position pFirstPosition, Position pSecondPosition) {
        if (pFirstPosition == pSecondPosition) {
            System.out.println("You can not enter the same position twice!");
            return false;
        }
        else if (pFirstPosition.getX() != pSecondPosition.getX() && pFirstPosition.getY() != pSecondPosition.getY()){
            System.out.println("The ship must be placed either vertically or horizontally");
            return false;
        }
        else if (Position.getDistance(pFirstPosition, pSecondPosition) != Ship.getLength(pShipType.charAt(0))) {
            int shipLength = Ship.getLength(pShipType.charAt(0));
            System.out.println(String.format("The Ship must have a length of %d!", shipLength));
            return false;
        }
        else {
            for (Position aPos : occupiedFields) {
                if (aPos.compareTo(pFirstPosition) || aPos.compareTo(pSecondPosition)) {
                    System.out.println("There is already a ship placed on one of these fields");
                    return false;
                }
            }
        
        return true;
        }
    }

    public Fleet createUserFleet() {
        Fleet userFleet = new Fleet();
        OceanGrid userFleetGrid = new OceanGrid();
        String[] shipTypes = {"Carrier", "Battleship", "Battleship", "Submarine", "Submarine", "Submarine",
                "Patrolboat", "Patrolboat", "Patrolboat", "Patrolboat", };

        userFleetGrid.printOceanGrid();
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 10; i++) {
            System.out.println("\nPlease enter " + shipTypes[i] + " position...");
            boolean inputCheck = false;
            Position startPosition = null;
            Position endPosition = null;
            while (!inputCheck) {
                try {
                    startPosition = new Position(sc.next());
                    endPosition = new Position(sc.next());
                    if (validatePositions(shipTypes[i], startPosition, endPosition)) {
                        System.out.println("Good choice!\n");
                        inputCheck = true;             
                    }
                }
                catch (Exception e) {
                    System.out.println("Enter a valid position!");
                }    
                
        }

            Ship newShip = new Ship(startPosition, endPosition, shipTypes[i]);
            userFleetGrid.addShip(newShip);
            //TODO: add ship to fleet
            userFleet.addShip(newShip);
            userFleetGrid.printOceanGrid();
            for (Position pos : newShip.getPositions()) {
                occupiedFields.add(pos);
            }        
        }
    return userFleet;
}
}
