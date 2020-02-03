package Parse;

public class Parser {

    public static int parseInt(String numStr) {
        if (numStr.contains("million"))
            return (1000000);
        if (numStr.contains("thousand"))
            return (parseThousands(numStr));
        if (numStr.contains("hundred"))
            return (parseHundreds(numStr));
        return (parseTens(numStr));
    }

    public static int parseThousands(String thousandStr)
    {
        String thousandSplit[] = thousandStr.split(" thousand ", 2);
        return (parseHundreds(thousandSplit[0]) * 1000 + parseHundreds(thousandSplit[1]));
    }

    public static int parseHundreds(String hundredStr)
    {
        String hundredSplit[] = hundredStr.split(" hundred ", 2);
        return (parseDigits(hundredSplit[0]) * 100 + parseTens(hundredSplit[1]));
    }

    public static int parseTens(String tensStr)
    {
        if (tensStr.contains("ten"))
            return 10;
        if (tensStr.contains("eleven"))
            return 11;
        if (tensStr.contains("twelve"))
            return 12;
        if (tensStr.contains("thirteen"))
            return 13;
        if (tensStr.contains("fourteen"))
            return 14;
        if (tensStr.contains("fifteen"))
            return 15;
        if (tensStr.contains("sixteen"))
            return 16;
        if (tensStr.contains("seventeen"))
            return 17;
        if (tensStr.contains("eighteen"))
            return 18;
        if (tensStr.contains("nineteen"))
            return 19;

        if (tensStr.contains("-")) {
            String tenSplit[] = tensStr.split("-", 2);
            return (parseTensAfter20(tenSplit[0]) + parseDigits(tenSplit[1]));
        }
        return (parseTensAfter20(tensStr));
    }

    public static int parseTensAfter20(String tensStr)
    {
        if (tensStr.contains("twenty"))
            return 20;
        if (tensStr.contains("thirty"))
            return 30;
        if (tensStr.contains("forty"))
            return 40;
        if (tensStr.contains("fifty"))
            return 50;
        if (tensStr.contains("sixty"))
            return 60;
        if (tensStr.contains("seventy"))
            return 70;
        if (tensStr.contains("eighty"))
            return 80;
        if (tensStr.contains("ninety"))
            return 90;
        return (parseDigits(tensStr));
    }

    public static int parseDigits(String digitStr)
    {
        if (digitStr.contains("one"))
            return 1;
        if (digitStr.contains("two"))
            return 2;
        if (digitStr.contains("three"))
            return 3;
        if (digitStr.contains("four"))
            return 4;
        if (digitStr.contains("five"))
            return 5;
        if (digitStr.contains("six"))
            return 6;
        if (digitStr.contains("seven"))
            return 7;
        if (digitStr.contains("eight"))
            return 8;
        if (digitStr.contains("nine"))
            return 9;
        return (0);
    }

    public static void main(String[] args) {
        System.out.println(parseInt("seven hundred eighty-three thousand nine hundred and nineteen"));
    }

}
