package de.freyama.prisoners_dilemma.prisoner

/**
 * An AdaptiveTitForTat Prisoner works by adapting to the world around them.
 * The strategy works as follows;
 *
 * An adaption rate `r` is provided at initialisation.
 * This rate is used to compute a continuous value `world` according to the moves the opponent makes.
 * The logic of this calculation is as follows;
 *
 * if opponent cooperated in the last bout
 * then
 *   world += r * (1 - world)
 * else
 *   world += r * (0 - world)
 * end
 *
 * Then, using the value of `world`, the Prisoner determines what move to make.
 * They will cooperate if `world` >= 0.5, otherwise they will defect
 */
class AdaptiveTitForTat(private val adaption: Double) : Prisoner("TitForTat (ADAPTIVE) (r=$adaption)") {
    private var world: Double = 1.0

    /**
     * Make a move be adapting to the world after the previous move and using the new state to pick a move.
     */
    override fun play(): Boolean {
        adapt()
        val move = this.world >= 0.5
        this.lastMove = move
        return move
    }

    /**
     * Adapt to the world using the opponent's last move
     */
    private fun adapt() {
        val lastMove = this.opponent?.lastMove
        if (lastMove == null) {
            return
        }

        if (lastMove) {
            // Cooperated, increase world value
            this.world += this.adaption * (1 - world)
        }
        else {
            // Defected, decrease world value
            this.world += this.adaption * (0 - world)
        }
    }

    /**
     * Override reset to set the world value back to 1.0
     */
    override fun reset() {
        this.world = 1.0
        super.reset()
    }
}
