package de.freyama.prisoners_dilemma.prisoner

/**
 * A prisoner that cycles through a specific pattern defined before the tournaments start.
 */
class Periodic : Prisoner {
    private val pattern: BooleanArray
    private var currentMove: Int = 0

    constructor(vararg pattern: Boolean) : super("Periodic (${pattern.map({x -> if (x) "C" else "D"}).joinToString(", ")})") {
        this.pattern = pattern
    }

    /**
     * Make a move by cycling through the defined pattern
     */
    override fun play(): Boolean {
        val move = this.pattern[this.currentMove]
        this.currentMove = (currentMove + 1) % this.pattern.size
        this.lastMove = move
        return move
    }

    /**
     * Reset the Prisoner by setting the currentMove back to the start of the pattern.
     */
    override fun reset() {
        this.currentMove = 0
        super.reset()
    }
}


