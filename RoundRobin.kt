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
        println("Running a round robin tournament, with $bouts bouts per match, and ${this.prisoners.size} prisoners.")
        for (i in 0..(this.prisoners.size - 1)) {
            for (j in i..(this.prisoners.size - 1)) {
                val match = Match(this.prisoners[i], this.prisoners[j], bouts)
                match.play(verbose)
            }
        }

        // After the tournament is over, print out a table from highest to lowest points.
        // Sort the prisoners Array
        this.prisoners.sortBy({prisoner -> -prisoner.score})

        // Draw a nice table
        this.renderTable()
    }

    private fun renderTable() {
        // Firstly, generate the column sizes.
        val column1Size = this.prisoners.map({prisoner -> prisoner.strategy.length}).max()!!
        var maxScore = this.prisoners.map({prisoner -> prisoner.score}).max()!!
        var column2Size = 0
        while (maxScore > 0) {
            maxScore = maxScore / 10
            column2Size++
        }

        // Print the table
        val row = "│ %-${column1Size}s │ %${column2Size}s │"
        println("┌${"─".repeat(column1Size + 2)}┬${"─".repeat(column2Size + 2)}┐")
        for (prisoner in this.prisoners) {
            println(row.format(prisoner.strategy, prisoner.score))
        }
        println("└${"─".repeat(column1Size + 2)}┴${"─".repeat(column2Size + 2)}┘")
    }
}
