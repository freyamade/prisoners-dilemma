import java.util.Arrays;

class EvolutionTournamentTester {

    public static void main(String[] args) {
        //args - initialSize, generations, bouts
        int initialSize;
        int generations;
        int bouts;
        int prisoners;
        try {
            initialSize = Integer.parseInt(args[0]);
            generations = Integer.parseInt(args[1]);
            bouts = Integer.parseInt(args[2]);
            prisoners = Integer.parseInt(args[3]);
        }
        catch (Exception e) {
            System.out.println("Error in args, running with default variables");
            initialSize = 1;
            generations = 3;
            bouts = 2;
            prisoners = -1;
        }
        Prisoner[] prisonerTypes;
        if (prisoners == -1) {
            prisonerTypes = RoundRobinTester.prisoners;
        }
        else {
            prisonerTypes = Arrays.<Prisoner>copyOf(RoundRobinTester.prisoners, prisoners);
        }
        System.out.println("Playing an evolution tournament until generation " + (generations - 1));
        EvolutionTournament et = new EvolutionTournament(initialSize, generations, bouts, prisonerTypes);
        et.run();
    }
}