class AllIn extends Prisoner {
    private int move;

    public AllIn(int move) {
        super((move == 1) ? "Naive" : "Suspicious");
        this.move = move;
    }

    public int play() {
        return move;
    }

    public Prisoner clone() {
        return new AllIn(move);
    }
}