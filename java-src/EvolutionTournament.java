import java.util.HashMap;
import java.util.ArrayList;

class EvolutionTournament {
    private int generations;
    private int bouts;
    private Prisoner[] prisonerTypes;
    private Prisoner[] generation;
    private HashMap<Prisoner, Integer> scores;
    private int currentGen;

    public EvolutionTournament(int initialSize, int generations, int bouts, Prisoner[] prisonerTypes) {
        this.generations = generations;
        this.bouts = bouts;
        this.prisonerTypes = prisonerTypes;
        scores = new HashMap<Prisoner, Integer>();
        generation = new Prisoner[initialSize * prisonerTypes.length];
        for(Prisoner p : prisonerTypes) {
            scores.put(p, initialSize);
        }
        //Creates and prints Generation 0
        this.createGeneration();
    }

    public void run() {
        //Run the evolution tournament, as a round robin
        for(currentGen = 1; currentGen < generations; currentGen ++) {

            //Run the round robin tournament
            RoundRobin tourny = new RoundRobin(generation, bouts);
            tourny.run();

            //Now start creating the next generation
            resetScores();
            int newGen = 0;
            for (Prisoner p : generation) {
                int score = Math.abs(p.getScore());
                newGen += score;
                int oldscore = scores.get(p);
                scores.put(p, score + oldscore);
            }
            generation = new Prisoner[newGen];
            createGeneration();
        }
    }

    private void createGeneration() {
        int index = 0;
        for(Prisoner p : prisonerTypes) {
            int offspring = scores.get(p);
            for (int i = 0; i < offspring; i++) {
                generation[index] = p.clone();
                index ++;
            }
        }
        displayStats();
    }

    private void resetScores() {
        for(Prisoner p : prisonerTypes) {
            scores.put(p, 0);
        }
    }

    public void displayStats() {
        //Displays all generational statistics
        System.out.println("Generation " + currentGen);
        for (Prisoner p : prisonerTypes) {
            System.out.println("\t #" + p + " : " + scores.get(p));
        }
        System.out.println("=================================================");
    }
}