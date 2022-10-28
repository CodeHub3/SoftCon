public class Position {
    private int[] aCoordinates = new int[2];

    public Position(String userInput) {
        char ch2Code = userInput.charAt(1);
        String ch2Str = String.valueOf(ch2Code);
        int ch2 = Integer.parseInt(ch2Str);
        if (ch2 > 9) {
            //TODO: Handle invalid input
        }
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
            //TODO: handle invalid input
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

    public int getX() {
        return aCoordinates[0];
    }

    public int getY() {
        return aCoordinates[1];
    }

    //method for test purposes...
    public void printPosition() {
        System.out.println("[" + aCoordinates[0] + "," + aCoordinates[1] + "]");
    }
}
