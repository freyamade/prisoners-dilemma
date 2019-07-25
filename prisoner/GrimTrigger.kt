package de.freyama.prisoners_dilemma.prisoner

/**
 * A prisoner will always cooperate until the opponent defects for the first time.
 * After that, they will always defect.
 */
class GrimTrigger : Prisoner("Grim Trigger") {
    private var defected = false

    /**
     * Make a move by determining if the trigger has been set off.
     */
    override fun play(): Boolean {
        if (!defected) {
            // We need to check to make sure the opponent has defected yet
            this.defected = this.opponent?.lastMove != false
        }
        val move: Boolean = !this.defected
        this.lastMove = move
        return move
    }
}
