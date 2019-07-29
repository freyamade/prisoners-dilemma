package de.freyama.prisoners_dilemma.prisoner

/**
 * A prisoner that uses the opposite of move that the opponent used last round.
 * Will start by defecting before starting into this pattern.
 */
class ReverseTitForTat : Prisoner("Reverse TitForTat") {

    /**
     * Make a move by playing the opposite of the opponent's last move, defecting if there is none.
     */
    override fun play(): Boolean {
        val lastMove = this.opponent?.lastMove
        val move: Boolean = if (lastMove == null) false else !lastMove
        this.lastMove = move
        return move
    }
}
