public class Position {
    private int[] aCoordinates = new int[2];

    public Position(String userInput) {
        if (userInput.charAt(1) != ',') {
            throw new IndexOutOfBoundsException();
        }
        char ch2Code = userInput.charAt(2);
        String ch2Str = String.valueOf(ch2Code);
        int ch2 = Integer.parseInt(ch2Str);
        aCoordinates[1] = ch2;

        char ch1 = Character.toUpperCase(userInput.charAt(0));
        Character[] letters = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};
        
        int found = -1;
        for (int i = 0; i < letters.length; ++i) {
            if (letters[i] == ch1) {
            found = i;
            break;
            }
        }
        if (found == -1 ) {
            //TODO: handle invalid input -> throw exception
            throw new IndexOutOfBoundsException();
        }
        else {
            aCoordinates[0] = found;
        }

        //test jjj
        /*aCoordinates[0] = 4;
        aCoordinates[1] = 4;*/
    }
    public Position(int y, int x) {
        aCoordinates[0] = y;
        aCoordinates[1] = x;
    }

    public Position() {
        aCoordinates[0] = 0;
        aCoordinates[1] = 0;
    }

    public int getX() {
        return aCoordinates[0];
    }

    public int getY() {
        return aCoordinates[1];
    }

    public void setX (int x) {
        aCoordinates[0] = x;
    }
    public void setY (int y) {
        aCoordinates[1] = y;
    }

    public boolean isEqual(Position pOther) {
        if (aCoordinates[0] == pOther.getX() && aCoordinates[1] == pOther.getY()) {return true;}
        return false;
    }

    //method for test purposes...
    public void printPosition() {
        System.out.println("[" + aCoordinates[0] + "," + aCoordinates[1] + "]");
    }

    static int getDistance(Position position1, Position position2) {
        int temp;
        if (position1.getY() == position2.getY()) {
            temp = position1.getX() - position2.getX() - 1;
        }        
        else {
            temp = position1.getY() - position2.getY() - 1;
         }
        return java.lang.Math.abs(temp);
    }
}
