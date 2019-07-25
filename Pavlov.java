class Pavlov extends Prisoner {

    public Pavlov() {
        //Constructor
        super("Pavlov");
    }

    public int play() {
        //Make a move
        if (this.getLastMove() == opponent.getLastMove()) {
            return 1;
        }
        return 0;
    }

    public Prisoner clone() {
        return new Pavlov();
    }
}