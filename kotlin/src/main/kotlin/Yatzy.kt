
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

    fun threeOfAKind(d1: Int, d2: Int, d3: Int, d4: Int, d5: Int): Int {
        val t: IntArray = IntArray(6)
        t[d1 - 1]++
        t[d2 - 1]++
        t[d3 - 1]++
        t[d4 - 1]++
        t[d5 - 1]++
        for (i in 0..5)
            if (t[i] >= 3)
                return (i + 1) * 3
        return 0
    }

    fun fourOfAKind(_1: Int, _2: Int, d3: Int, d4: Int, d5: Int): Int {
        val tallies: IntArray = IntArray(6)
        tallies[_1 - 1]++
        tallies[_2 - 1]++
        tallies[d3 - 1]++
        tallies[d4 - 1]++
        tallies[d5 - 1]++
        for (i in 0..5)
            if (tallies[i] >= 4)
                return (i + 1) * 4
        return 0
    }

    fun smallStraight(d1: Int, d2: Int, d3: Int, d4: Int, d5: Int): Int {
        val tallies: IntArray = IntArray(6)
        tallies[d1 - 1] += 1
        tallies[d2 - 1] += 1
        tallies[d3 - 1] += 1
        tallies[d4 - 1] += 1
        tallies[d5 - 1] += 1
        return if (tallies[0] == 1 &&
            tallies[1] == 1 &&
            tallies[2] == 1 &&
            tallies[3] == 1 &&
            tallies[4] == 1
        ) 15 else 0
    }

    fun largeStraight(d1: Int, d2: Int, d3: Int, d4: Int, d5: Int): Int {
        val tallies: IntArray = IntArray(6)
        tallies[d1 - 1] += 1
        tallies[d2 - 1] += 1
        tallies[d3 - 1] += 1
        tallies[d4 - 1] += 1
        tallies[d5 - 1] += 1
        return if (tallies[1] == 1 &&
            tallies[2] == 1 &&
            tallies[3] == 1 &&
            tallies[4] == 1
            && tallies[5] == 1
        ) 20 else 0
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

    private fun hasOnePair(tallies: IntArray): Boolean = tallies.any { it == 2 }
    private fun hasThreeOfAKind(tallies: IntArray): Boolean = tallies.any { it == 3 }
}
