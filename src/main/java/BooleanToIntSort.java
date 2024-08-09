public class BooleanToIntSort implements Sorter {
    public static void main(String[] args) {
        int a = 10;
        int b = 1;
        int c = 5;
        int d = -1;
        int e = 0;
        System.out.printf("Input %s, %s, %s, %s, %s%n", a, b, c, d, e);
        String ordered = new BooleanToIntSort().sort(a, b, c, d, e);
        System.out.println(ordered);
    }

    @Override
    public int min(int a, int b) {
        return (booleanToInt(a <= b) * a + booleanToInt(b < a) * b);
    }

    @Override
    public int max(int a, int b) {
        return (booleanToInt(a >= b) * a + booleanToInt(b > a) * b);
    }

    private static int booleanToInt(boolean bool) {
        int length = ("" + bool).length();
        int mod5 = length % 5;
        return mod5 / 4;
        // true 4 % 5 -> 4 / 4 -> 1
        // false 5 % 5 = 0 / 4 -> 0
    }
}