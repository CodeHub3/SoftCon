public class Position {
    private int[] aCoordinates = new int[2];

    public Position(String userInput) {
        if (userInput.length()!=2){
            throw new IndexOutOfBoundsException();
        }
        char ch2Code = userInput.charAt(1);
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
            throw new IndexOutOfBoundsException();
        }
        else {
            aCoordinates[0] = found;
        }
    }
    public Position(int y, int x) {
        aCoordinates[0] = y;
        aCoordinates[1] = x;
    }

    public Position() {
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
