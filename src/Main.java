//Balloon Game
//Open https://www.codechef.com/ide to run it

import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {

    public static void main(String str[]) {
        int[] points;
        points = new int[]{10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
        assertEqual(calculateMaxScore(points, 5, 1), 50);
        points = new int[]{10, 100, 10, 10, 10, 100, 10, 10, 10, 100};
        assertEqual(calculateMaxScore(points, 3, 1), 300);
        points = new int[]{10, 100, 500, 10, 10, 100, 500, 10, 10, 100};
        assertEqual(calculateMaxScore(points, 3, 1), 1100);
        points = new int[]{10, 5, 11, 8, 7, 5, 2, 9, 13, 1, 12, 8, 4, 8, 9, 4, 12, 11, 8, 7, 5, 12, 8,
                5, 9, 4, 7, 3, 11, 10, 5, 3, 7, 10, 9, 8, 4, 7, 10, 9, 12, 4, 6, 3, 8, 6, 9, 6, 2, 9};
        assertEqual(calculateMaxScore(points, 10, 2), 108);
    }

    public static void assertEqual(Object o1, Object o2) {
        if (o1.equals(o2))
            System.out.println("Pass");
        else
            System.out.println("Fail");
    }


    //Please complete below
    public static int calculateMaxScore(int[] points, int bullets, int reloadingGap) {

        int[][] dp = new int[points.length][bullets];

        for (int i = 0; i < points.length; i++) {
            for (int j =0; j < bullets; j++) {
                int inc = points[i];
                if (i-1-reloadingGap >=0 && j-1 >=0) {
                    inc+=  dp[i-1-reloadingGap][j-1];
                }
                int exc = 0;
                if (i-1 >=0) {
                    exc+= dp[i-1][j];
                }
                dp[i][j] = Math.max(inc,exc);
            }
        }
        return dp[points.length-1][bullets-1];
    }

}