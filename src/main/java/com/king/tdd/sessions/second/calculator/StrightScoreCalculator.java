package com.king.tdd.sessions.second.calculator;

import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created with IntelliJ IDEA.
 * User: jose
 * Date: 10/3/13
 * Time: 5:08 PM
 * To change this template use File | Settings | File Templates.
 */
public class StrightScoreCalculator implements ScoreCalculator {

    private boolean small;

    public StrightScoreCalculator(boolean small) {
        this.small = small;
    }

    @Override
    public int getScore(int[] roll) {
        Integer[] rollCopy = ArrayUtils.toObject(roll);
        Arrays.sort(rollCopy, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        int valueToCompare = small ? 1 : 2;
        int score = small ? 15 : 20;
        return rollCopy[0] == valueToCompare++ && rollCopy[1] == valueToCompare++ && rollCopy[2] == valueToCompare++ && rollCopy[3] == valueToCompare++ && rollCopy[4] == valueToCompare++ ? score : 0;
    }
}
