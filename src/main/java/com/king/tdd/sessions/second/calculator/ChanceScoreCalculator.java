package com.king.tdd.sessions.second.calculator;

/**
 * Created with IntelliJ IDEA.
 * User: jose
 * Date: 10/3/13
 * Time: 5:05 PM
 * To change this template use File | Settings | File Templates.
 */
public class ChanceScoreCalculator implements ScoreCalculator {
    @Override
    public int getScore(int[] roll) {
        int score = 0;
        for (int diceValue : roll) {
            score += diceValue;
        }
        return score;
    }
}
