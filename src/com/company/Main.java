package com.company;

import java.util.Arrays;
import java.util.Scanner;



public class Main {
    public static void main(String[] args) {

        System.out.println("42".length());
        System.out.println(validatePin("+452"));

        System.out.println(solution(990));

        System.out.println(expandedForm(12));

    }

    private static boolean validatePin(String pin) {
        // Your code here...

        return (pin.length() == 4 || pin.length() == 6) && pin.matches("[0-9]+");
    }

    private static String expandedForm(int num)
    {
        StringBuilder builder = new StringBuilder();

        do {
            double numLength = Integer.toString(num).length();
            double numb = num - num % Math.pow(10, numLength - 1);
            if (numb != 0) {
                builder.append((int) numb);
                num -= numb;
            }
            if (num > 0 || !(numb != 0))
                builder.append(" + ");
        } while (num != 0);
        return builder.toString();
    }

    private static String solution(int n) {
        if (n > 3999)
            return "";

        StringBuilder romanNumber = new StringBuilder();

        while (n >= 1000)
        {
            romanNumber.append("M");
            n -= 1000;
        }
        if (n >= 100) {
            romanNumber.append(ConvertDigit(n));
            n %= 100;
        }
        if (n >= 10) {
            romanNumber.append(ConvertDigit(n));
            n %= 10;
        }
        romanNumber.append(ConvertDigit(n));
        return romanNumber.toString();
    }

    private static String ConvertDigit(int n)
    {
        int nLength = Integer.toString(n).length();
        System.out.println(nLength);
        String x1, x5, x10;
        int digit;

        if (nLength == 3)
        {
            x1 = "C"; x5 = "D"; x10 = "M";
            digit = n / 100;
        }
        else if (nLength == 2)
        {
            x1 = "X"; x5 = "L"; x10 = "C";
            digit = n / 10;
        }
        else
        {
            x1 = "I"; x5 = "V"; x10 = "X";
            digit = n;
        }

        if (digit == 0) {
            return "";
        }
        if (digit == 1) {
            return x1;
        }
        if (digit == 2) {
            return x1 + x1;
        }
        if (digit == 3) {
            return x1 + x1 + x1;
        }
        if (digit == 4) {
            return x1 + x5;
        }
        if (digit == 5) {
            return x5;
        }
        if (digit == 6) {
            return x5 + x1;
        }
        if (digit == 7) {
            return x5 + x1 + x1;
        }
        if (digit == 8) {
            return x5 + x1 + x1 + x1;
        }
        if (digit == 9) {
            return x1 + x10;
        }
        return "";
    }
}
