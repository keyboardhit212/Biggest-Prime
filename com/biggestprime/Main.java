package com.biggestprime;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static Scanner console = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Enter digits: ");
        String numbers = console.nextLine();
        try {
            hasNegative(numbers);
            System.out.println("Highest prime digit is: " + getHighest(numbers));
        } catch (NegativeValueFoundException e) {
            System.out.println("Digits must not have a negative value!");
            System.exit(1);
        } catch (NumberFormatException e) {
            System.out.println("An invalid digit was entered!");
            System.exit(1);
        }
    }

    private static int getHighest(String digits) throws NumberFormatException {
        int highestPrime = 0;
        for (String digit : digits.split(" ")) {
            int parsedDigit = Integer.parseInt(digit);
            if (Prime.isPrime(parsedDigit) && parsedDigit > highestPrime) {
                highestPrime = parsedDigit;
            }
        }
        return highestPrime;
    }


    private static boolean hasNegative(String digits) throws NegativeValueFoundException {
        for (String digit : digits.split(" ")) {
            try {
                int parsedDigit = Integer.parseInt(digit);
                if (parsedDigit < 0)
                    throw new NegativeValueFoundException();
            } catch (InputMismatchException e) {
                System.out.println("One of the digit is invalid!");
                System.exit(1);
            }
        }
        return false;
    }



}
