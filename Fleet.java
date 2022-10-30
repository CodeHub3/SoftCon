import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Fleet {
    private ArrayList<Ship> aFleet = new ArrayList<>(10);

    public ArrayList<Ship> getFleet(){
        return aFleet;
    } 

    public void addShip(Ship ship) {
        aFleet.add(ship);
    }

}
