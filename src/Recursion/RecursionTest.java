package Recursion;

public class RecursionTest {
    public static void main(String[] args) {
        int i = test2(4);
        System.out.println(i);

    }

    public static void test(int n) {
        if (n >= 2) {
            test(n - 1);
        }
        System.out.println("n=" + n);
    }


    public static int test2(int n) {
        if (n < 2) {
            return 1;
        } else {
            return n * test2(n - 1);
        }


    }
}
