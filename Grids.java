public class Grids {

    TargetGrid aTarget;
    OceanGrid aOcean;

    public Grids(TargetGrid pTarget, OceanGrid pOcean) {
        aTarget = pTarget;
        aOcean = pOcean;
    }

    public void printGrids () {
        // shows nothing exept if we tell it to. needs to show X and O and boat if it is reveiled.
        System.out.println("\n");
        System.out.println("===== TARGET GRID =====");
        System.out.println("  A B C D E F G H I J  ");
        System.out.println(" +-+-+-+-+-+-+-+-+-+-+");

        for (int col = 0; col < 10 ; col++) {
            System.out.print(col);
            for (int row = 0; row < 10 ; row++) {
                System.out.print("|");
                System.out.print(aTarget.aDatastructure[row][col]);
            }
            System.out.print("|" + col + "\n");
        }

        System.out.println(" +-+-+-+-+-+-+-+-+-+-+");
        System.out.println("  A B C D E F G H I J  ");
        System.out.println("=======================");

        System.out.println("\n-----------------------\n");

        System.out.println("===== OCEAN GRID ======");
        System.out.println("  A B C D E F G H I J  ");
        System.out.println(" +-+-+-+-+-+-+-+-+-+-+");

        for (int col = 0; col < 10 ; col++) {
            System.out.print(col);
            for (int row = 0; row < 10 ; row++) {
                System.out.print("|");
                System.out.print(aOcean.aDatastructure[row][col]);
            }
            System.out.print("|" + col + "\n");
        }

        System.out.println(" +-+-+-+-+-+-+-+-+-+-+");
        System.out.println("  A B C D E F G H I J  ");
        System.out.println("=======================");
    }

}
