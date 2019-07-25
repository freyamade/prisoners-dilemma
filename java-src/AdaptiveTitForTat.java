class AdaptiveTitForTat extends Prisoner {
    /*Works as follows
    An adaption rate r is used to compute a continuous variable ‘world’ according to the history moves of the opponent. The logic of the strategy is shown as below.

    If (opponent played C in the last cycle) then
    world = world + r*(1-world), r is the adaptation rate
    else
    world = world + r*(0-world)
    If (world >= 0.5) play C, else play D
    */

    private double r;
    private double world;

    public AdaptiveTitForTat(double r) {
        //Constructor where 'r' is the adaptation rate 0 < r <= 1
        super("Adaptive (r=" + r + ")");
        this.r = r;
        reset();
    }

    public int play() {
        //Make and return a move
        if (lastMove != -1) {
            //Not the first round of the game
            if (opponent.getLastMove() == 1) {
                world += r*(1-world);
            }
            else {
                world += r * (0-world);
            }
        }
        return (world >= 0.5) ? 1 : 0;
    }

    public void reset() {
        world = 1.0;
        super.reset();
    }

    public Prisoner clone() {
        //Return an offspring (for evolution tournament)
        return new AdaptiveTitForTat(r);
    }
}