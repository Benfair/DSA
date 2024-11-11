package week_0.lab3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PeakColumns {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Get matrix dimensions with error handling
        int rows = getIntInput(scanner, "Enter the number of rows: ");
        int cols = getIntInput(scanner, "Enter the number of columns: ");

        int[][] matrix = new int[rows][cols];

        // Populate the matrix with user input
        System.out.printf("Enter values for a %d x %d matrix, row by row:\n", rows, cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = getIntInput(scanner, String.format("Element [%d][%d]: ", i, j));
            }
        }

        // Display the matrix
        System.out.println("Matrix A:");
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.printf("%2d ", value);
            }
            System.out.println();
        }

        // Precompute row maximums and column minimums
        int[] rowMax = new int[rows];
        int[] colMin = new int[cols];

        // Initialize rowMax with minimum possible values and colMin with maximum possible values
        for (int i = 0; i < rows; i++) rowMax[i] = Integer.MIN_VALUE;
        for (int j = 0; j < cols; j++) colMin[j] = Integer.MAX_VALUE;

        // Fill rowMax and colMin
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] > rowMax[i]) rowMax[i] = matrix[i][j];
                if (matrix[i][j] < colMin[j]) colMin[j] = matrix[i][j];
            }
        }

        // Display the matrix and find peak-columns
        System.out.println("\nPeak-column(s): ");
        boolean found = false;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // Check if matrix[i][j] is a peak-column
                if (matrix[i][j] == rowMax[i] && matrix[i][j] == colMin[j]) {
                    System.out.printf("(%d,%d) = %d\n", i+1, j+1, matrix[i][j]);
                    found = true;
                }
            }
        }

        if (!found) {
            System.out.println("No peak-columns found in the matrix.");
        }

    }   

    // Method to handle integer input with error handling
    public static int getIntInput(Scanner scanner, String prompt) {
        int input = 0;
        boolean valid = false;
        while (!valid) {
            System.out.print(prompt);
            try {
                input = scanner.nextInt();
                valid = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter an integer.");
                scanner.next(); // clear invalid input
            }
        }
        return input;
    }
}