import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        UserRegistry registry = new UserRegistry();
        Scanner sc = new Scanner(System.in);
        int choice = 0;

        while (choice != 5) {
            System.out.println("\n===== User Registry Menu =====");
            System.out.println("1. Add User");
            System.out.println("2. Find User");
            System.out.println("3. Delete User");
            System.out.println("4. Display All Users");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            try {
                choice = Integer.parseInt(sc.nextLine());

                switch (choice) {

                    case 1:
                        System.out.print("Enter ID    : ");
                        int id = Integer.parseInt(sc.nextLine());
                        System.out.print("Enter Name  : ");
                        String name = sc.nextLine();
                        System.out.print("Enter Email : ");
                        String email = sc.nextLine();
                        registry.addUser(id, name, email);
                        break;

                    case 2:
                        System.out.print("Enter ID to find: ");
                        int findId = Integer.parseInt(sc.nextLine());
                        registry.findUser(findId);
                        break;

                    case 3:
                        System.out.print("Enter ID to delete: ");
                        int delId = Integer.parseInt(sc.nextLine());
                        registry.deleteUser(delId);
                        break;

                    case 4:
                        registry.displayAll();
                        break;

                    case 5:
                        System.out.println("Exiting... Bye!");
                        break;

                    default:
                        System.out.println("Invalid choice. Enter 1-5.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter a valid number.");
            }
        }

        sc.close();
    }
}