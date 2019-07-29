package de.freyama.prisoners_dilemma.prisoner

/**
 * A prisoner that plays like Tit for Tat except it defects twice whenever the opponent defects.
 */
class TwoTitsForTat : Prisoner("TwoTitsForTat") {
    private var toDefect: Boolean = false

    /**
     * Make a move by responding to the opponent's last move.
     */
    override fun play(): Boolean {
        val lastMove = this.opponent?.lastMove
        var move: Boolean = true
        // If we have the `toDefect` flag set, then we defect
        if (this.toDefect) {
            move = false
        }
        else {
            // Determine if we need to defect and set the flag
            if (lastMove == false) {
                this.toDefect = true
                move = false
            }
        }
        this.lastMove = move
        return move
    }

    /**
     * Override the reset function to set the flag back to false
     */
    override fun reset() {
        this.toDefect = false
        super.reset()
    }
}
