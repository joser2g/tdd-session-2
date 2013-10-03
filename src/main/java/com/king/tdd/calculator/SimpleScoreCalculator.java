package com.king.tdd.calculator;

/**
 * Created with IntelliJ IDEA.
 * User: jose
 * Date: 10/3/13
 * Time: 3:36 PM
 * To change this template use File | Settings | File Templates.
 */
public class SimpleScoreCalculator implements ScoreCalculator {
    private final int increment;

    public SimpleScoreCalculator(int increment) {
        this.increment = increment;
    }

    @Override
    public int getScore(final int[] roll) {
        int score = 0;
        for(int diceValue : roll) {
            if(diceValue == increment) {
                score += increment;
            }
        }
        return score;
    }
}
