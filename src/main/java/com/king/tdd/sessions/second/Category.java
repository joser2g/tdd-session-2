package com.king.tdd.sessions.second;

import com.king.tdd.sessions.second.calculator.*;

/**
 * Created with IntelliJ IDEA.
 * User: jose
 * Date: 10/3/13
 * Time: 3:08 PM
 * To change this template use File | Settings | File Templates.
 */
public enum Category {
    ONES(new SimpleScoreCalculator(1)),
    TWOS(new SimpleScoreCalculator(2)),
    PAIRS(new GroupCountScoreCalculator(2)),
    THREE_OF_A_KIND(new GroupCountScoreCalculator(3)),
    FOUR_OF_A_KIND(new GroupCountScoreCalculator(4)),
    TWO_PAIRS(new TwoPairsScoreCalculator()),
    SMALL_STRAIGHT(new StrightScoreCalculator(true)),
    LARGE_STRAIGHT(new StrightScoreCalculator(false)),
    FULL_HOUSE(new FullHouseScoreCalculator()),
    YAHTZEE(new YahtzeeScoreCalculator()),
    CHANCE(new ChanceScoreCalculator());

    private final ScoreCalculator scoreCalculator;

    private Category(final ScoreCalculator scoreCalculator) {
        this.scoreCalculator = scoreCalculator;
    }

    public ScoreCalculator getScoreCalculator() {
        return scoreCalculator;
    }
}
