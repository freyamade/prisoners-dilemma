import java.util.Random;

class RandPrisoner extends Prisoner {

    private Random randy;

    public RandPrisoner() {
        //Constructor
        super("Random");
        randy = new Random();
    }

    public int play() {
        //Make and return the move made by this prisoner
        int move = (int) Math.round(randy.nextDouble());
        return move;
    }

    public Prisoner clone() {
        return new RandPrisoner();
    }
}