package de.freyama.prisoners_dilemma
import de.freyama.prisoners_dilemma.prisoner.*

/**
 * The entrypoint into the program generates an array of Prisoners and puts them in matches of 100 bouts.
 */

fun main() {
    val prisoners: Array<Prisoner> = arrayOf(
        AdaptiveTitForTat(0.1),
        Always(true),
        Always(false),
        Majority(MajorityType.HARD),
        Majority(MajorityType.SOFT),
        Rand(),
        TitForTat(TitForTatType.NASTY),
        TitForTat(TitForTatType.NICE),
        Periodic(true, true, false),
        Periodic(true, false),
        Periodic(false, false, true),
        Periodic(false, true)
    )
    val bouts: Int = 100

    // Create and run a RoundRobin tournament.
    RoundRobin(prisoners, bouts).run()
}
