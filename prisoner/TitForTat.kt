package de.freyama.prisoners_dilemma.prisoner

/**
 * An Enum class indicating the types of Majority Prisoner that can be in the system, along with their tie move
 */
enum class TitForTatType(val firstMove: Boolean) {
    NASTY(false),
    NICE(true),
}

/**
 * A prisoner that uses the move that the opponent used last round.
 * A TitForTat Prisoner can be NASTY or NICE, indicating they will open with Defect or Cooperate respectively.
 */
class TitForTat : Prisoner {
    private val firstMove: Boolean

    constructor(type: TitForTatType) : super("TitForTat (${type.name})") {
        this.firstMove = type.firstMove
    }

    /**
     * Make a move by replaying the opponent's last move, or the initially defined firstMove if there is none.
     */
    override fun play(): Boolean {
        val lastMove = this.opponent?.lastMove
        val move: Boolean = if (lastMove == null) this.firstMove else lastMove
        this.lastMove = move
        return move
    }
}
