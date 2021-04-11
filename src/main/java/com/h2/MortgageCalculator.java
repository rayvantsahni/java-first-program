package com.h2;

import com.h2.Utilities;

import java.text.DecimalFormat;
import java.text.MessageFormat;

public class MortgageCalculator
{
    private long loanAmount;
    private int termInYears;
    private float annualRate;
    private double monthlyPayment;

    public MortgageCalculator(long loanAmount, int termInYears, float annualRate) {
        this.loanAmount = loanAmount;
        this.termInYears = termInYears;
        this.annualRate = annualRate;
    }

    private int getNumberOfPayments() {
        return this.termInYears * 12;
    }

    private float getMonthlyInterestRate() {
        float interestRate = this.annualRate / 100;
        return interestRate / 12;
    }

    public void calculateMonthlyPayment() {
        long P = this.loanAmount;
        float r = this.getMonthlyInterestRate();
        int n = this.getNumberOfPayments();

        this.monthlyPayment = P * (r * Math.pow(1 + r, n)) / (Math.pow(1 + r, n) - 1);
    }

    public String toString() {
        DecimalFormat df = new DecimalFormat("####0.00");
        return MessageFormat.format("monthlyPayment: {0}", df.format(monthlyPayment));
    }

    public static void main(String[] args) {
        long loanAmount = Utilities.getLongValue(args[0]);
        int termInYears = Utilities.getIntValue(args[1]);
        float annualRate = Utilities.getFloatValue(args[2]);

        MortgageCalculator calculator = new MortgageCalculator(loanAmount, termInYears, annualRate);
        calculator.calculateMonthlyPayment();

        System.out.println(calculator.toString());
    }
}
