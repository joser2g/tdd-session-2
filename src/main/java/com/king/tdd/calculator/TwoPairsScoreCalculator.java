package com.king.tdd.calculator;

import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created with IntelliJ IDEA.
 * User: jose
 * Date: 10/3/13
 * Time: 4:50 PM
 * To change this template use File | Settings | File Templates.
 */
public class TwoPairsScoreCalculator implements ScoreCalculator {
    @Override
    public int getScore(int[] roll) {
        Integer[] rollCopy = ArrayUtils.toObject(roll);
        Arrays.sort(rollCopy, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });

        boolean firstPairAlreadyFound = false;
        int score = 0;
        for(int i = 1 ; i < rollCopy.length ; ++i) {
            if(rollCopy[i] == rollCopy[i - 1]) {
                score += 2 * rollCopy[i];
                if(firstPairAlreadyFound) {
                    return score;
                }
                firstPairAlreadyFound = true;
            }
        }
        return 0;
    }
}
