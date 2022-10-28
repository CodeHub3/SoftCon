import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Com {
    //TODO com
    //noo com hit only call
    private ArrayList<Position> aComBomb = new ArrayList<>();
    private ArrayList<Position> aComHit = new ArrayList<>();

    //Doesnt work
    public comBomb(Position target, Fleet pFleet){
        aComBomb.add(target);
        for(Ship ship : pFleet.aFleet){
            for(Position pos : ship.getPositions){
                if(pos == target){
                    //call ocenaGrid with pos
                }
            }
        }
    }

}