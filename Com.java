import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Com {
    //TODO com
    private ArrayList<Position> aComCall = new ArrayList<>();

    //public getComCall (Position target,) getter method for postion to check if call was alrdy made

    public void comBomb(Position target, Fleet pFleet, OceanGrid ocean){
        aComCall.add(target);
        for(Ship ship : pFleet.aFleet){
            for(Position pos : ship.getPositions()){
                if(pos == target){
                    ocean.addHit(pos);
                }
                else{
                    ocean.addMiss(pos);
                }
            }
        }
    }

    public void playerBombing(Position aim, Fleet cFleet, TargetGrid tarGrid){
        for(Ship ship : cFleet.aFleet){
            for(Position pos : ship.getPositions()){
                if(pos == aim){
                    if(ship.getLifespan()==1){
                        tarGrid.addHit(ship.getPositions(),ship.getType());
                    }
                    else{
                        tarGrid.addHit(aim);
                    }
                    ship.getLifespan -=1;
                }
                else{
                    tarGrid.addMiss(aim);
                }
            }
        }
    }
}