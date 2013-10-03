package com.king.tdd.calculator;

/**
 * Created with IntelliJ IDEA.
 * User: jose
 * Date: 10/3/13
 * Time: 5:01 PM
 * To change this template use File | Settings | File Templates.
 */
public class YahtzeeScoreCalculator extends GroupCountScoreCalculator {

    public YahtzeeScoreCalculator() {
        super(5);
    }

    @Override
    public int getScore(int[] roll) {
        return super.getScore(roll) == 0 ? 0 : 50;
    }
}
