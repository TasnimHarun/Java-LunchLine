/**
 * The <code>LunchLineSimulator</code> class is the main class to
 * implement <code>Student</code> and <CODE>StudentLine</CODE> classes.
 *
 * @author Tasnim Harun
 *      email: tasnim.harun@stonybrook.edu
 *      Stony Brook ID: 112692494
 *<dt><b>Assignment:</b></dt>
 *      Homework #1 for CSE 214, Fall 2021
 */

import java.util.Scanner;

public class LunchLineSimulator {
    private static StudentLine realityA;    //variables of LunchLine
    private static StudentLine realityB;

    /**
     * The main operating method for this program. Student data is given from the user
     * and stored in <code>StudentLine</code> and <code>Student</code> classes.
     * Operations are then performed based on user input, chosen from a list of options.
     * @exception InvalidArgumentException
     *      Indicates an invalid index
     * @exception EmptyLineException
     *      Indicates array is empty
     * @exception DeanException
     *      Indicates array is full
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Welcome to middle school."
                + "\n You are in reality A.");
        realityA = new StudentLine();   //creates object in studentLine
        realityB = new StudentLine();
        StudentLine line = realityA;    //Starts in reality A
        System.out.println("Pick one of the options from the menu:");
        System.out.println(
                    "A) Add a student to the line at the end\n" +
                "\n" +
                "     C) Have a new student cut a friend\n" +
                "\n" +
                "     T) Have two students trade places\n" +
                "\n" +
                "     B) Have the bully remove a student\n" +
                "\n" +
                "     U) Update a student's money amount\n" +
                "\n" +
                "     S) Serve a student\n" +
                "\n" +
                "     P) Print the current reality's lunch line\n" +
                "\n" +
                "     O) Switch to the other reality\n" +
                "\n" +
                "     E) Check if the realities are equal\n" +
                "\n" +
                "     D) Duplicate this reality into the other reality\n" +
                "\n" +
                "     Q) Quit middle school and move on to real life.\n");
        char inp = in.next().charAt(0); //takes user input
        char input = Character.toUpperCase(inp);    //sets the input to uppercase
        int countA = 0, countB = 0; //creates to variables to store the counts for A and B
        int count;  //general variable to use for the program
        count = countA; //starts off in reality A
        //loop of the main program
        while(input != 'Q') {
            if (input == 'A') {
                //Add student

                in.nextLine();
                System.out.println("Please enter student name: ");
                String name = in.nextLine();

                System.out.println("Please enter money amount: ");
                double money = in.nextDouble();
                Student student = new Student(name, money);
                line.addStudent(count, student);    //calls add method from StudentLine
                count++;
                //System.out.println("count is " + count);
                System.out.println(student.getName() +" has been added to the "
                        +"line in position " + count + ". " + student.getName()
                        + " has $" + student.getMoney()+".\n") ;
                //System.out.println(line.toString());
            }else if (input == 'T'){
                System.out.println("Enter the index of student 1: ");
                int index1 = in.nextInt();
                System.out.println("Enter the index of student 2: ");
                int index2 = in.nextInt();
                line.swapStudents(index1-1, index2-1);
                System.out.println(line.getStudent(index1-1).getName() + " and "
                        + line.getStudent(index2-1).getName() + "have switched places.");
            }else if(input == 'C'){
                System.out.println("Enter the name of the student cutting: ");
                in.nextLine();
                String name = in.nextLine();
                System.out.println("Enter the money amount: ");
                double money = in.nextDouble();
                System.out.println("Enter the index to which "
                        + "they are cutting in: ");
                int index = in.nextInt();
                Student student =  new Student(name, money);
                line.addStudent(index-1, student);
            }else if(input == 'B'){
                System.out.println("Oh no! Billy the bully is here!");
                System.out.println("Choose student for Billy to bully: ");
                int index = in.nextInt();
                if(count != 0) {
                    System.out.println("The bully has stolen from "
                            + line.getStudent(index - 1).getName()
                            + " so they left the line.");
                }
                line.removeStudent(index-1);
                count--;
            }else if(input == 'U'){
                System.out.println("Choose which student's lunch"
                        + " money you'd like to update: ");
                int index = in.nextInt();
                System.out.println("Enter new amount: ");
                double num = in.nextDouble();
                line.getStudent(index-1).setMoney(num);
                System.out.println(line.getStudent(index-1).getName() + "now has "
                        + "$" + line.getStudent(index-1).getMoney());
            }else if(input == 'S'){
                line.removeStudent(0);
                System.out.println(line.getStudent(0).getName()
                        + " has been served mysterious food.");
            }else if(input == 'P') {
                if(line==realityA){
                    System.out.println("Lunch line in reality A");
                    System.out.println(line.toString());
                }else if(line == realityB){
                    System.out.println("Lunch line in reality B");
                    System.out.println(line.toString());
                }
            }else if(input == 'O') {
                if(line==realityA) {
                    countA = count;//stores count of reality A
                    line = realityB;
                    count = countB;
                    System.out.println("You are in reality B.");
                }else if(line==realityB){
                    countB = count; //stores count of realityB
                    line = realityA;
                    count = countA;
                    System.out.println("You are in reality A.");
                }
            }else if(input == 'E'){
                //Checks if inputs are equal
                if (realityA.equals(realityB)) {
                    System.out.println("The realities are equal");
                } else {
                    System.out.println("The realities are not equal");
                }
            }else if(input == 'D') {
                if (line == realityA) {
                    realityB = realityA.clone();
                    System.out.println("Reality A has been "
                            + "duplicated in Reality B");
                    //System.out.println(realityB.toString());
                } else if (line == realityB) {
                    realityA = realityB.clone();
                    System.out.println("Reality B has been "
                            + "duplicated in Reality A");
                    //System.out.println(realityA.toString());
                }
            }else{
                System.out.println("Invalid input. Try again.");
            }
            System.out.println("\nPick one of the options from the menu:");
            inp = in.next().charAt(0);
            input = Character.toUpperCase(inp); //Sets the character to uppercase
        }
        System.out.println("You have exited the program");
    }
}
