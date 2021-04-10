package main.java;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.Map;
import com.h2.BestLoanRates;
import com.h2.SavingsCalculator;

public class Finance
{
    public final static String BEST_LOAN_RATES = "bestLoanRates";
    public final static String SAVINGS_CALCULATOR = "savingsCalculator";
    public final static String MORTGAGE_CALCULATOR = "mortgageCalculator";

    public final static Map<String, String> commandsToUsage = Map.of(BEST_LOAN_RATES, "usage: bestLoanRates",
            SAVINGS_CALCULATOR, "usage: savingsCalculator <credits separated by ','> <debits separated by ','>",
            MORTGAGE_CALCULATOR, "usage: mortgageCalculator <loanAmount> <termInYears> <annualRate>");

    private static boolean validateCommandArguments(String[] args) {
        int argsLength = args.length;

        switch (args[0]) {
            case BEST_LOAN_RATES:
                return argsLength == 1;
            case SAVINGS_CALCULATOR:
                return argsLength == 3;
            case MORTGAGE_CALCULATOR:
                return argsLength == 4;
        }
        return false;
    }

    private static void executeCommand(String command, String[] arguments) {
        switch (command) {
            case BEST_LOAN_RATES:
                System.out.println("Finding best loan rates ...");
                BestLoanRates.main(arguments);
                break;
            case SAVINGS_CALCULATOR:
                System.out.println("Finding your net savings ...");
                SavingsCalculator.main(arguments);
                break;
            case MORTGAGE_CALCULATOR:
                System.out.println("Finding your monthly payment ...");
                MortgageCalculator.main(arguments);
                break;
        }
    }

    public static void main(String[] args) {
        String command = args[0];
        if (!commandsToUsage.containsKey(command)) {
            System.out.println(MessageFormat.format("{0}: command not found", command));
            return;
        }

        boolean isValidCommand = validateCommandArguments(args);
        if (isValidCommand) {  // add a '!'
            System.out.println(commandsToUsage.get(args[0]));
            return;
        }

        executeCommand(command, Arrays.copyOfRange(args, 1, args.length));
    }
}
