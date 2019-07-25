import java.util.Arrays;

class Periodic extends Prisoner {
    private int[] moves;
    private int move;

    public Periodic(int ... moves) {
        super("Periodic (" + Arrays.toString(moves) + ")");
        this.moves = moves;
    }

    public int play() {
        //Make the next move in the moves array
        int toPlay = moves[move];
        move = (move + 1) % moves.length;
        return toPlay;
    }

    public void reset() {
        move = 0;
        super.reset();
    }

    public Prisoner clone() {
        return new Periodic(moves);
    }
}