public class Student extends Person {
    private int rollNo;

    Student(String name, int age, int rollNo) {
        super(name, age);
        this.rollNo = rollNo;
    }

    void display() {
        super.display();
        System.out.println("Roll No: " + rollNo);
    }
}