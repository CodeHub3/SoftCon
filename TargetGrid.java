public class TargetGrid extends Grid {

    Character[][] aDataStructure = new Character[10][10];

    /*TODO funtion: addBomb(Position userBomb)
    * -place bomb in grid
    * -if bomb position is equal to ship position, then replace cell with X and make it displayable
    * -if bomb position is empty ocean replace cell with 0 and make it desplayable
    * -check if hole boat got desroyed -if yes: revile boat, make hole boat displayable
    *
    *
    *
     */


    public void printTargetGrid() {

        // shows nothing exept if we tell it to. needs to show X and O and boat if it is reveiled.

        System.out.println("==== TARGET GRID ====");
        System.out.println("  A B C D E F G H I J  ");
        System.out.println(" +-+-+-+-+-+-+-+-+-+-+");

        for (int row = 0; row <= 9; row++) {
            System.out.print(row);
            for (int col = 0; col <= 9; col++) {
                System.out.print("|");
                System.out.print(aDataStructure[row][col]);
            }
            System.out.print("|" + row + "\n");
        }

        System.out.println(" +-+-+-+-+-+-+-+-+-+-+");
        System.out.println("  A B C D E F G H I J  ");

    }

}
