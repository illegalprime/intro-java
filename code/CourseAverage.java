import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class CourseAverage {

    public static void main(String[] args) {
        int exam1, exam2, exam3;
        double examAvg, hwAvg, finalExam, courseAvg;
        Scanner gradeFile = null;
        try {
            gradeFile = new Scanner(new FileInputStream("grades.txt"));
        } catch(FileNotFoundException e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }
        exam1 = gradeFile.nextInt();
        exam2 = gradeFile.nextInt();
        exam3 = gradeFile.nextInt();
        examAvg = (exam1 + exam2 + exam3) / 3.0;
        hwAvg = gradeFile.nextDouble();
        finalExam = gradeFile.nextDouble();
        courseAvg = .6 * hwAvg + .2 * examAvg + .2 * finalExam;
        System.out.printf("Your course average is %.1f%n", courseAvg);    
    }
}