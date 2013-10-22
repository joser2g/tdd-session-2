package com.king.tdd.sessions.second;


import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class YahtzeeTest {

    private static final int[] ROLL_WITH_NO_ONES = {2, 2, 2, 2, 2};
    private static final int[] ROLL_WITH_TWO_ONES = {2, 2, 1, 2, 1};
    private static final int[] ROLL_WITH_THREE_TWOS = {2, 2, 1, 2, 1};
    private static final int[] ROLL_WITH_NO_PAIRS = {2, 4, 1, 6, 5};
    private static final int[] ROLL_WITH_A_TWOS_PAIR = {2, 2, 1, 6, 5};

    private Yahtzee yahtzee;

    @Before
    public void setUp() {
        yahtzee = new Yahtzee();
    }

//    @Test(expected = InvalidArgumentException.class)
//    public void nullRollThrowsException() {
//        yahtzee.getScore(null);
//    }

    @Test
    public void onesRollWithNoOnesScoresZero() {
        assertThat(yahtzee.getScore(ROLL_WITH_NO_ONES, Category.ONES), equalTo(0));
    }

    @Test
    public void onesRollWithTwoOnesScoresTwo() {
        assertThat(yahtzee.getScore(ROLL_WITH_TWO_ONES, Category.ONES), equalTo(2));
    }

    @Test
    public void twosRollWithThreeTwosScoresSix() {
        assertThat(yahtzee.getScore(ROLL_WITH_THREE_TWOS, Category.TWOS), equalTo(6));
    }

    @Test
    public void pairsRollWithNoPairsScoresZero() {
        assertThat(yahtzee.getScore(ROLL_WITH_NO_PAIRS, Category.PAIRS), equalTo(0));
    }

    @Test
    public void pairsRollScoringWorks() {
        assertThat(yahtzee.getScore(ROLL_WITH_A_TWOS_PAIR, Category.PAIRS), equalTo(4));
        assertThat(yahtzee.getScore(new int[]{2, 1, 2, 3, 1}, Category.PAIRS), equalTo(4));
        assertThat(yahtzee.getScore(new int[]{2, 1, 3, 5, 1}, Category.PAIRS), equalTo(2));
        assertThat(yahtzee.getScore(new int[]{1, 2, 4, 1, 4}, Category.PAIRS), equalTo(8));
        assertThat(yahtzee.getScore(new int[]{5, 1, 5, 4, 4}, Category.PAIRS), equalTo(10));
    }

    @Test
    public void threeOfAKindRollScoringWorks() {
        assertThat(yahtzee.getScore(new int[]{2, 1, 2, 3, 2}, Category.THREE_OF_A_KIND), equalTo(6));
        assertThat(yahtzee.getScore(new int[]{2, 1, 3, 5, 1}, Category.THREE_OF_A_KIND), equalTo(0));
        assertThat(yahtzee.getScore(new int[]{1, 1, 2, 4, 1}, Category.THREE_OF_A_KIND), equalTo(3));
        assertThat(yahtzee.getScore(new int[]{5, 1, 5, 4, 5}, Category.THREE_OF_A_KIND), equalTo(15));
    }

    @Test
    public void fourOfAKindRollScoringWorks() {
        assertThat(yahtzee.getScore(new int[]{2, 1, 2, 2, 2}, Category.FOUR_OF_A_KIND), equalTo(8));
        assertThat(yahtzee.getScore(new int[]{2, 1, 3, 1, 4}, Category.FOUR_OF_A_KIND), equalTo(0));
        assertThat(yahtzee.getScore(new int[]{1, 1, 1, 1, 4}, Category.FOUR_OF_A_KIND), equalTo(4));
        assertThat(yahtzee.getScore(new int[]{5, 1, 5, 5, 5}, Category.FOUR_OF_A_KIND), equalTo(20));
    }

    @Test
    public void twoPairsRollScoringWorks() {
        assertThat(yahtzee.getScore(new int[]{2, 1, 2, 3, 1}, Category.TWO_PAIRS), equalTo(6));
        assertThat(yahtzee.getScore(new int[]{2, 1, 3, 5, 1}, Category.TWO_PAIRS), equalTo(0));
        assertThat(yahtzee.getScore(new int[]{2, 3, 2, 4, 4}, Category.TWO_PAIRS), equalTo(12));
        assertThat(yahtzee.getScore(new int[]{5, 1, 5, 4, 4}, Category.TWO_PAIRS), equalTo(18));
    }

    @Test
    public void yahtzeeRollScoringWorks() {
        assertThat(yahtzee.getScore(new int[]{2, 1, 2, 3, 1}, Category.YAHTZEE), equalTo(0));
        assertThat(yahtzee.getScore(new int[]{2, 2, 2, 2, 2}, Category.YAHTZEE), equalTo(50));
        assertThat(yahtzee.getScore(new int[]{5, 5, 5, 5, 4}, Category.YAHTZEE), equalTo(0));
        assertThat(yahtzee.getScore(new int[]{5, 5, 5, 5, 5}, Category.YAHTZEE), equalTo(50));
    }

    @Test
    public void chanceRollScoringWorks() {
        assertThat(yahtzee.getScore(new int[]{2, 1, 2, 3, 1}, Category.CHANCE), equalTo(9));
        assertThat(yahtzee.getScore(new int[]{2, 2, 2, 2, 2}, Category.CHANCE), equalTo(10));
        assertThat(yahtzee.getScore(new int[]{5, 5, 5, 5, 4}, Category.CHANCE), equalTo(24));
        assertThat(yahtzee.getScore(new int[]{5, 5, 5, 5, 5}, Category.CHANCE), equalTo(25));
    }

    @Test
    public void smallStraightRollScoringWorks() {
        assertThat(yahtzee.getScore(new int[]{2, 1, 2, 3, 1}, Category.SMALL_STRAIGHT), equalTo(0));
        assertThat(yahtzee.getScore(new int[]{1, 2, 5, 3, 4}, Category.SMALL_STRAIGHT), equalTo(15));
        assertThat(yahtzee.getScore(new int[]{1, 2, 3, 4, 5}, Category.SMALL_STRAIGHT), equalTo(15));
        assertThat(yahtzee.getScore(new int[]{2, 3, 4, 5, 6}, Category.SMALL_STRAIGHT), equalTo(0));
    }

    @Test
    public void largeStraightRollScoringWorks() {
        assertThat(yahtzee.getScore(new int[]{2, 1, 2, 3, 1}, Category.LARGE_STRAIGHT), equalTo(0));
        assertThat(yahtzee.getScore(new int[]{1, 2, 5, 3, 4}, Category.LARGE_STRAIGHT), equalTo(0));
        assertThat(yahtzee.getScore(new int[]{1, 2, 3, 4, 5}, Category.LARGE_STRAIGHT), equalTo(0));
        assertThat(yahtzee.getScore(new int[]{2, 3, 4, 5, 6}, Category.LARGE_STRAIGHT), equalTo(20));
    }

    @Test
    public void fullHouseRollScoringWorks() {
        assertThat(yahtzee.getScore(new int[]{2, 1, 2, 3, 1}, Category.FULL_HOUSE), equalTo(0));
        assertThat(yahtzee.getScore(new int[]{2, 2, 3, 3, 3}, Category.FULL_HOUSE), equalTo(13));
        assertThat(yahtzee.getScore(new int[]{3, 5, 3, 5, 5}, Category.FULL_HOUSE), equalTo(21));
        assertThat(yahtzee.getScore(new int[]{2, 1, 2, 3, 2}, Category.FULL_HOUSE), equalTo(0));
        assertThat(yahtzee.getScore(new int[]{2, 1, 2, 3, 3}, Category.FULL_HOUSE), equalTo(0));
    }

}
