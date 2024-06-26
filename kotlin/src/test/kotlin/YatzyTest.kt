import kotlin.test.Test
import kotlin.test.assertEquals

class YatzyTest {

    @Test
    fun chance_scores_sum_of_all_dice() {
        assertEquals(15, Yatzy().chance(2, 3, 4, 5, 1))
        assertEquals(16, Yatzy().chance(3, 3, 4, 5, 1))
    }

    @Test
    fun yatzy_scores_50() {
        assertEquals(50, Yatzy().yatzy(4, 4, 4, 4, 4))
        assertEquals(50, Yatzy().yatzy(6, 6, 6, 6, 6))
        assertEquals(0, Yatzy().yatzy(6, 6, 6, 6, 3))
    }

    @Test
    fun ones_scores_sum_of_all_one() {
        assertEquals(1, Yatzy().ones(1, 2, 3, 4, 5))
        assertEquals(2, Yatzy().ones(1, 2, 1, 4, 5))
        assertEquals(0, Yatzy().ones(6, 2, 2, 4, 5))
        assertEquals(4, Yatzy().ones(1, 2, 1, 1, 1))
    }

    @Test
    fun twos_scores_sum_of_all_two() {
        assertEquals(4, Yatzy().twos(1, 2, 3, 2, 6))
        assertEquals(10, Yatzy().twos(2, 2, 2, 2, 2))
    }

    @Test
    fun threes_scores_sum_of_all_three() {
        assertEquals(6, Yatzy().threes(1, 2, 3, 2, 3))
        assertEquals(12, Yatzy().threes(2, 3, 3, 3, 3))
    }

    @Test
    fun fours_scores_sum_of_all_four() {
        assertEquals(12, Yatzy().fours(4, 4, 4, 5, 5))
        assertEquals(8, Yatzy().fours(4, 4, 5, 5, 5))
        assertEquals(4, Yatzy().fours(4, 5, 5, 5, 5))
    }

    @Test
    fun fives_scores_sum_of_all_five() {
        assertEquals(10, Yatzy().fives(4, 4, 4, 5, 5))
        assertEquals(15, Yatzy().fives(4, 4, 5, 5, 5))
        assertEquals(20, Yatzy().fives(4, 5, 5, 5, 5))
    }

    @Test
    fun sixes_scores_sum_of_all_six() {
        assertEquals(0, Yatzy().sixes(4, 4, 4, 5, 5))
        assertEquals(6, Yatzy().sixes(4, 4, 6, 5, 5))
        assertEquals(18, Yatzy().sixes(6, 5, 6, 6, 5))
    }

    @Test
    fun one_pair_scores_sum_of_highest_pair() {
        assertEquals(6, Yatzy().onePair(3, 4, 3, 5, 6))
        assertEquals(6, Yatzy().onePair(1, 3, 3, 3, 1))
        assertEquals(10, Yatzy().onePair(5, 3, 3, 3, 5))
        assertEquals(12, Yatzy().onePair(5, 3, 6, 6, 5))
        assertEquals(0, Yatzy().onePair(3, 4, 1, 5, 6))
    }

    @Test
    fun two_pairs_scores_sum_of_two_pairs() {
        assertEquals(16, Yatzy().twoPairs(3, 3, 5, 4, 5))
        assertEquals(16, Yatzy().twoPairs(3, 3, 5, 5, 5))
        assertEquals(0, Yatzy().twoPairs(3, 3, 2, 4, 5))
    }

    @Test
    fun three_of_a_kind_scores_sum_of_three_of_a_kind() {
        assertEquals(9, Yatzy().threeOfAKind(3, 3, 3, 4, 5))
        assertEquals(15, Yatzy().threeOfAKind(5, 3, 5, 4, 5))
        assertEquals(9, Yatzy().threeOfAKind(3, 3, 3, 3, 5))
        assertEquals(0, Yatzy().threeOfAKind(3, 1, 3, 4, 5))
    }

    @Test
    fun four_of_a_kind_scores_sum_of_four_of_a_kind() {
        assertEquals(12, Yatzy().fourOfAKind(3, 3, 3, 3, 5))
        assertEquals(20, Yatzy().fourOfAKind(5, 5, 5, 4, 5))
        assertEquals(12, Yatzy().fourOfAKind(3, 3, 3, 3, 3))
    }

    @Test
    fun small_straight_scores_sum_of_all_dice() {
        assertEquals(15, Yatzy().smallStraight(1, 2, 3, 4, 5))
        assertEquals(15, Yatzy().smallStraight(2, 3, 4, 5, 1))
        assertEquals(0, Yatzy().smallStraight(1, 2, 2, 4, 5))
    }

    @Test
    fun large_straight_scores_sum_of_all_dice() {
        assertEquals(20, Yatzy().largeStraight(6, 2, 3, 4, 5))
        assertEquals(20, Yatzy().largeStraight(2, 3, 4, 5, 6))
        assertEquals(0, Yatzy().largeStraight(1, 2, 2, 4, 5))
    }

    @Test
    fun full_house_scores_sum_of_all_dice() {
        assertEquals(18, Yatzy().fullHouse(6, 2, 2, 2, 6))
        assertEquals(0, Yatzy().fullHouse(2, 3, 4, 5, 6))
    }
}
