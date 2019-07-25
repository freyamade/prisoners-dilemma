package de.freyama.prisoners_dilemma
import de.freyama.prisoners_dilemma.prisoner.*

/**
 * A RoundRobin instance represents a tournament played in RoundRobin style between a group of Prisoners.
 * Each pairing of Prisoners will play a Match with the specified number of bouts, then a league table will be drawn.
 */
class RoundRobin(private val prisoners: Array<Prisoner>, private val bouts: Int) {

    /**
     * Run the tournament using the setup specified.
     */
    fun run(verbose: Boolean = false) {
        // Print out a header for the tournament.
        println("Running a round robin tournament, with $bouts bouts per match, and ${prisoners.size} prisoners.")
        for (i in 0..(prisoners.size - 1)) {
            // Start at (i + 1) since we don't currently handle Prisoners playing themselves.
            for (j in (i + 1)..(prisoners.size - 1)) {
                val match = Match(prisoners[i], prisoners[j], bouts)
                match.play(verbose)
            }
        }

        // After the tournament is over, print out a table from highest to lowest points.
        // Sort the prisoners Array
        prisoners.sortBy({prisoner -> -prisoner.score})

        // Print out the prisoners in order.
        for (prisoner in prisoners) {
            println(prisoner)
        }
    }
}
