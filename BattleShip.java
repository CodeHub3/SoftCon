public class BattleShip {
    public static void main(String[] args ) {
        //System.out.println("\nWelcome to Battle Ship!\n");
        Typewriter.main("\nWelcome to Battle Ship!\n");
        try {
            Thread.sleep(500);
            } 
            catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            }
        Typewriter.main("Loading...   ");
        for (int i = 1; i<=10; i++) {
            try {
                Thread.sleep(i * 70);
                } 
                catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                }
            System.out.print("|");
        }
        TargetGrid emptyTarget = new TargetGrid();
        OceanGrid emptyOcean = new OceanGrid();
        Grids emptyGrids = new Grids(emptyTarget, emptyOcean);
        emptyGrids.printGrids();

        Player player = new Player();
        Com com = new Com();

        TargetGrid target = com.createComTarget();
        OceanGrid ocean = player.createUserOcean();
        Grids grids = new Grids(target,ocean);

        grids.printGrids();

        boolean finished = false;
        while (!finished) {

            target.bombard(player.createBomb());
            target.printTargetGrid();
            if (target.isFleetDestroyed()) {
                Typewriter.main("\nCongratulations You Won!!!\n");
                System.out.println("\n   ###%%%%%%%%%%%%%###\n   ## %%%%%%%%%%%%% ##\n     ##%%%%%%%%%%%##  \n         %%%%%%%      \n           ###        \n         (((((((      \n        %%%%%%%%%     \n");
                Typewriter.main("  Thank you for playing\n\n");
                finished = true;
                break;
            }
            //System.out.print("\nThe other player is making his move now");
            Typewriter.main("The other player is making his move now");
            for (int i=0; i<4; i++) {                
                try {
                Thread.sleep(500);
                } 
                catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                }
                if (i!=3) {System.out.print(".");}
                }
            ocean.bombard(com.createBomb());
            grids.printGrids();
            if (ocean.isFleetDestroyed()) {
                Typewriter.main("\n       Game Over\n\n");
                System.out.println("  @@               @@     \n@@@@  @@@@@@@@@@@  @@@@   \n    @@@@@@@@@@@@@@@       \n    @@@  @@@@@@  @@       \n     @@@@@@@@@@@@@        \n       @@@ @ @@@          \n        @@@@@@@@          \n      @@@      @@         \n    @@@          @@@      \n");
                Typewriter.main("       You lost!\n");
                Typewriter.main("\nRevealing all ships of the opponent");
                //add ... in slow
                for (int i=0; i<4; i++) {                
                    try {
                    Thread.sleep(500);
                    } 
                    catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    }
                    if (i!=3) {System.out.print(".");}
                    }             
                target.revealAllShips();
                target.printTargetGrid();
                finished = true;
            }
        }        
    }
}
