import java.util.ArrayList;

public class OceanGrid {
    Character[][] aDatastructure = new Character[10][10];
    public Fleet userFleet = new Fleet();

    public void addToFleet(Ship pShip) {
        userFleet.addShip(pShip);
    }

    public boolean shipDoesNotOverlap(Ship ship) {
        return userFleet.shipDoesNotOverlap(ship);
    }

    public void addFleet(Fleet pFleet) {
        for (Ship ship : pFleet.getFleet()) {
            for(Position pos : ship.getPositions()){
                aDatastructure[pos.getX()][pos.getY()] = ship.getType();
            }
        }
    }
    
    public OceanGrid () {
        for (int col = 0; col < 10; col++) {
            for (int row = 0; row < 10; row++) {
                aDatastructure[col][row] = ' ';
            }
        }
    }
    public void addShip(Ship pShip){
        for(Position pos : pShip.getPositions()){
            aDatastructure[pos.getX()][pos.getY()] = pShip.getType();
        }        
    }

    public void addHit(Position hit){
        //TODO
        aDatastructure[hit.getX()][hit.getY()]= 'X';
    }

    public void addMiss(Position miss){
        //TODO
        aDatastructure[miss.getX()][miss.getY()]= 'O';
    }

    public void revealShip(Ship pShip) {
        //puts in ship into the grid
        for(Position pos : pShip.getPositions()){
            aDatastructure[pos.getX()][pos.getY()] = pShip.getType();
        }
    }

    public void bombard(Position bomb) {
        if (userFleet.positionInFleet(bomb)) {
            Ship damagedShip = userFleet.getCorrespondingShip(bomb);
            damagedShip.reduceLifespan();
            //in ocean grid we display only X's and O's
            addHit(bomb);
        }
        else {
            addMiss(bomb);
        }
    }

    public boolean isFleetDestroyed() {
        for (Ship ship : userFleet.getFleet()) {
            if (ship.getLifespan() > 0) {
                return false;
            }
        }
        return true;
    }
    
    public void printOceanGrid() {
    System.out.println("===== OCEAN GRID ======");
        System.out.println("  A B C D E F G H I J  ");
        System.out.println(" +-+-+-+-+-+-+-+-+-+-+");

        for (int col = 0; col < 10 ; col++) {
            System.out.print(col);
            for (int row = 0; row < 10 ; row++) {
                System.out.print("|");
                System.out.print(aDatastructure[row][col]);
                try {
                    Thread.sleep(4);
                  } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                  }
            }
            System.out.print("|" + col + "\n");
        }

        System.out.println(" +-+-+-+-+-+-+-+-+-+-+");
        System.out.println("  A B C D E F G H I J  ");
        System.out.println("=======================");
    }
}
