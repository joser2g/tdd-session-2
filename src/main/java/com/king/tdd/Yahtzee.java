package com.king.tdd;

/**
 * Created with IntelliJ IDEA.
 * User: jose
 * Date: 10/3/13
 * Time: 2:55 PM
 * To change this template use File | Settings | File Templates.
 */
public class Yahtzee {
    public int getScore(int[] roll, Category category) {
        return category.getScoreCalculator().getScore(roll);
    }
}
