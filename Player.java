import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class Player{
    OceanGrid oceanGrid = new OceanGrid();
    private ArrayList<Position> aPlayerCall = new ArrayList<>();

    public boolean validatePositions(String pShipType, Position pFirstPosition, Position pSecondPosition) {
        if (pFirstPosition.isEqual(pSecondPosition)) {
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
        return true;
        }
    }

    public OceanGrid createUserOcean() {

        String[] shipTypes = {"Carrier", "Battleship", "Battleship", "Submarine", "Submarine", "Submarine",
                "Patrolboat", "Patrolboat", "Patrolboat", "Patrolboat", };

        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 10; i++) {
            System.out.println("\nPlease enter " + shipTypes[i] + " position. Length: " + Ship.getLength(shipTypes[i].charAt((0))) );
            boolean inputCheck = false;
            Position startPosition = new Position();
            Position endPosition = new Position();
            while (!inputCheck) {
                try {
                    String userInput = sc.nextLine();
                    if (userInput.charAt(2) != ',') {
                        throw new InputMismatchException();
                    }
                    String[] arrOfStr = userInput.split(",", 2);
                    startPosition = new Position(arrOfStr[0]);
                    endPosition = new Position(arrOfStr[1]);
                    
                    if(!validatePositions(shipTypes[i], startPosition, endPosition)) {
                        throw new IndexOutOfBoundsException();
                    }
                    inputCheck = true;
                }
                catch (Exception e) {
                    System.out.println("Enter a valid position! (e.g. A2,A4)");
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
        }
        return oceanGrid;
    }

    public Position createBomb() {
        Scanner sc = new Scanner(System.in);
        boolean inputCheck = false;
        Typewriter.main("\nEnter position of bomb\n");
        while (!inputCheck) {            
            try {
                Position newUserBomb = new Position(sc.nextLine());
                
                for (Position playerCall : aPlayerCall) {
                    if (playerCall.isEqual(newUserBomb)) {
                        throw new ArithmeticException();
                    }    
                }
                inputCheck = true;
                aPlayerCall.add(newUserBomb);
            }
            catch (ArithmeticException e) {
                System.out.println("You already made that call, try again!");
            }
            catch (Exception e) {
                System.out.println("Not a valid position, try again! (e.g. B7)");
            }
            
        }
        return aPlayerCall.get(aPlayerCall.size()-1);
    }
}