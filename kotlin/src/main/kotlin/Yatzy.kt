class Yatzy {

    fun chance(vararg dices: Int): Int = dices.sum()

    fun yatzy(vararg dices: Int): Int {
        val tallies = dices.getTalliesByDice()
        return if (tallies.hasYatzy()) 50 else 0
    }

    fun ones(vararg dices: Int): Int = dices.countNumberOccurrences(1)

    fun twos(vararg dices: Int): Int = dices.countNumberOccurrences(2)

    fun threes(vararg dices: Int): Int = dices.countNumberOccurrences(3)

    fun fours(vararg dices: Int): Int = dices.countNumberOccurrences(4)

    fun fives(vararg dices: Int): Int = dices.countNumberOccurrences(5)

    fun sixes(vararg dices: Int): Int = dices.countNumberOccurrences(6)

    fun onePair(vararg dices: Int): Int {
        val tallies = dices.getTalliesByDice()
        return tallies.getMaxNumberByOccurrences(2)
    }

    fun twoPairs(vararg dices: Int): Int {
        val tallies = dices.getTalliesByDice()
        return tallies.getSumNumberByOccurrences(2, 2)
    }

    fun threeOfAKind(vararg dices: Int): Int {
        val tallies = dices.getTalliesByDice()
        return tallies.getMaxNumberByOccurrences(3)
    }

    fun fourOfAKind(vararg dices: Int): Int {
        val tallies = dices.getTalliesByDice()
        return tallies.getMaxNumberByOccurrences(4)
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

    private fun IntArray.countNumberOccurrences(number: Int): Int = filter { it == number }.sum()

    private fun Map<Int, Int>.getMaxNumberByOccurrences(number: Int, occurrence: Int = 1): Int =
        getNumberByOccurrences(number, occurrence)?.maxOrNull() ?: 0

    private fun Map<Int, Int>.getSumNumberByOccurrences(number: Int, occurrence: Int = 1): Int =
        getNumberByOccurrences(number, occurrence)?.sum() ?: 0

    private fun Map<Int, Int>.getNumberByOccurrences(number: Int, occurrence: Int = 1): List<Int>? =
        filter { it.value >= number }.takeIf { it.count() >= occurrence }?.keys?.map { it * number }

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
