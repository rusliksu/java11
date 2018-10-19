package com.company;
import java.util.stream.*;

public class PangramCheker {
    public static boolean check(String sentence){
        char[] alphabet = new char[26];
        for (int i = 0; i < 26; i++)
            alphabet[i] = (char)('a' + i);

        int[] checked = new int[26];

        for (char letter : sentence.toCharArray())
            if (letter >= 'a' && letter <= 'z'){
                checked[letter - 'a'] = 1;
                if (IntStream.of(checked).sum() == 26)
                    return true;
            }
        return false;
    }

    public static void main(String args[]){
        System.out.print(check("qweryuiop[asdfghjkl;zcvbnmmqwertyioplkjhgfdsazxcvbnm"));
        System.out.print(check("The quick"));
        System.out.print(check("1213"));
    }
}
