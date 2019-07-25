class ReverseTitForTat extends Prisoner {

    //Starts by defecting, then plays opposite of opponents move

    public ReverseTitForTat() {
        super("Reverse TFT");
    }

    public int play() {
        if (this.lastMove != -1) {
            return Math.abs(opponent.getLastMove() - 1);
        }
        return 0;
    }

    public Prisoner clone() {
        return new ReverseTitForTat();
    }

}