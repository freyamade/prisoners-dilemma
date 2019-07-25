import java.util.Collections;
import java.util.Comparator;
import java.util.Arrays;

class RoundRobin {
    private Prisoner[] prisoners;
    private int bouts;

    public RoundRobin(Prisoner[] prisoners, int bouts) {
        //Constructor
        this.prisoners = prisoners;
        this.bouts = bouts;
    }

    public void run() {
        this.run(false);
    }

    public void run(boolean verbose) {
        //Run 'bouts' bouts for every pairing of prisoner, including themselves
        System.out.println("Running a round robin tournament with " + bouts + " bouts between " + prisoners.length + " prisoners");
        for (int i = 0; i < prisoners.length; i ++) {
            //Updated to make prisoners play themselves
            for (int j = i; j < prisoners.length; j ++) {
                Match match = new Match(prisoners[i], prisoners[j], bouts);
                match.play(verbose);
            }
        }
    }

    public void sort() {
        //Sort the prisoners in order of score, using the inbuilt sort method
        Collections.sort(Arrays.asList(prisoners), new Comparator<Prisoner>() {
            public int compare(Prisoner p1, Prisoner p2) {
                int score1 = p1.getScore();
                int score2 = p2.getScore();
                if (score1 > score2) {
                    return -1;
                }
                else if (score1 == score2) {
                    return 0;
                }
                else {
                    return 1;
                }
            }
        });
    }

    public void displayStats() {
        //Print out the league table
        String[] data = new String[prisoners.length];
        int longest = 0;
        for(int i = 0; i < prisoners.length; i ++) {
            String prisonerData = prisoners[i].toString();
            int length = prisonerData.length();
            if (length > longest) {
                longest = length;
            }
            data[i] = prisonerData;
        }
        Table table = new Table(data, "Round Robin Results", longest);
        System.out.println(table);
    }
}
