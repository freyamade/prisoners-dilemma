class Grudger extends Prisoner {
    //Co-operates until opponent defects
    private boolean betrayed;

    public Grudger() {
        //Constructor
        super("Grudger");
    }

    public int play() {
        //Make a move and return it
        if (!betrayed && opponent.getLastMove() == 0) {
            //They haven't been betrayed until now
            //!betrayed is for shortcutting
            betrayed = true;
        }
        //If they haven't been betrayed, return 1, else 0
        return (betrayed) ? 0 : 1;
    }

    public void reset() {
        //Reset this prisoner
        betrayed = false;
        super.reset();
    }

    public Prisoner clone() {
        return new Grudger();
    }
}