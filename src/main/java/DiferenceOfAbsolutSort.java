public class DiferenceOfAbsolutSort implements Sorter {
    public static void main(String[] args) {
        int a = 10;
        int b = 1;
        int c = 5;
        int d = -1;
        int e = 0;
        System.out.printf("Input %s, %s, %s, %s, %s%n", a, b, c, d, e);
        String ordered = new DiferenceOfAbsolutSort().sort(a, b, c, d, e);
        System.out.println(ordered);
    }

    @Override
    public int min(int a, int b) {
        long la = a;
        long lb = b;
        long sum = la + lb;
        long absDiff = abs(la - lb);
        return (int) ((sum - absDiff) / 2);
    }

    @Override
    public int max(int a, int b) {
        return a + b - min(a, b);
    }

    static long abs(long a) {
        return a * (a >> Long.SIZE - 1) + a * ((a >> Long.SIZE - 1) + 1);
    }
}