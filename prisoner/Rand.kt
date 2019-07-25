package de.freyama.prisoners_dilemma.prisoner
import kotlin.random.Random

/**
 * A prisoner that randomly chooses its move based with a 50% chance of using either move.
 */
class Rand() : Prisoner("Random") {
    /**
     * Make a move by randomly picking either true or false
     */
    override fun play(): Boolean {
        val move = Random.nextBoolean()
        this.lastMove = move
        return move
    }
}
