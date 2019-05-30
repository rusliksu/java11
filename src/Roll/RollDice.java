package Roll;

public class RollDice {
    public static String main(String[] args)
    {
        int a = 1, b = 4;
        int max = Math.max(a, b);
        switch (max) {
            case 1:
                return "1/1";
            case 2:
                return "5/6";
            case 3:
                return "2/3";
            case 4:
                return "1/2";
            case 5:
                return "1/3";
            case 6:
                return "1/6";
        }
        return " ";
    }
}
