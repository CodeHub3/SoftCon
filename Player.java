import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException; //andere exception?

public class Player {

    OceanGrid oceanGrid = new OceanGrid();

    /*
    public ArrayList<Position> occupiedFields = new ArrayList<>();
    //translator */

    public boolean validatePositions(String pShipType, Position pFirstPosition, Position pSecondPosition) {
        if (pFirstPosition.isEqual(pSecondPosition)) {
            System.out.println("You can not enter the same position twice!");
            return false;
        }
        else if (pFirstPosition.getX() != pSecondPosition.getX() && pFirstPosition.getY() != pSecondPosition.getY()){
            System.out.println("The ship must be placed either vertically or horizontally");
            return false;
        }
        //eher kommisch: wieso ned pFirstPosition.getDistance(pSecondPosition); du callt mer e method vomene objetkt (Position) wos gar ned wük git.
        else if (Position.getDistance(pFirstPosition, pSecondPosition) != Ship.getLength(pShipType.charAt(0))) {
            int shipLength = Ship.getLength(pShipType.charAt(0));
            System.out.println(String.format("The Ship must have a length of %d!", shipLength));
            return false;
        }
        else {
            /*
            for (Position aPos : occupiedFields) {
                if (aPos.isEqual(pFirstPosition) || aPos.isEqual(pSecondPosition)) {
                    System.out.println("There is already a ship placed on one of these fields");
                    return false;
                } 
            }*/
        
        return true;
        }
    }

    public OceanGrid createUserOcean() {

        String[] shipTypes = {"Carrier", "Battleship", "Battleship", "Submarine", "Submarine", "Submarine",
                "Patrolboat", "Patrolboat", "Patrolboat", "Patrolboat", };

        Scanner sc = new Scanner(System.in);
        //TODO input wird falsch eingegeben: eigentlich A2,A5

        for (int i = 0; i < 2/*10*/; i++) {
            System.out.println("\nPlease enter " + shipTypes[i] + " position. Length: " + Ship.getLength(shipTypes[i].charAt((0))) );
            boolean inputCheck = false;
            Position startPosition = new Position(); //antipattern null, musste es zu 0,0 ändern
            Position endPosition = new Position();
            while (!inputCheck) {
                try {
                    // Wieso nicht Position.startPosition = new..
                    String userInput = sc.next();
                    if (userInput.charAt(2) != ',') {
                        throw new InputMismatchException();
                    }
                    String[] arrOfStr = userInput.split(",", 2);
                    startPosition = new Position(arrOfStr[0]);
                    endPosition = new Position(arrOfStr[1]);
                    
                    if (!validatePositions(shipTypes[i], startPosition, endPosition)) {
                        throw new IndexOutOfBoundsException();
                    }
                    inputCheck = true;
                }
                catch (Exception e) {
                    System.out.println("Enter a valid position!");
                }

                if (inputCheck) {
                    Ship newShip = new Ship(startPosition, endPosition, shipTypes[i]);
                    if (oceanGrid.shipDoesNotOverlap(newShip)) {                       
                        oceanGrid.addShip(newShip);
                        oceanGrid.addToFleet(newShip);
                        oceanGrid.printOceanGrid();
                        System.out.println("\nGood choice!");
                }
                    else {
                        inputCheck = false;
                        System.out.println("\nThe ships must not overlap\n");
                        System.out.println("Enter a valid position!");
                }
                }

            }

            /*
            for (Position pos : newShip.getPositions()) {
                occupiedFields.add(pos);
            } */
        }

    return oceanGrid;
}

    private ArrayList<Position> aPlayerCall = new ArrayList<>();
    public Position createBomb() {
        //TODO check if position of bomb was already chosen
        Scanner sc = new Scanner(System.in);
        boolean inputCheck = false;
        while (!inputCheck) {
            System.out.println("\nEnter position of bomb");
            try {
                Position newUserBomb = new Position(sc.next());
                inputCheck = true;
                for (Position playerCall : aPlayerCall) {
                    if (playerCall.isEqual(newUserBomb)) {
                        
                    }    
                }
                aPlayerCall.add(newUserBomb);
            }
            catch (Exception e) {
                System.out.println("Not a valid position, try again!");
            }
            
        }
        return aPlayerCall.get(aPlayerCall.size()-1);
    }
}