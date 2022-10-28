import java.util.ArrayList;

public class Ship {
    private ArrayList<Position> aPositions= new ArrayList<>();
    private char aType;
    private int aLifespan;


    public Ship(Position startPosition, Position endPosition, String pType) {

        aType = pType.charAt(0);

        //TODO all the different type
        if (aType == 'C') {
            aLifespan = 6;
        }
        else if (aType == 'B') {
            aLifespan = 4;
        }
        else if (aType == 'S') {
            aLifespan = 3;
        }
        else if (aType == 'P') {
            aLifespan = 2;
        }

        aPositions.add(startPosition);
        //no encapsuation; maybe getter method
        if (startPosition.getY() == endPosition.getY()) {
            int i = startPosition.getX() + 1;
            while (i != endPosition.getX()) {
                aPositions.add(new Position(i, startPosition.getY()));
                i++;
            }
        }
        if (startPosition.getX() == endPosition.getX()) { //vertical ship
            int j = startPosition.getY()+1;
            while (j != endPosition.getY()){
                aPositions.add(new Position(startPosition.getX(),j));
                j++;
            }
        }
        aPositions.add(endPosition);

        //prints all the positions, just for test purpouses
        for (Position position : aPositions) {
            position.printPosition();
        }

    }

    public int getLifespan() {
        return aLifespan;
    }

    public ArrayList<Position> getPositions() {
        return aPositions;
    } 
    public char getType(){
        return aType;
    } 




}
