class MajorityPrisoner extends Prisoner {

    private int tieMove;

    public MajorityPrisoner(String type) {
        super(type + " Majority");
        int tieMove;
        if (type.equals("Soft")) {
            tieMove = 1;
        }
        else {
            tieMove = 0;
        }
        this.tieMove = tieMove;
    }

    public int play() {
        //Make and return the move made by this prisoner
        int move = tieMove;
        int majority = opponent.getMajority();
        if (majority != -1) {
            //If the majority is not a tie
            move = majority;
        }
        return move;
    }

    public Prisoner clone() {
        return new MajorityPrisoner((tieMove == 1) ? "Soft" : "Hard");
    }
}