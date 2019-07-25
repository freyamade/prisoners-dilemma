class Gradual extends Prisoner {

    private int opDefections;
    private int defectionsToMake;
    private int calmingCoops;

    public Gradual() {
        super("Gradual");
    }

    public int play() {
        //Are we calming them down?
        if (calmingCoops > 0) {
            calmingCoops -= 1;
            return 1;
        }
        //Did opponent defect last time?
        if (opponent.getLastMove() == 0) {
            opDefections += 1;
            defectionsToMake = opDefections;
            calmingCoops = 2;
        }
        if (defectionsToMake > 0) {
            defectionsToMake -= 1;
            return 0;
        }
        else {
            //If nothing else, cooperate
            return 1;
        }
    }

    public void reset() {
        opDefections = 0;
        defectionsToMake = 0;
        calmingCoops = 0;
        super.reset();
    }

    public Prisoner clone() {
        return new Gradual();
    }
}