//Open https://www.codechef.com/ide to run it
//Implement pow(x, y) % z
public class Code {

    public static void main(String[] str) {
        assertEqual(pow(4L, 2L, 3L), 1);
        assertEqual(pow(9L, 2L, 2L), 1);
        assertEqual(pow(1L, 10L, 2L), 1);
        assertEqual(pow(2L, 100L, 2L), 0);
        assertEqual(pow(123456789101112131L, 123456789101112131L, 987654321L), 562489885);
        assertEqual(pow(10000000L, 100000000000000L, 9999999L), 1);
        assertEqual(pow(32121124, 45567321L, 233111L), 26820);
        assertEqual(pow(909L, 100L, 57L), 54);
    }

    public static void assertEqual(Object o1, Object o2) {
        if (o1.equals(o2))
            System.out.println("Pass");
        else
            System.out.println("Fail");
    }

    //Please complete the below
    public static int pow(long x, long n, long d) {

        if (n == 1) return (int)(x%d);
        //(x^n)%d = ((x%d)*x^(n-1)%d)%d)
        long a = (x%d);
        long b = pow(x, n-1, d);
        return (int)((a*b) % d);
    }

}