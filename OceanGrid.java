import java.util.ArrayList;

public class OceanGrid {
    Character[][] aDatastructure = new Character[10][10];

    //TODO funtion: addBomb(Position comBomb)
    public OceanGrid () {
        for (int col = 0; col < 10; col++) {
            for (int row = 0; row < 10; row++) {
                aDatastructure[col][row] = ' ';
            }
        }
    }

    //TODO CHANGE TO FLEET (1 for loop more)--> DONE
    public void addFleet(ArrayList<Ship> pFleet){
        for(Ship ship : pFleet.aFleet){
            for(Position pos : ship.aPositions){
                aDatastructure[pos.getY()][pos.getX()] = ship.aType;
            }
        }
    }

    //TODO ADD HIT BOMB --> DONE
    public void addHit(ArrayList<Position> pComHit){
        for(Position p : pComHit.aComHit){
            aDatastructure[pos.getY()][pos.getX()] = "X";
        }
    }
}
