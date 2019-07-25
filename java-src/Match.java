class Match {
    //A match is between two prisoners and is made up of n bouts

    private Prisoner prisoner1;
    private Prisoner prisoner2;
    private int bouts;

    //Use this along with the moves to get each player's score
    //my_score = scores[my_move][their_move]
    private static final int[][] scores = {{1, 5}, {0, 3}};

    public Match(Prisoner prisoner1, Prisoner prisoner2, int bouts) {
        //Constructor
        this.prisoner1 = prisoner1;
        this.prisoner2 = prisoner2;
        this.bouts = bouts;

        //Update the prisoner's opponents instance variables
        prisoner1.setOpponent(prisoner2);
        prisoner2.setOpponent(prisoner1);
    }

    public void play() {
        this.play(false);
    }

    public void play(boolean verbose) {
        //Play the match
        if (verbose) {
            System.out.println("Match between " + prisoner1 + " and " + prisoner2);
        }
        for (int i = 0; i < bouts; i ++) {
            //Check are is the prisoner playing themselves
            if (prisoner1 != prisoner2) {
                //Get the moves
                int move1 = prisoner1.play();
                int move2 = prisoner2.play();

                //Update each prisoner's last move
                prisoner1.setLastMove(move1);
                prisoner2.setLastMove(move2);

                //Update the prisoners' scores
                prisoner1.updateScore(scores[move1][move2]);
                prisoner2.updateScore(scores[move2][move1]);

                if (verbose) {
                    System.out.println("Round : " + i + " - Prisoner1 move : " + move1 + ", Prisoner2 move : " + move2);
                    System.out.println("\tScores - P1 : " + scores[move1][move2] + ", P2 : " + scores[move2][move1]);
                }
            }
            else {
                //If the prisoner is playing themself, they make the same move and update the score once
                int move = prisoner1.play();

                //Update the prisoner's last move
                prisoner1.setLastMove(move);

                //Update the prisoner's score
                prisoner1.updateScore(scores[move][move]);

                if (verbose) {
                    System.out.println("Round : " + i + " - Prisoner move : " + move);
                    System.out.println("Score - " + scores[move][move]);
                }
            }

            if (verbose) {
                System.out.println("===============================================");
            }
        }
        //Reset the prisoners for the next bout
        prisoner1.reset();
        prisoner2.reset();
        if (verbose) {
            System.out.println("******************************************\n");
        }
    }
}