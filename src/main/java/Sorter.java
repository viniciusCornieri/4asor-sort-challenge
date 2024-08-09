public interface Sorter {

    default String sort(int a, int b, int c, int d, int e) {
        int x1, x2, x3, x4, x5;
        // 1 iteration
        x1 = min(a, b);
        x2 = max(a, b);
        x3 = min(c, d);
        x4 = max(c, d);
        x5 = e;
        // 2 iteration
        e = max(x4, x5);
        d = min(x4, x5);
        c = max(x3, x2);
        b = min(x3, x2);
        a = x1;
        // 3 iteration
        x1 = min(a, b);
        x2 = max(a, b);
        x3 = min(c, d);
        x4 = max(c, d);
        x5 = e;
        // 4 iteration
        e = max(x4, x5);
        d = min(x4, x5);
        c = max(x3, x2);
        b = min(x3, x2);
        a = x1;
        // 5 iteration
        x1 = min(a, b);
        x2 = max(a, b);
        x3 = min(c, d);
        x4 = max(c, d);
        x5 = e;
        String ordered = "[%s, %s, %s, %s, %s]".formatted(x1, x2, x3, x4, x5);
        return ordered;
    }

    int min(int a, int b);

    int max(int a, int b);

}
