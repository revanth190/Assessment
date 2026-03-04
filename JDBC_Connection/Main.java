import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc  = new Scanner(System.in);
        int choice  = 0;

        while (choice != 5) {
            System.out.println("\n===== JDBC User Registry =====");
            System.out.println("1. Add User");
            System.out.println("2. Find User");
            System.out.println("3. Display All");
            System.out.println("4. Delete User");
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

                        Connection con1 = DBConnection.getConnection();
                        PreparedStatement ps1 = con1.prepareStatement(
                            "INSERT INTO users VALUES (?, ?, ?)"
                        );
                        ps1.setInt(1, id);
                        ps1.setString(2, name);
                        ps1.setString(3, email);
                        ps1.executeUpdate();
                        System.out.println("User added: " + name);
                        con1.close();
                        break;

                    case 2:
                        System.out.print("Enter ID to find: ");
                        int findId = Integer.parseInt(sc.nextLine());

                        Connection con2 = DBConnection.getConnection();
                        PreparedStatement ps2 = con2.prepareStatement(
                            "SELECT * FROM users WHERE id = ?"
                        );
                        ps2.setInt(1, findId);
                        ResultSet rs2 = ps2.executeQuery();

                        if (rs2.next()) {
                            System.out.println("-- User Found --");
                            System.out.println("ID   : " + rs2.getInt("id"));
                            System.out.println("Name : " + rs2.getString("name"));
                            System.out.println("Email: " + rs2.getString("email"));
                        } else {
                            System.out.println("No user found with ID: " + findId);
                        }
                        rs2.close();
                        con2.close();
                        break;

                    case 3:
                        Connection con3 = DBConnection.getConnection();
                        PreparedStatement ps3 = con3.prepareStatement(
                            "SELECT * FROM users"
                        );
                        ResultSet rs3 = ps3.executeQuery();

                        System.out.println("===== All Users =====");
                        boolean found = false;
                        while (rs3.next()) {
                            found = true;
                            System.out.println("ID   : " + rs3.getInt("id"));
                            System.out.println("Name : " + rs3.getString("name"));
                            System.out.println("Email: " + rs3.getString("email"));
                            System.out.println("---------------------");
                        }
                        if (!found) System.out.println("No users found.");
                        rs3.close();
                        con3.close();
                        break;

                    case 4:
                        System.out.print("Enter ID to delete: ");
                        int delId = Integer.parseInt(sc.nextLine());

                        Connection con4 = DBConnection.getConnection();
                        PreparedStatement ps4 = con4.prepareStatement(
                            "DELETE FROM users WHERE id = ?"
                        );
                        ps4.setInt(1, delId);
                        int rows = ps4.executeUpdate();

                        if (rows > 0) {
                            System.out.println("User deleted with ID: " + delId);
                        } else {
                            System.out.println("No user found with ID: " + delId);
                        }
                        con4.close();
                        break;

                    case 5:
                        System.out.println("Exiting... Bye!");
                        break;

                    default:
                        System.out.println("Invalid choice. Enter 1-5.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Error: Enter a valid number.");
            } catch (Exception e) {
                System.out.println("DB Error: " + e.getMessage());
            }
        }
        sc.close();
    }
}