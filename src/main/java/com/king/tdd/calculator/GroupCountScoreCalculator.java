package com.king.tdd.calculator;

import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created with IntelliJ IDEA.
 * User: jose
 * Date: 10/3/13
 * Time: 4:06 PM
 * To change this template use File | Settings | File Templates.
 */
public class GroupCountScoreCalculator implements ScoreCalculator {

    private int groupSize;

    public GroupCountScoreCalculator(int groupSize) {
        this.groupSize = groupSize;
    }

    @Override
    public int getScore(int[] roll) {
        Integer[] rollCopy = ArrayUtils.toObject(roll);
        Arrays.sort(rollCopy, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });

        for(int i = groupSize - 1 ; i < rollCopy.length ; ++i) {
            if(rollCopy[i] == rollCopy[i - groupSize + 1]) {
                return rollCopy[i] * groupSize;
            }
        }
        return 0;
    }
}
