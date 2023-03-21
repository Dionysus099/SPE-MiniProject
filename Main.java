package org.example;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int operations;
        double x, ans;

        do {
            System.out.println("\nScientific Calculator\n");
            System.out.println("1. Square Root Function");
            System.out.println("2. Factorial Function");
            System.out.println("3. Natural Logarithmic Function");
            System.out.println("4. Power Function");
            System.out.println("0. Exit from the Calculator");

            System.out.print("Enter Your Choice of Operation: ");
            operations = scanner.nextInt();

            switch (operations) {
                case 1:
                    System.out.print("Enter a number: ");
                    x = scanner.nextDouble();
                    ans = Math.sqrt(x);
                    System.out.println("Square root of " + x + " = " + ans);
                    break;

                case 2:
                    System.out.print("Enter a number: ");
                    x = scanner.nextDouble();
                    ans = factorial(x);
                    System.out.println(x + "! = " + ans);
                    break;

                case 3:
                    System.out.print("Enter a number: ");
                    x = scanner.nextDouble();
                    ans = Math.log(x);
                    System.out.println("Natural logarithm of " + x + " = " + ans);
                    break;

                case 4:
                    System.out.print("Enter a base number: ");
                    double base = scanner.nextDouble();
                    System.out.print("Enter an exponent: ");
                    double exponent = scanner.nextDouble();
                    ans = Math.pow(base, exponent);
                    System.out.println(base + "^" + exponent + " = " + ans);
                    break;

                case 0:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid operations. Please try again.");
            }
        } while (operations != 0);
    }

    public static double factorial(double n) {
        if (n == 0) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }
}
