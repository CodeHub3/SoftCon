public class OceanGrid implements Playground {
    Character[][] aDatastructure = new Character[10][10];
    private Fleet userFleet = new Fleet();
    private boolean lastCallHit = false;

    public OceanGrid () {
        for (int col = 0; col < 10; col++) {
            for (int row = 0; row < 10; row++) {
                aDatastructure[col][row] = ' ';
            }
        }
    }

    public void addToFleet(Ship pShip) {
        userFleet.addShip(pShip);
    }

    public boolean shipDoesNotOverlap(Ship ship) {
        return userFleet.shipDoesNotOverlap(ship);
    }

    public void addMiss(Position miss){
        aDatastructure[miss.getX()][miss.getY()]= 'O';
    }

    public void addHit(Position hit){
        aDatastructure[hit.getX()][hit.getY()]= 'X';
    }

    public void revealShip(Ship pShip) {
        //puts in ship into the grid
        for(Position pos : pShip.getPositions()){
            aDatastructure[pos.getX()][pos.getY()] = pShip.getType();
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
   
    public void bombard(Position bomb) {
        if (userFleet.positionInFleet(bomb)) {
            Ship damagedShip = userFleet.getCorrespondingShip(bomb);
            damagedShip.reduceLifespan();
            //in ocean grid we display only X's and O's
            addHit(bomb);
            lastCallHit = true;
        }
        else {
            addMiss(bomb);
            lastCallHit = false;
        }
    }

    public void addShip(Ship pShip){
        for(Position pos : pShip.getPositions()){
            aDatastructure[pos.getX()][pos.getY()] = pShip.getType();
        }        
    }
    
    public boolean getLastCalHit(){
        return lastCallHit;
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
