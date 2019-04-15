public class Last2Digits {
    public static void main(String[] args)
    {
        System.out.println(calculate(11));
    }

    public static int calculate(int n)
    {
        return (int)Math.pow(5, n) % 100;
    }

}
