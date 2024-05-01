class Yatzy {

    fun chance(vararg dices: Int): Int = dices.sum()

    fun yatzy(vararg dices: Int): Int {
        val tallies = dices.getTalliesByDice()
        return if (tallies.hasYatzy()) 50 else 0
    }

    fun ones(vararg dices: Int): Int = dices.countNumberOccurrence(1)

    fun twos(vararg dices: Int): Int = dices.countNumberOccurrence(2)

    fun threes(vararg dices: Int): Int = dices.countNumberOccurrence(3)

    fun fours(vararg dices: Int): Int = dices.countNumberOccurrence(4)

    fun fives(vararg dices: Int): Int = dices.countNumberOccurrence(5)

    fun sixes(vararg dices: Int): Int = dices.countNumberOccurrence(6)

    fun onePair(vararg dices: Int): Int {
        val tallies = dices.getTalliesByDice()
        return tallies.countSameNumber(2)
    }

    fun twoPairs(vararg dices: Int): Int {
        val tallies = dices.getTalliesByDice()
        return tallies.filter { it.value >= 2 }.takeIf { it.count() >= 2 }?.keys?.sumOf { it * 2 } ?: 0
    }

    fun threeOfAKind(vararg dices: Int): Int {
        val tallies = dices.getTalliesByDice()
        return tallies.countSameNumber(3)
    }

    fun fourOfAKind(vararg dices: Int): Int {
        val tallies = dices.getTalliesByDice()
        return tallies.countSameNumber(4)
    }

    fun smallStraight(vararg dices: Int): Int {
        val tallies = dices.getTalliesByDice()
        return if (tallies.hasSmallStraight()) 15 else 0
    }

    fun largeStraight(vararg dices: Int): Int {
        val tallies = dices.getTalliesByDice()
        return if (tallies.hasLargeStraight()) 20 else 0
    }

    fun fullHouse(vararg dices: Int): Int {
        val tallies = dices.getTalliesByDice()
        return if (tallies.isFullHouse()) dices.sum() else 0
    }

    private fun IntArray.countNumberOccurrence(number: Int): Int = filter { it == number }.sum()

    private fun Map<Int, Int>.countSameNumber(number: Int) =
        filter { it.value >= number }.keys.maxOfOrNull { it * number } ?: 0

    private fun IntArray.getTalliesByDice(): Map<Int, Int> {
        val tallies = HashMap<Int, Int>(6)
        for (dice in this) {
            tallies[dice] = (tallies[dice] ?: 0) + 1
        }
        return tallies
    }

    private fun Map<Int, Int>.isFullHouse(): Boolean = hasOnePair() && hasThreeOfAKind()
    private fun Map<Int, Int>.hasOnePair(): Boolean = any { it.value == 2 }
    private fun Map<Int, Int>.hasThreeOfAKind(): Boolean = any { it.value == 3 }
    private fun Map<Int, Int>.hasSmallStraight(): Boolean = filterKeys { it in 0..4 }.all { it.value == 1 }
    private fun Map<Int, Int>.hasLargeStraight(): Boolean = filterKeys { it in 1..5 }.all { it.value == 1 }
    private fun Map<Int, Int>.hasYatzy(): Boolean = any { it.value == 5 }
}
