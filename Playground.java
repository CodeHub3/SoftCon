interface Playground {
    public void addToFleet(Ship pShip);
    public boolean shipDoesNotOverlap(Ship ship);
    public void addMiss(Position userBomb);
    public void addHit(Position userBomb);
    public void revealShip(Ship pShip);
    public boolean isFleetDestroyed();
    public void bombard(Position bomb);


}
