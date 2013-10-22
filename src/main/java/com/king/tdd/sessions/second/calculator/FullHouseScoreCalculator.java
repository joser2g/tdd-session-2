package com.king.tdd.sessions.second.calculator;

import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created with IntelliJ IDEA.
 * User: jose
 * Date: 10/3/13
 * Time: 5:18 PM
 * To change this template use File | Settings | File Templates.
 */
public class FullHouseScoreCalculator implements ScoreCalculator {
    @Override
    public int getScore(int[] roll) {
        Integer[] rollCopy = ArrayUtils.toObject(roll);
        Arrays.sort(rollCopy, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });

        int threeOfAKindScore = 0;
        for (int i = 2; i < rollCopy.length; ++i) {
            if (rollCopy[i] == rollCopy[i - 2]) {
                if (threeOfAKindScore == 0) {
                    threeOfAKindScore = 3 * rollCopy[i];
                } else {
                    threeOfAKindScore = 0;
                }
            }
        }

        if (threeOfAKindScore == 0) {
            return 0;
        }

        int pairScore = 0;
        for (int i = 1; i < rollCopy.length; ++i) {
            if (rollCopy[i] == rollCopy[i - 1]) {
                if (pairScore == 0) {
                    pairScore = 2 * rollCopy[i];
                } else {
                    pairScore = 0;
                }
            }
        }

        return pairScore != 0 ? (threeOfAKindScore + pairScore) : 0;
    }
}
