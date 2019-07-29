package de.freyama.prisoners_dilemma.prisoner

/**
 * A prisoner that will cooperate until the opponent defects.
 * Once the opponent defects, this strategy will switch to constantly defecting until the opponent defects again.
 * This will cause the strategy to switch back to constant cooperation.
 */
class Pavlov : Prisoner("Pavlov") {
    /**
     * Keep track of the current move to play
     */
    private var move = true

    /**
     * Make a move by determining by playing the currently selected move, updating it if necessary.
     */
    override fun play(): Boolean {
        // If the opponent defects, negate our current move
        if (this.opponent?.lastMove == false) {
            this.move = !this.move
        }
        this.lastMove = this.move
        return this.move
    }
}
