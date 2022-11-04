import java.util.ArrayList;
import java.util.Random;

public class Com{
    TargetGrid targetGrid = new TargetGrid();
    private ArrayList<Position> aComCalls = new ArrayList<>();

    public Ship createCarrier() {
        Random rand = new Random();
        Position startPos = new Position();
        Position endPos = new Position();

        if (rand.nextBoolean()) { //horizontally
            startPos.setX(rand.nextInt(10));
            startPos.setY(rand.nextInt(5));
            endPos.setX(startPos.getX());
            endPos.setY(startPos.getY() + 5);

        }
        else { //vertically
            startPos.setX(rand.nextInt(5));
            startPos.setY(rand.nextInt(10));
            endPos.setY(startPos.getY());
            endPos.setX(startPos.getX() + 5);
        }
        return new Ship(startPos, endPos, "Carrier");
    }
    public Ship createBattleship() {
        Random rand = new Random();
        Position startPos = new Position();
        Position endPos = new Position();


        if (rand.nextBoolean()) { //horizontally
            startPos.setX(rand.nextInt(10));
            startPos.setY(rand.nextInt(7));
            endPos.setX(startPos.getX());
            endPos.setY(startPos.getY() + 3);
        }
        else { //vertically
            startPos.setX(rand.nextInt(7));
            startPos.setY(rand.nextInt(10));
            endPos.setY(startPos.getY());
            endPos.setX(startPos.getX() + 3);
        }
        return new Ship(startPos, endPos, "Battleship");
    }
    public Ship createSubmarine() {
        Random rand = new Random();
        Position startPos = new Position();
        Position endPos = new Position();


        if (rand.nextBoolean()) { //horizontally
            startPos.setX(rand.nextInt(10));
            startPos.setY(rand.nextInt(8));
            endPos.setX(startPos.getX());
            endPos.setY(startPos.getY() + 2);
        }
        else { //vertically
            startPos.setX(rand.nextInt(8));
            startPos.setY(rand.nextInt(10));
            endPos.setY(startPos.getY());
            endPos.setX(startPos.getX() + 2);
        }
        return new Ship(startPos, endPos, "Submarine");
    }
    public Ship createPatrolboat() {
        Random rand = new Random();
        Position startPos = new Position();
        Position endPos = new Position();


        if (rand.nextBoolean()) { //horizontally
            startPos.setX(rand.nextInt(10));
            startPos.setY(rand.nextInt(9));
            endPos.setX(startPos.getX());
            endPos.setY(startPos.getY() + 1);
        }
        else { //vertically
            startPos.setX(rand.nextInt(9));
            startPos.setY(rand.nextInt(10));
            endPos.setY(startPos.getY());
            endPos.setX(startPos.getX() + 1);
        }
        return new Ship(startPos, endPos, "Patrolboat");
    }
    public TargetGrid createComTarget() {
        //alles gecommented muss noch gelöscht werden
        int count = 0;

        Ship carrier = createCarrier();
        targetGrid.addToFleet(carrier);
        //targetGrid.addShip(carrier);

        while (count < 2) {
            Ship battleship = createBattleship();
            if (targetGrid.shipDoesNotOverlap(battleship)) {
                targetGrid.addToFleet(battleship);
                //targetGrid.addShip(battleship);
                ++count;
            }
        }
        count = 0;

        while (count < 3) {
            Ship submarine = createSubmarine();
            if (targetGrid.shipDoesNotOverlap(submarine)) {
                targetGrid.addToFleet(submarine);
                //targetGrid.addShip(submarine);
                ++count;
            }
        }
        count = 0;

        while (count < 4) {
            Ship patrolboat = createPatrolboat();
            if (targetGrid.shipDoesNotOverlap(patrolboat)) {
                targetGrid.addToFleet(patrolboat);
                //targetGrid.addShip(patrolboat);
                ++count;
            }
        }

        //targetGrid.printTargetGrid();
        return targetGrid;

    }

    public Position createBombRandom(){

        Random rand = new Random();
        Position bombPos = new Position();
        boolean inputCheck = false;
      
        while (!inputCheck) {
            bombPos.setX(rand.nextInt(10));
            bombPos.setY(rand.nextInt(10));
            inputCheck = true;
            for (Position comCall : aComCalls) {
                if (bombPos.isEqual(comCall)) {
                    inputCheck = false;
                    break;
                }
            }
        }
        aComCalls.add(bombPos);
        return bombPos;
    }

    public Position createBombAfterHit(){
        Position bombPos = new Position();
        boolean inputCheck = false;
        Random rand = new Random();
        int counter = 0;
        while (!inputCheck) {
            if (rand.nextBoolean()) {
                //horizontal
                if (rand.nextBoolean()) {
                    //links
                    if (aComCalls.get(aComCalls.size()-1).getX() >= 1) {
                        bombPos.setX(aComCalls.get(aComCalls.size()-1).getX()-1);
                        bombPos.setY(aComCalls.get(aComCalls.size()-1).getY());
                        inputCheck = true;
                    }
                    }
                else {
                    //rechts
                    if (aComCalls.get(aComCalls.size()-1).getX() <= 8) {
                        bombPos.setX(aComCalls.get(aComCalls.size()-1).getX()+1);
                        bombPos.setY(aComCalls.get(aComCalls.size()-1).getY());
                        inputCheck = true;
                    }
                }
            }
            else {
                //vertikal
                if (rand.nextBoolean()) {
                    //hoch
                    if (aComCalls.get(aComCalls.size()-1).getY() >= 1) {
                        bombPos.setX(aComCalls.get(aComCalls.size()-1).getX());
                        bombPos.setY(aComCalls.get(aComCalls.size()-1).getY()-1);
                        inputCheck = true;
                    }
                }
                else {
                    //runter
                    if (aComCalls.get(aComCalls.size()-1).getY() <= 8) {
                        bombPos.setX(aComCalls.get(aComCalls.size()-1).getX());
                        bombPos.setY(aComCalls.get(aComCalls.size()-1).getY()+1);
                        inputCheck = true;
                    }
                }

            }
            if (inputCheck) {
                for (Position comCall : aComCalls) {
                    if (bombPos.isEqual(comCall)) {
                        inputCheck = false;
                        break;
                    }
                }   
            }
            if (counter == 20) {
                return createBombRandom();
            }
            counter++;
        }
        aComCalls.add(bombPos);
        return bombPos;
    }
}  

