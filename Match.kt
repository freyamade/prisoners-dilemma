package de.freyama.prisoners_dilemma
import de.freyama.prisoners_dilemma.prisoner.*

/**
 * A Match instance represents a matchup between two prisoners.
 * Each match has a number of bouts that are played between the two prisoners involved.
 */
class Match {
    /**
     * Map the pair of moves made by the Prisoners to the score received.
     * The score for a move has a key of Pair(myMove, theirMove) for each Prisoner
     */
    private val scoreMatrix: HashMap<Pair<Boolean, Boolean>, Int> = hashMapOf(
        // Both players defect
        Pair(false, false) to 1,
        // You defect, they cooperate
        Pair(false, true) to 5,
        // You cooperate, they defect
        Pair(true, false) to 0,
        // Both players cooperate
        Pair(true, true) to 3
    )

    // Keep track of the prisoners in the match
    private val prisoner1: Prisoner
    private val prisoner2: Prisoner

    // Keep track of the number of bouts in the match
    private val bouts: Int

    constructor(prisoner1: Prisoner, prisoner2: Prisoner, bouts: Int) {
        this.prisoner1 = prisoner1
        this.prisoner2 = prisoner2
        this.bouts = bouts

        // Set the prisoners' opponents pointers
        prisoner1.opponent = prisoner2
        prisoner2.opponent = prisoner1
    }

    /**
     * Play the match by running `bouts` rounds, having Prisoners pick moves and updating scores appropriately.
     * If the verbose flag is set, print out extra information about the match as it plays.
     */
    fun play(verbose: Boolean = false) {
        if (verbose) {
            // Print a header
            println("\nMatch between $prisoner1 and $prisoner2")
        }

        // Play each bout
        for (bout in 0..this.bouts) {
            // Start by assuming that the Prisoners cannot play themselves.
            val move1 = prisoner1.play()
            val move2 = prisoner2.play()

            // Get the scores for each prisoner
            val score1 = scoreMatrix[Pair(move1, move2)]!!
            var score2 = scoreMatrix[Pair(move2, move1)]!!

            // Update the Prisoners' scores
            prisoner1.addPoints(score1)
            prisoner2.addPoints(score2)

            // Print out debug info if verbose is true
            if (verbose) {
                println("Round #$bout - Prisoner1 move: $move1. Prisoner2 move: $move2")
                println("\tScores - Prisoner1: $score1. Prisoner2: $score2")
            }
        }

        // After the Match is over, reset the memories of the prisoners
        prisoner1.reset()
        prisoner2.reset()
    }
}
