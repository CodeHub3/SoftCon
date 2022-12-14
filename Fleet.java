import java.util.ArrayList;

public class Fleet {
    public ArrayList<Ship> aFleet = new ArrayList<>(10);

    public ArrayList<Ship> getFleet(){
        return aFleet;
    }

    public boolean positionInFleet(Position pos) {
        for (Ship ship : aFleet) {
            for (Position posInShip : ship.getPositions()) {
                if (posInShip.isEqual(pos)) {
                    return true;
                }
            }
        }
        return false;
    }
    public boolean shipDoesNotOverlap(Ship pShip) {
        for (Position pos : pShip.getPositions()) {
            for (Ship ship : aFleet) {
                for (Position posInShip : ship.getPositions()) {
                    if (posInShip.isEqual(pos)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    public void addShip(Ship ship) {
        aFleet.add(ship);
    }

    public Ship getCorrespondingShip(Position pos) {
        try {
            for (Ship ship : aFleet) {
                for (Position posInShip : ship.getPositions()) {
                    if (posInShip.isEqual(pos)) {
                        return ship;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("position does not correspond to a ship");
        }

        //dummy return statement
        return new Ship(new Position(0,0), new Position(0,1), "Patrolboat");
    }

}
