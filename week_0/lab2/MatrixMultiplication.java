package week_0.lab2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MatrixMultiplication {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int rowsInA = getIntInput(scanner, "Enter number of rows in Matrix A: ");
        int colsInARowsInB = getIntInput(scanner, "Enter number of columns in Matrix A or rows in Matrix B: ");
        int colsInB = getIntInput(scanner, "Enter number of columns in Matrix B: ");

        int[][] matA = createMatrix(scanner, rowsInA, colsInARowsInB, "A");
        int[][] matB = createMatrix(scanner, colsInARowsInB, colsInB, "B");

        printMatrix(matA, "Matrix A");
        printMatrix(matB, "Matrix B");

        int[][] matC = multiplyMatrices(matA, matB);

        printMatrix(matC, "Matrix C");

        scanner.close();
    }

    // Function to get a valid integer input
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
                scanner.next();  // Clear the invalid input
            }
        }
        return input;
    }

    // Function to create a matrix and fill it with user input
    public static int[][] createMatrix(Scanner scanner, int rows, int cols, String matrixName) {
        int[][] matrix = new int[rows][cols];
        System.out.printf("Enter values for %s (%d x %d):%n", matrixName, rows, cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = getIntInput(scanner, String.format("Element [%d][%d]: ", i, j));
            }
        }
        return matrix;
    }

    // Function to print a matrix
    public static void printMatrix(int[][] matrix, String matrixName) {
        System.out.println(matrixName + ":");
        for (int[] row : matrix) {
            System.out.print("|");
            for (int value : row) {
                System.out.printf("%3d ", value);
            }
            System.out.println("|");
        }
        System.out.println();
    }

    // Function to multiply two matrices
    public static int[][] multiplyMatrices(int[][] matA, int[][] matB) {
        int rowsInA = matA.length;
        int colsInB = matB[0].length;
        int colsInARowsInB = matA[0].length;
        
        int[][] product = new int[rowsInA][colsInB];
        
        for (int i = 0; i < rowsInA; i++) {
            for (int j = 0; j < colsInB; j++) {
                for (int k = 0; k < colsInARowsInB; k++) {
                    product[i][j] += matA[i][k] * matB[k][j];
                }
            }
        }
        return product;
    }
}
