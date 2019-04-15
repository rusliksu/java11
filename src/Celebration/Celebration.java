package Celebration;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Celebration {
    public static void main(String args[])
    {
        try{
            FileInputStream fstream = new FileInputStream("\\input.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            String line;
            int[] employees = new int[Integer.parseInt(br.readLine())];
            for (int i = 0; i < employees.length; i++) {
                employees[i] = Integer.parseInt(br.readLine());
            }
            for (int i = 0; i < employees.length; i++) {
                System.out.println(maxDeep(employees, employees[i]));
            }
        }catch (IOException e){
            System.out.println("Ошибка"); }
    }

    public static int maxDeep(int[] list, int index)
    {
        if (index == -1)
            return 1;
        return Celebration.maxDeep(list, list[index - 1]) + 1;
    }
}
