import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Com {
    //TODO com
    private ArrayList<Position> aComCall = new ArrayList<>();

    public comBomb(Position target, Fleet pFleet){
        aComCall.add(target);
        for(Ship ship : pFleet.aFleet){
            for(Position pos : ship.getPositions()){
                if(pos == target){
                    OceanGrid.addHit(pos);
                }
            }
        }
    }
}