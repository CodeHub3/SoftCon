public class TargetGrid {

    Character[][] aDatastructure = new Character[10][10];

    /*TODO funtion: bombard(Position userBomb)
    * -place bomb in grid
    * -if bomb position is equal to ship position, then replace cell with X and make it displayable
    * -if bomb position is empty ocean replace cell with O and make it desplayable
    * -check if hole boat got desroyed -if yes: revile boat, make hole boat displayable
     */

    public TargetGrid () {
        for (int col = 0; col < 10; col++) {
            for (int row = 0; row < 10; row++) {
                aDatastructure[col][row] = ' ';
            }
        }
    }
    public void bombard(Position userBomb) {
        aDatastructure[userBomb.aCoordinates[0]][userBomb.aCoordinates[1]] = 'X';
    }



}
