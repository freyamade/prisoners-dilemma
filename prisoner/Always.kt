package de.freyama.prisoners_dilemma.prisoner

/**
 * A prisoner that uses one move only for all of its matches.
 */
class Always(private val move: Boolean) : Prisoner("Always ${if (move) "Cooperate" else "Defect"}") {
    /**
     * Make a move by returning the one kind of move we always use
     */
    override fun play(): Boolean {
        val move = this.move
        this.lastMove = move
        return move
    }
}
