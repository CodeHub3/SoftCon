import java.util.ArrayList;

public class Ship {
    ArrayList<Position> aPositions= new ArrayList<>();
    char aType;
    int lifespan;


    public Ship(Position startPosition, Position endPosition, String pType) {

        aType = pType.charAt(0);

        //TODO all the different type
        if (aType == 'C') {
            lifespan = 6;
        }

        aPositions.add(startPosition);
        //no encapsuation; maybe getter method
        if (startPosition.aCoordinates[1] == endPosition.aCoordinates[1]) {
            int i = startPosition.aCoordinates[0] + 1;
            while (i != endPosition.aCoordinates[0]) {
                aPositions.add(new Position(i, startPosition.aCoordinates[1]));
                i++;
            }
        }
        if (startPosition.aCoordinates[0] == endPosition.aCoordinates[0]) { //vertical ship
            int j = startPosition.aCoordinates[1]+1;
            while (j != endPosition.aCoordinates[1]){
                aPositions.add(new Position(startPosition.aCoordinates[0],j));
                j++;
            }
        }
        aPositions.add(endPosition);

        //prints all the positions, just for test purpouses
        for (Position position : aPositions) {
            position.printPosition();
        }



    }






}
