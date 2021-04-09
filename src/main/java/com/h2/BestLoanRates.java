package com.h2;

import java.text.MessageFormat;
import java.util.Map;
import java.util.Scanner;

public class BestLoanRates
{
    public static final Map<Integer, Float> bestRates = Map.of(1, 5.50f, 2, 3.45f, 3, 2.67f);

    public static float getRates(int loanTermInYears) {
        if (bestRates.containsKey(loanTermInYears))
            return bestRates.get(loanTermInYears);
        return .0f;
    }

    private static boolean areEqual(float first, float second) {
        return Math.abs(first - second) < Float.MIN_NORMAL;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your name");
        String name = scanner.nextLine();
        System.out.println(MessageFormat.format("Hello {0}", name));

        System.out.println("Enter the loan term (in years)");
        int loanTermInYears = scanner.nextInt();

        float bestRate = getRates(loanTermInYears);
        if (areEqual(bestRate, .0f))
            System.out.println(MessageFormat.format("No available rates for term: {0} years", loanTermInYears));
        else
            System.out.println(MessageFormat.format("Best Available Rate: {0}%", bestRate));

        scanner.close();
    }
}
