package de.freyama.prisoners_dilemma.prisoner

/**
 * A prisoner that plays like Tit for Tat except it only defects when the opponent defects twice.
 */
class TitForTwoTats : Prisoner("TitForTwoTats") {
    private var defected: Boolean = false

    /**
     * Make a move by responding to the opponent's last move.
     */
    override fun play(): Boolean {
        val lastMove = this.opponent?.lastMove
        var move: Boolean = true
        // Determine if we should defect
        if (lastMove == false) {
            if (this.defected) {
                move = false
                this.defected = false
            }
            else {
                this.defected = true
            }
        }
        else {
            // If they cooperated, set the defected flag back to false
            this.defected = false
        }
        this.lastMove = move
        return move
    }

    /**
     * Override the reset function to set the flag back to false
     */
    override fun reset() {
        this.defected = false
        super.reset()
    }
}
