import java.util.ArrayList;

public class OceanGrid {
    Character[][] aDatastructure = new Character[10][10];

    public OceanGrid () {
        for (int col = 0; col < 10; col++) {
            for (int row = 0; row < 10; row++) {
                aDatastructure[col][row] = ' ';
            }
        }
    }

    public void addFleet(Fleet pFleet){
        for(Ship ship : pFleet.getFleet){
            for(Position pos : ship.getPositions()){
                aDatastructure[pos.getY()][pos.getX()] = ship.getType();
            }
        }
    }

    public void addHit(Position hit){
        aDatastructure[hit.getY()][hit.getX()]="X";
    }
    
}
