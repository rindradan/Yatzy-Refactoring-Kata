class Yatzy {

    fun chance(d1: Int, d2: Int, d3: Int, d4: Int, d5: Int): Int {
        var total = 0
        total += d1
        total += d2
        total += d3
        total += d4
        total += d5
        return total
    }

    fun yatzy(vararg dices: Int): Int {
        val counts = IntArray(6)
        for (die in dices)
            counts[die - 1]++
        for (i in 0..5)
            if (counts[i] == 5)
                return 50
        return 0
    }

    fun ones(d1: Int, d2: Int, d3: Int, d4: Int, d5: Int): Int {
        var sum = 0
        if (d1 == 1) sum++
        if (d2 == 1) sum++
        if (d3 == 1) sum++
        if (d4 == 1) sum++
        if (d5 == 1)
            sum++

        return sum
    }

    fun twos(d1: Int, d2: Int, d3: Int, d4: Int, d5: Int): Int {
        var sum = 0
        if (d1 == 2) sum += 2
        if (d2 == 2) sum += 2
        if (d3 == 2) sum += 2
        if (d4 == 2) sum += 2
        if (d5 == 2) sum += 2
        return sum
    }

    fun threes(d1: Int, d2: Int, d3: Int, d4: Int, d5: Int): Int {
        var s: Int = 0
        if (d1 == 3) s += 3
        if (d2 == 3) s += 3
        if (d3 == 3) s += 3
        if (d4 == 3) s += 3
        if (d5 == 3) s += 3
        return s
    }

    fun fours(vararg dices: Int): Int {
        var sum: Int = 0
        for (at in 0..4) {
            if (dices[at] == 4) {
                sum += 4
            }
        }
        return sum
    }

    fun fives(vararg dice: Int): Int {
        var s = 0
        var i: Int = 0
        while (i < dice.size) {
            if (dice[i] == 5)
                s = s + 5
            i++
        }
        return s
    }

    fun sixes(vararg dices: Int): Int {
        var sum = 0
        for (at in dices.indices)
            if (dices[at] == 6)
                sum = sum + 6
        return sum
    }

    fun onePair(d1: Int, d2: Int, d3: Int, d4: Int, d5: Int): Int {
        val counts = IntArray(6)
        counts[d1 - 1]++
        counts[d2 - 1]++
        counts[d3 - 1]++
        counts[d4 - 1]++
        counts[d5 - 1]++
        var at: Int
        at = 0
        while (at != 6) {
            if (counts[6 - at - 1] >= 2)
                return (6 - at) * 2
            at++
        }
        return 0
    }

    fun twoPairs(d1: Int, d2: Int, d3: Int, d4: Int, d5: Int): Int {
        val counts = IntArray(6)
        counts[d1 - 1]++
        counts[d2 - 1]++
        counts[d3 - 1]++
        counts[d4 - 1]++
        counts[d5 - 1]++
        var n = 0
        var score = 0
        var i = 0
        while (i < 6) {
            if (counts[6 - i - 1] >= 2) {
                n++
                score += 6 - i
            }
            i += 1
        }
        return if (n == 2)
            score * 2
        else
            0
    }

    fun threeOfAKind(vararg dices: Int): Int {
        val tallies = getTalliesByDice(dices)
        return if (hasThreeOfAKindOrMore(tallies)) {
            tallies.getIndex { it >= 3 } * 3
        } else 0
    }

    fun fourOfAKind(vararg dices: Int): Int {
        val tallies = getTalliesByDice(dices)
        return if (hasThreeOfAKindOrMore(tallies)) {
            tallies.getIndex { it >= 4 } * 4
        } else 0
    }

    fun smallStraight(vararg dices: Int): Int {
        val tallies = getTalliesByDice(dices)
        return if (hasSmallStraight(tallies)) 15 else 0
    }

    fun largeStraight(vararg dices: Int): Int {
        val tallies = getTalliesByDice(dices)
        return if (hasLargeStraight(tallies)) 20 else 0
    }

    fun fullHouse(vararg dices: Int): Int {
        val tallies: IntArray = getTalliesByDice(dices)
        return if (hasOnePair(tallies) && hasThreeOfAKind(tallies)) {
            dices.sum()
        } else 0
    }

    private fun getTalliesByDice(dices: IntArray): IntArray {
        val tallies = IntArray(6)
        for (dice in dices) {
            tallies[dice - 1]++
        }
        return tallies
    }

    private fun IntArray.getIndex(predicate: (Int) -> Boolean) = indexOfFirst(predicate) + 1
    private fun hasOnePair(tallies: IntArray): Boolean = tallies.any { it == 2 }
    private fun hasThreeOfAKind(tallies: IntArray): Boolean = tallies.any { it == 3 }
    private fun hasThreeOfAKindOrMore(tallies: IntArray): Boolean = tallies.any { it >= 3 }
    private fun hasSmallStraight(tallies: IntArray): Boolean =
        tallies.filterIndexed { index, _ -> index in 0..4 }.all { it == 1 }
    private fun hasLargeStraight(tallies: IntArray): Boolean =
        tallies.filterIndexed { index, _ -> index in 1..5 }.all { it == 1 }
}
