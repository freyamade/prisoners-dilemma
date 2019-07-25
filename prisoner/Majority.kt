package de.freyama.prisoners_dilemma.prisoner

/**
 * An Enum class indicating the types of Majority Prisoner that can be in the system, along with their tie move
 */
enum class MajorityType(val tieMove: Boolean) {
    HARD(false),
    SOFT(true),
}

/**
 * A prisoner that uses the move that has been used most by its current opponent.
 * A Majority type Prisoner can be either "Hard" or "Soft", indicating that the either Defect or Cooperate on ties respectively.
 */
class Majority : Prisoner {
    private val tieMove: Boolean

    constructor(type: MajorityType) : super("Majority (${type.name})") {
        this.tieMove = type.tieMove
    }

    /**
     * Make a move by playing the opponent's most common move, falling back to the initially defined `tieMove` if there is none.
     */
    override fun play(): Boolean {
        val opponentMajority = this.opponent?.getMajority()
        val move: Boolean =  if (opponentMajority == null) this.tieMove else opponentMajority
        this.lastMove = move
        return move
    }
}
