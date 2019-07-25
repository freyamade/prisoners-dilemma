class TitForTatPrisoner extends Prisoner {

    private int firstMove;

    public TitForTatPrisoner(String type) {
        //Constructor
        super(type + " Tit for Tat");
        int firstMove;
        if (type.equals("Nice")) {
            firstMove = 1;
        }
        else {
            firstMove = 0;
        }
        this.firstMove = firstMove;
    }

    public int play() {
        //Make and return the move made by this prisoner
        int move = firstMove;
        if (this.lastMove != -1) {
            //If this prisoner has made a last move, so has the opponent
            move = opponent.getLastMove();
        }
        return move;
    }

    public Prisoner clone() {
        return new TitForTatPrisoner((firstMove == 1) ? "Nice" : "Nasty");
    }

}