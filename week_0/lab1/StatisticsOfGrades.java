package week_0.lab1;

public class StatisticsOfGrades{
    public static void main(String[] args){
        System.out.println("Hello Bene");

        // Define the grades
        int[] grades = {90, 85, 70, 75, 60, 95, 100, 85, 70, 80};

        // Calculate the average
        int sum = 0;
        for(int i = 0; i < grades.length; i++){
            sum += grades[i];
        }
        double average = sum / grades.length;
        System.out.println("The average of the grades is: " + average);
        
    }
}