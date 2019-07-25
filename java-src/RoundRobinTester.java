class RoundRobinTester{

    public static final Prisoner[] prisoners = {
            new RandPrisoner(),
            new ReverseTitForTat(),
            new Grudger(),
            new Gradual(),
            new AllIn(1),
            new AllIn(0),
            new AdaptiveTitForTat(0.1),
            new TitForTatPrisoner("Nice"),
            new TitForTatPrisoner("Nasty"),
            new MajorityPrisoner("Soft"),
            new MajorityPrisoner("Hard"),
            new Pavlov(),
            new Periodic(1,1,0), //C, C, D
            new Periodic(1,0),   //C, D
            new Periodic(0,0,1), //D, D, C
            new Periodic(0, 1)   //D, C
        };

    public static void main(String[] args) {
        //Tester for a normal Round Robin


        int bouts = 100;
        RoundRobin roundRobin = new RoundRobin(prisoners, bouts);
        roundRobin.run(false);
        roundRobin.sort();
        roundRobin.displayStats();
    }
}