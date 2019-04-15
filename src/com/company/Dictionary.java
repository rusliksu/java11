package com.company;

public class Dictionary {

    private final String[] words;

    public Dictionary(String[] words) {
        this.words = words;
    }

    public String findMostSimilar(String to) {
        int n = words.length;
        int min = 100000;
        int j = 0;
        int[] MassOfIndexes = new int[n];
        System.out.println(to);
        for(int i = 0; i < n; i++)
        {
            MassOfIndexes[i] = compareTwoWords(to, words[i]);
            if (min > MassOfIndexes[i]) {
                j = i;
                min = MassOfIndexes[i];
            }
            System.out.println(MassOfIndexes[i] + " " + words[i]);
        }
        return words[j];
    }

    int compareTwoWords(String firstWord, String secondWord) {
        if (firstWord.length() < secondWord.length()) {
            String tmp;
            tmp = firstWord;
            firstWord = secondWord;
            secondWord = tmp;
        }
        int index = firstWord.length() - secondWord.length(); // чем больше индекс, тем непохожее слова
        //int index = firstWord.length() - secondWord.length(); // ищем разность длины между словами, чтобы учесть лишние буквы в вычислении индекса
        char[] firstWordInChar = firstWord.toCharArray();
        char[] secondWordInChar = secondWord.toCharArray();
        int j = 0;
        for (int i = 0; i < secondWordInChar.length && j < firstWordInChar.length; i++) // учитываем неправильные символы
        {
            int k = j;
            while (k != firstWordInChar.length - 1 && secondWordInChar[i] != firstWordInChar[k])
                k++;
            if (secondWordInChar[i] == firstWordInChar[k])
                j = k;
            else
                index++;

//                if (i != secondWordInChar.length - 1 && i != 0 && j != 0)
//                    if (secondWordInChar[i + 1] == firstWordInChar[j - 1] &&
//                            secondWordInChar[i + 1] != secondWordInChar[i - 1] &&
//                            secondWordInChar[i + 1] != secondWordInChar[i])
//                        // когда попадаем на одинаковый символ, сравниваем символы после одинакового во втором слове и перед одинаковым в первом
//                        // также избегаем ситуации, когда перед буквой и после одинакоые символы и когда следом идут 2 одинаковые буквы
//                        index--; // в такой ситуации уменьшаем индекс
        }
        return index;
    }

    public static void main(String[] args) {
        Dictionary dictionary = new Dictionary(new String[]{"cherry", "pineapple", "melon", "strawberry", "raspberry"});
        System.out.println(dictionary.findMostSimilar("strawbery"));
        System.out.println();

        System.out.println(dictionary.findMostSimilar("berry"));
        System.out.println();


        Dictionary dictionary1 = new Dictionary(new String[]{"javascript", "java", "ruby", "php", "python", "coffeescript"});
        System.out.println(dictionary1.findMostSimilar("heaven"));
        System.out.println();

        System.out.println(dictionary1.findMostSimilar("javascript"));
        System.out.println();


    }
}
