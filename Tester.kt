package de.freyama.prisoners_dilemma
import de.freyama.prisoners_dilemma.prisoner.*

/**
 * The entrypoint into the program generates an array of Prisoners and puts them in matches of 100 bouts.
 */

fun main() {
    val prisoners: Array<Prisoner> = arrayOf(
        Rand(),
        Majority(MajorityType.HARD),
        Majority(MajorityType.SOFT),
        TitForTat(TitForTatType.NASTY),
        TitForTat(TitForTatType.NICE)
    )
    val bouts: Int = 100
    for (i in 0..(prisoners.size - 1)) {
        for (j in (i + 1)..(prisoners.size - 1)) {
            val match = Match(prisoners[i], prisoners[j], bouts)
            match.play()
        }
    }
    for (prisoner in prisoners) {
        println(prisoner)
    }
}
