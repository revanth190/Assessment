public class Teacher extends Person {
    private String subject;

    Teacher(String name, int age, String subject) {
        super(name, age);
        this.subject = subject;
    }

    void display() {
        super.display();
        System.out.println("Subject: " + subject);
    }
}