import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class YatzyTest {

    @Test
    public void chance_scores_sum_of_all_dice() {
        assertEquals(15, new Yatzy(2,3,4,5,1).chance());
        assertEquals(16, new Yatzy(3,3,4,5,1).chance());
    }

    @Test
    public void yatzy_scores_50() {
        int expected =50;
        assertEquals(expected, new Yatzy(1,1,1,1,1).yatzy());
        assertEquals(expected, new Yatzy(2,2,2,2,2).yatzy());
        assertEquals(expected, new Yatzy(3,3,3,3,3).yatzy());
    }

    @Test
    public void yatzy_scores_0() {
        int expected =0;
        assertEquals(expected, new Yatzy(3,3,3,3,5).yatzy());
        assertEquals(expected, new Yatzy(2,2,2,4,2).yatzy());
        assertEquals(expected, new Yatzy(5,3,3,3,3).yatzy());
        assertEquals(expected, new Yatzy(3,3,3,3,5).yatzy());
    }

    @Test public void ones_called_score1_when_1() {
        assertEquals(1, new Yatzy(1, 2, 3, 4, 5).ones());
        assertEquals(2, new Yatzy(1, 2, 1, 4, 5).ones());
        assertEquals(0, new Yatzy(6, 2, 3, 4, 5).ones());
        assertEquals(4, new Yatzy(1, 1, 3, 1, 1).ones());
    }

    @Test
    public void two_called_score2_when_2() {
        assertEquals(4, new Yatzy(1,2,3,2,6).twos());
        assertEquals(10, new Yatzy(2,2,2,2,2).twos());
    }

    @Test
    public void three_called_score3_when_3() {
        assertEquals(6, new Yatzy(1,2,3,2,3).threes());
        assertEquals(12,new Yatzy(2,3,3,3,3).threes());
    }

    @Test
    public void four_called_score4_when_4() {
        assertEquals(12, new Yatzy(4,4,4,5,5).fours());
        assertEquals(8, new Yatzy(4,4,5,5,5).fours());
        assertEquals(4, new Yatzy(4,5,5,5,5).fours());
    }

    @Test
    public void five_called_score5_when_5() {
        assertEquals(10, new Yatzy(4,4,4,5,5).fives());
        assertEquals(15, new Yatzy(4,4,5,5,5).fives());
        assertEquals(20, new Yatzy(4,5,5,5,5).fives());
    }

    @Test
    public void six_called_score6_when_6() {
        assertEquals(0, new Yatzy(4,4,4,5,5).sixes());
        assertEquals(6, new Yatzy(4,4,6,5,5).sixes());
        assertEquals(18, new Yatzy(6,5,6,6,5).sixes());
    }

    @Test
    public void one_pair_called() {
        assertEquals(6, new Yatzy(3,4,3,5,6).pair());
        assertEquals(10, new Yatzy(5,3,3,3,5).pair());
        assertEquals(12, new Yatzy(5,3,6,6,5).pair());
        assertEquals(2, new Yatzy(1,1,2,3,5).pair());
        assertEquals(0, new Yatzy(1,2,3,4,5).pair());
    }

    @Test
    public void two_Pair() {
        assertEquals(16, new Yatzy(3,3,5,4,5).two_pair());
        assertEquals(16, new Yatzy(3,3,5,5,5).two_pair());
        assertEquals(0, new Yatzy(3,3,5,6,1).two_pair());
    }

    @Test
    public void three_of_a_kind() 
    {
        assertEquals(9, Yatzy.three_of_a_kind(3,3,3,4,5));
        assertEquals(15, Yatzy.three_of_a_kind(5,3,5,4,5));
        assertEquals(9, Yatzy.three_of_a_kind(3,3,3,3,5));
    }

    @Test
    public void four_of_a_knd() {
        assertEquals(12, Yatzy.four_of_a_kind(3,3,3,3,5));
        assertEquals(20, Yatzy.four_of_a_kind(5,5,5,4,5));
        assertEquals(9, Yatzy.three_of_a_kind(3,3,3,3,3));
    }

    @Test
    public void smallStraight() {
        assertEquals(15, Yatzy.smallStraight(1,2,3,4,5));
        assertEquals(15, Yatzy.smallStraight(2,3,4,5,1));
        assertEquals(0, Yatzy.smallStraight(1,2,2,4,5));
    }

    @Test
    public void largeStraight() {
        assertEquals(20, Yatzy.largeStraight(6,2,3,4,5));
        assertEquals(20, Yatzy.largeStraight(2,3,4,5,6));
        assertEquals(0, Yatzy.largeStraight(1,2,2,4,5));
    }

    @Test
    public void fullHouse() {
        assertEquals(18, Yatzy.fullHouse(6,2,2,2,6));
        assertEquals(0, Yatzy.fullHouse(2,3,4,5,6));
    }
}
