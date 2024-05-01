class Yatzy {

    fun chance(vararg dices: Int): Int = dices.sum()

    fun yatzy(vararg dices: Int): Int {
        val tallies = getTalliesByDice(dices)
        return if (hasYatzy(tallies)) 50 else 0
    }

    fun ones(vararg dices: Int): Int = dices.countNumberOccurrence(1)

    fun twos(vararg dices: Int): Int = dices.countNumberOccurrence(2)

    fun threes(vararg dices: Int): Int = dices.countNumberOccurrence(3)

    fun fours(vararg dices: Int): Int = dices.countNumberOccurrence(4)

    fun fives(vararg dices: Int): Int = dices.countNumberOccurrence(5)

    fun sixes(vararg dices: Int): Int = dices.countNumberOccurrence(6)

    private fun IntArray.countNumberOccurrence(number: Int): Int = filter { it == number }.sum()

    fun onePair(vararg dices: Int): Int {
        val tallies = getTalliesByDice(dices)
        return tallies.countSameNumber(2)
    }

    fun twoPairs(vararg dices: Int): Int {
        val tallies = getTalliesByDice(dices)
        return tallies.filter { it.value >= 2 }.takeIf { it.count() >= 2 }?.keys?.sumOf { it * 2 } ?: 0
    }

    fun threeOfAKind(vararg dices: Int): Int {
        val tallies = getTalliesByDice(dices)
        return tallies.countSameNumber(3)
    }

    fun fourOfAKind(vararg dices: Int): Int {
        val tallies = getTalliesByDice(dices)
        return tallies.countSameNumber(4)
    }

    private fun Map<Int, Int>.countSameNumber(number: Int) =
        filter { it.value >= number }.keys.maxOfOrNull { it * number } ?: 0

    fun smallStraight(vararg dices: Int): Int {
        val tallies = getTalliesByDice(dices)
        return if (hasSmallStraight(tallies)) 15 else 0
    }

    fun largeStraight(vararg dices: Int): Int {
        val tallies = getTalliesByDice(dices)
        return if (hasLargeStraight(tallies)) 20 else 0
    }

    fun fullHouse(vararg dices: Int): Int {
        val tallies = getTalliesByDice(dices)
        return if (isFullHouse(tallies)) dices.sum() else 0
    }

    private fun getTalliesByDice(dices: IntArray): Map<Int, Int> {
        val tallies = HashMap<Int, Int>(6)
        for (dice in dices) {
            tallies[dice] = (tallies[dice] ?: 0) + 1
        }
        return tallies
    }

    private fun isFullHouse(tallies: Map<Int, Int>): Boolean =
        hasOnePair(tallies) && hasThreeOfAKind(tallies)

    private fun hasOnePair(tallies: Map<Int, Int>): Boolean = tallies.any { it.value == 2 }
    private fun hasThreeOfAKind(tallies: Map<Int, Int>): Boolean = tallies.any { it.value == 3 }
    private fun hasSmallStraight(tallies: Map<Int, Int>): Boolean =
        tallies.filterKeys { it in 0..4 }.all { it.value == 1 }

    private fun hasLargeStraight(tallies: Map<Int, Int>): Boolean =
        tallies.filterKeys { it in 1..5 }.all { it.value == 1 }
    private fun hasYatzy(tallies: Map<Int, Int>): Boolean = tallies.any { it.value == 5 }
}
