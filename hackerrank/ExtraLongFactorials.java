package hackerrank;

import java.math.BigInteger;

public class ExtraLongFactorials {
    /*
     * Complete the 'extraLongFactorials' function below.
     *
     * The function accepts INTEGER n as parameter.
     */

    public static void extraLongFactorials(int n) {
        // Write your code here
        String stringInteger = String.valueOf(n);
        BigInteger bigInt = new BigInteger(stringInteger);

        if (bigInt.equals(BigInteger.ZERO)) {
            bigInt = BigInteger.ONE;
        } else {
            bigInt = bigInt.multiply(bigFactorial(bigInt.subtract(BigInteger.ONE)));
        }

        System.out.println(bigInt);
    }

    public static BigInteger bigFactorial(BigInteger n) {

        BigInteger bigInt = BigInteger.ONE;

        for (int i = 1; i <= n.intValue(); i++) {
            bigInt = bigInt.multiply(BigInteger.valueOf(i));
        }

        return bigInt;

        /*
        if (n.equals(BigInteger.ZERO)) {
            return BigInteger.ONE;
        } else {
            return n.multiply(bigFactorial(n.subtract(BigInteger.ONE)));
        }

         */

    }

    public static void main(String[] args) {
        int number = 3;
        //System.out.println(factorial(number));
        extraLongFactorials(number);
    }
}
