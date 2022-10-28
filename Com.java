import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Com {
    //TODO com
    private ArrayList<Position> aComBomb = new ArrayList<>();
    private ArrayList<Position> aComHit = new ArrayList<>();

    public comBomb(Position target, ArrayList<Ship> pFleet){
        aComBomb.add(target);
        for(Ship ship : pFleet.aFleet){
            for(Position pos : ship.aPositions){
                if(pos == target){
                    aComHit.add(target)
                }
            }
        }
    }

}