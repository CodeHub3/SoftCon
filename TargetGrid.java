import java.util.ArrayList;

public class TargetGrid {
    Character[][] aDatastructure = new Character[10][10];
    private Fleet comFleet = new Fleet();

    public void addToFleet(Ship pShip) {
        comFleet.addShip(pShip);
    }
    public TargetGrid () {
        for (int col = 0; col < 10; col++) {
            for (int row = 0; row < 10; row++) {
                aDatastructure[col][row] = ' ';
            }
        }
    }

    public boolean shipInFleet(Ship ship) {
        return comFleet.shipInFleet(ship);
    }

    public void addMiss(Position userBomb) {
        aDatastructure[userBomb.getX()][userBomb.getY()] = 'o'; //'◯';
    }
    public void addHit(Position userBomb){
        aDatastructure[userBomb.getX()][userBomb.getY()] = 'X';
    }
    public void printTargetGrid() {
        // shows nothing exept if we tell it to. needs to show X and O and boat if it is reveiled.
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
    public void bombard(Position bomb) {
        if (comFleet.positionInFleet(bomb)) {
            Ship damagedShip = comFleet.getCorrespondingShip(bomb);
            damagedShip.reduceLifespan();

            if (damagedShip.getLifespan() <= 0) {
                revealShip(damagedShip);

            }else {
                addHit(bomb);
            }
        }
        else {
            addMiss(bomb);
        }
    }
    public boolean isDestroyed() {
        for (Ship ship : comFleet.aFleet) {
            if (ship.getLifespan() != 0) {
                return false;
            }
        }
        return true;
    }

}
