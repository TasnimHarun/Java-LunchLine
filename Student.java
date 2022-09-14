/**
 * The <code>Student</code> class creates the student objects
 * @author Tasnim Harun
 *      email: tasnim.harun@stonybrook.edu
 *      Stony Brook ID: 112692494
 * <dt><b>Assignment:</b></dt>
 *      Homework #1 for CSE 214, Fall 2021
 */

public class Student {
    private String name;
    private double money;

    /**
     * Constructs an instance of <CODE>Student</CODE> class.
     * @param name
     *      The name of the student.
     * @param money
     *      The amount of lunch money the student has.
     *<dt>Precondition:
     *      <dd><code>name</code> is not null.
     *      <dd><code>money</code> is greater than or equal to 0.
     *<dt><b>Postcondition:</b><dd>
     *     This <CODE>Student</CODE> has been initialized as a student.
     */
    public Student(String name, double money){
        this.name = name;
        this.money = money;
    }

    /**
     * Indicates the name of the student
     * @return
     *      The name of the student
     */
    public String getName(){

        return name;
    }

    /**
     * Indicates the amount of money the student has
     * @return
     *      Value of money student has
     */
    public double getMoney(){
        return money;
    }

    /**
     * Changes the name of the student
     * @param name
     *      The name of the student
     */
    public void setName(String name){

        this.name = name;
    }

    /**
     * Checks if the value for money is acceptable
     * @param money
     *      Amount of money assigned to student
     * @exception InvalidArgumentException
     *      Inidicates if the money value is negative
     */
    public void checkMoney(double money) throws InvalidArgumentException{
        if(money<0){
            throw new InvalidArgumentException("Cannot have negative money amount");
        }
    }

    /**
     * Changes the money the student has
     * @param money
     *      Amount of money student has
     */
    public void setMoney(double money) {
        try{
            checkMoney(money);
            this.money = money;
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    /**
     * Checks if two instances of <code>Student</code> are equal.
     * @param obj
     *      Second student object that student is being compared to
     * @return
     *      True if objects are equal, otherwise false
     */
    public boolean equals(Object obj){
        if(obj instanceof Student){
            Student otherStudent = (Student)obj;
            if((this.name.equals(otherStudent.name))
                    && (this.money == otherStudent.money))
                return true;
        }
        return false;
    }

    /**
     * Copies the student object into a new object.
     * @return
     *      New object with same value as student
     */
    public Student clone(){
        Student newStudent = new Student(this.name, this.money);
        return newStudent;
    }

    /**
     * Prints the contents of student
     * @return
     *      The statement with student information
     */
    public String toString(){
        return name + " is in the line with " + money + " dollars.";
    }


}
