package de.freyama.prisoners_dilemma.prisoner

/*
 * This is an abstract class that all Prisoner Strategy classes will follow.
 * There are two moves that can be made in Prisoner's Dilemma; Defect (0) or Cooperate (1).
 */
abstract class Prisoner {
    // Instance Variables

    /**
     * The last move that the Strategy played.
     * This is necessary in two situations; either the strategy needs to know the last move it played
     * or it needs to know the last move its opponent played.
     */
    var lastMove: Boolean? = null
    /**
     * Keeps track of how many of each move was played by the strategy so far.
     * `.first` is the count of defects, and `.second` is the count of cooperates.
     */
    var moveCounts: Pair<Int, Int> = Pair(0, 0)
    /**
     * Maintains a reference to the current opponent being faced.
     * Some Prisoners remember moves their opponents use against them to determine moves to make.
     */
    var opponent: Prisoner? = null
    /**
     * The current score that the strategy has received
     */
    var score: Int = 0
    /**
     * Strategy name
     */
    val strategy: String

    constructor(strategy: String) {
        this.strategy = strategy
        // Reset the current state of the Prisoner
        this.reset()
    }

    // Overrides

    /**
     * Convert the Prisoner class into a String
     */
    override fun toString(): String = "$strategy Prisoner"

    fun equals(other: Prisoner) = this.strategy.equals(other.strategy)

    // Abstract Methods

    /**
     * Make a move.
     * Returning True symbolises cooperation, False symbolises defection.
     */
    abstract fun play(): Boolean

    // Concrete Methods

    /**
     * Add some points to the Prisoner's score
     */
    fun addPoints(points: Int) {
        this.score += points
    }

    /**
     * Get the move played most by the opponent.
     * null will be returned when the opponent has no majority.
     */
    fun getMajority(): Boolean? {
        if (this.moveCounts.first == this.moveCounts.second) {
            return null
        }
        return this.moveCounts.second > this.moveCounts.first
    }

    /**
     * Reset the state of the Prisoner, by deleting the move counts and last move values.
     * This function is called after two prisoners finish playing against eachother, as these details are recorded for a pair of Prisoners.
     */
    fun reset() {
        // Reset the moveCounts
        this.moveCounts = Pair(0, 0)
        // Set the lastMove to null to indicate there was no last move
        this.lastMove = null
    }
}
