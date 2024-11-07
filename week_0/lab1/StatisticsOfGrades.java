package week_0.lab1;

import java.util.Scanner;
import java.util.Arrays;

public class StatisticsOfGrades{
    public static void main(String[] args){
        
        System.out.println("Enter grades, separated by spaces (e.g. 99 80 75): ");
        Scanner scanner = new Scanner(System.in);
        String[] gradesString = scanner.nextLine().split(" ");
        scanner.close();
        int[] grades = new int[gradesString.length];
        for(int i = 0; i < gradesString.length; i++){
            grades[i] = Integer.parseInt(gradesString[i]);
        }
        System.out.println("Values: ");

        Arrays.sort(grades);

        int min = grades[0];
        System.out.println("Minimum grade = " + min);
        int max = grades[grades.length - 1];
        System.out.println("Maximum grade = " + max);

        int sum = 0;
        for(int i = 0; i < grades.length; i++){
            sum += grades[i];
        }
        double average = sum / grades.length;
        System.out.println("Average = " + average);

        // Collect data for the range of grades
        int[] ranges = new int[5];
        for(int grade : grades){
            if(grade >= 0 && grade <= 20){
                ranges[0]++;
            } else if(grade >= 21 && grade <= 40){
                ranges[1]++;
            } else if(grade >=41 && grade <= 60){
                ranges[2]++;
            } else if(grade >= 61 && grade <= 80){
                ranges[3]++;
            } else {
                ranges[4]++;
            }
        }

        System.out.println("Range of grades = " + Arrays.toString(ranges));
        System.out.println();
        System.out.println("Graph: ");

        // vertical axis
        for(int i = 6; i > 0; i--){
            //System.out.printf("%2d > ", i);
            System.out.print(i + " > ");
            for (int j = 0; j < 5; j++) {
                if (ranges[j] >= i) {
                    System.out.print("#######   ");
                } else {
                    System.out.print("          ");
                }

            }
            System.out.println();
        }

        // horizontal axis
        String symbol = "+---------";
        System.out.print("  " + symbol.repeat(5) + "+");
        System.out.println();

        System.out.print("  I  0-20  ");
        System.out.print(" I  21-40  ");
        System.out.print("I  41-60  ");
        System.out.print("I  61-80  ");
        System.out.print("I  81-100 I");
        System.out.println();

    }
}