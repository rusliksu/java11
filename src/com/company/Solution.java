package com.company;

public class Solution {
    public int numJewelsInStones(String J, String S) {
        int count = 0;
        for (char i : S.toCharArray())
        {
            if (J.contains(i + ""))
            {
                count++;
            }
        }
        return count;
    }


}
