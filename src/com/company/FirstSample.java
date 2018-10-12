package com.company;

import static java.lang.Math.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.file.Paths;
import java.util.Date;
import java.util.Scanner;


public class FirstSample {
    enum Size { SMALL, MEDIUM, LARGE, EXTRA_LARGE };
    public static void  main(String[] args) throws IOException
    {
        // прочитать вводимые данные
        Scanner in = new Scanner(System.in);

        System.out.print("How much money do you nee to retire? ");
        double goal = in.nextDouble();

        System.out.print(
                "How much money will you contribute every year? ");
        double payment = in.nextDouble();

        System.out.print("Interest rate in %: ");
        double interestRate = in.nextDouble();

        double balance = 0;
        int years = 0;

        // обновить остаток на счету, пока не
        // достигнута заданная сумма
        while (balance < goal)
        {
            // добавить ежегодный взнос и проценты
            balance += payment;
            double interest = balance * interestRate / 100;
            balance += interest;
            years++;
        }

        System.out.println("You can retire in " + years + " years.");
    }
}
