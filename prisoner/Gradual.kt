package de.freyama.prisoners_dilemma.prisoner

/**
 * A prisoner that punishes defects by defecting `n` times, before cooperating twice.
 * `n` is the number of times the opponent has defected in the match so far.
 * When not punishing defects, they will always Cooperate.
 *
 * A flaw I made implementing the version in Java (I think) was that the punishment system could get interrupted by the opponent defecting again.
 * Reading back over the documentation on the strategy, I don't think this is intended.
 */
class Gradual : Prisoner("Gradual") {
    /**
     * The number of defections made by the opponent so far
     */
    private var defectionsPlayed: Int = 0

    /**
     * The number of defections that needs to be made by this Prisoner to finish punishing the opponent
     */
    private var defectionsToPlay: Int = 0

    /**
     * The number of cooperations to be played after the punishment period is over
     */
    private var cooperationsToPlay: Int = 0

    /**
     * Make a move by determining if we are currently punishing or calming the opponent.
     * We also need to determine if we need to start punishing the opponent, or if we just cooperate.
     */
    override fun play(): Boolean {
        if (this.defectionsToPlay == 0 && this.cooperationsToPlay == 0) {
            // We're not already punishing or calming, so figure out if we need to start doing so.

            // Check if the opponent defected in the last move
            val lastMove = this.opponent?.lastMove
            if (lastMove != false) {
                // Just cooperate
                this.lastMove = true
                return true
            }
            // They've defected
            // Increment the number of defections played, and set the the toPlay variables
            this.defectionsPlayed++
            this.defectionsToPlay = this.defectionsPlayed
            this.cooperationsToPlay = 2
        }
        // Firstly check if we need to play a defection
        if (this.defectionsToPlay > 0) {
            // We're still punishing, play a defect
            this.defectionsToPlay--
            this.lastMove = false
            return false
        }
        else {
            // Otherwise, we should be cooperating
            this.cooperationsToPlay--
            this.lastMove = true
            return true
        }
    }

    /**
     * Override reset to set the custom fields back to 0
     */
    override fun reset() {
        this.defectionsPlayed = 0
        this.defectionsToPlay = 0
        this.cooperationsToPlay = 0
        super.reset()
    }
}
