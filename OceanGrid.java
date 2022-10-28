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

    public void putInFleet(ArrayList<Ship> pFleet) {

    }

    public void addShip(Ship pShip){
        for(Position pos : pShip.aPositions){
            aDatastructure[pos.getY()][pos.getX()] = pShip.aType;
        }
    }


}
