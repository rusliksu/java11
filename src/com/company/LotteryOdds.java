package com.company;

import java.util.Scanner;

public class LotteryOdds {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("How many numbers do you need to draw? ");
        int k = in.nextInt();

        System.out.print("What is the highest number can you draw? ");
        int n = in.nextInt();

//        вычислить биномиальный коэффициент по формуле:
//        n*(n-1)*(n-2)*...*(n-k-1)/(1*2*3*...*k)

        int lotteryOdds = 1;
        for (int i = 1; i <= k; i++)
            lotteryOdds = lotteryOdds * (n - i +  1) / i;

        System.out.println(
                "Your odds are l in " + lotteryOdds + ". Good luck!");
    }
}
