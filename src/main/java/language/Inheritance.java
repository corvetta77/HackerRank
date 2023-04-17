package language;

import java.util.*;



class Person {
    protected String firstName;
    protected String lastName;
    protected int idNumber;

    // Constructor
    Person(String firstName, String lastName, int identification){
        this.firstName = firstName;
        this.lastName = lastName;
        this.idNumber = identification;
    }

    // Print person data
    public void printPerson(){
        System.out.println(
                "Name: " + lastName + ", " + firstName
                        + 	"\nID: " + idNumber);
    }

}

class Student extends Person{
    public static final Map<String, String> DICTIONARY = new HashMap<String, String>();
    private int[] testScores;

    /*
     *   Class Constructor
     *
     *   @param firstName - A string denoting the Person's first name.
     *   @param lastName - A string denoting the Person's last name.
     *   @param id - An integer denoting the Person's ID number.
     *   @param scores - An array of integers denoting the Person's test scores.
     */
    // Write your constructor here
    public Student(String firstName, String lastName, int id, int[] testScores) {
        super(firstName, lastName, id);
        this.testScores = testScores;
    }

    /*
     *   Method Name: calculate
     *   @return A character denoting the grade.
     */
    // Write your method here
    public char calculate() {
        double scoresAvg = Arrays.stream(testScores).average().getAsDouble();

        if (scoresAvg < 40) {
            return 'T';
        } else if(scoresAvg >= 40 && scoresAvg < 55) {
            return 'D';
        } else if(scoresAvg >= 55 && scoresAvg < 70) {
            return 'P';
        } else if(scoresAvg >= 70 && scoresAvg < 80) {
            return 'A';
        } else if(scoresAvg >= 80 && scoresAvg < 90) {
            return 'E';
        } else if(scoresAvg >= 90 && scoresAvg < 100) {
            return 'O';
        } else {
            throw new RuntimeException();
        }
    }
}

public class Inheritance {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String firstName = scan.next();
        String lastName = scan.next();
        int id = scan.nextInt();
        int numScores = scan.nextInt();
        int[] testScores = new int[numScores];
        for(int i = 0; i < numScores; i++){
            testScores[i] = scan.nextInt();
        }
        scan.close();

        Student s = new Student(firstName, lastName, id, testScores);
        s.printPerson();
        System.out.println("Grade: " + s.calculate() );
    }
}
