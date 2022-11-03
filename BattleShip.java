public class BattleShip {
    public static void main(String[] args ) {
        System.out.println("\nWelcome to Battle Ship!\n");
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
            grids.printGrids();
            if (target.isFleetDestroyed()) {
                System.out.println("\nCongratulations You Won!!!\nThank you for playing");
                finished = true;
            }
            System.out.print("\nThe other player is making his move now");
            for (int i=0; i<4; i++) {                
                try {
                Thread.sleep(1000);
                } 
                catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                }
                if (i!=3) {System.out.print(".");}
                }
            ocean.bombard(com.createBomb());
            grids.printGrids();
            if (ocean.isFleetDestroyed()) {
                System.out.println("\nGame Over\nYou lost!");
                target.revealAllShips();
                finished = true;
            }


        }
        
    }
}
