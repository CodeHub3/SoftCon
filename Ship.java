import java.util.ArrayList;

public class Ship {
    private ArrayList<Position> aPositions= new ArrayList<>();
    private char aType;
    private int aLifespan;


    public Ship(Position startPosition, Position endPosition, String pType) {

        aType = pType.charAt(0);
        aLifespan = getLength(aType);

        

        aPositions.add(startPosition);
        if (startPosition.getY() == endPosition.getY()) {
            int i = startPosition.getX() + 1;
            while (i != endPosition.getX()) {
                aPositions.add(new Position(i, startPosition.getY()));
                i++;
            }
        }
        if (startPosition.getX() == endPosition.getX()) { 
            int j = startPosition.getY()+1;
            while (j != endPosition.getY()){
                aPositions.add(new Position(startPosition.getX(),j));
                j++;
            }
        }
        aPositions.add(endPosition);
    }

    static int getLength(char pShipType) {
        if (pShipType == 'B') {
            return 4;
        }
        else if (pShipType == 'S') {
            return 3;
        }
        else if (pShipType == 'P') {
            return 2;
        }
        else {
            return 6;
        }
    }

    public int getLifespan() {
        return aLifespan;
    }
    public void reduceLifespan() {
        aLifespan -= 1;
    }
    public ArrayList<Position> getPositions() {
        return aPositions;
    } 
    public char getType(){
        return aType;
    }
}
