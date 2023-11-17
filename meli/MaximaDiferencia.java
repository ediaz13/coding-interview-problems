package meli;

import java.util.Arrays;

public class MaximaDiferencia {
    public static int maximaDiferencia(int[] a) {
        if (a == null || a.length < 2) {
            return -1; // Unable to calculate maximum difference
        }

        int maxDifference = Integer.MIN_VALUE;
        int minElement = a[0];

        for (int i = 1; i < a.length; i++) {
            if (a[i] < minElement) {
                minElement = a[i];
            } else {
                int currentDifference = a[i] - minElement;
                maxDifference = Math.max(maxDifference, currentDifference);
            }
        }

        return (maxDifference != Integer.MIN_VALUE) ? maxDifference : -1;
    }

    public static int maximaDiferenciaStreams(int[] a) {
        if (a == null || a.length < 2) {
            return -1; // Unable to calculate maximum difference
        }

        int[] minElement = {Integer.MAX_VALUE};

        return Arrays.stream(a, 1, a.length - 1)
                .reduce(-1, (maxDifference, currentElement) -> {
                    minElement[0] = Math.min(minElement[0], a[currentElement - 1]);
                    return Math.max(maxDifference, currentElement - minElement[0]);
                });
    }

    public static void main(String[] args) {
        int[] array = {15, 3, 6, 10};
        int result = maximaDiferencia(array);
        //int resultStream = maximaDiferenciaStreams(array);
        System.out.println("La máxima diferencia es: " + result);
        //System.out.println("La máxima diferencia Stream es: " + resultStream);

        int[] descendingArray = {10, 8, 6, 4, 2};
        int resultDescending = maximaDiferencia(descendingArray);
        System.out.println("La máxima diferencia en el array descendente es: " + resultDescending);
    }
}
