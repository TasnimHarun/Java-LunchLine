/**
 * The <code>StudentLine</code> class creates the array
 *      which holds student objects
 * @author Tasnim Harun
 *      email: tasnim.harun@stonybrook.edu
 *      Stony Brook ID: 112692494
 *<dt><b>Assignment:</b></dt>
 *      Homework #1 for CSE 214, Fall 2021
 */

public class StudentLine implements Cloneable{
    private Student[] student;  //Array for storing students
    private int studentCount;   //Integer to keep track of number of students
    final int CAPACITY = 20;    //Size of the array

    /**
     * Constructs an empty line of students
     *<dt><b>PostCondition:</b></dt>
     *      This <CODE>StudentLine</CODE> creates an empty array of students
     */
    public StudentLine(){
        student = new Student[CAPACITY];
        studentCount = 0;
    }

    /**
     *Indicates the number of students in the StudentLine.
     * @return studentCount
     *      The number of students in the array
     */
    public int numStudents(){

        return studentCount;
    }

    /**
     * Checks if the index is valid
     * @param index
     *      Index of the student being added
     * @throws InvalidArgumentException
     *      Indicates the index is not valid
     */
    public void checkArgument(int index) throws InvalidArgumentException{
        if((index < 0) || (index > CAPACITY)){
            throw new InvalidArgumentException("The index is not"
                    + " within the acceptable range.");
        }
    }

    /**
     * Indicates the specified student in <CODE>StudentLine</CODE>
     * <dt><b>PreCondition:</b></dt>
     *      StudentLine has been initialized and index is within acceptable range of values
     * @param index
     *      The index of the student targeted
     * @return student[index]
     *      The student at the given index
     * @exception ArrayIndexOutOfBoundsException
     *      Indicates if the index is not within the acceptable range
     */
    public Student getStudent(int index){
        try {
            checkArgument(index);
            return student[index];
        } catch(ArrayIndexOutOfBoundsException e){
            System.out.println("This student does not exist.");
            return null;
        }catch(Exception e2){
            System.out.println(e2);
            return null;
        }
    }

    /**
     * Checks if the array is empty
     * @exception EmptyLineException
     *      Indicates the line is empty
     */
    public void checkEmpty() throws EmptyLineException{
        if(studentCount==0){
            throw new EmptyLineException("Invalid Input."
                + "Cannot remove from an empty line.");
        }
    }

    /**
     * Removes a student from the array <CODE>StudentLine</CODE>
     * <dt><b>PreCondition:</b></dt>
     *      Student Line is not empty and index of student is in the line.
     *<dt><b>Postconditions:</b></dt>
     *      Student removed from <CODE>StudentLine</CODE>
     * @param index
     *      The index of the student to be removed
     * @return student[index]
     *      The student that replaced the student removed
     * @throws EmptyLineException
     *      If the line is empty then there is nothing to remove
     * @exception ArrayIndexOutOfBoundsException
     *      Indicates if the index is out of the acceptable range
     */
    public Student removeStudent(int index){
            try {
                checkEmpty();
                for (int i = index; i < studentCount-1; i++) {
                    student[i] = student[i + 1];
                }
                studentCount--;
                return student[index];
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("The index doesn't exist");
                return null;
            } catch (Exception e2){
                System.out.println(e2);
                return null;
            }
    }

    /**
     * Checks if the line is full.
     * @throws DeanException
     *      Indicates the line is full
     */
    public void checkDean() throws DeanException{
        if(studentCount == CAPACITY){
            throw new DeanException("The line is full."
                + " Dean has sent the student to detention");
        }
    }

    /**
     * Adds a student to <CODE>StudentLine</CODE>
     * <dt><b>Preconditions:</b></dt>
     *      Index is greater than 0 but not larger than CAPACITY
     *      and the array is not full
     *<dt><b>Postconditions:</b></dt>
     *      Student added to <CODE>StudentLine</CODE>
     * @param index
     *      Index of the student being added
     * @param student
     *      Student being added to the line
     * @exception InvalidArgumentException
     *      Indicates if index value is less than 0 or greater than 0
     * @exception DeanException
     *      Indicates if <CODE>StudentLine</CODE> is full
     */
    public void addStudent(int index, Student student) {
        try {
            checkArgument(index);
            checkDean();
            if (index != studentCount) {
                for (int i = studentCount; i > index; i--) {
                    this.student[i] = this.student[i - 1];
                }
                this.student[index] = student;
                studentCount++;
                System.out.println("Friend has successfully cut in");
            }else {
                this.student[index] = student;
                studentCount++;
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    /**
     * Switches position of two students in <CODE>StudentLine</CODE>
     * <dt><b>Preconditions:</b></dt>
     *      Student line is not empty and both indices are within the acceptable range.
     *<dt><b>Postcondition:</b></dt>
     *      Student  with index1 is in position of student with index2 and vice versa.
     * @param index1
     *      Index of the first student
     * @param index2
     *      Index of the second student
     * @exception ArrayIndexOutOfBoundsException
     *      Indicates if either of the indices are valid
     */
    public void swapStudents(int index1, int index2){
        try {
            Student temp;
            temp = student[index1];
            student[index1] = student[index2];
            student[index2] = temp;
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Index is not within acceptable range");
        }
    }

    /**
     * Checks if two <CODE>StudentLine</CODE> arrays are equal
     * @param o
     *      Second line the first is compared to
     * @return
     *      True if both are equal, false otherwise
     */
    public boolean equals (Object o){
        if(o instanceof StudentLine){
            StudentLine sl = (StudentLine)o;
            if(this.studentCount == sl.studentCount){   //checking arrays are the same size
                for(int i = 0; i<studentCount; i++){
                    if(this.student[i].equals(sl.student[i]))
                        return true;
                }
            }
        }
        return false;
    }

    /**
     * Copies the contents of one line into the other
     * @return
     *      New student line with the copied value
     * @throws RuntimeException
     *      Indicates the class does not implement the
     *      <CODE>Cloneable</CODE> interface
     */
    public StudentLine clone() throws RuntimeException{
        StudentLine newLine;
        try {
            newLine = (StudentLine) super.clone();
        }
        catch(CloneNotSupportedException e){
            throw new RuntimeException("This class does not "
                    + "implement cloneable");
        }
        newLine.student = (Student[])student.clone();
        return newLine;
    }

    /**
     * Prints the <CODE>String</CODE> of each student in the line
     * @return
     *      The <CODE>String</CODE> of each student
     */
    public String toString(){
        for (int i =0; i<studentCount; i++) {
            System.out.print(i+1 + ". " + student[i] + " \n");
        }
        return "";
    }
}
