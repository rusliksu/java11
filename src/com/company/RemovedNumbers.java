package com.company;

import java.util.ArrayList;
import java.util.List;

public class RemovedNumbers {

    public static void main(String args[])
    {
//        ArrayList<String> list = new ArrayList<String>();
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i));
//        }
        System.out.println(removNb(26));
    }

    public static List<long[]> removNb(long n) {
        double sum = n*(n+1)/2;
        double b;
        List<long[]> AnswerList = new ArrayList<>();
        for (int i = 2; i<=n; i++)
        {
            b = (sum - i)/(i+1);
            if (b<=n && b%1==0)
            {
                AnswerList.add(new long[] {i,(long)b});
            }
        }
        return AnswerList;
    }
}
