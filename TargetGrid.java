import java.util.ArrayList;

public class TargetGrid implements Playground {
    Character[][] aDatastructure = new Character[10][10];
    private Fleet comFleet = new Fleet();

    public void addToFleet(Ship pShip) {
        comFleet.addShip(pShip);
    }

    public boolean shipDoesNotOverlap(Ship ship) {
        return comFleet.shipDoesNotOverlap(ship);
    }

    public TargetGrid () {
        for (int col = 0; col < 10; col++) {
            for (int row = 0; row < 10; row++) {
                aDatastructure[col][row] = ' ';
            }
        }
    }
    public void addMiss(Position userBomb) {
        aDatastructure[userBomb.getX()][userBomb.getY()] = 'O';
    }
    public void addHit(Position userBomb){
        aDatastructure[userBomb.getX()][userBomb.getY()] = 'X';
    }
    public void printTargetGrid() {
        System.out.println("===== TARGET GRID =====");
        System.out.println("  A B C D E F G H I J  ");
        System.out.println(" +-+-+-+-+-+-+-+-+-+-+");

        for (int col = 0; col < 10 ; col++) {
            System.out.print(col);
            for (int row = 0; row < 10 ; row++) {
                System.out.print("|");
                System.out.print(aDatastructure[row][col]);
            }
            System.out.print("|" + col + "\n");
        }

        System.out.println(" +-+-+-+-+-+-+-+-+-+-+");
        System.out.println("  A B C D E F G H I J  ");
        System.out.println("=======================");
    }
    public void revealShip(Ship pShip) {
        //puts in ship into the grid
        for(Position pos : pShip.getPositions()){
            aDatastructure[pos.getX()][pos.getY()] = pShip.getType();
        }
    }

    public void revealAllShips() {
        //not tested
        for(Ship ship : comFleet.aFleet) {
            revealShip(ship);
        }
    }
    public void bombard(Position bomb) {
        if (comFleet.positionInFleet(bomb)) {
            Ship damagedShip = comFleet.getCorrespondingShip(bomb);
            damagedShip.reduceLifespan();

            if (damagedShip.getLifespan() <= 0) {
                revealShip(damagedShip);
            }
            else {
                addHit(bomb);
            }
        }
        else {
            addMiss(bomb);
        }
    }
    public boolean isFleetDestroyed() {
        for (Ship ship : comFleet.getFleet()) {
            if (ship.getLifespan() >= 0) {
                return false;
            }
        }
        return true;
    }

}
