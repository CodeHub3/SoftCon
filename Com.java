import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class Com {
    TargetGrid targetGrid = new TargetGrid();
    ArrayList<Position> placedBombs = new ArrayList<>();
    public Ship createCarrier() {
        Random rand = new Random();
        Position startPos = new Position();
        Position endPos = new Position();
        int count = 0;

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
        targetGrid.comFleet.addShip(carrier);
        //targetGrid.addShip(carrier);

        while (count < 2) {
            Ship battleship = createBattleship();
            if (targetGrid.comFleet.shipDoesNotOverlap(battleship)) {
                targetGrid.comFleet.addShip(battleship);
                //targetGrid.addShip(battleship);
                ++count;
            }
        }
        count = 0;

        while (count < 3) {
            Ship submarine = createSubmarine();
            if (targetGrid.comFleet.shipDoesNotOverlap(submarine)) {
                targetGrid.comFleet.addShip(submarine);
                //targetGrid.addShip(submarine);
                ++count;
            }
        }
        count = 0;

        while (count < 4) {
            Ship patrolboat = createPatrolboat();
            if (targetGrid.comFleet.shipDoesNotOverlap(patrolboat)) {
                targetGrid.comFleet.addShip(patrolboat);
                //targetGrid.addShip(patrolboat);
                ++count;
            }
        }

        //targetGrid.printTargetGrid();
        return targetGrid;

    }

    public boolean isBombNeverUsed(Position bomb) {
        for (Position pos : placedBombs) {
            if (pos.isEqual(bomb)) {
                return false;
            }
        }
        return true;
    }
    public Position createBomb() {
        Random rand = new Random();
        //not tested if it really works

        while (true) {
            Position bomb = new Position(rand.nextInt(10), rand.nextInt(10));
            if (isBombNeverUsed(bomb)){
                placedBombs.add(bomb);
                return bomb;
            }

        }

    }





    //alls wasman nicht braucht...
    private ArrayList<Position> aComCall = new ArrayList<>();
    public Position comBomb(){

        Random rand = new Random();
        Position bombPos = new Position();
        for(int i = 0; i!=aComCall.size(); i++) {
            while(aComCall[i].isEqual(bombPos)){
            bombPos.setX(rand.nextInt(10));
            bombPos.setY(rand.nextInt(10));
            i=0;
            }
        }
        aComCall.add(bombPos);
        return bombPos;
    }