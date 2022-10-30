import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Com {
    //TODO com
    private ArrayList<Position> aComCall = new ArrayList<>();

    public void comBomb(Position target, Fleet pFleet){
        aComCall.add(target);
        for(Ship ship : pFleet.aFleet){
            for(Position pos : ship.getPositions()){
                if(pos == target){
                    OceanGrid.addHit(pos);
                }
                else{
                    OceanGrid.addMiss(pos);
                }
            }
        }
    }

    public void playerBombing(Position aim, Fleet cFleet){
        for(Ship ship : cFleet.aFleet){
            for(Position pos : ship.getPositions()){
                if(pos == aim){
                    if(ship.getLifespan()==1){
                        TargetGrid.addHit(ship.getPositions(),ship.getType());
                    }
                    else{
                        TargetGrid.addHit(aim);
                    }
                    ship.getLifespan -=1;
                }
                else{
                    TargetGrid.addMiss(aim);
                }
            }
        }
    }
}