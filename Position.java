public class Position {
    int[] aCoordinates = new int[2];

    public Position(String userInput) {

        //TODO convert input string to Position (array of length 2)
        Character[] letters = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};

        //test
        aCoordinates[0] = 4;
        aCoordinates[1] = 4;
    }
    public Position(int y, int x) {
        aCoordinates[0] = y;
        aCoordinates[1] = x;
    }

    //method for test purposes...
    public void printPosition() {
        System.out.println("[" + aCoordinates[0] + "," + aCoordinates[1] + "]");
    }
}
