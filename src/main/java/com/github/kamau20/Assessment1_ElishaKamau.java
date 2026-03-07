package com.github.kamau20;

import java.util.Scanner;

public class Assessment1_ElishaKamau {
    public static void main(String[] args) {

        variableOperations(); // Quiz 1
        // gradeCalculator(); // Quiz 2
        // numberSequence(); // Quiz 3
        // inputValidation(); // Quiz 4
        // patternPrinting(); // Quiz 5
    }

    public static void variableOperations() {
        // Solution for Quiz Variable Operations

        int a = 15;
        int b = 4;
        int c = 7;

        int sum = a + b + c; // Calculates the sum
        int product = a * b; // Calculates the product
        int expressionResult = (a + b) * c; // Calculates the expressionResult
        int remainder = a % b; // Calculates the remainder

        System.out.println("Sum: " + sum);
        System.out.println("Product: " + product);
        System.out.println("Expression Result: " + expressionResult);
        System.out.println("Remainder: " + remainder);
    }

    public static void gradeCalculator() {
        // Solution for Quiz Grade Calculator

        Scanner scanner = new Scanner(System.in); // Creates a Scanner Object to read user input
        System.out.println("Enter student's score (0-100): "); // Prompts user
        int score = scanner.nextInt();

        String grade = ""; // Variable for storing the grade

        if (score < 0 || score > 100) {
            System.out.println("Error: Score must be between 0 and 100\n");
        } else if (score >= 90) {
            grade = "A"; 
        } else if (score >= 80) {
            grade = "B";
        } else if (score >= 70) {
            grade = "C";
        } else if (score >= 60) {
            grade = "D";
        } else {
            grade = "F";
        }

        if (!grade.equals("Invalid")) { // Display result
            System.out.println("Score: " + score);
            System.out.println("Grade: " + grade);
        }

        scanner.close();
    }

    public static void numberSequence() {
        // Solution for Quiz Number Sequence

        for (int i = 1; i <= 20; i++) { // iteration using for loop
            System.out.print(i + ": "); // prints the current number

            if (i % 5 == 0) { // Checks if number is divisible by 5
                System.out.print("Multiple of 5");
            }

            if (i % 2 == 0) { // Checks if number is even or odd
                if (i % 5 == 0) {
                    System.out.print(", ");
                }
                System.out.print("Even");
            } else {
                if (i % 5 == 0) {
                    System.out.print(", ");
                }
                System.out.print("Odd");
            }
            System.out.println();
        }
    }

    public static void inputValidation() {
        // Solution for Quiz Input Validation

        Scanner scanner = new Scanner(System.in);

        int number = 0;
        boolean validInput = false;

        while (!validInput) {
            System.out.print("Enter a positive integer: ");

            if (scanner.hasNextInt()) {
                number = scanner.nextInt();

                if (number > 0) {
                    validInput = true;
                } else {
                    System.out.println("Invalid input! Please enter a positive integer:");
                }
            } else {
                System.out.println("Invalid input! Please enter a valid integer");
            }
        }

        long factorial = 1; // Calculates the factorial
        int originalNumber = number;

        while (number > 0) {
            factorial *= number;
            number--;
        }
        System.out.println("The factorial of " + originalNumber + " is: " + factorial);

        scanner.close();
    }

    public static void patternPrinting() {
        // Solution for Quiz Pattern Printing

        int rows = 5; // Variable to store the number of rows

        System.out.println("Right-angled triangle pattern:");

        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
