package de.freyama.prisoners_dilemma.prisoner

// Basic Iterator prisoners dilemma
fun main() {
    val rand = Rand()
    val hard = Majority(MajorityType.HARD)
    val soft = Majority(MajorityType.SOFT)
    val nasty = TitForTat(TitForTatType.NASTY)
    val nice = TitForTat(TitForTatType.NICE)
    println(rand)
    println(hard)
    println(soft)
    println(nasty)
    println(nice)
}
