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
            if (grades[i] < 0 || grades[i] > 100) {
                System.out.println("Invalid grade entered. Each grade should be between 0 and 100.");
                System.exit(0);
            }
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
        double average = (double)sum / grades.length;
        System.out.println("Average = " + average);

        // Frequency of the range of grades
        int[] stats = new int[5];
        for(int grade : grades){
            if(grade >= 0 && grade <= 20){
                stats[0]++;
            } else if(grade >= 21 && grade <= 40){
                stats[1]++;
            } else if(grade >=41 && grade <= 60){
                stats[2]++;
            } else if(grade >= 61 && grade <= 80){
                stats[3]++;
            } else {
                stats[4]++;
            }
        }

        System.out.println("Frequency of grouped data = " + Arrays.toString(stats));
        System.out.println();
        System.out.println("Bar Graph: ");

        // vertical axis
        for(int i = 6; i > 0; i--){
            System.out.print(i + " > ");
            for (int j = 0; j < 5; j++) {
                if (stats[j] >= i) {
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

        System.out.print("  I  0-20  " + " I  21-40  " + "I  41-60  " + "I  61-80  " + "I  81-100 I");
        System.out.println();
    }
}