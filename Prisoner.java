abstract class Prisoner {

    protected String strategy;
    protected int score;
    //0 is defect, 1 is cooperate
    protected int lastMove;
    //Counts how many of each move was done in this bout, using the move as an index
    protected int[] moves;
    protected Prisoner opponent;

    public Prisoner(String strategy) {
        //Set up the move count array
        this.strategy = strategy;
        //Set up moves and lastMove
        reset();
    }

    public String toString() {
        //String representation of the prisoner
        return strategy + " Prisoner: Score - " + score;
    }

    public String getStrategy() {
        return strategy;
    }

    public int getScore() {
        // Return the score for this prisoner
        return score;
    }

    public int getMajority() {
        //Returns the move this prisoner made more of, or -1 if tie
        if (moves[0] > moves[1]) {
            return 0;
        }
        else if (moves[0] < moves[1]) {
            return 1;
        }
        else {
            return -1;
        }
    }

    public int getLastMove() {
        //Return the last move made by this prisoner
        return lastMove;
    }

    public void setLastMove(int lastMove) {
        //Update this prisoner's last move
        this.lastMove = lastMove;
        //Increment the count of the moves played
        this.moves[lastMove] ++;
    }

    public void updateScore(int score) {
        //Update this prisoner's score
        this.score += score;
    }

    public void reset() {
        //Reset the prisoner's move count in between bouts
        moves = new int[2];
        //Set the last move to -1 to indicate that no last move was made
        lastMove = -1;
    }

    public void setOpponent(Prisoner opponent) {
        //Update the opponent variable to the current opponent
        this.opponent = opponent;
    }

    //Abstract play method, to be overwritten in the appropriate subclasses
    public abstract int play();

    public abstract Prisoner clone();

    public int hashCode() {
        return strategy.hashCode();
    }

    public boolean equals(Object obj) {
        //For the sake of the HashMap, check the equality by strategy
        if (this == obj) {
            return true;
        }
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        Prisoner p = (Prisoner) obj;
        return (p.strategy.equals(this.strategy));
    }
}
