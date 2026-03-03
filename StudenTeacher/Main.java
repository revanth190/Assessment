public class Main {
    public static void main(String[] args) {

        Teacher t1 = new Teacher("Ms. Priya",  35, "Java");
        Teacher t2 = new Teacher("Mr. Ramesh",  42, "Mathematics");
        Teacher t3 = new Teacher("Ms. Sneha",  29, "English");

        Student s1 = new Student("Arjun", 20, 101);
        Student s2 = new Student("Meera", 21, 102);
        Student s3 = new Student("Rahul", 19, 103);

        t1.display();
        System.out.println();
        t2.display();
        System.out.println();
        t3.display();

        System.out.println();
        
        s1.display();
        System.out.println();
        s2.display();
        System.out.println();
        s3.display();
    }
}
